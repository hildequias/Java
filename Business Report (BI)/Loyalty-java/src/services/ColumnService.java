package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import valueObjects.ColumnVO;
import valueObjects.ConnectionVO;
import valueObjects.TableVO;
import Factory.ConectionFactory;

@Service("ColumnService")
@RemotingDestination(channels={"my-amf"})
public class ColumnService extends AbstractService<ColumnVO>{
	
	enum Comandos {  
		SQLServer, MySQL, PortgreSQL
    }
	
	@RemotingInclude
	public List<ColumnVO> findAllByDataBaseUnknow(ConnectionVO conexao, TableVO tabela) throws SQLException{
		
		List<ColumnVO> colunas = new ArrayList<ColumnVO>();
		String sql = "";
		Connection connection = ConectionFactory.getSQLConnection(conexao);
		PreparedStatement preparedStatement = null;
		switch (Comandos.valueOf(conexao.getBanco())){
		
			case SQLServer:
				sql = "SELECT 0 as id, c.name as field, t.name as type," +
					  " 0 as category, 0 as series"+
					  " FROM SYS.columns c"+
					  " INNER JOIN sysobjects o ON c.object_id = o.id"+
					  " INNER JOIN sys.types t ON t.system_type_id = c.system_type_id"+
					  " WHERE o.name = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, tabela.getNome());
				break;
			case MySQL:
				sql = "SHOW COLUMNS FROM "+tabela.getNome()+" FROM "+conexao.getData_base()+";";
				preparedStatement = connection.prepareStatement(sql);
				break;
				
			case PortgreSQL:
				sql = "";
				preparedStatement = connection.prepareStatement(sql);
				break;
		}
		
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	ColumnVO colunaVO = new ColumnVO();
        	colunaVO.setId(0);
        	colunaVO.setField(resultSet.getString("field"));
        	colunaVO.setType(resultSet.getString("type"));
        	colunaVO.setSelected(false);
        	colunaVO.setCategory(false);
        	colunaVO.setSeries(false);
        	colunas.add(colunaVO);
        }
        connection.close();
        return colunas;
	}
	
	@RemotingInclude
	public List<Object> executeQuery(ConnectionVO conexao, TableVO tabela, List<ColumnVO> colunas) throws SQLException{
		
		List<Object> listaColunas = new ArrayList<Object>();
		
		int numeroColunas = 0;
		
		if(colunas.size() > 0){
			String sql = "Select ";
			for(ColumnVO c: colunas){
				
				sql += c.getField();
				sql += ", ";
				numeroColunas++;
			}
			sql = sql.substring (0, sql.length() - 2);
			sql += " FROM "+tabela.getNome();
			sql += " WHERE 1=1";
			
			Connection connection = ConectionFactory.getSQLConnection(conexao);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int i = 0;
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				for(ColumnVO c: colunas) {

					String tipo = c.getType();
					Object dado = new Object();
					
					if(tipo.equals("varchar") || tipo.equals("longtext") || tipo.equals("nvarchar")){
						
						dado = resultSet.getString(c.getField());
					}
					
					if(tipo.equals("int") || tipo.equals("bit") || tipo.substring(0, 4).equals("int(")){
						
						dado = resultSet.getInt(c.getField());
					}
					
					if(tipo.equals("Boolean")){
						
						dado = resultSet.getBoolean(c.getField());
					}
					
					if(tipo.equals("Date") || tipo.equals("datetime") || tipo.equals("timestamp")){
						
						dado = resultSet.getDate(c.getField());
					}
					
					if(tipo.equals("numeric")){
						
						dado = resultSet.getDouble(c.getField());
					}
					
					map.put(c.getField(), dado);
					
					//ResultSetMetaData metaDados = resultSet.getMetaData();
					//int tipo2 =  metaDados.getColumnType(1);
					/*  
					switch ( tipo ) {  
					  
					    case Types.INTEGER:  
					          
					        break;  
					  
					    case Types.DOUBLE:  
					        //usa resultSet.getDouble();  
					        break;
					}
					i++;
					
					/* 
					DialectFactory d = new DialectFactory();
					String s = d.discoveryType(conexao, c.getType());
					
					switch (Tipos.valueOf(s)){
						
						case INT:
							int i = resultSet.getInt(c.getField());
							lista.add(i);
							break;
						case STRING:
							String campo = resultSet.getString(c.getField());
							lista.add(campo);
							break;
						case DATE:
							Date data = resultSet.getDate(c.getField());
							lista.add(data);
							break;
						case TIME:
							Date t = resultSet.getTime(c.getField());
							lista.add(t);
							break;
					}*/
					
					i++;
		        }
				listaColunas.add(map);
			}
	        connection.close();
		}
		return listaColunas;
	}
}

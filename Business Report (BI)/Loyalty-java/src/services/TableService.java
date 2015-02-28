package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import Factory.ConectionFactory;

import valueObjects.ConnectionVO;
import valueObjects.TableVO;;

@Service("TableService")
@RemotingDestination(channels={"my-amf"})
public class TableService {
	
	enum Comandos {  
		SQLServer, MySQL, PortgreSQL
    }
	
	@RemotingInclude
	public List<TableVO> findAll(ConnectionVO conexao) throws SQLException{
		
		List<TableVO> tabelas = new ArrayList<TableVO>();
		String sql = "";
		switch (Comandos.valueOf(conexao.getBanco())){
		
			case SQLServer:
				sql = "SELECT name FROM sysobjects WHERE xtype in ('U','V')";
				break;
				
			case MySQL:
				sql = "SHOW TABLES";
				break;
				
			case PortgreSQL:
				sql = "";
				break;
		}
		
		Connection connection = ConectionFactory.getSQLConnection(conexao);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	TableVO tabelaVO = new TableVO();
        	tabelaVO.setNome(resultSet.getString(1));
        	tabelas.add(tabelaVO);
        }
        
		return tabelas;
	}
}

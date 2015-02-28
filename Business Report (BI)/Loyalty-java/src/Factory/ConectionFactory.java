package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import valueObjects.ConnectionVO;

public class ConectionFactory {
	
	private ConectionFactory() {
    }
	
	enum Comandos {  
		SQLServer, MySQL, PortgreSQL
    }  
	
	public static Connection getSQLConnection(ConnectionVO conexao) throws SQLException {
		
		Connection con = null;
		
		switch (Comandos.valueOf(conexao.getBanco())){
			
		case SQLServer:
			con = getSQLServer(conexao);
			break;
		case MySQL:
			con = getMySQL(conexao);
			break;
		case PortgreSQL:
			con = getPostgreSQL(conexao);
			break;
		}
		return con;
	}
	
	// Conecta com o Banco SQL Server
	public static Connection getSQLServer(ConnectionVO conexao) throws SQLException{
		
		Connection con = null;
        try {
        	Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://"+ conexao.getServidor()+":"+conexao.getPorta()+";databaseName="+conexao.getData_base()+";user="+conexao.getUser()+";password="+conexao.getSenha()+"");
        }catch (ClassNotFoundException ex) {
        	System.out.println("Erro ao conectar-se ao Banco de Dados!");
        }
        return con;
	}
	
	// Conecta com o Banco PostgreSQL
	public static Connection getPostgreSQL(ConnectionVO conexao)throws SQLException{
		
		Connection con = null;
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://"+ conexao.getServidor()+":"+conexao.getPorta()+"/"+conexao.getData_base(), conexao.getUser(),conexao.getSenha());
		}catch (ClassNotFoundException ex) {
        	System.out.println("Erro ao conectar-se ao Banco de Dados!");
        }
		return con;
	}
	
	// Conecta com o Banco MySQL
	public static Connection getMySQL(ConnectionVO conexao)throws SQLException{
		
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+ conexao.getServidor()+":"+conexao.getPorta()+"/"+conexao.getData_base()+"?user="+conexao.getUser()+"&password="+conexao.getSenha()+"");
		}catch (ClassNotFoundException ex) {
            System.out.println("Erro ao conectar-se ao Banco de Dados!");
        }
        return con;
	}
}

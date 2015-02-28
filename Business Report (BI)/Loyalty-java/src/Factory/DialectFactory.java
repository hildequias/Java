package Factory;

import valueObjects.ConnectionVO;

public class DialectFactory {
	
	public DialectFactory(){}
	
	enum Comandos {  
		SQLServer, MySQL, PortgreSQL
    }
	
	public String discoveryType(ConnectionVO conexao, String str){
		
		String s = null;
		switch (Comandos.valueOf(conexao.getBanco())){
		
		case SQLServer:
			s = typesSQLServer(str);
			break;
		case MySQL:
			//con = getMySQL(conexao);
			break;
		case PortgreSQL:
			//con = getPostgreSQL(conexao);
			break;
		}
		return s;
	}
	
	public String typesSQLServer(String str){
		
		if(str == "bigint" || str == "binary" || str == "bit" || str == "int" || str == "smallint" || str == "tinyint" || str == "uniqueidentifier"){
			
			return "INT";
		}
		
		if( str == "varchar"){
			
			return "STRING";
		}
		
		if(str == "date" || str == "datetime" || str == "datetime2" || str == "datetimeoffset" || str == "smalldatetime" || str == "timestamp" ){
			
			return "DATE";
		}
		
		if(str == "time"){
			
			return "TIME";
		}
		
		return "STRING";
	}
	
	/*public SQLiteDialect() {
        super();
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "integer"); 
     */
}

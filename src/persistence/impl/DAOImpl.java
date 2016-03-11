package persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOImpl
{
	Connection        con;
	PreparedStatement ps;
	ResultSet         rs;
	
	public void open( ) throws Exception
	{
		Class.forName( "oracle.jdbc.OracleDriver" );
		
		con = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:XE", "salao", "salao" );
	}
	
	public void close( ) throws Exception
	{
		con.close( );
	}
}

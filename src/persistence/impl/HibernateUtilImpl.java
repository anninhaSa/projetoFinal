package persistence.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Classe que prov� recurso para se conectar ao BD.
 */
public class HibernateUtilImpl
{
	private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			sessionFactory = new AnnotationConfiguration( ).configure( "config/oracle_hibernate.cfg.xml" ).buildSessionFactory( );
		}
		catch ( Exception e )
		{
			System.err.println( "A cria��o de SessionFactory falhou." + e );
			throw new ExceptionInInitializerError( e );
		}
	}
	
	/**
	 * Coleta {@link SessionFactory}.
	 * @return {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory( )
	{
		return sessionFactory;
	}
}
package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Classe que provê recurso para se conectar ao BD.
 */
public class HibernateUtil
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
			System.err.println( "A criação de SessionFactory falhou." + e );
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
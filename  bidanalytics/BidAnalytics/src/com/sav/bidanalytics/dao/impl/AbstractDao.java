package com.sav.bidanalytics.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sav.bidanalytics.dao.api.IDao;


/**
 * Abstract Data Access Object - to create connections with the database.
 * @author saviosebastian
 *
 */
public abstract class AbstractDao implements IDao {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractDao.class.getName() );
	
	protected Connection connection = null;
	
	
	protected AbstractDao() {
		createJNDIConnection();
	}
	
	protected AbstractDao( final Connection connection1 ) {
		connection = connection1;
	}
	
	/**
	 * If you don't need to create a connection right away but after a while - eg: if you want to check if you have 
	 * optimized database calls by saving information into file system in a way that it can be retrieved immediately
	 * then you want to make sure that the database connection creation "isLazy"=true - so that you can first check
	 * if persisted data is enough to address the requirement - else read from the Database
	 *  
	 * @param isLazy
	 */
	protected AbstractDao( final boolean isLazy  ) {
		if( !isLazy ) {
			createJNDIConnection();
		}
	}
	
	protected AbstractDao( final int jdbc ) {
		createJDBCConnection();
	}
	
	protected final void createJNDIConnection() {
		try {
			final Context ctx = new InitialContext();
		    final DataSource ds = (DataSource)ctx.lookup(DB_CONTEXT_LOOKUP);
		    if (ds != null) {
		        connection = ds.getConnection();
		    }
		    connection.setAutoCommit( false );
		} catch (final NamingException e) {
			LOGGER.severe( e.toString() );
			connection = null;
		} catch (final SQLException e) {
			LOGGER.severe( e.toString() );
			connection = null;
		}
	}
	
	protected final void createJDBCConnection() {
		try {
			connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
		    connection.setAutoCommit( false );
		} catch (final SQLException e) {
			LOGGER.severe( e.toString() );
			connection = null;
		}
	}
	
	
	protected final void finallyMethod() {
		try {
			if( null != connection && !connection.isClosed() ) {
				connection.close();
				connection = null;
			}
		}  catch (final Exception ex) {
			exceptionHandler( ex, LOGGER);
		}
	}
	
	@Override
	public void finalize() {
		finallyMethod();
	}
	

	protected final void exceptionHandler( final Exception e, final Logger logger ) {
		logger.log( Level.SEVERE, logger.getName() + " " + e.toString() );
		if( IS_DEBUG_DAO ) {
			logger.log( Level.SEVERE , logger.getName() + " " + e.toString(), e );
			e.printStackTrace();
		}
	}

}

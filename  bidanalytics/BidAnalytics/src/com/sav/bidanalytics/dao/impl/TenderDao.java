package com.sav.bidanalytics.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import com.sav.bidanalytics.beans.impl.TenderInfo;
import com.sav.bidanalytics.dao.api.ITenderDao;

public final class TenderDao extends AbstractDao implements ITenderDao {
	
	private static final Logger LOGGER = Logger.getLogger( TenderDao.class.getName() );
	
	protected TenderDao() {
		super();
	}
	
	protected TenderDao( final Connection connection1 ) {
		super( connection1 );
	}
	
	/**
	 * If you don't need to create a connection right away but after a while - eg: if you want to check if you have 
	 * optimized database calls by saving information into file system in a way that it can be retrieved immediately
	 * then you want to make sure that the database connection creation "isLazy"=true - so that you can first check
	 * if persisted data is enough to address the requirement - else read from the Database
	 *  
	 * @param isLazy
	 */
	protected TenderDao( final boolean isLazy  ) {
		super(isLazy);
	}
	
	protected TenderDao( final int jdbc ) {
		super(jdbc);
	}
	
	
	public void put( final TenderInfo tenderInfo ) {
		try {
			final PreparedStatement statement = connection.prepareStatement( );
			
		} catch (final Exception e) {
			exceptionHandler(e, LOGGER);
		}
	}
	
	

}
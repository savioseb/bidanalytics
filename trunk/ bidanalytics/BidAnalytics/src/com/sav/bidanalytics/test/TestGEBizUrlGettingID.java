package com.sav.bidanalytics.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

public class TestGEBizUrlGettingID {
	
	private static final String urlString = "https://www.gebiz.gov.sg/scripts/main.do?doctype=TQ&doc=MOESCHETQ14015896&extSystemCode=E";
	public static final boolean IS_DEBUG_TEST = true;
	
	private static final Logger LOGGER = Logger.getLogger( TestGEBizUrlGettingID.class.getName() );
	
	
	private static final void testUrl() {
		try {
			final URL url = new URL(urlString);
			final URLConnection connection = url.openConnection();
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			final StringBuilder strBuilder = new StringBuilder();
			String line;
			while ( null != ( line = bufferedReader.readLine() ) ) {
				strBuilder.append( "\n" );
				strBuilder.append(line);
			}
			bufferedReader.close();
			final String response = strBuilder.toString();
			if( IS_DEBUG_TEST ) {
				LOGGER.info( "Response From ECP for " + urlString + ": " + response );
				//System.out.println( "Response From ECP for " + urlString + ": " + response );
			}
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
		}
		
	}
	
	public static final void main( final String args[] ) {
		testUrl();
	}

}

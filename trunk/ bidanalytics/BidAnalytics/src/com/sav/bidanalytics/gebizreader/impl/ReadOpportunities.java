package com.sav.bidanalytics.gebizreader.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.sav.bidanalytics.gebizreader.api.IReadOpportunities;


/**
 * Read GEBiz Opportunities
 * Date: 20141201 - Monday - 1121HRS SGT
 * 
 * - Write to Time Stamped File
 * 
 * @author saviosebastian
 *
 */
public class ReadOpportunities implements IReadOpportunities {

	private static final void testUrl() {
		try {
			final URL url = new URL( URL_READ_OPPORTUNITES_MAIN_URL );
			final URLConnection connection = url.openConnection();
			
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			final BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( )
				
				@Override
				public void write(int b) throws IOException {
					// TODO Auto-generated method stub
					
				}
			}))
			
			final StringBuilder strBuilder = new StringBuilder();
			String line;
			while ( null != ( line = bufferedReader.readLine() ) ) {
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

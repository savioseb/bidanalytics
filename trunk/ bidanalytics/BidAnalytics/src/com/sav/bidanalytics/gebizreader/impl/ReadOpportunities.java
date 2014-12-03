package com.sav.bidanalytics.gebizreader.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.sav.bidanalytics.beans.impl.OpportunityPageInfo;
import com.sav.bidanalytics.beans.impl.TenderInfo;
import com.sav.bidanalytics.gebizreader.api.IReadOpportunities;
import com.sav.bidanalytics.util.impl.WriteFileDump;


/**
 * Read GEBiz Opportunities
 * Date: 20141201 - Monday - 1121HRS SGT
 * 
 * - Write to Time Stamped File
 * 
 * @author saviosebastian
 *
 */
public final class ReadOpportunities implements IReadOpportunities {
	
	private static Logger LOGGER = Logger.getLogger( ReadOpportunities.class.getName() );
	
	/**
	 * Main Handle to process the URL
	 */
	private final void processUrl() {
		try {
			final String urlContents = readFromUrl( URL_READ_OPPORTUNITES_URL );
			WriteFileDump.write( urlContents, FILE_SAVE_PATH + "ReadOpportunties" );
			final OpportunityPageInfo opportunityPageInfo = new OpportunityPageInfo();
			getTenders(urlContents, opportunityPageInfo );
			
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
			if( IS_DEBUG ){ 
				e.printStackTrace();
			}
		}
	}
	
	
	private void getTenders( final String urlContents, final OpportunityPageInfo opportunityPageInfo ) {
		try {
			int lastIndex = 0;
			opportunityPageInfo.setQuotationInfos( new ArrayList<TenderInfo>() );
			while ( -1 != lastIndex ) {
				lastIndex = urlContents.indexOf( HTML_ELEMENT_QUOTATION , lastIndex );
				if( -1 != lastIndex ) {
					final TenderInfo quotationInfo = new TenderInfo();
					quotationInfo.setIndex( lastIndex );
					getTenderInfo(urlContents, quotationInfo);
					lastIndex = quotationInfo.getIndex();
					
					if( IS_DEBUG ) {
						System.out.println( quotationInfo.toCSV() );
					}
				}
			}
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
			if( IS_DEBUG ) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	/**
	 * Read the contents of the Tender Info from The Table Listing
	 * @param urlContents
	 * @param quotationInfo
	 */
	private void getTenderInfo( final String urlContents, final TenderInfo quotationInfo ) {
		try {
			final String[] results = new String[HTML_ELEMENT_STARTS.length ];
			for( int i = 0; i < HTML_ELEMENT_STARTS.length; i++ ) {
				results[i] = extractContents( urlContents, quotationInfo, HTML_ELEMENT_STARTS[i] , HTML_ELEMENT_ENDS[i]);
			}
			
			quotationInfo.setUrl( results[ INDEX_URL ] );
			quotationInfo.setNo( results[ INDEX_NO ] );
			quotationInfo.setDescription( results[ INDEX_DESC ] );
			quotationInfo.setCallingEntity( results[ INDEX_CALLING_ENTITY ] );
			quotationInfo.setPublicationDate( results[ INDEX_PUB_DATE ] );
			quotationInfo.setClosingDate( results[ INDEX_CLOSE_DATE ] );
			quotationInfo.setClosingTime( results[ INDEX_CLOSE_TIME ] );
			quotationInfo.setSubmissionType( results[ INDEX_SUB_TYPE ] );
			quotationInfo.setStatus( results[ INDEX_STATUS ] );
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
			if( IS_DEBUG ) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	/**
	 * Extract items
	 * @param urlContents the url's Contents
	 * @param quotationInfo Quotation info
	 * @param startingElement Starting Element to search for
	 * @param endingElement Ending Element to Search for
	 * @return String - the String between the start and Ending Element.
	 */
	private String extractContents( final String urlContents, final TenderInfo quotationInfo, final String startingElement, final String endingElement ) {
		try {
			final int urlStartIndex = startingElement.length() + urlContents.indexOf( startingElement, quotationInfo.getIndex() );
			final int urlEndIndex = urlContents.indexOf(endingElement , urlStartIndex );
			quotationInfo.setIndex( urlEndIndex );
			return urlContents.substring( urlStartIndex , urlEndIndex );
		} catch ( final Exception e ) {
			LOGGER.severe( e.toString() );
			if( IS_DEBUG ) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * Read the URL Contents
	 * @param urlString
	 * @return the contents of the URL
	 */
	private String readFromUrl( final String urlString ) {
		final StringBuilder strBuilder = new StringBuilder();
		try {
			final URLConnection connection = new URL( urlString ).openConnection();
			final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ( null != ( line = bufferedReader.readLine() ) ) {
				strBuilder.append( "\n" ).append(line);
			}
			bufferedReader.close();
			if( IS_DEBUG_PRINT_URL_CONTENTS ) {
				LOGGER.info( "Response From ECP for " + URL_READ_OPPORTUNITES_URL + ": " + strBuilder );
				//System.out.println( "Response From ECP for " + urlString + ": " + response );
			}
		} catch ( final Exception exception ) {
			LOGGER.severe( exception.toString() );
			if( IS_DEBUG ) {
				exception.printStackTrace();
			}
		}
		return strBuilder.toString();
	}
	
	
	public static final void main( final String args[] ) {
		new ReadOpportunities().processUrl();
	}
}

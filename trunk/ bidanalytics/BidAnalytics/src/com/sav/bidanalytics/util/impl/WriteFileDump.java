package com.sav.bidanalytics.util.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Logger;

import com.sav.bidanalytics.util.api.IProjectConstants;

public final class WriteFileDump implements IProjectConstants {
	
	private static final Logger LOGGER = Logger.getLogger( WriteFileDump.class.getName() );
	
	public static final void write( final String urlContents, final String filename ) {
		if( IS_FILE_DUMP ) {
			try {
				final String fileDumpName = filename + GetDateTimeCurrent.get() + ".html" ;
				final BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( new File( fileDumpName ) ) );
				bufferedWriter.append( urlContents );
				bufferedWriter.close();
			} catch ( Exception exception ) {
				LOGGER.severe( "Error while trying to write file: " + filename + "\n" + exception.toString() );
				if( IS_DEBUG ) {
					exception.printStackTrace();
				}
			}
		}
	}

}

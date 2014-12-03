package com.sav.bidanalytics.util.impl;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Logger;

import com.sav.bidanalytics.util.api.IProjectConstants;

public final class GeBizSessionManagement implements IProjectConstants {
	
	private List<String> cookies;
	private static GeBizSessionManagement geBizSessionManagement = null;
	
	
	private static final Logger LOGGER = Logger.getLogger( GeBizSessionManagement.class.getName() );
	
	private GeBizSessionManagement() {
	}
	
	public static List<String> getNewCookies() {
		if( null == geBizSessionManagement ) {
			geBizSessionManagement = new GeBizSessionManagement();
		}
		return geBizSessionManagement.createCookiePrivate();
	}
	
	public static List<String> getCookies() {
		if( null == geBizSessionManagement ) {
			geBizSessionManagement = new GeBizSessionManagement();
		}
		return geBizSessionManagement.getCookiesPrivate();
	}
	
	private List<String> getCookiesPrivate() {
		if( null != cookies ) {
			return cookies;
		}
		return createCookiePrivate();
	}
	
	private synchronized List<String> createCookiePrivate() {
		try {
			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
			final URL url = new URL( "https://www.gebiz.gov.sg/scripts/main.do?sourceLocation=openarea&select=tenderId" );
			final URLConnection connection = url.openConnection();
			cookies = connection.getHeaderFields().get("Set-Cookie");
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
			if( IS_DEBUG ) {
				e.printStackTrace();
			}
		}
		return cookies;
	}

}

package com.sav.bidanalytics.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class TestGEBizUrl {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	private static List<String> cookies = null;
	
	private static final String urlString = "https://www.gebiz.gov.sg/scripts/main.do?sourceLocation=openarea&select=tenderId";
	public static final boolean IS_DEBUG_TEST = true;
	
	private static final Logger LOGGER = Logger.getLogger( TestGEBizUrl.class.getName() );
	
	
	private static final void testUrl() {
		try {
			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
			final URL url = new URL(urlString);
			final URLConnection connection = url.openConnection();
			cookies = connection.getHeaderFields().get("Set-Cookie");
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
				//LOGGER.info( "Response From ECP for " + urlString + ": " + response );
				//System.out.println( "Response From ECP for " + urlString + ": " + response );
			}
		} catch (final Exception e) {
			LOGGER.severe( e.toString() );
		}
		
	}
	
	
	private static void createSession() throws Exception {
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		final URL url = new URL( "https://www.gebiz.gov.sg/scripts/main.do?sourceLocation=openarea&select=tenderId" );
		final URLConnection connection = url.openConnection();
		cookies = connection.getHeaderFields().get("Set-Cookie");
	}
	
	
	
	private static void sendPost() throws Exception {
		
		createSession();
		 
		String url = "	https://www.gebiz.gov.sg/scripts/main.do?sourceLocation=openarea&select=tenderId";
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		if( null != cookies ) {
			for (String cookie : cookies) {
			    con.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
			}
			System.out.println("Cookies: " + new Gson().toJson( cookies ) );
		}
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "selectedCategory=&optionOnChange=false&callingEntitySelected=&supplyHead=&dateType=Publication+Date&dateFrom=30%2F11%2F2014&dateTo=&searchByTQNo=&searchByTQIntNo=&searchByDesc=&sortField=publish_date&sortDirection=ASC&htmlTableDesc=TQNoticeList&new_line_no=1&htmlTableInternalSubmit=&htmlTableFrom=";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append( "\n" );
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
	
	public static final void main( final String args[] ) throws Exception {
		//testUrl();
		sendPost();
		//String a = "sav " \n sav";
		//System.out.println( a.replaceAll( "\n", " " ) );
		
	}

}

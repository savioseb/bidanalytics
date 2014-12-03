package com.sav.bidanalytics.gebizreader.api;

import com.sav.bidanalytics.util.api.IProjectConstants;

public interface IReadOpportunities extends IProjectConstants, IUrls {
	
	public static final String URL_READ_OPPORTUNITES_URL = MAIN_URL + "/scripts/main.do?sourceLocation=openarea&select=tenderId";
	
	/**
	 * Look for Elements
	 */
	public static final String HTML_ELEMENT_QUOTATION = "<td><b>Quotation:</b>";
	
	public static final String HTML_ELEMENT_QUOTE_URL_START = "<a href=\"";
	public static final String HTML_ELEMENT_QUOTE_URL_END =  "\"";
	public static final String HTML_ELEMENT_QUOTE_NO_B_START = "<b>\n\t\t\t\t\t\t";
	public static final String HTML_ELEMENT_QUOTE_NO_B_END = "\n\t\t\t\t\t</b>";
	public static final String HTML_ELEMENT_QUOTE_DESCRIPTION_START = "<td valign=\"top\" >\n            <table width=\"99%\" border=\"0\" cellpadding=\"2\" cellspacing=\"0\">\n                <tr>\n                    <td>";
	public static final String HTML_ELEMENT_QUOTE_DESCRIPTION_END = "</td>";
	public static final String HTML_ELEMENT_QUOTE_CALLING_ENTITY_START = "<td><b>Calling Entity</b> ";
	public static final String HTML_ELEMENT_QUOTE_CALLING_ENTITY_END = "</td>";
	public static final String HTML_ELEMENT_QUOTE_PUBLICATION_START = "<td align=\"center\">";
	public static final String HTML_ELEMENT_QUOTE_PUBLICATION_END = "</td>";
	public static final String HTML_ELEMENT_QUOTE_CLOSING_DATE_START = "<td align=\"center\">";
	public static final String HTML_ELEMENT_QUOTE_CLOSING_DATE_END = "</td>";
	public static final String HTML_ELEMENT_QUOTE_CLOSING_TIME_START = "<td align=\"center\">";
	public static final String HTML_ELEMENT_QUOTE_CLOSING_TIME_END = "</td>";
	public static final String HTML_ELEMENT_QUOTE_SUBMISSION_TYPE_START = "<td align=\"center\"><span class=\"hgA11M\"><b>";
	public static final String HTML_ELEMENT_QUOTE_SUBMISSION_TYPE_END = "</b></span> </td>";
	public static final String HTML_ELEMENT_QUOTE_STATUS_START = "<td align=\"center\" valign=\"top\">\n            ";
	public static final String HTML_ELEMENT_QUOTE_STATUS_END = "\n        </td>";
	
	final String[] HTML_ELEMENT_ENDS = {
			HTML_ELEMENT_QUOTE_URL_END,
			HTML_ELEMENT_QUOTE_NO_B_END,
			HTML_ELEMENT_QUOTE_DESCRIPTION_END,
			HTML_ELEMENT_QUOTE_CALLING_ENTITY_END,
			HTML_ELEMENT_QUOTE_PUBLICATION_END,
			HTML_ELEMENT_QUOTE_CLOSING_DATE_END,
			HTML_ELEMENT_QUOTE_CLOSING_TIME_END,
			HTML_ELEMENT_QUOTE_SUBMISSION_TYPE_END,
			HTML_ELEMENT_QUOTE_STATUS_END
	};
	
	final String[] HTML_ELEMENT_STARTS = {
			HTML_ELEMENT_QUOTE_URL_START,
			HTML_ELEMENT_QUOTE_NO_B_START ,
			HTML_ELEMENT_QUOTE_DESCRIPTION_START,
			HTML_ELEMENT_QUOTE_CALLING_ENTITY_START,
			HTML_ELEMENT_QUOTE_PUBLICATION_START,
			HTML_ELEMENT_QUOTE_CLOSING_DATE_START,
			HTML_ELEMENT_QUOTE_CLOSING_TIME_START,
			HTML_ELEMENT_QUOTE_SUBMISSION_TYPE_START,
			HTML_ELEMENT_QUOTE_STATUS_START
	};
	
	public static final int INDEX_URL = 0;
	public static final int INDEX_NO = 1;
	public static final int INDEX_DESC = 2;
	public static final int INDEX_CALLING_ENTITY = 3;
	public static final int INDEX_PUB_DATE = 4;
	public static final int INDEX_CLOSE_DATE = 5;
	public static final int INDEX_CLOSE_TIME = 6;
	public static final int INDEX_SUB_TYPE = 7;
	public static final int INDEX_STATUS = 8;
	
		
	

}

package com.sav.bidanalytics.dao.api;

import com.sav.bidanalytics.util.api.IProjectConstants;

public interface IDao extends IProjectConstants {
	
	public static final String DB_CONTEXT_LOOKUP = "java:comp/env/jdbc/bidanalytics";
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/bidanalytics";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root123";

}

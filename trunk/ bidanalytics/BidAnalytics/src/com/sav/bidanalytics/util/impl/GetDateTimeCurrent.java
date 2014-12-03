package com.sav.bidanalytics.util.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class GetDateTimeCurrent {

	public static final String get() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format( new Date() );	
	}
}

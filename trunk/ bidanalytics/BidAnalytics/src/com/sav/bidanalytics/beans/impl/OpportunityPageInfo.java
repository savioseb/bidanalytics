package com.sav.bidanalytics.beans.impl;

import java.util.ArrayList;

import com.google.gson.Gson;

public final class OpportunityPageInfo {
	
	private int pageNo;
	private ArrayList<TenderInfo> quotationInfos;
	
	
	@Override
	public String toString() {
		return new Gson().toJson( this );
	}
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public ArrayList<TenderInfo> getQuotationInfos() {
		return quotationInfos;
	}
	public void setQuotationInfos(ArrayList<TenderInfo> quotationInfos) {
		this.quotationInfos = quotationInfos;
	}
	
	

}

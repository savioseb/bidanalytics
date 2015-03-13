package com.sav.bidanalytics.beans.impl;

import com.google.gson.Gson;
import com.sav.bidanalytics.beans.api.IPersist;

public final class TenderInfo implements IPersist {
	
	private String no;
	private String reference;
	private String description;
	private String publicationDate;
	private String closingDate;
	private String closingTime;
	private String callingEntity;
	private String submissionType;
	private String status;
	private String url;
	private transient int index;
	private transient boolean isPersisted;
	
	@Override
	public String toString() {
		return new Gson().toJson( this );
	}
	
	public String toCSV() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append( no );
		strBuilder.append( ", " );
		strBuilder.append( "\"" ).append( reference.replaceAll("\"", "\"\"" ).replaceAll( "\n", " " ) ).append( "\"");
		strBuilder.append( ", " );
		strBuilder.append( "\"" ).append( description.replaceAll("\"", "\"\"" ).replaceAll( "\n", " " ) ).append( "\"");
		strBuilder.append( ", " );
		strBuilder.append( publicationDate );
		strBuilder.append( ", " );
		strBuilder.append( closingDate );
		strBuilder.append( ", " );
		strBuilder.append( closingTime );
		strBuilder.append( ", " );
		strBuilder.append( "\"" ).append( callingEntity.replaceAll("\"", "\"\"" ) ).append( "\"");
		strBuilder.append( ", " );
		strBuilder.append( submissionType );
		strBuilder.append( ", " );
		strBuilder.append( status );
		strBuilder.append( ", " );
		strBuilder.append( url );
		return strBuilder.toString();
		
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public String getCallingEntity() {
		return callingEntity;
	}

	public void setCallingEntity(String callingEntity) {
		this.callingEntity = callingEntity;
	}

	public String getSubmissionType() {
		return submissionType;
	}

	public void setSubmissionType(String submissionType) {
		this.submissionType = submissionType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public boolean isPersisted() {
		return isPersisted;
	}

	@Override
	public void setPersisted(boolean isPersisted) {
		this.isPersisted = isPersisted;
	}
	
	
	
	

}

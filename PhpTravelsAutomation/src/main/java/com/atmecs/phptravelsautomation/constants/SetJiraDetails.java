package com.atmecs.phptravelsautomation.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravelsautomation.utils.ReadPropertiesFile;

public class SetJiraDetails {
	Properties property;
	private String jiraUrl;
	private String userName;
	private String password;
	private String projectName;
	private String issueDetails;
	private String issueType;
	private String reporterName;
	
	
	public SetJiraDetails(String filepath) {
		try {
			property= ReadPropertiesFile.loadProperty(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setJiraUrl();
		setPassword();
		setUserName();
	    setProjectName();
	    setIssueDetails();
	    setIssueType();
	    setReporterName();
	}
	public String getJiraUrl() {
		return jiraUrl;
	}
	public void setJiraUrl() {
		this.jiraUrl = property.getProperty("jiraUrl");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName() {
		userName = property.getProperty("userName");
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword() {
		password = property.getProperty("password");
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName() {
		projectName =  property.getProperty("projectName");
	}
	public String getIssueDetails() {
		return issueDetails;
	}
	public void setIssueDetails() {
		issueDetails = property.getProperty("issueDetails");
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType() {
		issueType = property.getProperty("issueType");
	}
	public String getReporterName() {
		return reporterName;
	}
	public void setReporterName() {
		this.reporterName = property.getProperty("reporterName");
	}

}

package com.atmecs.phptravelsautomation.jiralisteners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.atmecs.phptravelsautomation.constants.FilePath;
import com.atmecs.phptravelsautomation.constants.SetJiraDetails;
import com.atmecs.phptravelsautomation.utils.JiraLogTicketProvider;
import com.atmecs.phptravelsautomation.utils.RaiseJiraTicket;

public class LogJiraTicket implements ITestListener{
	SetJiraDetails details= new SetJiraDetails(FilePath.JIRA_CONFIG);


	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
        RaiseJiraTicket jiraTicket= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(RaiseJiraTicket.class);
		boolean isTicketReady = jiraTicket.jiraTicketReady();
		System.out.println("The status of jiraTicket is"+isTicketReady);
		
		if(isTicketReady) {
			System.out.println(" the jira ticket is "+isTicketReady);
			JiraLogTicketProvider logTicket = new JiraLogTicketProvider(details.getJiraUrl(), details.getUserName(), details.getPassword(), details.getProjectName());
			String issueSummary= result.getMethod().getConstructorOrMethod().getMethod().getName()+details.getIssueDetails();
			String issueDescription = result.getThrowable().getMessage()+"\n";
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			logTicket.createJiraTicket(details.getIssueType(), issueSummary, issueDescription,details.getReporterName());
		
	}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

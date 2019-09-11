package com.atmecs.phptravelsautomation.utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Issue.FluentCreate;

public class JiraLogTicketProvider {
	public JiraClient client;
	public String project;
	
	public JiraLogTicketProvider(String jiraUrl, String userName, String password, String project) {
		BasicCredentials credentials= new BasicCredentials(userName, password);
		client = new JiraClient(jiraUrl,credentials);
		this.project = project;
	}
	public void createJiraTicket(String issueType, String summary,String description, String reporterName) {
		try {
		FluentCreate create = client.createIssue(project, issueType);
		create.field(Field.SUMMARY, summary);
		create.field(Field.DESCRIPTION, description);
		Issue newIssue  = create.execute();
		System.out.println("new issue created with jira ID "+newIssue);
		
		}
		catch (JiraException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

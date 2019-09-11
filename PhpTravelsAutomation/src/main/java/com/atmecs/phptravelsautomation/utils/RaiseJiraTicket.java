package com.atmecs.phptravelsautomation.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RaiseJiraTicket {
	boolean jiraTicketReady();

}

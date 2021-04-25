package covidresources.enums;

public enum CovidResourcesAPILogCodes {
	
	COVID_RESOURCES_API_INFO_CODE("info_in_module=calendar-api "),
	COVID_RESOURCES_API_ERROR_CODE("error_in_module=calendar-api "),
	COVID_RESOURCES_API_WARN_CODE("warning_in_module=calendar-api "),
	COVID_RESOURCES_API_EXECUTION_CODE("execution_metrics_in_module=calendar-api ");

	private String logMessage;

	private CovidResourcesAPILogCodes(String logMessage){
	    this.logMessage=logMessage;
	}
	public String getLogMessage(){
	    return logMessage;
	}

}

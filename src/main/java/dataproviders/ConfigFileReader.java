package dataproviders;

import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;

	public String getReportConfigPath() {
		// TODO Auto-generated method stub
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("reportConfigPath not specified in the Configuration.properties file.");
	}
}
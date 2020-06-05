package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.cucumber.listener.Reporter;

import managers.FileReaderManager;
import setup.WebSetup;

public class ExtentReporter extends WebSetup {
	
	public ExtentReporter() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}

}

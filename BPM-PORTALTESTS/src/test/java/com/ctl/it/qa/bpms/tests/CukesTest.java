package com.ctl.it.qa.bpms.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ctl.it.qa.staf.Environment;
import com.ctl.it.qa.staf.HtmlReport;
import com.ctl.it.qa.staf.STAFEnvironment;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;
// import com.github.mkolisnyk.cucumber.reporting.CucumberConsolidatedReport;
// import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
// import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
// import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
// import net.masterthought.cucumber.Configuration;
// import net.masterthought.cucumber.ReportBuilder;
// import net.masterthought.cucumber.Reportable;
// import net.masterthought.cucumber.presentation.PresentationMode;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@TestEnvironment(Environment.TEST1)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/Features", tags = {"@DIA_Sanity"},
		// glue = {"com.ctl.it.qa.bpms.tests.stepdefinitions"},
		plugin = { "pretty", "html:target/cucumber", "html:target/site/serenity/index.html",
				"json:target/jira-xray-data.json", "json:target/cucumber-report.json",
				"usage:target/site/serenity/cucumber-usage.json" })
// "pretty:target/site/serenity/cucumber-pretty.txt",
// "junit:target/site/serenity/cucumber-results.xml",
// "usage:target/site/serenity/cucumber-usage.json"})

public class CukesTest {

	@BeforeClass
	public static void setEnvironment() {
		STAFEnvironment.registerEnvironment(CukesTest.class);
		Steps.initialize("data.xml");
//		SplunkLogger.cukeTestSplunkBeforeClass();
//		RallyTools.initiateRallyLogin();
	}

	@AfterClass
	public static void generateSplunkLog() throws Exception {
	//	SplunkLogger.cukeTestSplunkAfterClass(CukesTest.class);
		HtmlReport.generate();
		File reportOutputdirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber-report.json");

		String ProjectName = "BPMS";
		

// 		Configuration config = new Configuration(reportOutputdirectory, ProjectName);
// 		config.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);

// 		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
// 		Reportable result = reportBuilder.generateReports();		

// 		CucumberResultsOverview result2 = new CucumberResultsOverview();
// 		result2.setOutputDirectory("target");
// 		result2.setOutputName("cucumber-results");
// 		result2.setSourceFile("./target/cucumber-report.json");
// 		result2.executeFeaturesOverviewReport();

//		CucumberDetailedResults results = new CucumberDetailedResults();
//		results.setOutputDirectory("target/");
//		results.setOutputName("cucumber-results");
//		results.setSourceFile("./target/cucumber-report.json");
//		results.execute();

//		CucumberConsolidatedReport result2 = new CucumberConsolidatedReport();
//		result2.setOutputDirectory("target");
//		result2.setOutputName("cucumber-results");
//		result2.setPdfPageSize("A4 landscape");
//		result2.setSourceFile("./target/cucumber-report.json");
//		result2.execute(
//			new File("./target/cucumber-report.json"),
//			true
//		);
//		result2.execute();
//
// 		RallyTools.closeRallyAPI();

	}
}

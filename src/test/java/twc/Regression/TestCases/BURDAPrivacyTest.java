package twc.Regression.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import org.testng.annotations.Test;

import twc.Regression.HandleWithCharles.CharlesProxy;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import twc.Regression.Driver.Drivers;
import twc.Regression.General.Functions;
import twc.Regression.General.TwcAndroidBaseTest;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;


public class BURDAPrivacyTest extends TwcAndroidBaseTest  {
	

	
	private static final String CONFIG_FILE_PATH = "charles_common.config";
	private File configFile;
	private CharlesProxy proxy;
	
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** BURDA Privacy Test Started");
		logStep("****** BURDA Privacy Test Started");
		//this.configFile = this.rewriteRuleToEnableLGPD(CONFIG_FILE_PATH);
		this.configFile = this.charlesGeneralConfigFile(CONFIG_FILE_PATH);
		proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

		proxy.startCharlesProxyWithUI();
		proxy.disableRewriting();
		proxy.stopRecording();
		proxy.disableMapLocal();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** LGPD  Privacy Test Ended");
		logStep("****** LGPD Privacy Test Ended");
	}

	
	
	@Test(priority = 0)
	@Title("Enable Preconditions to change region to Germany for BURDA ")
	public void enable_preConditions_toChange_Region_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** enable Preconditions to change region to Germany for BURDA test case Started");
		logStep("****** enable Preconditions to change region to Germany for BURDA test case Started");
	//	Functions.Appium_Autostart();
		// Preconditions
		//Utils.getCurrentMacIPAddressAndSetiPhoneProxy(true, true);
	//	Functions.listFilesForFolder(CharlesFunctions.folder);
		CharlesFunctions.archive_folder("Charles");
		proxy.startRecording();
		proxy.clearCharlesSession();
		Functions.launchtheApp_forLocalization("true","fr_DE",true,"de",false);
		System.out.println("App launched ");
		logStep("App launched ");
		proxy.getXml();
		CharlesFunctions.archive_folder("Charles");
		proxy.clearCharlesSession();
		AppiumFunctions.Kill_Launch_App();
		proxy.getXml();
	//CharlesFunctions.createXMLFileForCharlesSessionFile();
	}
	
	
	
	@Test(priority = 130, enabled = true)
	@Title("Validating NextGen IM Call npa value")
	public void validate_NextGen_IM_call_npa_val_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating NextGen IM Call npa value");
		logStep("Validating NextGen IM Call npa value ");

		  Functions.validate_npa_homescreenmarquee_Optoutmode();

	}
	
	
	
	
	
	
	@Test(priority = 140, enabled = true)
	@Title("Enable Preconditions to change region to Germany and language to German for BURDA ")
	public void enable_preConditions_toChange_Region_and_Language_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Enable Preconditions to change region to Germany and language to German for BURDA test case Started");
		logStep("****** Enable Preconditions to change region to Germany and language to German for BURDA test case Started");
		Ad.closeApp();
	//	Functions.Appium_Autostart();
		// Preconditions
		//Utils.getCurrentMacIPAddressAndSetiPhoneProxy(true, true);
		//Functions.listFilesForFolder(Functions.folder);
		CharlesFunctions.archive_folder("Charles");
		proxy.startRecording();
		proxy.clearCharlesSession();
		Functions.launchtheApp_forLocalizationn("true","fr_DE",true,"de",true);
		System.out.println("App launched ");
		logStep("App launched ");
		CharlesFunctions.archive_folder("Charles");
		proxy.clearCharlesSession();
		AppiumFunctions.Kill_Launch_App();
		proxy.getXml();
	//CharlesFunctions.createXMLFileForCharlesSessionFile();
	}

	
	@Test(priority = 151, enabled = true)
	@Title("Validating Video Call npa value")
	public void validate_Video_call_npa_val_for_BURDA() throws Exception {
		System.out.println("==============================================");
		System.out.println("****** Validating Video Call npa value");
		logStep("Validating Video Call npa value ");

	Functions.validate_npa_video_ad_dontsellmyinformation();
	CharlesFunctions.archive_folder("Charles");

	}
	
	
	
	
	
	@Test(priority = 40)
	public void preConditionsTest_for_LGPD() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
		   AppiumFunctions.resetApp();
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();
		// Preconditions
	//	Utils.getCurrentMacIPAddressAndSetiPhoneProxy(true, true);
		//Functions.listFilesForFolder(Functions.folder);
	//	Functions.archive_folder("Charles");
		//Functions.launchtheApp("true");
		System.out.println("App launched ");
		this.proxy.clearCharlesSession();
		AppiumFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
		AppiumFunctions.clickOnVideos_tile();
	//	Functions.close_launchApp();
		//Utils.navigateToAllCards(false);
		CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	//	Utils.createXMLFileForCharlesSessionFile();
	}
	
	

	
	
	
	
	
	
	
	
	
}

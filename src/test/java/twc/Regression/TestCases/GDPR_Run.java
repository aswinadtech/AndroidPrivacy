package twc.Regression.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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

public class GDPR_Run extends TwcAndroidBaseTest  {
	
	
	private static final String CONFIG_FILE_PATH ="enableGDPR.config";
	private CharlesProxy proxy;
	private File configFile;
	public static String  ipAddress=null;
	public static String  portNumber=null;
	
	public static String  defaultPortNumber=properties.getProperty("PortNumber");
	public static String CurrentWifiName=null;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** GDPR Privacy Test Started");
		logStep("****** GDPR Privacy Test Started");
		/*this.configFile = this.rewriteRuleToEnableGDPR(CONFIG_FILE_PATH);
		this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);
		this.proxy.startCharlesProxyWithUI();
		this.proxy.disableRewriting();
		this.proxy.stopRecording();
		this.proxy.disableMapLocal();*/
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		/*if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** GDPR Privacy Test Ended");
		logStep("****** GDPR Privacy Test Ended");*/
	}
	
	@Test(priority = 0)
	public void preConditionsTest_for_GDPR() throws Exception {
	
		
	}
	@Test(priority =2,enabled = true)  
	 @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for GDPR privacy") 
	public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_GDPR_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for GDPR privacy testcase started =========================" ); 
     // Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out. println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for GDPR privacy  testcase End =========================" );
	  }
	
	
		@Test(priority = 3, enabled = true)
	@Title("Verifying wfxtg trigger api call url on KillLaunch")
	public void Smoke_Test_CaseVerify_WeatherFXAPI_url_KillLaunch() throws Exception {
		System.out.println("================= Verifying WeatherFX API url started =========================");
		
		//Functions.validating_WeatherFXAPI();
		System.out.println("================= Verifying WeatherFX API url End =========================");
	}
	

	@Test(priority =4,enabled = true)  
	 @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for GDPR privacy") 
	public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_GDPR_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for GDPR privacy testcase started =========================" ); 
	// Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for GDPR privacy testcase End =========================" );
	  }
	
		@Test(priority =6,enabled = true)  
	 @Title("Verifying Factual location.wfxtriggers.com api call supressing for GDPR privacy")  
	public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_GDPR_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing for GDPR privacy started =========================" ); 
	//Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
		  
	  System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing for GDPR privacy End =========================" );
	  }
	
	

	 /*@Test(priority=8,enabled = true)  
	  @Title("Verifying supress amazon slot id for  home screen hourly preload ad call GDPR Privacy") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_GDPRPrivacy() throws Exception { 
	  System.out.println("=================Verifying supress amazon slot id for  home screen hourly preload ad call GDPR Privacy test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call GDPR Privacy");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slot id in home screen hourly preload ad call for GDPR Privacy  test case  End ========================="); 
	  }*/
	
	
	
	
	/*@Test(priority =28, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for GDPR privacy" ) 
		  public void  Verifying_homescreenhourly_adCall_Presence_GDPR_privacy() throws Exception {
	   System.out.println("=================Verifying home screen hourly ad call presense for GDPR privacy  testcase started =========================" );
		  logStep("Verifying home screen hourly ad call presense for GDPR privacy");
		  Functions.finding_Homescreen_iu_value();
		  System.out.println("=================Verifying home screen hourly ad call presense for GDPR privacy  testcase  End =========================" );	  
		  }*/
		  
		  @Test(priority = 30, enabled = true)	  
		  @Title("Verifying home screen marquee ad call presense for GDPR privacy" )	
		  public void Verifying_homescreenmarquee_adCall_Presence_GDPR_privacy()  throws Exception {
		  logStep("Verifying home screen marquee ad call presense for GDPR privacy" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for GDPR privacy test case started =========================" );  
		 //Functions.finding_Homescreen_marquee_iu_value();
		  System.out.println("=================Verifying home screen marquee ad call presense for GDPR privacy test case End =========================" );	  
		  }
		

			/*@Test(priority =32, enabled = true)  
			 @Title("Verifying npa=1 in home screen hourly ad call for GDPR privacy") 
			public void Verifying_npa_equals_1_homescreenHourly_adCall_GDPR_Privacy() throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen hourly ad call for GDPR privacy  testcase started =========================" ); 
			  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen hourly ad call for GDPR privacy  testcase End =========================" );
			  }*/
		  
			@Test(priority =34, enabled = true)  
			 @Title("Verifying npa=1 in home screen marquee ad call for GDPR privacy") 
			public void Verifying_npa_equals_1_homescreenmarquee_adCall_GDPR_Privacy() throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen marquee ad call for GDPR privacy  testcase started =========================" ); 
			//Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen marquee ad call for GDPR privacy  testcase End =========================" );
			  }
		
		
			
			@Test(priority =36, enabled = true)  
			 @Title("Verifying npa=1 in videos ad call for GDPR privacy") 
			public void Verifying_npa_equals_1_videos_adCall_GDPR_Privacy() throws Exception {	  
			 System.out. println("=================Verifying npa=1 in detailed page ad call for GDPR privacy testcase started =========================" ); 
			// Functions.validate_npa_video_ad_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in detailed page ad call for GDPR privacy testcase End =========================" );
			  }
	
		@Test(priority = 38, enabled = true)
		@Title("Verify Criteo SDK inapp v2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_GDPR() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
			//CharlesFunctions.createXMLFileForCharlesSessionFile();
			//Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

		}

		@Test(priority = 40, enabled = true)
		@Title("Verify Criteo SDK config app call")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_GDPR() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");
			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");
			//Functions.verifyCriteo_config_app_Call("Criteo", false);
			//CharlesFunctions.archive_folder("Charles");
			

		}

	
	
		

}

package twc.Regression.TestCases;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;
import twc.Regression.General.Functions;
import twc.Regression.General.TwcAndroidBaseTest;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.HandleWithCharles.CharlesProxy;

public class EXEMPT_Run extends TwcAndroidBaseTest {

	private static final String CONFIG_FILE_PATH = "enableExempt.config";
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** EXEMPT Privacy Test Started");
		logStep("****** EXEMPT  Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableEXEMPT(CONFIG_FILE_PATH);
		this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

		this.proxy.startCharlesProxyWithUI();
		this.proxy.disableRewriting();
		this.proxy.stopRecording();
		this.proxy.disableMapLocal();
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (this.configFile != null) {
			this.configFile.delete();
		}
		this.proxy.disableRewriting();
		//this.proxy.quitCharlesProxy();
		
		System.out.println("****** EXEMPT   Privacy Test Ended");
		logStep("****** EXEMPT  Privacy Test Ended");
	}
	
	@Test(priority = 2000)
	public void preConditionsTest_for_EXEMPT() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		
	}
	@Test(priority =2002,enabled = true)  
	 @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for EXEMPT  privacy") 
	public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_EXEMPT_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for EXEMPT  privacy testcase started =========================" ); 
	 Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out. println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for EXEMPT  privacy  testcase End =========================" );
	  }
	

	@Test(priority =2004,enabled = true)  
	 @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for EXEMPT  privacy") 
	public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_EXEMPT_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for EXEMPT  privacy testcase started =========================" ); 
	 Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for EXEMPT  privacy testcase End =========================" );
	  }
	
	@Test(priority =2006,enabled = true)  
	 @Title("Verifying Factual location.wfxtriggers.com api call supressing for EXEMPT  privacy")  
	public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_EXEMPT_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing for EXEMPT  privacy started =========================" ); 
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	  System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing for EXEMPT  privacy End =========================" );
	  }
	
	  @Test(priority = 2007, enabled = true)	  
	  @Title("Verifying weatherfx api call presence for EXEMPT privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_weatherfxapiCall_presence_EXEMPT_Privacy() throws Exception {
	   logStep("Verifying weatherfx api call presence  for for EXEMPT  privacy testcase started"); 
	   System.out.println("=================Verifying weatherfx api call presence  for for EXEMPT  privacy testcase started test case started =========================");
	   Functions.validating_WeatherFXAPI();	
	   System.out. println("================= Verifying weatherfx api call presence  for for EXEMPT  privacy testcase started test case End =========================" ); 
	  }
	

	 /*@Test(priority=2008,enabled = true)  
	  @Title("Verifying supress amazon slot id for  home screen hourly preload ad call EXEMPT Privacy") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_EXEMPT_Privacy()throws Exception { 
	  System.out.println("=================Verifying supress amazon slot id for  home screen hourly preload ad call EXEMPT Privacy test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call EXEMPT Privacy");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slot id in home screen hourly preload ad call for EXEMPT Privacy  test case  End ========================="); 
	  }*/
	
	 
		@Test(priority = 2010, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call EXEMPT Privacy")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_EXEMPT_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call EXEMPT Privacy testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call EXEMPT Privacy");
			//Functions.get_aaxcal_feed1();
			 // Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call EXEMPT Privacy testcase End =========================");

		}
	
	@Test(priority = 2012, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call EXEMPT Privacy")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_EXEMPT_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call EXEMPT Privacy testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call EXEMPT Privacy");
		//Functions.get_aaxcal_feed2();
		 // Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call EXEMPT Privacy  testcase End =========================");
	}

	 @Test(priority = 2014, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call EXEMPT Privacy")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_EXEMPT_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call EXEMPT Privacy testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call EXEMPT Privacy");
		//Functions.get_aaxcal_Hourly();
		 // Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call EXEMPT Privacy testcase  End =========================");
		}
		
		  @Test(priority =2016, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call EXEMPT Privacy")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_EXEMPT_Privacy() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call EXEMPT Privacy  test case Started =========================");
				//Functions.get_aaxcal_Hourly1();
				  //Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call EXEMPT Privacy test case  End =========================");

			}
			


			@Test(priority = 2018, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call EXEMPT Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_EXEMPT_Privacy() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call EXEMPT Privacy test case Started =========================");
				//Functions.get_aaxcal_Hourly2();
				 //Functions.verifyaax_SlotId_supress("4fbed16a-cc6f-4cb1-94f7-81465acbd47");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call EXEMPT Privacy test case  End =========================");

			}



			@Test(priority = 2020, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call EXEMPT Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_EXEMPT_Privacy()throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call EXEMPT Privacy test case  Started =========================");
			//	Functions.get_aaxcal_Hourly3();
				 //Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call EXEMPT Privacy  test case End =========================");
			}
			  

		
		@Test(priority = 2022, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call EXEMPT Privacy")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_EXEMPT_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call EXEMPT Privacy  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call EXEMPT Privacy");
			//Functions.get_aaxcal_map_details();
			 //Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call EXEMPT Privacy testcase  End =========================");
		}
	

		@Test(priority = 2024, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call EXEMPT Privacy")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_EXEMPT_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call EXEMPT Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call EXEMPT Privacy");
			//Functions.get_aaxcal_Daily();
			// Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call LATAM_CO Privacy testcase End =========================");
		}
		@Test(priority = 2026, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for EXEMPT Privacy")
		public void Verifying_supress_amazon_Slotid_video_adcall_EXEMPT_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for EXEMPT Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for EXEMPT Privacy");
			// Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for EXEMPT Privacy testcase  End =========================");
		        //CharlesFunctions.archive_folder("Charles");
		}	
	
	@Test(priority = 2028, enabled = true)
		@Title("Verify Criteo SDK inapp v2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_EXEMPT_Privacy() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
			CharlesFunctions.createXMLFileForCharlesSessionFile();
			Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

		}

		@Test(priority = 2030, enabled = true)
		@Title("Verify Criteo SDK config app call")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_EXEMPT_Privacy() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");
			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");
			CharlesFunctions.archive_folder("Charles");
			Functions.verifyCriteo_config_app_Call("Criteo", false);
		}
	
	
	
		
	
	


}

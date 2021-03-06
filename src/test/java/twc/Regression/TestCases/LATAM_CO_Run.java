package twc.Regression.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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

public class LATAM_CO_Run extends TwcAndroidBaseTest {
	private static final String CONFIG_FILE_PATH = "enableLATAMCO.config";
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** LATAM CO Privacy Test Started");
		logStep("****** LATAM CO  Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableLATAMCO(CONFIG_FILE_PATH);
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
		
		System.out.println("****** LATAM CO   Privacy Test Ended");
		logStep("****** LATAM CO  Privacy Test Ended");
	}
	
	@Test(priority = 500)
	public void preConditionsTest_for_LATAMCO() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		CharlesFunctions.archive_folder("Charles");
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
		attachScreen();
	//	Functions.close_launchApp();
		//Utils.navigateToAllCards(false);
		//CharlesFunctions.archive_folder("charles");
		AppiumFunctions.clickOnVideos_tile();
		attachScreen();
		Thread.sleep(80000);
		this.proxy.getXml();
	//	Utils.createXMLFileForCharlesSessionFile();
	}
	@Test(priority =502,enabled = true)  
	 @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for LATAM_CO  privacy") 
	public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_Latam_CO_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for LATAM_CO  privacy testcase started =========================" ); 
	 Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out. println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for LATAM_CO  privacy  testcase End =========================" );
	  }
	

	@Test(priority =504,enabled = true)  
	 @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for LATAM_CO  privacy") 
	public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_Latam_CO_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for LATAM_CO  privacy testcase started =========================" ); 
	 Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for LATAM_CO  privacy testcase End =========================" );
	  }
	
	@Test(priority =506,enabled = true)  
	 @Title("Verifying Factual location.wfxtriggers.com api call supressing for LATAM_CO  privacy")  
	public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_Latam_CO_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing for LATAM_CO  privacy started =========================" ); 
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	  System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing for LATAM_CO  privacy End =========================" );
	  }
	

	 @Test(priority=508,enabled = true)  
	  @Title("Verifying supress amazon slot id for  home screen hourly preload ad call LATAM_CO Privacy") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_Latam_CO_Privacy()throws Exception { 
	  System.out.println("=================Verifying supress amazon slot id for  home screen hourly preload ad call LATAM_CO Privacy test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call LATAM_CO Privacy");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slot id in home screen hourly preload ad call for LATAM_CO Privacy  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 510, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call LATAM_CO Privacy")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_Latam_CO_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call LATAM_CO Privacy testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call LATAM_CO Privacy");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call LATAM_CO Privacy testcase End =========================");

		}
	
	@Test(priority = 512, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  LATAM_CO Privacy")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_Latam_CO_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  LATAM_CO Privacy testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  LATAM_CO Privacy");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  LATAM_CO Privacy  testcase End =========================");
	}

	 @Test(priority = 514, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call LATAM_CO Privacy")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_Latam_CO_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call LATAM_CO Privacy testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call LATAM_CO Privacy");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call LATAM_CO Privacy testcase  End =========================");
		}
		
		  @Test(priority =516, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call LATAM_CO Privacy")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_Latam_CO_Privacy() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call LATAM_CO Privacy  test case Started =========================");
				//Functions.get_aaxcal_Hourly1();
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call LATAM_CO Privacy test case  End =========================");

			}
			


			@Test(priority = 518, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LATAM_CO Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_Latam_CO_Privacy() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LATAM_CO Privacy test case Started =========================");
				//Functions.get_aaxcal_Hourly2();
				 Functions.verifyaax_SlotId_supress("4fbed16a-cc6f-4cb1-94f7-81465acbd47");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LATAM_CO Privacy test case  End =========================");

			}



			@Test(priority = 520, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call LATAM_CO Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_Latam_CO_Privacy()throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call LATAM_CO Privacy test case  Started =========================");
			//	Functions.get_aaxcal_Hourly3();
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call LATAM_CO Privacy  test case End =========================");
			}
			  

		
		@Test(priority = 522, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call LATAM_CO Privacy")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_Latam_CO_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call LATAM_CO Privacy  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call LATAM_CO Privacy");
			//Functions.get_aaxcal_map_details();
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call LATAM_CO Privacy testcase  End =========================");
		}
	

		@Test(priority = 524, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call LATAM_CO Privacy")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_Latam_CO_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call LATAM_CO Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call LATAM_CO Privacy");
			//Functions.get_aaxcal_Daily();
			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call LATAM_CO Privacy testcase End =========================");
		}
		@Test(priority = 526, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for LATAM_CO Privacy")
		public void Verifying_supress_amazon_Slotid_video_adcall_Latam_CO_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for LATAM_CO Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for LATAM_CO Privacy");
			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for LATAM_CO Privacy testcase  End =========================");
		}	 
	
	
	         @Test(priority =528, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for Latam_CO_privacy") 
		  public void  Verifying_homescreenhourly_adCall_Presence_Latam_CO_privacy()throws Exception {
	          System.out.println("=================Verifying home screen hourly ad call presense for Latam_CO_privacy() privacy  testcase started =========================" );
		  logStep("Verifying home screen hourly ad call presense for Latam_CO_privacy() privacy");
		  Functions.finding_Homescreen_iu_value();
		  System.out.println("=================Verifying home screen hourly ad call presense for Latam_CO_privacy() privacy  testcase  End =========================" );	  
		  }
		  
		  @Test(priority = 530, enabled = true)	  
		  @Title("Verifying home screen marquee ad call presense for Latam_CO_privacy")	
		  public void Verifying_homescreenmarquee_adCall_Presence_Latam_CO_privacy() throws	 Exception {
		  logStep("Verifying home screen marquee ad call presense for Latam_CO_privacy() privacy" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for Latam_CO_privacy() privacy test case started =========================" );  
		  Functions.finding_Homescreen_marquee_iu_value();
		  System.out.println("=================Verifying home screen marquee ad call presense for Latam_CO_privacy() privacy test case End =========================" );	  
		  }
		

			@Test(priority =532, enabled = true)  
			 @Title("Verifying npa=1 in home screen hourly ad call for Latam_CO_privacy") 
			public void Verifying_npa_equals_1_homescreenHourly_adCall_Latam_CO_privacy()throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen hourly ad call for Latam_CO_privacy() privacy  testcase started =========================" ); 
			  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen hourly ad call for Latam_CO_privacy() privacy  testcase End =========================" );
			  }
		  
			@Test(priority =534, enabled = true)  
			 @Title("Verifying npa=1 in home screen marquee ad call for Latam_CO_privacy") 
			public void Verifying_npa_equals_1_homescreenmarquee_adCall_Latam_CO_privacy()throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen marquee ad call for Latam_CO_privacy() privacy  testcase started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen marquee ad call for Latam_CO_privacy() privacy  testcase End =========================" );
			  }
			  
			@Test(priority = 536, enabled = true)	  
		  @Title("Verifying videos ad call presense for Latam_CO_privacy") 
		  public void Verifying_videos_adCall_Presence_Latam_CO_privacy() throws   Exception {
		System.out. println("=================Verifying videos ad call presense for Latam_CO_privacy() privacy test case started =========================" );
		  logStep("Verifying videos ad call presense for Latam_CO_privacy() privacy"); 	
			/*CharlesFunctions.ClearSessions();
			AppiumFunctions.Kill_Launch_App();
			CharlesFunctions.startSessionBrowserData();
			AppiumFunctions.clickOnVideos_tile();
			CharlesFunctions.archive_folder("charles");
			CharlesFunctions.ExportSession();*/
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out.println("=================Verifying videos ad call presense for Latam_CO_privacy() privacy test case started End =========================" );  
		  }
		  
		  
		  @Test(priority =538, enabled = true)  
	 @Title("Verifying npa=1 in videos ad call for Latam_CO_privacy") 
	public void Verifying_npa_equals_1_videos_adCall_Latam_CO_privacy()throws Exception {	  
	 System.out. println("=================Verifying npa=1 in detailed page ad call for Latam_CO_privacy() privacy testcase started =========================" ); 
	 Functions.validate_npa_video_ad_dontsellmyinformation();
		CharlesFunctions.archive_folder("Charles");
	  System.out. println("=================Verifying npa=1 in detailed page ad call for Latam_CO_privacy() privacy testcase End =========================" );
	  }
}

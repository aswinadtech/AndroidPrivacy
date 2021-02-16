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


public class LGPD_Run extends TwcAndroidBaseTest  {
	
	private static final String CONFIG_FILE_PATH = "enableLGPD.config";
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** LGPD Privacy Test Started");
		logStep("****** LGPD Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableLGPD(CONFIG_FILE_PATH);
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
		this.proxy.quitCharlesProxy();
		
		System.out.println("****** LGPD  Privacy Test Ended");
		logStep("****** LGPD Privacy Test Ended");
	}
	@Test(priority = 40)
	public void preConditionsTest_for_LGPD() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		CharlesFunctions.archive_folder(“Charles”);
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
		System.out.println("Launching the app with full reset");
		   AppiumFunctions.resetApp();
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();
			System.out.println("App launched ");
			//CharlesFunctions.archive_folder("charles");
		this.proxy.clearCharlesSession();
		AppiumFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
		AppiumFunctions.clickOnVideos_tile();
                  Thread.sleep(80000);		
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
		Thread.sleep(20000);
	//	Utils.createXMLFileForCharlesSessionFile();
	}
@Test(priority =41, enabled = true)  
	 @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for LGPD privacy") 
	public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for LGPD privacy testcase started =========================" ); 
	 Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out. println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for LGPD privacy  testcase End =========================" );
	  }
	

	@Test(priority =42, enabled = true)  
	 @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for LGPD privacy") 
	public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for LGPD privacy testcase started =========================" ); 
	 Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for LGPD privacy testcase End =========================" );
	  }
	
	@Test(priority =44, enabled = true)  
	 @Title("Verifying Factual location.wfxtriggers.com api call supressing for LGPD privacy") 
	public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing for LGPD privacy started =========================" ); 
	 //Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
          logStep("https://location.wfxtriggers.com url was not trigred");
	  System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing for LGPD privacy End =========================" );
	  }
	


	 @Test(priority=46,enabled = true)  
	  @Title("Verifying supress amazon slot id for  home screen hourly preload ad call LGPD Privacy") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_LGPDPrivacy() throws Exception { 
	  System.out.println("=================Verifying supress amazon slot id for  home screen hourly preload ad call LGPD Privacy test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call LGPD Privacy");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slot id in home screen hourly preload ad call for LGPD Privacy  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 48, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call LGPD Privacy")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_LGPDPrivacy() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call LGPD Privacy testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call LGPD Privacy");
	
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call LGPD Privacy testcase End =========================");

		}
	
	@Test(priority = 50, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  LGPD Privacy")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_LGPDPrivacy() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  LGPD Privacy testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  LGPD Privacy");
	
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  LGPD Privacy  testcase End =========================");
	}

	 @Test(priority = 52, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call LGPD Privacy")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_LGPDPrivacy() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call LGPD Privacy testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call LGPD Privacy");

		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call LGPD Privacy testcase  End =========================");
		}
		
		  @Test(priority =54, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call LGPD Privacy")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_LGPDPrivacy() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call LGPD Privacy  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call LGPD Privacy test case  End =========================");

			}
			


			@Test(priority = 56, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LGPD Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_LGPDPrivacy() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LGPD Privacy test case Started =========================");
				
				 Functions.verifyaax_SlotId_supress("4fbed16a-cc6f-4cb1-94f7-81465acbd47");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  LGPD Privacy test case  End =========================");

			}



			@Test(priority = 58, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call LGPD Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_LGPDPrivacy() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call LGPD Privacy test case  Started =========================");
	
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call LGPD Privacy  test case End =========================");
			}
			  

		
		@Test(priority = 60, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call LGPD Privacy")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_LGPDPrivacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call LGPD Privacy  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call LGPD Privacy");
		
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call LGPD Privacy testcase  End =========================");
		}
	
		@Test(priority = 62, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call LGPD Privacy")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_LGPDPrivacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call LGPD Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call LGPD Privacy");
		
			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call LGPD Privacy testcase End =========================");
		}
		@Test(priority = 64, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for LGPD Privacy")
		public void Verifying_supress_amazon_Slotid_video_adcall_LGPDPrivacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for LGPD Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for LGPD Privacy");
			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for LGPD Privacy testcase  End =========================");
		}	 
	
		@Test(priority =68, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for LGPD privacy" ) 
		  public void  Verifying_homescreenhourly_adCall_Presence_LGPDprivacy() throws Exception {
	   System.out.println("=================Verifying home screen hourly ad call presense for LGPD privacy  testcase started =========================" );
		  logStep("Verifying home screen hourly ad call presense for LGPD privacy");
		  Functions.finding_Homescreen_iu_value();
		  System.out.println("=================Verifying home screen hourly ad call presense for LGPD privacy  testcase  End =========================" );	  
		  }
		  
		  @Test(priority = 70, enabled = true)	  
		  @Title("Verifying home screen marquee ad call presense for LGPD privacy" )	
		  public void Verifying_homescreenmarquee_adCall_Presence_LGPDprivacy()  throws	 Exception {
		  logStep("Verifying home screen marquee ad call presense for LGPD privacy" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for LGPD privacy test case started =========================" );  
		  Functions.finding_Homescreen_marquee_iu_value();
		  System.out.println("=================Verifying home screen marquee ad call presense for LGPD privacy test case End =========================" );	  
		  }
		

			@Test(priority =72, enabled = true)  
			 @Title("Verifying npa=1 in home screen hourly ad call for LGPD privacy") 
			public void Verifying_npa_equals_1_homescreenHourly_adCall_LGPD_Privacy() throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen hourly ad call for LGPD privacy  testcase started =========================" ); 
			  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen hourly ad call for LGPD privacy  testcase End =========================" );
			  }
		  
			@Test(priority =74, enabled = true)  
			 @Title("Verifying npa=1 in home screen marquee ad call for LGPD privacy") 
			public void Verifying_npa_equals_1_homescreenmarquee_adCall_LGPD_Privacy() throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen marquee ad call for LGPD privacy  testcase started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen marquee ad call for LGPD privacy  testcase End =========================" );
		
			
			}
		  
	
		/*@Test(priority = 36, enabled = true)
	@Title("Verifying supress of normal amozon slotid in feed_1  for LGPD privacy")
	public void Verifying_supress_normal_slotId_feed1_LGPD_Privacy() throws Exception {
		System.out.println("=================Verifying presence of normal amozon slotid in feed_1  for LGPD privacy  testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed1");
	
	//	AppiumFunctions. SwipeUp_for_feeds(15);
	//	AppiumFunctions.clickOnMaps_tile();
		//Thread.sleep(2000);
		//AppiumFunctions.clickOnMaps_tile();
		Thread.sleep(2000);
		  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
		System.out.println("=================Verifying presence of normal amozon slotid in feed_1  for LGPD privacy testcase End =========================");
	}	*
		
		/*@Test(priority = 38, enabled = true)
		@Title("Verifying supress of normal amozon slotid in maps details for LGPD privacy")
		public void Verifying_supress_normal_slotId_mapsDeatils_LGPD_Privacy()throws Exception {
			System.out.println("=================Verifying presence of normal amozon slotid in maps details for LGPD privacy testcase Started =========================");
			logStep(" Verifying preload amazon aax for  map details");
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			 
			System.out.println("=================Verifying presence of normal amozon slotid in maps details for LGPD privacy testcase  End =========================");
		}*/

		
	
		
		/*  @Test(priority = 40, enabled = true)
		  @Title("Verifying feed_1 ad call presense for LGPD privacy") 
		  public void Verifying_feed1_adCall_Presence_LGPDprivacy() throws   Exception {
		  System.out. println("=================Verifying feed_1 ad call presense for LGPD privacy  test case started =========================" );
		  logStep("Verifying feed_1 ad call presense for LGPD privacy");
		  Functions.verifying_feedcalls(1);
		  System.out. println("================= Verifying feed_1 ad call presense for LGPD privacy test case End =========================" ); 
		  }*/
		  
		  
		 /* @Test(priority = 42, enabled = true)
		  @Title("Verifying maps details page ad call presense for LGPD privacy") 
		  public void Verifying_mapsdetailspage_adCall_Presence_LGPDprivacy() throws   Exception {
		  System.out. println("=================Verifying feed_1 ad call presense for LGPD privacy  test case started =========================" );
		  logStep("Verifying maps details page  ad call presense for LGPD privacy");
		  Functions.Verifying_detail_gampadcalls_Optoutmode();
		  System.out. println("================= Verifying feed_1 ad call presense for LGPD privacy test case End =========================" ); 
		  }*/
		  @Test(priority = 76, enabled = true)	  
		  @Title("Verifying videos ad call presense for LGPD privacy") 
		  public void Verifying_videos_adCall_Presence_LGPDprivacy()  throws   Exception {
		System.out. println("=================Verifying videos ad call presense for LGPD privacy test case started =========================" );
		  logStep("Verifying videos ad call presense for LGPD privacy"); 	
			/*CharlesFunctions.ClearSessions();
			AppiumFunctions.Kill_Launch_App();
			CharlesFunctions.startSessionBrowserData();
			AppiumFunctions.clickOnVideos_tile();
			CharlesFunctions.archive_folder("charles");
			CharlesFunctions.ExportSession();*/
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out.println("=================Verifying videos ad call presense for LGPD privacy test case started End =========================" );  
		  }
	
		  
	/*@Test(priority =46, enabled = true)  
	 @Title("Verifying npa=1 in Feed ad call for LGPD privacy") 
	public void Verifying_npa_equals_1_Feed_adCall_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying npa=1 in Feed ad call for LGPD privacy testcase started =========================" ); 
	Functions.validate_npa_homescreen_Optoutmode();
	  System.out. println("=================Verifying npa=1 in Feed ad call for LGPD privacy testcase End =========================" );
	  }
	
	@Test(priority =48, enabled = true)  
	 @Title("Verifying npa=1 in detailed page ad call for LGPD privacy") 
	public void Verifying_npa_equals_1_detailedpage_adCall_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying npa=1 in detailed page ad call for LGPD privacy testcase started =========================" ); 
	 Functions.validate_npa_detailed_feed_Optoutmode();
	  System.out. println("=================Verifying npa=1 in detailed page ad call for LGPD privacy testcase End =========================" );
	  }*/

	@Test(priority =78, enabled = true)  
	 @Title("Verifying npa=1 in videos ad call for LGPD privacy") 
	public void Verifying_npa_equals_1_videos_adCall_LGPD_Privacy() throws Exception {	  
	 System.out. println("=================Verifying npa=1 in detailed page ad call for LGPD privacy testcase started =========================" ); 
	 Functions.validate_npa_video_ad_dontsellmyinformation();
	  System.out. println("=================Verifying npa=1 in detailed page ad call for LGPD privacy testcase End =========================" );
	  CharlesFunctions.archive_folder(“Charles”);
	  }
	
	/*@BeforeTest
	public  void lauchApp() throws Exception {
	CharlesFunctions.openCharlesBrowser();	
		AppiumFunctions.LaunchAppWithFullReset();
	      AppiumFunctions.resetApp();
	  Thread.sleep(20000);
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
	  AppiumFunctions.Kill_Launch_App();
		AppiumFunctions.clickOnVideos_tile();
		CharlesFunctions.ExportSession();		
	}*/
	
}

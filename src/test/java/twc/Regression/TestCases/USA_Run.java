package twc.Regression.TestCases;
import org.testng.annotations.Test;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import ru.yandex.qatools.allure.annotations.Title;
import twc.Regression.Driver.Drivers;
import twc.Regression.General.Functions;
import twc.Regression.General.TwcAndroidBaseTest;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.HandleWithCharles.CharlesProxy;

public class USA_Run extends TwcAndroidBaseTest {
	

	private static final String CONFIG_FILE_PATH = "enableUSA.config";
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA CCPA  Privacy Test Started");
		logStep("****** LGPD Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
		this.proxy = new CharlesProxy("localhost", 8222, CONFIG_FILE_PATH);

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
	//	this.proxy.quitCharlesProxy();
		
		System.out.println("****** USA Privacy Test Ended");
		logStep("****** USA Privacy Test Ended");
	}
	
	
	@Test(priority = 300)
	public void preConditionsTest_for_USA() throws Exception {
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
	//	Functions.close_launchApp();
		//Utils.navigateToAllCards(false);
	//	Utils.createXMLFileForCharlesSessionFile();
	}

	@Test(priority =302, enabled = true)  
	  @Title("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppiumFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	  AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 304, enabled = true)	  
	  @Title("Selecting the  Do Not Sell My Information option  in the privacy card") 
	  public void Selecting_DoNotSellMyInformation_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(20000); 
	  Functions.selecting_opt_out_mode(); 
	  System.out.println("kill launch the app for two times");
	  AppiumFunctions.Kill_Launch_App(); 
	  CharlesFunctions.ClearSessions();
	  Thread.sleep(30000); 
	   AppiumFunctions.Kill_Launch_App();  
	   CharlesFunctions.ClearSessions();
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	 // DoNotSellMyInformation
	  @Test(priority = 306, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_Privacy_DoNotSellMyInformation()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case  started =========================");
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	   AppiumFunctions.Kill_Launch_App();  
	   AppiumFunctions.clickOnMaps_tile();
	   AppiumFunctions.clickOnVideos_tile();
		CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	   CharlesFunctions.ExportSession();
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 308, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 310, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_Privacy_DoNotSellMyInformation() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA privacy when Advertising option set to Do Not Sell My Information"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=312,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 314, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA privacy when Advertising option set to Do Not Sell My Information");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");

		}
	
	@Test(priority = 316, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information  testcase End =========================");
	}

	 @Test(priority = 318, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
		
		  @Test(priority =320, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}
			


			@Test(priority = 322, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}



			@Test(priority = 324, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information  test case End =========================");
			}
			  

		
		@Test(priority = 326, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
	
		@Test(priority = 328, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");
		}
		@Test(priority = 330, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}	 
	

	@Test(priority =332, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_Privacy_DoNotSellMyInformation() throws Exception {
   System.out.println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =334, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_Privacy_DoNotSellMyInformation()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 336, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }


	  @Test(priority = 338, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }
	
	  
  @Test(priority = 340, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_Privacy_DoNotSellMyInformation()  throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );
	  }
	  
	  @Test(priority = 342, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");
      }
	  
	  @Test(priority = 344, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
      }
	  
	  
	  @Test(priority = 346, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_videos_adCall_Presence_USA_Privacy_DoNotSellMyInformation()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started End =========================" );  
	  }
	
	  @Test(priority = 348, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  End ========================="); 
	  }
	

		 @Test(priority = 350, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
		  }
		  
	  
		

	 
	//==========================================================================================================//
	 
	 
	 
	  
	  @Test(priority = 400, enabled = true)	  
	  @Title("Selecting the  Standard Advertising Settings  in the privacy card") public void
	  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
	  logStep("Selecting the Standard Advertising Settings  in the privacy card");
     System.out. println("=================Slecting Standard Advertising Settings  in privacy card testcase started =========================");
	 AppiumFunctions. Kill_Launch_App();
	//  AppFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	  AppiumFunctions.SwipeUp_Counter_privacy(25);
	  Thread.sleep(10000); 
	  Functions.selecting_opt_in_mode();
	  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Standard Advertising Settings  in privacy card  testcase End ========================="); 
	  }
	  

	
	  
	  @Test(priority = 402, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_Privacy_StandardAdvertisingSettings() throws  Exception { 
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings" ); 
	  System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
	  CharlesFunctions.ClearSessions();
	   AppiumFunctions.Kill_Launch_App();  
		AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();		
		CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	  Functions.validating_bcp_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	  
	  }
	  
	  @Test(priority = 404, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_Factual_locationwfxtriggerscom_apiCall_presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
	   logStep("Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings"); 
	   System.out.println("=================Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");
	   Functions.validating_Fatualcall_privacy_Optinmode_scenarion(); 
	   System.out. println("================= Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	 
	  }
	  
	 
	  
	  @Test(priority=406,enabled = true)  
	  @Title("Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings") 
	  public void Verifying_presence_amazon_Slotid_homescreenhourly_preload_adcall_USA_Privacy_StandardAdvertisingSettings()  throws Exception { 
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings");
	  Functions.verifyaax_SlotId_Presence("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  End ========================="); 
	  }
	
	 
		@Test(priority = 408, enabled = true)
		@Title("Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_feed1_preroladcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_Presence("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings testcase End =========================");

		}
	
	@Test(priority = 410, enabled = true)
	@Title("Verifying presence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings")
	public void Verifying_presence_amazon_Slotid_feed2_preroladcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
		logStep("Verifying presennce amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings");
		  Functions.verifyaax_SlotId_Presence("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
	}

	 @Test(priority = 412, enabled = true)
		@Title("Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_Hourlydetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  Started =========================");
		logStep("Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case n");
		  Functions.verifyaax_SlotId_Presence("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case   End =========================");
		}
		
		  @Test(priority =414, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println(
						"=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings  test case Started =========================");
				  Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}
			


			@Test(priority = 416, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings test case Started =========================");
				 Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}



			@Test(priority = 418, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying v amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings test case  Started =========================");
				 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying presence amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings  test case End =========================");
			}
			  

		
		@Test(priority = 420, enabled = true)
		@Title("Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_presence_amazon_Slotid_mapsdetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings  testcase  Started =========================");
			logStep("Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_map_details();
			 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings testcase  End =========================");
		}
	
		@Test(priority = 422, enabled = true)
		@Title("Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_presence_amazon_Slotid_Dailydetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings  testcase Started =========================");
			logStep("Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
			 Functions.verifyaax_SlotId_Presence("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
		}
		@Test(priority = 424, enabled = true)
		@Title("Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_presence_amazon_Slotid_video_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_video_details();
			 Functions.verifyaax_SlotId_Presence("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to  Standard Advertising Settings  testcase  End =========================");
		}	 
	
		
		
		  
		  @Test(priority = 426, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenhourly_adCall_Presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  started ========================="); 
		  Functions. finding_Homescreen_marquee_iu_value();
		  System.out.println("================= Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }
		  
		  @Test(priority = 428, enabled = true)  
		  @Title("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenmarquee_adCall_Presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions. finding_Homescreen_iu_value();
		  System.out.println("================= Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }
		  
		  @Test(priority = 430, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings")
		  public void  Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings  test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreen_Optinmode(); 
		  System.out.println("================= Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" ); 
		  }
		  
		  
		  @Test(priority = 432, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreenhourly_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" ); 
		  }
		  
		  @Test(priority = 463, enabled = true)  
		  @Title("Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_Privacy_StandardAdvertisingSettings()throws  Exception {
		  logStep("Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" );
		  Functions.validate_SOD_Cust_param_deatiledfeed_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		  }
		  
		  @Test(priority = 434, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenmarquee_adCall_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" ); 
		  Functions.validate_RDP_homescreen_Optinmode();
		  System.out. println("=================  Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================");
	   }
		  
		  @Test(priority = 436, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenHourly_adCall_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" ); 
		  Functions.validate_RDP_homescreenhourly_Optinmode();
		  System.out. println("================= Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings End =========================");
	   }
		
		
		
		  
		  
		  @Test(priority = 438, enabled = true)  
		  @Title("Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void  Verifying_video_adCall_Presence_USA_Privacy_StandardAdvertisingSettings()  throws Exception {
		  logStep("Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");			
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out. println("================= Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );	  
		  }
		  
		
		
		  
		   @Test(priority = 440, enabled = true)	  
		  @Title("Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin_mode_scenario() throws Exception {
		  logStep("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card");
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" );
		  Functions.validate_SOD_Cust_param_video_Optinmode();
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		  }
		  
		   @Test(priority = 442, enabled = true)  
			  @Title("Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings" ) 
			  public void Verifying_rdp_keyword_supress_videos_Call_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {	  
			 System.out. println("================= Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" );
			  logStep("Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings");
			  Functions.validate_RDP_video_ad_Optinmode(); 
			  System.out. println("================= Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
			  }
			  

	  
	/*	@BeforeTest
		public  void lauchApp() throws Exception {
			CharlesFunctions.openCharlesBrowser();
			AppiumFunctions.LaunchAppWithFullReset();
		    AppiumFunctions.resetApp();
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();		
		  Thread.sleep(20000);
			CharlesFunctions.ClearSessions();
			CharlesFunctions.startSessionBrowserData();
		  AppiumFunctions.Kill_Launch_App();
			AppiumFunctions.ClickonIUnderstand();
			
		}*/

}

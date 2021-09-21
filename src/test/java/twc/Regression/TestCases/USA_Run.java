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
		private static final String LGPD_CONFIG_FILE_PATH = "enableLGPD.config";
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA   Privacy Test Started");
		logStep("****** USA Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
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
		
		System.out.println("****** USA Privacy Test Ended");
		logStep("****** USA Privacy Test Ended");
	}
	
	
	@Test(priority = 500)
		public void preConditionsTest_for_USA_slecting_DoNotSellMyInformation() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		CharlesFunctions.archive_folder("Charles");
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
		   AppiumFunctions.resetApp();
		Thread.sleep(100000);
		Thread.sleep(100000);
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

	@Test(priority =502, enabled = true)  
	  @Title("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppiumFunctions.Kill_Launch_App();
	  Thread.sleep(40000);	  
	 // AppiumFunctions.SwipeUp_Counter_privacy(25);
		    Thread.sleep(40000);	 
		//  attachScreen();
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 504, enabled = true)	  
	  @Title("Selecting the  Do Not Sell My Information option  in the privacy card") 
	  public void Selecting_DoNotSellMyInformation_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(40000); 
	  Functions.selecting_opt_out_mode(); 
		  attachScreen();
	  System.out.println("kill launch the app for two times");
	  AppiumFunctions.Kill_Launch_App(); 
	  this.proxy.clearCharlesSession();
	  Thread.sleep(30000); 
	   AppiumFunctions.Kill_Launch_App();  
	  
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	 // DoNotSellMyInformation
	  @Test(priority = 506, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_Privacy_DoNotSellMyInformation()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case  started =========================");
	  this.proxy.clearCharlesSession();
	   AppiumFunctions.Kill_Launch_App();  
	   AppiumFunctions.clickOnMaps_tile();
		  attachScreen();
	   AppiumFunctions.clickOnVideos_tile();
		  attachScreen();
		  	  Thread.sleep(80000);			
		  //CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	//   CharlesFunctions.ExportSession();
	 // Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
         logStep("https://ad.crwdcntrl.net/ url was  not trigred");
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 508, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 510, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_Privacy_DoNotSellMyInformation() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA privacy when Advertising option set to Do Not Sell My Information"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 //Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	logStep("https://location.wfxtriggers.com url was not trigred");
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=512,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Do Not Sell My Information  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 514, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA privacy when Advertising option set to Do Not Sell My Information");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");

		}
	
	@Test(priority = 516, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to Do Not Sell My Information  testcase End =========================");
	}

	 @Test(priority = 518, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
		
		  @Test(priority =520, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}
			


			@Test(priority = 522, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}



			@Test(priority = 524, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to Do Not Sell My Information  test case End =========================");
			}
			  

		
		@Test(priority = 526, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
	
		@Test(priority = 528, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");
		}
		@Test(priority = 530, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}	 
	

	@Test(priority =532, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_Privacy_DoNotSellMyInformation() throws Exception {
   System.out.println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Do Not Sell My Information  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =534, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_Privacy_DoNotSellMyInformation()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 536, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }


	  @Test(priority = 538, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }
	
	  
  @Test(priority = 540, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA privacy when Advertising option set to Do Not Sell My Information" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_Privacy_DoNotSellMyInformation()  throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );
	  }
	  
	  @Test(priority = 542, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");
      }
	  
	  @Test(priority = 544, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
      }
	  
	  
	  @Test(priority = 546, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_videos_adCall_Presence_USA_Privacy_DoNotSellMyInformation()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA privacy when Advertising option set to Do Not Sell My Information test case started End =========================" );  
	  }
	
	  @Test(priority = 548, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case  End ========================="); 
	  }
	

		 @Test(priority = 550, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_Privacy_DoNotSellMyInformation() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
			
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
		  }
		  
	  
		
	
		@Test(priority = 552, enabled = true)
		@Title("Verify Criteo SDK inapp v2 call when privacy optout")
	public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== Criteo SDK inapp/v2 call when privacy optout ====================");
		System.out.println("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
		logStep("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
		
			CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

	}

	@Test(priority = 554, enabled = true)
		@Title("Verify Criteo SDK config app call when privacy optout")
	public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA() throws Exception {
		System.out.println("==============================================");
		System.out.println(
				"=========================== Criteo SDK config/app call when privacy optout====================");
		System.out.println("****** Criteo SDK config/app call when privacy optout validation Started");
		logStep("****** Criteo SDK config/app call when privacy optout validation Started");
			Functions.verifyCriteo_config_app_Call("Criteo", false);
		  CharlesFunctions.archive_folder("Charles");

	}
	
	
	
	@Test(priority = 556, enabled = true)
	 @Title("Enabling Preconfiguration for USA to LGPD_Travel Scenario")
		public void enable_PreConfiguration_for_USA_LGPD_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA to LGPD Travel Scenario");
			logStep("Enable Preconfiguration for USA to LGPD  Travel Scenario");
			proxy.quitCharlesProxy();
			// Ad.closeApp();
			this.configFile = this.rewriteRuleToEnableLGPD(LGPD_CONFIG_FILE_PATH);
			this.proxy = new CharlesProxy("localhost", 8333, LGPD_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			this.proxy.disableRewriting();
	                 this.proxy.stopRecording();
	                this.proxy.disableMapLocal();
	                proxy.enableRewriting();
	                proxy.startRecording();
			// Ad.launchApp();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			AppiumFunctions.ClickonIUnderstand();
			
		}
	 
	 @Test(priority = 558, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA to LGPD Travel Scenario") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA to LGPD Travel Scenario"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
		CharlesFunctions.archive_folder("Charles");
		  this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();  
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
	   AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();
		  	Thread.sleep(80000);
		  	Thread.sleep(80000);
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 560, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA to LGPD Travel Scenario")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA to LGPD Travel Scenario" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 562, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA to LGPD Travel Scenario") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=564,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 566, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");

		}
	
	@Test(priority = 568, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase End =========================");
	}

	 @Test(priority = 570, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
		
		  @Test(priority =572, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}
			


			@Test(priority = 574, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}



			@Test(priority = 576, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case End =========================");
			}
			  

		
		@Test(priority = 578, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
	
		@Test(priority = 580, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");
		}
		@Test(priority = 582, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}	 
	

	@Test(priority =584, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
 System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =586, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 588, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }


	  @Test(priority = 600, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }
	
	  @Test(priority = 602, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );
	  }
	  
	  
	  
	  @Test(priority = 604, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
    }
	  
	  @Test(priority = 606, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
    }
	  
	  
	  @Test(priority = 608, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started End =========================" );  
	  }
	
	  @Test(priority = 610, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End ========================="); 
	  }
	

		 @Test(priority = 612, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
		  }
		  

	
		  @Test(priority = 614, enabled = true)	  
		  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
		  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
	      }
		  
		  @Test(priority = 616, enabled = true)	  
		  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
	      }
		  
			
			@Test(priority =618, enabled = true)  
			 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
			 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LGPD_Travel_Scenario() throws Exception {
			 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  	  
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
			 Functions.validate_npa_video_ad_dontsellmyinformation();
			 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
			
			 }

	@Test(priority = 620, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
	
		CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

			}

			@Test(priority = 622, enabled = true)
			@Title("Verify Criteo SDK config app call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
				CharlesFunctions.archive_folder("Charles");

			}
			
			
			
			
				  
	 @Test(priority = 624, enabled = true)
	 @Title("Enabling Preconfiguration for USA to GDPRTravel Scenario")
		public void enable_PreConfiguration_for_USA_GDPR_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA to LGPD Travel Scenario");
			logStep("Enable Preconfiguration for USA to LGPD Travel Scenario");
			proxy.quitCharlesProxy();
			// Ad.closeApp();
			this.configFile = this.rewriteRuleToEnableLGPD(GDPR_CONFIG_FILE_PATH);
			this.proxy = new CharlesProxy("localhost", 8333, GDPR_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			this.proxy.disableRewriting();
	                 this.proxy.stopRecording();
	                this.proxy.disableMapLocal();
	                proxy.enableRewriting();
	                proxy.startRecording();
			// Ad.launchApp();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			AppiumFunctions.ClickonIUnderstand();
			
		}
	 
	 @Test(priority = 626, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
		CharlesFunctions.archive_folder("Charles");
		  this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();  
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
	   AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();
		  	Thread.sleep(80000);
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 628, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 630, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=632,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 634, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");

		}
	
	@Test(priority = 636, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase End =========================");
	}

	 @Test(priority = 638, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
		
		  @Test(priority =640, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}
			


			@Test(priority = 642, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}



			@Test(priority = 644, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case End =========================");
			}
			  

		
		@Test(priority = 646, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
	
		@Test(priority = 648, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");
		}
		@Test(priority = 650, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}	 
	

	@Test(priority =652, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
 System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =654, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 656, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }


	  @Test(priority = 658, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }
	
	  @Test(priority = 660, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );
	  }
	  
	  
	  
	  @Test(priority = 662, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
    }
	  
	  @Test(priority = 664, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
    }
	  
	  
	  @Test(priority = 666, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started End =========================" );  
	  }
	
	  @Test(priority = 668, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End ========================="); 
	  }
	

		 @Test(priority = 670, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
		  }
		  

	
		  @Test(priority = 672, enabled = true)	  
		  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
		  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
	      }
		  
		  @Test(priority = 674, enabled = true)	  
		  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
	      }
		  
			
			@Test(priority =676, enabled = true)  
			 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
			 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_GDPR_Travel_Scenario() throws Exception {
			 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  	  
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
			 Functions.validate_npa_video_ad_dontsellmyinformation();
			 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
			
			 }

	@Test(priority = 678, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
	
		CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

			}

			@Test(priority = 680, enabled = true)
			@Title("Verify Criteo SDK config app call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_GDPR_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
				CharlesFunctions.archive_folder("Charles");

			}
			
			
			
			
			
			
			@Test(priority = 682, enabled = true)
	 @Title("Enabling Preconfiguration for USA to LATAMCO Travel Scenario")
		public void enable_PreConfiguration_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA to LATMCO Travel Scenario");
			logStep("Enable Preconfiguration for USA to LATMCO Travel Scenario");
			proxy.quitCharlesProxy();
			// Ad.closeApp();
			this.configFile = this.rewriteRuleToEnableLGPD(LATAMCOCONFIG_FILE_PATH);
			this.proxy = new CharlesProxy("localhost", 8333, LATAMCOCONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			this.proxy.disableRewriting();
	                 this.proxy.stopRecording();
	                this.proxy.disableMapLocal();
	                proxy.enableRewriting();
	                proxy.startRecording();
			// Ad.launchApp();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			AppiumFunctions.ClickonIUnderstand();
			
		}
	 
	 @Test(priority = 684, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
		CharlesFunctions.archive_folder("Charles");
		  this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();  
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
	   AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();
		  	Thread.sleep(80000);
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 686, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 688, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=690,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 692, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");

		}
	
	@Test(priority = 694, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase End =========================");
	}

	 @Test(priority = 696, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
		
		  @Test(priority =700, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}
			


			@Test(priority = 702, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}



			@Test(priority = 704, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case End =========================");
			}
			  

		
		@Test(priority = 706, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
	
		@Test(priority = 708, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");
		}
		@Test(priority = 710, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}	 
	

	@Test(priority =712, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
 System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =714, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 716, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }


	  @Test(priority = 718, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }
	
	  @Test(priority = 720, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );
	  }
	  
	  
	  
	  @Test(priority = 722, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
    }
	  
	  @Test(priority = 724, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
    }
	  
	  
	  @Test(priority = 726, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started End =========================" );  
	  }
	
	  @Test(priority = 728, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End ========================="); 
	  }
	

		 @Test(priority = 730, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
		  }
		  

	
		  @Test(priority = 732, enabled = true)	  
		  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
		  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
	      }
		  
		  @Test(priority = 734, enabled = true)	  
		  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
	      }
		  
			
			@Test(priority =736, enabled = true)  
			 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
			 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_LATAMCO_Travel_Scenario() throws Exception {
			 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  	  
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
			 Functions.validate_npa_video_ad_dontsellmyinformation();
			 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
			
			 }

	@Test(priority = 738, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
	
		CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

			}

			@Test(priority = 740, enabled = true)
			@Title("Verify Criteo SDK config app call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_LATAMCO_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
				CharlesFunctions.archive_folder("Charles");

			}
			
			
			 @Test(priority = 742, enabled = true)
	 @Title("Enabling Preconfiguration for USA to SERBIA Travel Scenario")
		public void enable_PreConfiguration_for_USA_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("==============================================");
			System.out.println("****** Enable Preconfiguration for USA to LGPD Travel Scenario");
			logStep("Enable Preconfiguration for USA to LGPD Travel Scenario");
			proxy.quitCharlesProxy();
			// Ad.closeApp();
			this.configFile = this.rewriteRuleToEnableLGPD(SERBIA_CONFIG_FILE_PATH);
			this.proxy = new CharlesProxy("localhost", 8333, SERBIA_CONFIG_FILE_PATH);
			proxy.startCharlesProxyWithUI();
			this.proxy.disableRewriting();
	                 this.proxy.stopRecording();
	                this.proxy.disableMapLocal();
	                proxy.enableRewriting();
	                proxy.startRecording();
			// Ad.launchApp();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			Thread.sleep(10000);
			AppiumFunctions.Kill_Launch_App();
			AppiumFunctions.ClickonIUnderstand();
			
		}
	 
	 @Test(priority = 746, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
		CharlesFunctions.archive_folder("Charles");
		  this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();  
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
		  this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();
		  AppiumFunctions.Kill_Launch_App();
	   AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();
		  	Thread.sleep(80000);
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 748, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 750, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  
	  @Test(priority=752,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case  End ========================="); 
	  }
	
	 
		@Test(priority = 754, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");

		}
	
	@Test(priority = 756, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase End =========================");
	}

	 @Test(priority = 758, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
		
		  @Test(priority =760, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}
			


			@Test(priority = 762, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");

			}



			@Test(priority = 764, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  test case End =========================");
			}
			  

		
		@Test(priority = 766, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}
	
		@Test(priority = 768, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase End =========================");
		}
		@Test(priority = 770, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario testcase  End =========================");
		}	 
	

	@Test(priority =772, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
 System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario  testcase  End =========================" );	  
	  }
	  
	  @Test(priority =774, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 776, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }


	  @Test(priority = 778, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" ); 
	  }
	
	  @Test(priority = 780, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================" );
	  }
	  
	  
	  
	  @Test(priority = 782, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
    }
	  
	  @Test(priority = 784, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
    }
	  
	  
	  @Test(priority = 786, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
	  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started End =========================" );  
	  }
	
	  @Test(priority = 788, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End ========================="); 
	  }
	

		 @Test(priority = 800, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
		  }
		  

	
		  @Test(priority = 802, enabled = true)	  
		  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  started =========================" ); 
		  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case  End =========================");
	      }
		  
		  @Test(priority = 804, enabled = true)	  
		  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
		  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws  Exception {
		  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario"); 
		  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
		  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
	      }
		  
			
			@Test(priority =806, enabled = true)  
			 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario") 
			 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USA_SERBIA_Travel_Scenario() throws Exception {
			 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario" );  	  
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case started =========================");
			 Functions.validate_npa_video_ad_dontsellmyinformation();
			 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USA Travel Scenario test case End =========================");
			
			 }

	@Test(priority = 808, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USA_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optout for USA Travel Scenario validation Started");
	
		CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

			}

			@Test(priority = 810, enabled = true)
			@Title("Verify Criteo SDK config app call when privacy optout for USA Travel Scenario")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USA_SERBIA_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optout for USA Travel Scenario====================");
				System.out.println(
						"****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				logStep("****** Criteo SDK config/app call when privacy optout for USA Travel Scenario validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
				CharlesFunctions.archive_folder("Charles");

			}
	 
	 


	 
	
	
	

	 
	//==========================================================================================================//
	  
				@Test(priority = 812,enabled = true)
				public void preConditionsTest_for_USA_slecting_StandardAdvertisingSettings() throws Exception {
					proxy.quitCharlesProxy();
					this.configFile = this.rewriteRuleToEnableUSA(CONFIG_FILE_PATH);
					this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);
					this.proxy.startCharlesProxyWithUI();
					this.proxy.disableRewriting();
					this.proxy.stopRecording();
					this.proxy.disableMapLocal();
					this.proxy.enableRewriting();
		                        this.proxy.startRecording();
					CharlesFunctions.archive_folder("Charles");
		                      this.proxy.clearCharlesSession();
				//	Functions.close_launchApp();
					//Utils.navigateToAllCards(false);
				//	Utils.createXMLFileForCharlesSessionFile();
				}
	 
	 
	 
	  
	  @Test(priority = 814, enabled = true)	  
	  @Title("Selecting the  Standard Advertising Settings  in the privacy card") public void
	  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
	  logStep("Selecting the Standard Advertising Settings  in the privacy card");
     System.out. println("=================Slecting Standard Advertising Settings  in privacy card testcase started =========================");
	Ad.resetApp();
		  
		Thread.sleep(100000);
		  Thread.sleep(100000);
		  AppiumFunctions. Kill_Launch_App();
	//  AppFunctions. Kill_Launch_App();
	  Thread.sleep(80000);	  
	//  AppiumFunctions.SwipeUp_Counter_privacy(25);
		    Thread.sleep(80000);
	  Thread.sleep(40000); 
	 // Functions.selecting_opt_in_mode();
	  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Standard Advertising Settings  in privacy card  testcase End ========================="); 
	  }
	  

	
	  
	 @Test(priority = 816, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_Privacy_StandardAdvertisingSettings() throws  Exception { 
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings" ); 
	  System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
	 	System.out.println("https://bcp.crwdcntrl.net/ url was trigred");
		logStep("https://bcp.crwdcntrl.net/ url was trigred");
		     this.proxy.clearCharlesSession();
	   AppiumFunctions.Kill_Launch_App(); 
	   AppiumFunctions.Kill_Launch_App();
		  attachScreen();
		AppiumFunctions.clickOnMaps_tile();
		  attachScreen();
		AppiumFunctions.clickOnVideos_tile();	
		  attachScreen();
		  	  Thread.sleep(80000);	
		//CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();	
	//  Functions.validating_bcp_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	  
	  }
	  
	/*  @Test(priority = 818, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_Factual_locationwfxtriggerscom_apiCall_presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
	   logStep("Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings"); 
	   System.out.println("=================Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");
		  
		  Functions.validating_Fatualcall_privacy_Optinmode_scenarion(); 
	   System.out. println("================= Verifying Factual location.wfxtriggers.com api call presence for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	 
	  }*/
	  
	 
	  
	  @Test(priority=820,enabled = true)  
	  @Title("Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings") 
	  public void Verifying_presence_amazon_Slotid_homescreenhourly_preload_adcall_USA_Privacy_StandardAdvertisingSettings()  throws Exception { 
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings");
	  Functions.verifyaax_SlotId_Presence("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  End ========================="); 
	  }
	
	 
		@Test(priority = 822, enabled = true)
		@Title("Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_feed1_preroladcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_Presence("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA privacy when Advertising option set to Standard Advertising Settings testcase End =========================");

		}
	
	@Test(priority = 824, enabled = true)
	@Title("Verifying presence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings")
	public void Verifying_presence_amazon_Slotid_feed2_preroladcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
		logStep("Verifying presennce amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings");
		  Functions.verifyaax_SlotId_Presence("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
	}

	 @Test(priority = 826, enabled = true)
		@Title("Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_Hourlydetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  Started =========================");
		logStep("Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case n");
		  Functions.verifyaax_SlotId_Presence("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying presence amazon SlotId for  hourly details preload ad call  USA privacy when Advertising option set to Standard Advertising Settings test case   End =========================");
		}
		
		  @Test(priority =828, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println(
						"=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings  test case Started =========================");
				  Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}
			


			@Test(priority = 830, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings test case Started =========================");
				 Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}



			@Test(priority = 832, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying v amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings test case  Started =========================");
				 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying presence amazon SlotId for  hourly3 details big ad preload call USA privacy when Advertising option set to  Standard Advertising Settings  test case End =========================");
			}
			  

		
		@Test(priority = 834, enabled = true)
		@Title("Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_mapsdetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings  testcase  Started =========================");
			logStep("Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_map_details();
			 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings testcase  End =========================");
		}
	
		@Test(priority = 836, enabled = true)
		@Title("Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_Dailydetails_preload_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings  testcase Started =========================");
			logStep("Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to Do Not Sell My Information");
			 Functions.verifyaax_SlotId_Presence("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
		}
		@Test(priority = 838, enabled = true)
		@Title("Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_video_adcall_USA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_video_details();
			 Functions.verifyaax_SlotId_Presence("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA privacy when Advertising option set to  Standard Advertising Settings  testcase  End =========================");
		}	 
	
		
		
		  
		  @Test(priority = 840, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenhourly_adCall_Presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  started ========================="); 
		  Functions. finding_Homescreen_marquee_iu_value();
		  System.out.println("================= Verifying home screen hourly ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }
		  
		  @Test(priority = 842, enabled = true)  
		  @Title("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenmarquee_adCall_Presence_USA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions. finding_Homescreen_iu_value();
		  System.out.println("================= Verifying home screen marquee ad call presense for USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }
		  
		  @Test(priority = 844, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings")
		  public void  Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings  test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreen_Optinmode(); 
		  System.out.println("================= Verifying SOD custum param for  home screen marquee ad call USA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" ); 
		  }
		  
		  
		  @Test(priority = 846, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreenhourly_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" ); 
		  }
		  
		  @Test(priority = 848, enabled = true)  
		  @Title("Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_Privacy_StandardAdvertisingSettings()throws  Exception {
		  logStep("Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" );
		  Functions.validate_SOD_Cust_param_deatiledfeed_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  maps details page ad call USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		  }
		  
		  @Test(priority = 850, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenmarquee_adCall_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" ); 
		  Functions.validate_RDP_homescreen_Optinmode();
		  System.out. println("=================  Verifying rdp keyword supress in home screen marquee ad call for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================");
	   }
		  
		  @Test(priority = 852, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenHourly_adCall_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" ); 
		  Functions.validate_RDP_homescreenhourly_Optinmode();
		  System.out. println("================= Verifying rdp keyword supress in home screen hourly ad call for USA privacy when Advertising option set to Standard Advertising Settings End =========================");
	   }
		
		
		
		  
		  
		  @Test(priority = 854, enabled = true)  
		  @Title("Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void  Verifying_video_adCall_Presence_USA_Privacy_StandardAdvertisingSettings()  throws Exception {
		  logStep("Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================");			
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out. println("================= Verifying video call presense for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );	  
		  }
		  
		
		
		  
		   @Test(priority = 856, enabled = true)	  
		  @Title("Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings") 
		  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin_mode_scenario() throws Exception {
		  logStep("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card");
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" );
		  Functions.validate_SOD_Cust_param_video_Optinmode();
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		  }
		  
		   @Test(priority = 858, enabled = true)  
			  @Title("Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings" ) 
			  public void Verifying_rdp_keyword_supress_videos_Call_USA_Privacy_StandardAdvertisingSettings()  throws  Exception {	  
			 System.out. println("================= Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings test case started =========================" );
			  logStep("Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings");
			  Functions.validate_RDP_video_ad_Optinmode(); 
			  System.out. println("================= Verifying rdp keyword supress in videos call for USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
			 
			  }
	
	
	
		@Test(priority = 860, enabled = true)
		@Title("Verify Criteo SDK inapp v2 call")
	public void Verify_Criteo_SDK_inapp_v2_Call() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== Criteo SDK inapp/v2 call ====================");

		System.out.println("****** Criteo SDK inapp/v2 call validation Started");
		logStep("****** Criteo SDK inapp/v2 call validation Started");
		
			CharlesFunctions.createXMLFileForCharlesSessionFile();
		Functions.verifyCriteo_inapp_v2_Call("Criteo", true);

	}

	@Test(priority = 862, enabled = true)
		@Title("Verify Criteo SDK config app call")
	public void Verify_Criteo_SDK_config_app_Call() throws Exception {
		System.out.println("==============================================");
		System.out.println("=========================== Criteo SDK config/app call ====================");

		System.out.println("****** Criteo SDK config/app call validation Started");
		logStep("****** Criteo SDK config/app call validation Started");

			Functions.verifyCriteo_config_app_Call("Criteo", true);
		 CharlesFunctions.archive_folder("Charles");

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

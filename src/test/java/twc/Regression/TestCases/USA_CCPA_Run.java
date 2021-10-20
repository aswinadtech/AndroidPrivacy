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

public class USA_CCPA_Run extends TwcAndroidBaseTest {
	
	
	private static final String CONFIG_FILE_PATH = "enableUSACCPA.config";
	private static final String LGPD_CONFIG_FILE_PATH = "enableLGPD.config";
	private static final String GDPR_CONFIG_FILE_PATH ="enableGDPR.config";
	private static final String LATAMCO_CONFIG_FILE_PATH = "enableLATAMCO.config";
	private static final String SERBIA_CONFIG_FILE_PATH = "enableSerbia.config";
	
	private CharlesProxy proxy;
	private File configFile;
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("****** USA CCPA  Privacy Test Started");
		logStep("****** LGPD Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableUSACCPA(CONFIG_FILE_PATH);
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
		
		System.out.println("****** USA CCPA  Privacy Test Ended");
		logStep("****** USA CCPA  Privacy Test Ended");
	}
	
	@Test(priority = 100)
	public void preConditionsTest_for_USA_CCPA() throws Exception {
		// Enable rewriting on Charles install/launch TWC
		this.proxy.enableRewriting();
		this.proxy.startRecording();
		this.proxy.clearCharlesSession();
		AppiumFunctions.LaunchAppWithFullReset();
	    Thread.sleep(10000);	
		 Ad.resetApp();
		  Thread.sleep(100000);	
		  	AppiumFunctions.clickONNext();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.ClickonIUnderstand();
			AppiumFunctions.clickOnAllow();
		
		System.out.println("App launched ");
		this.proxy.clearCharlesSession();
		AppiumFunctions.Kill_Launch_App();
		AppiumFunctions.ClickonIUnderstand();
	
	}
	@Test(priority =102, enabled = true)  
	  @Title("Verifying Privacy Card is present on the screen") public void
	 Verifying_PrivacyCard_PresenceonScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppiumFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	 // AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 104, enabled = true)	  
	  @Title("Selecting the  Do Not Sell My Information option  in the privacy card") 
	  public void Selecting_DoNotSellMyInformation_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(20000); 
	  Functions.selecting_opt_out_mode(); 
			  System.out.println("kill launch the app for two times");
		    Thread.sleep(20000);		
		  this.proxy.clearCharlesSession(); 
	  Thread.sleep(30000); 
	   AppiumFunctions.Kill_Launch_App();  
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	 // DoNotSellMyInformation
	  @Test(priority = 106, enabled = true)  
	  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation()  throws Exception {  
	  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
		  this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();  
	   AppiumFunctions.clickOnMaps_tile();
		AppiumFunctions.clickOnVideos_tile();
		    Thread.sleep(80000);		
		  //CharlesFunctions.archive_folder("charles");
		this.proxy.getXml();
	 // Functions.validating_adcrw_privacy_Optoutmode_scenarion();
		  logStep("https://ad.crwdcntrl.net/ url was  not trigred");
		  
	  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case End =========================");	  
	  }
	  
	  @Test(priority = 107, enabled = true)
		@Title("Verifying WeatherFX API url call presence  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_WeatherFXAPICall_apiCall_presence_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("================= Verifying WeatherFX API url started =========================");
			
			Functions.validating_WeatherFXAPI();
			System.out.println("================= Verifying WeatherFX API url End =========================");
		}
	  
	  @Test(priority = 108, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 110, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception { 
	  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 	  
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 

				
	  
	 /* @Test(priority=112,enabled = true)  
	  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception { 
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information  test case  End ========================="); 
	  }*//
	
	 
		@Test(priority = 114, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");

		}
	
	@Test(priority = 116, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_feed2();
		  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information  testcase End =========================");
	}

	 @Test(priority = 118, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
		//Functions.get_aaxcal_Hourly();
		  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
		
		  @Test(priority =120, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information  test case Started =========================");
			
				  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}
			


			@Test(priority = 122, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case Started =========================");

				 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");

			}



			@Test(priority = 124, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  Started =========================");
				
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information  test case End =========================");
			}
			  

		
		@Test(priority = 126, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
	
			 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}
	
		@Test(priority = 128, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase End =========================");
		}
		@Test(priority = 130, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information")
		public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information");

			 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information testcase  End =========================");
		}	 
	

	/*@Test(priority =132, enabled = true)  
	  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
   System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information  testcase started =========================" );
	  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information  testcase  End =========================" );	  
	  }*/
	  
	  @Test(priority =134, enabled = true)	  
	  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" )	
	  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation()   throws	 Exception {
	  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );	  
	  }
	  
	  
	  @Test(priority = 136, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information" )
	  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }


	  /*@Test(priority = 138, enabled = true)	  
	  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" )
	  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================" ); 
	  }*/
	
	  @Test(priority = 140, enabled = true)	  
	  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information" )
	  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception { 
	 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================" );
	  }
	  
	  
	  
	  /*@Test(priority = 142, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  End =========================");
      }*/
	  
	  @Test(priority = 144, enabled = true)	  
	  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void
	  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws  Exception {
	  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 
	  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
      }
	  
	  
	  @Test(priority = 146, enabled = true)	  
	  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information") 
	  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation()  throws   Exception {
	System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information"); 	
	  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started End =========================" );  
	  }
	
	  @Test(priority = 148, enabled = true)	  
	  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ) 
	  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
	  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ); 
	  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case  End ========================="); 
	  }
	

		 @Test(priority = 150, enabled = true)	  
		  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" ) 
		  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation() throws Exception {
		  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information" );  
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case started =========================");
		  Functions.validate_RDP_video_ad_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information test case End =========================");
		  }
		  
		 
		 
		 
		 
		 @Test(priority = 151, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optout")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK inapp/v2 call when privacy optout ====================");
			System.out.println("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
			logStep("****** Criteo SDK inapp/v2 call when privacy optout validation Started");
			
				CharlesFunctions.createXMLFileForCharlesSessionFile();
							Functions.verifyCriteo_inapp_v2_Call("Criteo", false);
		 }
	
		@Test(priority = 152, enabled = true)
		@Title("Verify Criteo SDK config app call when privacy optout")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA() throws Exception {
			System.out.println("==============================================");
			System.out.println(
					"=========================== Criteo SDK config/app call when privacy optout====================");
			System.out.println("****** Criteo SDK config/app call when privacy optout validation Started");
			logStep("****** Criteo SDK config/app call when privacy optout validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
			 CharlesFunctions.archive_folder("Charles");
	}
		
		
	  
		 @Test(priority = 200, enabled = true)
		 @Title("Enabling Preconfiguration for USACCPA to LGPD Travel Scenario")
			public void enable_PreConfiguration_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
				System.out.println("==============================================");
				System.out.println("****** Enable Preconfiguration for USACCPA to LGPD Travel Scenario");
				logStep("Enable Preconfiguration for USACCPA to LGPD Travel Scenario");
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
				AppiumFunctions.Kill_Launch_App();
				AppiumFunctions.Kill_Launch_App();
				AppiumFunctions.ClickonIUnderstand();
				
			}
		 
		 @Test(priority = 202, enabled = true)  
		  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
		  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario()  throws Exception {  
		  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 
		  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy test case  started =========================");
			this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();  
			  AppiumFunctions.Kill_Launch_App();
			  Thread.sleep(5000);
			  AppiumFunctions.Kill_Launch_App();
			   Thread.sleep(5000);
			  AppiumFunctions.Kill_Launch_App();
			   Thread.sleep(5000);
			  this.proxy.clearCharlesSession();
			  AppiumFunctions.Kill_Launch_App();
			  AppiumFunctions.Kill_Launch_App();
			   Thread.sleep(10000);
		   AppiumFunctions.clickOnMaps_tile();
			   Thread.sleep(5000);
			AppiumFunctions.clickOnVideos_tile();
			   Thread.sleep(80000);
			//CharlesFunctions.archive_folder("charles");
			this.proxy.getXml();
		  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
		  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA  privacy test case End =========================");	  
		  }
		  
		  @Test(priority = 204, enabled = true)	  
		  @Title("Verifying WeatherFXAPICall_apiCall_presence api for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
		  public void Verifying_WeatherFXAPICall_apiCall_presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
		  logStep("Verifying Verifying_WeatherFXAPICall_apiCall_presence for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario" ); 
		  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario in privacy card started =========================" );
			Functions.validating_WeatherFXAPI();
		  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence when user selecting Optoutmode scenario in privacy card End =========================");  
		  }
		  
		  
		  @Test(priority = 205, enabled = true)	  
		  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
		  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
		  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario" ); 
		  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
		  Functions.validating_bcp_privacy_Optoutmode_scenarion();
		  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
		  }
		  
		  @Test(priority = 206, enabled = true)	  
		  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
		  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception { 
		  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario"); 
		 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
		 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
		 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
		  }
		            
		 /* @Test(priority=208,enabled = true)  
		  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
		  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception { 
		  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario test case Started========================="); 
		//  Functions.get_aaxcal_homescreen_hourly(); 
		  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario");
		  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
		  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario  test case  End ========================="); 
		  }*/
		
		 
			@Test(priority = 210, enabled = true)
			@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
			public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA__to_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase Started =========================");
				logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario");
				//Functions.get_aaxcal_feed1();
				  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
				System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase End =========================");

			}
		
		@Test(priority = 212, enabled = true)
		@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
		public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase Started =========================");
			logStep("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");
			//Functions.get_aaxcal_feed2();
			  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
			System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA ro LGPD Travel Scenario  testcase End =========================");
		}

		 @Test(priority = 214, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
			public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase  Started =========================");
			logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario");
			//Functions.get_aaxcal_Hourly();
			  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
			System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase  End =========================");
			}
			
			  @Test(priority =216, enabled = true)
				@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
				public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
					System.out.println(
							"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario  test case Started =========================");
				
					  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
					System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case  End =========================");

				}
				


				@Test(priority = 218, enabled = true)
				@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
				public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
					System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case Started =========================");

					 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
					System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  End =========================");

				}



				@Test(priority = 220, enabled = true)
				@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario")
				public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
					System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario test case  Started =========================");
					
					 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
					System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario  test case End =========================");
				}
				  

			
			@Test(priority = 222, enabled = true)
			@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
			public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario  testcase  Started =========================");
				logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");
		
				 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario testcase  End =========================");
			}
		
			@Test(priority = 224, enabled = true)
			@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario")
			public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase Started =========================");
				logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");

				 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
				System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario testcase End =========================");
			}
			@Test(priority = 226, enabled = true)
			@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
			public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase Started =========================");
				logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");

				 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
				System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario testcase  End =========================");
			}	 
		

		/*@Test(priority =228, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ) 
		  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
	   System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario  testcase started =========================" );
		  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");
		  Functions.finding_Homescreen_iu_value();
		  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario  testcase  End =========================" );	  
		  }*/
		  
		  @Test(priority =228, enabled = true)	  
		  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario" )	
		  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario()   throws	 Exception {
		  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" );  
		  Functions.finding_Homescreen_marquee_iu_value();
		  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================" );	  
		  }
		  
		  
		  @Test(priority = 230, enabled = true)	  
		  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" )
		  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ); 
		  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
		  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================" ); 
		  }


		 /* @Test(priority = 232, enabled = true)	  
		  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" )
		  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ); 
		  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
		  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================" ); 
		  }*/
		
		  @Test(priority = 234, enabled = true)	  
		  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" )
		  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception { 
		 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" );
		  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" );  
		  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
		  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case End =========================" );
		  }
		  
		  
		  
		 /* @Test(priority = 236, enabled = true)	  
		  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
		  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 
		  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  started =========================" ); 
		  Functions.validate_RDP_homescrenhourly_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  End =========================");
	      }*/
		  
		  @Test(priority = 238, enabled = true)	  
		  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
		  public void
		  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
		  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 
		  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" ); 
		  Functions.validate_RDP_homescreenmarquee_Optoutmode();
		  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case End =========================");
	      }
		  
		  
		  @Test(priority = 240, enabled = true)	  
		  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario") 
		  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario()  throws   Exception {
		System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" );
		  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 	
		  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario");
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started End =========================" );  
		  }
		
		  @Test(priority = 242, enabled = true)	  
		  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ) 
		  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
		  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ); 
		  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" );
		  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
		  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case  End ========================="); 
		  }
		

			 @Test(priority = 244, enabled = true)	  
			  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" ) 
			  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
			  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LGPD Travel Scenario" );  
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario test case started =========================");
			  Functions.validate_RDP_video_ad_Optoutmode();
			  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================");
			  }
			  

		
			 /* @Test(priority = 246, enabled = true)	  
			  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
			  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
			  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 
			  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  started =========================" ); 
			  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
			  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case  End =========================");
		      }*/
			  
			  @Test(priority = 248, enabled = true)	  
			  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD  Travel Scenario") 
			  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws  Exception {
			  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario"); 
			  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================" ); 
				 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
			  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================");
		      }
			 
				
				@Test(priority =250, enabled = true)  
				 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario") 
				 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
				 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario" );  	  
				  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case started =========================");
				 Functions.validate_npa_video_ad_dontsellmyinformation();
				 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario test case End =========================");
				
				 }
				

				@Test(priority = 252, enabled = true)
				@Title("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA to LGPD Travel Scenario")
				public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
					System.out.println("==============================================");
					System.out.println(
							"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA to LGPD Travel Scenario====================");
					System.out.println(
							"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA to LGPD Travel Scenario validation Started");
					logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA  to LGPD Travel Scenario validation Started");
			Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

				}

				@Test(priority = 254, enabled = true)
				@Title("Verify Criteo SDK config app call when privacy optout for USACCPA to LGPD Travel Scenario")
				public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_to_LGPD_Travel_Scenario() throws Exception {
					System.out.println("==============================================");
					System.out.println(
							"=========================== Criteo SDK config/app call when privacy optout for USACCPA to LGPD Travel Scenario====================");
					System.out.println(
							"****** Criteo SDK config/app call when privacy optout for USACCPA to LGPD Travel Scenario validation Started");
					logStep("****** Criteo SDK config/app call when privacy optout for USACCPA  to LGPD Travel Scenario validation Started");
				Functions
				.verifyCriteo_config_app_Call("Criteo", false);
					 CharlesFunctions.archive_folder("Charles");
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000); 


				}
				//==========================================================================================================//
				//USACCPA to LGPD travelling test cases End
				//==========================================================================================================//
				
				
				//==========================================================================================================//
				//USACCPA to GDPR  travelling test cases End
				//==========================================================================================================//
				
				 @Test(priority = 256, enabled = true)
				 @Title("Enabling Preconfiguration for USACCPA to LGPD Travel Scenario")
					public void enable_PreConfiguration_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
						System.out.println("==============================================");
						System.out.println("****** Enable Preconfiguration for USACCPA to GDPR  Travel Scenario");
						logStep("Enable Preconfiguration for USACCPA to GDPR Travel Scenario");
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
						AppiumFunctions.Kill_Launch_App();
						AppiumFunctions.Kill_Launch_App();
						AppiumFunctions.ClickonIUnderstand();
						
					}
				 
				 @Test(priority = 258, enabled = true)  
				  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario()  throws Exception {  
				  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
				  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA  to GDPR travelling  privacy test case  started =========================");
					this.proxy.clearCharlesSession();
				  AppiumFunctions.Kill_Launch_App();  
					  AppiumFunctions.Kill_Launch_App();
					   Thread.sleep(50000);
					  AppiumFunctions.Kill_Launch_App();
					  AppiumFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					  this.proxy.clearCharlesSession();
					  AppiumFunctions.Kill_Launch_App();
					   Thread.sleep(10000);
					  AppiumFunctions.Kill_Launch_App();
				   AppiumFunctions.clickOnMaps_tile();
					AppiumFunctions.clickOnVideos_tile();
					   Thread.sleep(80000);
					//CharlesFunctions.archive_folder("charles");
					this.proxy.getXml();
				  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
				  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA to GDPR travelling  privacy test case End =========================");	  
				  }
				  
				  @Test(priority = 260, enabled = true)	  
				  @Title("Verifying WeatherFXAPICall_apiCall_presence api for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LGPD Travel Scenario")
				  public void Verifying_WeatherFXAPICall_apiCall_presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
				  logStep("Verifying WeatherFXAPICall_apiCall_presence for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to GDPR in privacy card started =========================" );
				 	Functions.validating_WeatherFXAPI();
				  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to GDPR in privacy card  End =========================");  
				  }
				  
				  
				  @Test(priority = 262, enabled = true)	  
				  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
				  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
				  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
				  Functions.validating_bcp_privacy_Optoutmode_scenarion();
				  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
				  }
				  
				  @Test(priority = 264, enabled = true)	  
				  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception { 
				  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
				 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
				 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
				 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
				  }
				            
				 /* @Test(priority=266,enabled = true)  
				  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception { 
				  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario test case Started========================="); 
				//  Functions.get_aaxcal_homescreen_hourly(); 
				  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
				  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
				  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario  test case  End ========================="); 
				  }*/
				
				 
					@Test(priority = 268, enabled = true)
					@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
					public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA__to_GDPR_Travel_Scenario() throws Exception {
						System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase Started =========================");
						logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
						//Functions.get_aaxcal_feed1();
						  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
						System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase End =========================");

					}
				
				@Test(priority = 270, enabled = true)
				@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
				public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
					System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase Started =========================");
					//Functions.get_aaxcal_feed2();
					  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
					System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario  testcase End =========================");
				}

				 @Test(priority = 272, enabled = true)
					@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
					public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
					System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase  Started =========================");
					logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario");
					//Functions.get_aaxcal_Hourly();
					  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
					System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase  End =========================");
					}
					
					  @Test(priority =274, enabled = true)
						@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
						public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
							System.out.println(
									"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario  test case Started =========================");
						
							  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
							System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case  End =========================");

						}
						


						@Test(priority = 276, enabled = true)
						@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
						public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
							System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case Started =========================");

							 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
							System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  End =========================");

						}



						@Test(priority = 278, enabled = true)
						@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to GDPR Travel Scenario")
						public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
							System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to GDPR Travel Scenario test case  Started =========================");
							
							 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
							System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to GDPR Travel Scenario  test case End =========================");
						}
						  

					
					@Test(priority = 280, enabled = true)
					@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
					public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
						System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario  testcase  Started =========================");
						logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
				
						 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
						System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario testcase  End =========================");
					}
				
					@Test(priority = 282, enabled = true)
					@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
					public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
						System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase Started =========================");
						logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");

						 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
						System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario testcase End =========================");
					}
					@Test(priority = 284, enabled = true)
					@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
					public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
						System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase Started =========================");
						logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");

						 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
						System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario testcase  End =========================");
					}	 
				

				/*@Test(priority =286, enabled = true)  
				  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ) 
				  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
			   System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario  testcase started =========================" );
				  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
				  Functions.finding_Homescreen_iu_value();
				  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario  testcase  End =========================" );	  
				  }*/
				  
				  @Test(priority =288, enabled = true)	  
				  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to GDPR Travel Scenario" )	
				  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario()   throws	 Exception {
				  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" );  
				  Functions.finding_Homescreen_marquee_iu_value();
				  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================" );	  
				  }
				  
				  
				  @Test(priority = 290, enabled = true)	  
				  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" )
				  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
				  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  started ========================="); 
				  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
				  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================" ); 
				  }


				  /*@Test(priority = 292, enabled = true)	  
				  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" )
				  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
				  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case started ========================="); 
				  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
				  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================" ); 
				  }*/
				
				  @Test(priority = 294, enabled = true)	  
				  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" )
				  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception { 
				 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" );
				  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" );  
				  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
				  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case End =========================" );
				  }
				  
				  
				  
				 /* @Test(priority = 296, enabled = true)	  
				  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
				  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
				  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  started =========================" ); 
				  Functions.validate_RDP_homescrenhourly_Optoutmode();
				  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  End =========================");
			      }*/
				  
				  @Test(priority = 298, enabled = true)	  
				  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void
				  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
				  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
				  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" ); 
				  Functions.validate_RDP_homescreenmarquee_Optoutmode();
				  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case End =========================");
			      }
				  
				  
				  @Test(priority = 300, enabled = true)	  
				  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
				  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario()  throws   Exception {
				System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" );
				  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 	
				  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
				  Functions.Verify_video_ad_call_Optoutmode(); 
				  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started End =========================" );  
				  }
				
				  @Test(priority = 302, enabled = true)	  
				  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ) 
				  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
				  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ); 
				  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" );
				  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
				  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case  End ========================="); 
				  }
				

					 @Test(priority = 304, enabled = true)	  
					  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" ) 
					  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
					  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to GDPR Travel Scenario" );  
					  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario test case started =========================");
					  Functions.validate_RDP_video_ad_Optoutmode();
					  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================");
					  }
					  

				
					  /*@Test(priority = 306, enabled = true)	  
					  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
					  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
					  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
					  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  started =========================" ); 
					  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
					  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case  End =========================");
				      }*/
					  
					  @Test(priority = 308, enabled = true)	  
					  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario") 
					  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws  Exception {
					  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
					  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================" ); 
						 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
					  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================");
				      }
					  
						
						@Test(priority =310, enabled = true)  
						 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario") 
						 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
						 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario" );  	  
						  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case started =========================");
						 Functions.validate_npa_video_ad_dontsellmyinformation();
						 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario test case End =========================");
						
						 }
						

						@Test(priority = 312, enabled = true)
						@Title("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA to GDPR Travel Scenario")
						public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_to_GDPR_Travel_Scenario_tedt() throws Exception {
							System.out.println("==============================================");
							System.out.println(
									"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA to GDPR Travel Scenario====================");
							System.out.println(
									"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA to GDPR Travel Scenario validation Started");
							logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA  to GDPR Travel Scenario validation Started");
					Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

						}

						@Test(priority = 314, enabled = true)
						@Title("Verify Criteo SDK config app call when privacy optout for USACCPA to GDPR Travel Scenario")
						public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_to_GDPR_Travel_Scenario() throws Exception {
							System.out.println("==============================================");
							System.out.println(
									"=========================== Criteo SDK config/app call when privacy optout for USACCPA to GDPR Travel Scenario====================");
							System.out.println(
									"****** Criteo SDK config/app call when privacy optout for USACCPA to GDPR Travel Scenario validation Started");
							logStep("****** Criteo SDK config/app call when privacy optout for USACCPA to GDPR Travel Scenario validation Started");
						Functions
						.verifyCriteo_config_app_Call("Criteo", false);
							 CharlesFunctions.archive_folder("Charles");
								Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);

						}
						
						
						//==========================================================================================================//
						//USACCPA to GDPR travelling test cases End
						//==========================================================================================================//
						
						
						//==========================================================================================================//
						//USACCPA to LATAMCO  travelling test cases Started
						//==========================================================================================================//

						 @Test(priority = 316, enabled = true)
						 @Title("Enabling Preconfiguration for USACCPA to LATAMCO Travel Scenario")
							public void enable_PreConfiguration_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
								System.out.println("==============================================");
								System.out.println("****** Enable Preconfiguration for USACCPA to LATAMCO  Travel Scenario");
								logStep("Enable Preconfiguration for USACCPA to LATAMCO Travel Scenario");
								proxy.quitCharlesProxy();
								// Ad.closeApp();
								this.configFile = this.rewriteRuleToEnableLGPD(LATAMCO_CONFIG_FILE_PATH);
								this.proxy = new CharlesProxy("localhost", 8333, LATAMCO_CONFIG_FILE_PATH);
								proxy.startCharlesProxyWithUI();
								this.proxy.disableRewriting();
						                 this.proxy.stopRecording();
						                this.proxy.disableMapLocal();
						                proxy.enableRewriting();
						                proxy.startRecording();
								// Ad.launchApp();
								AppiumFunctions.Kill_Launch_App();
								AppiumFunctions.Kill_Launch_App();
								AppiumFunctions.ClickonIUnderstand();
								
							}
						 @Test(priority = 318, enabled = true)  
						  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario()  throws Exception {  
						  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
						  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA  to GDPR travelling  privacy test case  started =========================");
							this.proxy.clearCharlesSession();
						  AppiumFunctions.Kill_Launch_App();  
							  AppiumFunctions.Kill_Launch_App();
							  AppiumFunctions.Kill_Launch_App();
							  AppiumFunctions.Kill_Launch_App();
							   Thread.sleep(10000);
							  this.proxy.clearCharlesSession();
							  AppiumFunctions.Kill_Launch_App();
							   Thread.sleep(10000);
							  AppiumFunctions.Kill_Launch_App();
						   AppiumFunctions.clickOnMaps_tile();
							   Thread.sleep(10000);
							AppiumFunctions.clickOnVideos_tile();
							   Thread.sleep(80000);
							//CharlesFunctions.archive_folder("charles");
							this.proxy.getXml();
						  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
						  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA to LATAMCO travelling  privacy test case End =========================");	  
						  }
						  
						  @Test(priority = 320, enabled = true)	  
						  @Title("Verifying WeatherFXAPICall_apiCall_presence api for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
						  public void Verifying_WeatherFXAPICall_apiCall_presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
						  logStep("Verifying WeatherFXAPICall_apiCall_presence for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to LATAMCO in privacy card started =========================" );
						 Functions.validating_WeatherFXAPI();
						  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to LATAMCO in privacy card  End =========================");  
						  }
						  
						  
						  @Test(priority = 322, enabled = true)	  
						  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
						  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
						  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
						  Functions.validating_bcp_privacy_Optoutmode_scenarion();
						  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
						  }
						  
						  @Test(priority = 324, enabled = true)	  
						  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception { 
						  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 
						 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
						 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
						 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
						  }
						            
						  /*@Test(priority=326,enabled = true)  
						  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception { 
						  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case Started========================="); 
						//  Functions.get_aaxcal_homescreen_hourly(); 
						  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
						  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
						  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario  test case  End ========================="); 
						  }*/
						
						 
							@Test(priority = 328, enabled = true)
							@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
							public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA__to_LATAMCO_Travel_Scenario() throws Exception {
								System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase Started =========================");
								logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
								//Functions.get_aaxcal_feed1();
								  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
								System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase End =========================");

							}
						
						@Test(priority = 330, enabled = true)
						@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
						public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
							System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase Started =========================");
							//Functions.get_aaxcal_feed2();
							  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
							System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario  testcase End =========================");
						}

						 @Test(priority = 332, enabled = true)
							@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
							public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
							System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase  Started =========================");
							logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA Travel Scenario");
							//Functions.get_aaxcal_Hourly();
							  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
							System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase  End =========================");
							}
							
							  @Test(priority =334, enabled = true)
								@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
								public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
									System.out.println(
											"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario  test case Started =========================");
								
									  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
									System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case  End =========================");

								}
								


								@Test(priority = 336, enabled = true)
								@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
								public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
									System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case Started =========================");

									 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
									System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  End =========================");

								}



								@Test(priority = 338, enabled = true)
								@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LATAMCO Travel Scenario")
								public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
									System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LATAMCO Travel Scenario test case  Started =========================");
									
									 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
									System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LATAMCO Travel Scenario  test case End =========================");
								}
								  

							
							@Test(priority = 340, enabled = true)
							@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario")
							public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
								System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario  testcase  Started =========================");
								logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario");
						
								 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
								System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario testcase  End =========================");
							}
						
							@Test(priority = 342, enabled = true)
							@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
							public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
								System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase Started =========================");
								logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario");

								 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
								System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR  Travel Scenario testcase End =========================");
							}
							@Test(priority = 346, enabled = true)
							@Title("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario")
							public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
								System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase Started =========================");
								logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario");

								 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
								System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario testcase  End =========================");
							}	 
						

						/*@Test(priority =348, enabled = true)  
						  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ) 
						  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
					   System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario  testcase started =========================" );
						  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario");
						  Functions.finding_Homescreen_iu_value();
						  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario  testcase  End =========================" );	  
						  }*/
						  
						  @Test(priority =350, enabled = true)	  
						  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LATAMCO Travel Scenario" )	
						  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario()   throws	 Exception {
						  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" );  
						  Functions.finding_Homescreen_marquee_iu_value();
						  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================" );	  
						  }
						  
						  
						  @Test(priority = 352, enabled = true)	  
						  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" )
						  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
						  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  started ========================="); 
						  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
						  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================" ); 
						  }


						  /*@Test(priority = 354, enabled = true)	  
						  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" )
						  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
						  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case started ========================="); 
						  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
						  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================" ); 
						  }*/
						
						  @Test(priority = 356, enabled = true)	  
						  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" )
						  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception { 
						 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" );
						  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" );  
						  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
						  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case End =========================" );
						  }
						  
						  
						  
						 /* @Test(priority = 358, enabled = true)	  
						  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
						  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 
						  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  started =========================" ); 
						  Functions.validate_RDP_homescrenhourly_Optoutmode();
						  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  End =========================");
					      }*/
						  
						  @Test(priority = 360, enabled = true)	  
						  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void
						  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
						  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 
						  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" ); 
						  Functions.validate_RDP_homescreenmarquee_Optoutmode();
						  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case End =========================");
					      }
						  
						  
						  @Test(priority = 362, enabled = true)	  
						  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
						  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario()  throws   Exception {
						System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" );
						  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 	
						  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario");
						  Functions.Verify_video_ad_call_Optoutmode(); 
						  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started End =========================" );  
						  }
						
						  @Test(priority = 364, enabled = true)	  
						  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ) 
						  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
						  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ); 
						  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" );
						  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
						  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case  End ========================="); 
						  }
						

							 @Test(priority = 366, enabled = true)	  
							  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" ) 
							  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
							  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to LATAMCO Travel Scenario" );  
							  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario test case started =========================");
							  Functions.validate_RDP_video_ad_Optoutmode();
							  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================");
							  }
							  

						
							/*@Test(priority = 368, enabled = true)	  
							  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
							  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
							  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 
							  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  started =========================" ); 
							  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
							  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case  End =========================");
						      }*/
							  
							  @Test(priority = 370, enabled = true)	  
							  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO  Travel Scenario") 
							  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws  Exception {
							  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario"); 
							  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================" ); 
								 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
							  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================");
						      }
							  
								
								@Test(priority =372, enabled = true)  
								 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario") 
								 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
								 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario" );  	  
								  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case started =========================");
								 Functions.validate_npa_video_ad_dontsellmyinformation();
								 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to LATAMCO Travel Scenario test case End =========================");
								
								 }
								

								@Test(priority = 374, enabled = true)
								@Title("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA to LATAMCO Travel Scenario")
								public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_to_LATAMCO_Travel_Scenario_tedt() throws Exception {
									System.out.println("==============================================");
									System.out.println(
											"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA to LATAMCO Travel Scenario====================");
									System.out.println(
											"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA to LATAMCO Travel Scenario validation Started");
									logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA  to LATAMCO Travel Scenario validation Started");
							Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

								}

								@Test(priority = 376, enabled = true)
								@Title("Verify Criteo SDK config app call when privacy optout for USACCPA to LATAMCO Travel Scenario")
								public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_to_LATAMCO_Travel_Scenario() throws Exception {
									System.out.println("==============================================");
									System.out.println(
											"=========================== Criteo SDK config/app call when privacy optout for USACCPA to LATAMCO Travel Scenario====================");
									System.out.println(
											"****** Criteo SDK config/app call when privacy optout for USACCPA to LATAMCO Travel Scenario validation Started");
									logStep("****** Criteo SDK config/app call when privacy optout for USACCPA to LATAMCO Travel Scenario validation Started");
								Functions
								.verifyCriteo_config_app_Call("Criteo", false);
									 CharlesFunctions.archive_folder("Charles");
										Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);

								}
								
								
								//==========================================================================================================//
								//USACCPA to LATAMCO travelling test cases End
								//==========================================================================================================//
								
								@Test(priority = 378, enabled = true)
								 @Title("Enabling Preconfiguration for USACCPA to SERBIA Travel Scenario")
									public void enable_PreConfiguration_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
										System.out.println("==============================================");
										System.out.println("****** Enable Preconfiguration for USACCPA to SERBIA  Travel Scenario");
										logStep("Enable Preconfiguration for USACCPA to SERBIA Travel Scenario");
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
										AppiumFunctions.Kill_Launch_App();
										AppiumFunctions.Kill_Launch_App();
										AppiumFunctions.ClickonIUnderstand();
										
									}
								 @Test(priority = 380, enabled = true)  
								  @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario()  throws Exception {  
								  logStep("Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to GDPR Travel Scenario"); 
								  System.out.println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA  to SERBIA travelling  privacy test case  started =========================");
									this.proxy.clearCharlesSession();
								  AppiumFunctions.Kill_Launch_App();  
									  AppiumFunctions.Kill_Launch_App();
									  AppiumFunctions.Kill_Launch_App();
									   Thread.sleep(10000);
									  AppiumFunctions.Kill_Launch_App();
									   Thread.sleep(10000);
									  this.proxy.clearCharlesSession();
									  AppiumFunctions.Kill_Launch_App();
									   Thread.sleep(10000);
									  AppiumFunctions.Kill_Launch_App();
								   AppiumFunctions.clickOnMaps_tile();
									   Thread.sleep(10000);
									AppiumFunctions.clickOnVideos_tile();
									   Thread.sleep(80000);
									//CharlesFunctions.archive_folder("charles");
									this.proxy.getXml();
								  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
								  System.out.println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for USA-CCPA to SERBIA travelling  privacy test case End =========================");	  
								  }
								  
								  @Test(priority = 382, enabled = true)	  
								  @Title("Verifying WeatherFXAPICall_apiCall_presence api for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
								  public void Verifying_WeatherFXAPICall_apiCall_presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
								  logStep("Verifying WeatherFXAPICall_apiCall_presence for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to SERBIA in privacy card started =========================" );
								 	Functions.validating_WeatherFXAPI();
								  System.out.println("=================Verifying_WeatherFXAPICall_apiCall_presence Optoutmode scenario  USACCPA to SERBIA in privacy card  End =========================");  
								  }
								  
								  
								  @Test(priority = 384, enabled = true)	  
								  @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
								  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
								  logStep("Verifying Lotame bcp.crwdcntrl.net api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
								  Functions.validating_bcp_privacy_Optoutmode_scenarion();
								  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
								  }
								  
								  @Test(priority = 386, enabled = true)	  
								  @Title("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception { 
								  logStep("Verifying Factual location.wfxtriggers.com api call supressing for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 
								 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
								 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
								 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
								  }
								            
								  /*@Test(priority=388,enabled = true)  
								  @Title("Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception { 
								  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case Started========================="); 
								//  Functions.get_aaxcal_homescreen_hourly(); 
								  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");
								  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
								  System.out.println("=================Verifying supress amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario  test case  End ========================="); 
								  }*/
								
								 
									@Test(priority = 390, enabled = true)
									@Title("Verifying supress amazon Slot Id for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
									public void Verifying_supress_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA__to_SERBIA_Travel_Scenario() throws Exception {
										System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase Started =========================");
										logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");
										//Functions.get_aaxcal_feed1();
										  Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
										System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase End =========================");

									}
								
								@Test(priority = 392, enabled = true)
								@Title("Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
								public void Verifying_supress_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
									System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase Started =========================");
									//Functions.get_aaxcal_feed2();
									  Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
									System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario  testcase End =========================");
								}

								 @Test(priority = 394, enabled = true)
									@Title("Verifying supress amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
									public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
									System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase  Started =========================");
									logStep("Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for SERBIA Travel Scenario");
									//Functions.get_aaxcal_Hourly();
									  Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
									System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase  End =========================");
									}
									
									  @Test(priority =396, enabled = true)
										@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
										public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
											System.out.println(
													"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario  test case Started =========================");
										
											  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
											System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case  End =========================");

										}
										


										@Test(priority = 398, enabled = true)
										@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
										public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
											System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case Started =========================");

											 Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
											System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  End =========================");

										}



										@Test(priority = 400, enabled = true)
										@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to SERBIA Travel Scenario")
										public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
											System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to SERBIA Travel Scenario test case  Started =========================");
											
											 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
											System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to SERBIA Travel Scenario  test case End =========================");
										}
										  

									
									@Test(priority = 402, enabled = true)
									@Title("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
									public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
										System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario  testcase  Started =========================");
										logStep("Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");
								
										 Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
										System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario testcase  End =========================");
									}
								
									@Test(priority = 404, enabled = true)
									@Title("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
									public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
										System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase Started =========================");
										logStep("Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");

										 Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
										System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario testcase End =========================");
									}
									@Test(priority = 406, enabled = true)
									@Title("Verifying  amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario")
									public void Verifying_supress_amazon_Slotid_video_adcall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
										System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase Started =========================");
										logStep("Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");

										 Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
										System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario testcase  End =========================");
									}	 
								

								/*@Test(priority =408, enabled = true)  
								  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ) 
								  public void  Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
							   System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario  testcase started =========================" );
								  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");
								  Functions.finding_Homescreen_iu_value();
								  System.out.println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario  testcase  End =========================" );	  
								  }*/
								  
								  @Test(priority =410, enabled = true)	  
								  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to SERBIA Travel Scenario" )	
								  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario()   throws	 Exception {
								  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" );  
								  Functions.finding_Homescreen_marquee_iu_value();
								  System.out.println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================" );	  
								  }
								  
								  
								  @Test(priority = 412, enabled = true)	  
								  @Title("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" )
								  public void   Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
								  logStep("Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out.println("=================Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  started ========================="); 
								  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
								  System.out.println("================= Verifying SOD Cust param value in homescreen marquee call for  USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================" ); 
								  }


								 /* @Test(priority = 414, enabled = true)	  
								  @Title("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" )
								  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
								  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case started ========================="); 
								  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
								  System.out.println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================" ); 
								  }*/
								
								  @Test(priority = 416, enabled = true)	  
								  @Title("Verifying SOD Cust param value in maps details page ad call for USA _CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" )
								  public void Verifying_SOD_Cust_Param_mapsdetails_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception { 
								 System.out. println("================= Verifying SOD Cust param value in homescreen hourly ad call for USA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" );
								  logStep("Verifying SOD Cust param value in homescreen hourly ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" );  
								  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
								  System.out. println("================= Verifying SOD Cust param value in maps details page ad call for USA_CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case End =========================" );
								  }
								  
								  
								  
								 /* @Test(priority = 418, enabled = true)	  
								  @Title("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void  Verifying_rdp_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
								  logStep("Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 
								  System.out.println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  started =========================" ); 
								  Functions.validate_RDP_homescrenhourly_Optoutmode();
								  System.out. println("================= Verifying rdp=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  End =========================");
							      }*/
								  
								  @Test(priority = 420, enabled = true)	  
								  @Title("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void
								  Verifying_rdp_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
								  logStep("Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 
								  System.out.println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" ); 
								  Functions.validate_RDP_homescreenmarquee_Optoutmode();
								  System.out. println("================= Verifying rdp=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case End =========================");
							      }
								  
								  
								  @Test(priority = 422, enabled = true)	  
								  @Title("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
								  public void Verifying_videos_adCall_Presence_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario()  throws   Exception {
								System.out. println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" );
								  logStep("Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 	
								  logStep("Verifying supress of normal amazon slotid in feed_1  for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario");
								  Functions.Verify_video_ad_call_Optoutmode(); 
								  System.out.println("=================Verifying videos ad call presense for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started End =========================" );  
								  }
								
								  @Test(priority = 424, enabled = true)	  
								  @Title("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ) 
								  public void  Verifying_SOD_Cust_Param_videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
								  logStep("Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ); 
								  System.out. println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" );
								  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
								  System.out.println("================= Verifying SOD Cust param value in Videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case  End ========================="); 
								  }
								

									 @Test(priority = 426, enabled = true)	  
									  @Title("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" ) 
									  public void Verifying_rdp_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
									  logStep("Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA  to SERBIA Travel Scenario" );  
									  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario test case started =========================");
									  Functions.validate_RDP_video_ad_Optoutmode();
									  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================");
									  }
									  

								
									  /*@Test(priority = 428, enabled = true)	  
									  @Title("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
									  public void  Verifying_npa_equals_1_homescreenHourly_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
									  logStep("Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 
									  System.out.println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  started =========================" ); 
									  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
									  System.out. println("================= Verifying npa=1 in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case  End =========================");
								      }*/
									  
									  @Test(priority = 430, enabled = true)	  
									  @Title("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA  Travel Scenario") 
									  public void Verifying_npa_equals_1_homescreenmarquee_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws  Exception {
									  logStep("Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario"); 
									  System.out.println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================" ); 
										 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
									  System.out. println("================= Verifying npa=1 in home screen marquee  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================");
								      }
									  
										
										@Test(priority =432, enabled = true)  
										 @Title("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario") 
										 public void Verifying_npa_equals_1_Videos_adCall_USA_CCPA_Privacy_DoNotSellMyInformation_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
										 logStep("Verifying npa=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario" );  	  
										  System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case started =========================");
										 Functions.validate_npa_video_ad_dontsellmyinformation();
										 System.out. println("================= Verifying rdp=1 in videos  ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information for USACCPA to SERBIA Travel Scenario test case End =========================");
										
										 }
										

										@Test(priority = 434, enabled = true)
										@Title("Verify Criteo SDK inapp v2 call when privacy optout for USACCPA to SERBIA Travel Scenario")
										public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_USACCPA_to_SERBIA_Travel_Scenario_tedt() throws Exception {
											System.out.println("==============================================");
											System.out.println(
													"=========================== Criteo SDK inapp/v2 call when privacy optout for USACCPA to SERBIA Travel Scenario====================");
											System.out.println(
													"****** Criteo SDK inapp/v2 call when privacy optout for USACCPA to SERBIA Travel Scenario validation Started");
											logStep("****** Criteo SDK inapp/v2 call when privacy optout for USACCPA  to SERBIA Travel Scenario validation Started");
									Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

										}

										@Test(priority = 436, enabled = true)
										@Title("Verify Criteo SDK config app call when privacy optout for USACCPA to SERBIA Travel Scenario")
										public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_USACCPA_to_SERBIA_Travel_Scenario() throws Exception {
											System.out.println("==============================================");
											System.out.println(
													"=========================== Criteo SDK config/app call when privacy optout for USACCPA to LATAMCO Travel Scenario====================");
											System.out.println(
													"****** Criteo SDK config/app call when privacy optout for USACCPA to SERBIA Travel Scenario validation Started");
											logStep("****** Criteo SDK config/app call when privacy optout for USACCPA to SERBIA Travel Scenario validation Started");
										Functions
										.verifyCriteo_config_app_Call("Criteo", false);
											 CharlesFunctions.archive_folder("Charles");
												Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);
				Thread.sleep(60000);

										}
								
								//==========================================================================================================//
								//USACCPA to Serbia  travelling test cases Started
								//==========================================================================================================//
								
				//==========================================================================================================//
	 
				@Test(priority = 438)
				public void preConditionsTest_for_USACCPA_Selecting_StandardAdvertisingSettings() throws Exception {
					proxy.quitCharlesProxy();
					this.configFile = this.rewriteRuleToEnableUSACCPA(CONFIG_FILE_PATH);
					this.proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

					this.proxy.startCharlesProxyWithUI();
					this.proxy.disableMapLocal();
					this.proxy.enableRewriting();
	          	         this.proxy.startRecording();
		               this.proxy.clearCharlesSession();
				//	Functions.close_launchApp();
					//Utils.navigateToAllCards(false);
				//	Utils.createXMLFileForCharlesSessionFile();
				}
	 
	 
	 
	  
	  @Test(priority = 440, enabled = true)	  
	  @Title("Selecting the  Standard Advertising Settings  in the privacy card") public void
	  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
	  logStep("Selecting the Standard Advertising Settings  in the privacy card");
     System.out. println("=================Slecting Standard Advertising Settings  in privacy card testcase started =========================");
	Ad.resetApp();
		  //AppiumFunctions. Kill_Launch_App();
		//CharlesFunctions.archive_folder("charles");
	  Thread.sleep(100000);	  
	 // AppiumFunctions.SwipeUp_Counter_privacy(25);
	  Thread.sleep(40000); 
	 // Functions.selecting_opt_in_mode();
		   Thread.sleep(40000); 		  	
		  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  AppiumFunctions.Kill_Launch_App();
		this.proxy.clearCharlesSession();
	  System.out.println("================= Slecting Standard Advertising Settings  in privacy card  testcase End ========================="); 
	  }
	  

	
	  
	  @Test(priority = 442, enabled = true)	  
	  @Title("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
	  public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws  Exception { 
	  logStep("Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
	  System.out.println("=================Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");	  
		this.proxy.clearCharlesSession();
		  AppiumFunctions.Kill_Launch_App();  
		   AppiumFunctions.clickOnMaps_tile();
			AppiumFunctions.clickOnVideos_tile();
		    Thread.sleep(80000);			
		  //CharlesFunctions.archive_folder("charles");
			this.proxy.getXml();			
	  Functions.validating_bcp_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying Lotame bcp.crwdcntrl.net api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	  
	  }
	  
	  @Test(priority = 446, enabled = true)	  
	  @Title("Verifying Factual location.wfxtriggers.com api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_Factual_locationwfxtriggerscom_apiCall_supress_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
	   logStep("Verifying Factual location.wfxtriggers.com api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings"); 
	   System.out.println("=================Verifying Factual location.wfxtriggers.com api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");
	
		 Functions.validating_Fatualcall_privacy_Optinmode_scenarion(); 
	
	   System.out. println("================= Verifying Factual location.wfxtriggers.com api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	 
	  }
	  
	  
	  @Test(priority = 447, enabled = true)	  
	  @Title("Verifying weatherfx api call presence for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_weatherfxapiCall_presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
	   logStep("Verifying weatherfx api call presence  for USA-CCPA privacy when Advertising option set to Standard Advertising Settings"); 
	   System.out.println("=================Verifying Factual location.wfxtriggers.com api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");

	   Functions.validating_WeatherFXAPI();
	
	   System.out. println("================= Verifying weatherfx api call presence api call supress for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
	 
	  }
	 
	  
	 /* @Test(priority=448,enabled = true)  
	  @Title("Verifying presence amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings") 
	  public void Verifying_presence_amazon_Slotid_homescreenhourly_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings()  throws Exception { 
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying presence amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings");
	  Functions.verifyaax_SlotId_Presence("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying presence amazon slotid for  home screen hourly preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  End ========================="); 
	  }*/
	
	 
	
		@Test(priority = 450, enabled = true)
		@Title("Verifying presence amazon SlotId for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_feed1_preroladcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings");
			//Functions.get_aaxcal_feed1();
			  Functions.verifyaax_SlotId_Presence("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying presence amazon SlotId for  feed1 preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings testcase End =========================");

		}
	
	@Test(priority = 452, enabled = true)
	@Title("Verifying presence amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings")
	public void Verifying_presence_amazon_Slotid_feed2_preroladcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
		logStep("Verifying presennce amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings");
		  Functions.verifyaax_SlotId_Presence("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying prence amazon SlotId for feed2 prerload ad call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
	}

	 @Test(priority = 454, enabled = true)
		@Title("Verifying presence amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_Hourlydetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
		System.out.println("=================Verifying presence amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  Started =========================");
		logStep("Verifying presence amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case n");
		  Functions.verifyaax_SlotId_Presence("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying presence amazon SlotId for  hourly details preload ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case   End =========================");
		}
		
		  @Test(priority =456, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println(
						"=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings  test case Started =========================");
				  Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly1 details big ad  preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}
			


			@Test(priority = 458, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings test case Started =========================");
				 Functions.verifyaax_SlotId_Presence("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying presence amazon SlotId for  hourly2 details big ad  preload call  USA-CCPA privacy when Advertising option set to  Standard Advertising Settings test case  End =========================");

			}



			@Test(priority = 460, enabled = true)
			@Title("Verifying presence amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings")
			public void Verifying_presence_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
				System.out.println("=================Verifying v amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings test case  Started =========================");
				 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying presence amazon SlotId for  hourly3 details big ad preload call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings  test case End =========================");
			}
			  

		
		@Test(priority = 462, enabled = true)
		@Title("Verifying presence amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_mapsdetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings  testcase  Started =========================");
			logStep("Verifying presence amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_map_details();
			 Functions.verifyaax_SlotId_Presence("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying presence amazon SlotId for maps details preload ad call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings testcase  End =========================");
		}
	
		@Test(priority = 464, enabled = true)
		@Title("Verifying presence amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_Dailydetails_preload_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings  testcase Started =========================");
			logStep("Verifying presence amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
			 Functions.verifyaax_SlotId_Presence("6c5a145d-9198-48f4-adfd-08f05557eace");
			System.out.println("=================Verifying presence amazon SlotId for daily details preload ad call USA-CCPA privacy when Advertising option set to  Standard Advertising Settings testcase End =========================");
		}
		@Test(priority = 468, enabled = true)
		@Title("Verifying presence amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		public void Verifying_presence_amazon_Slotid_video_adcall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to  Standard Advertising Settings testcase Started =========================");
			logStep("Verifying presence amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to Do Not Sell My Information");
			Functions.get_aaxcal_video_details();
			 Functions.verifyaax_SlotId_Presence("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying presence amazon SlotId for videos preload ad call for USA-CCPA privacy when Advertising option set to  Standard Advertising Settings  testcase  End =========================");
		}	 
	
		
		
		  
		 /* @Test(priority = 470, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenhourly_adCall_Presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  started ========================="); 
		  Functions. finding_Homescreen_marquee_iu_value();
		  System.out.println("================= Verifying home screen hourly ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }*/
		  
		  @Test(priority = 472, enabled = true)  
		  @Title("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void Verifying_homescreenmarquee_adCall_Presence_USA_CCPA_Privacy_StandardAdvertisingSettings() throws Exception {
		  logStep("Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions. finding_Homescreen_marquee_iu_value();
		  System.out.println("================= Verifying home screen marquee ad call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" );	  
		  }
		  
		  @Test(priority = 474, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen marquee ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings")
		  public void  Verifying_SOD_Cust_Param_homescreenmarquee_adCall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen marquee ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying SOD custum param for  home screen marquee ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings  test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreen_Optinmode(); 
		  System.out.println("================= Verifying SOD custum param for  home screen marquee ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  End =========================" ); 
		  }
		  
		  
		  /*@Test(priority = 476, enabled = true)	  
		  @Title("Verifying SOD custum param for  home screen hourly ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_homescreenhourly_adCall_USA_CCPA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  home screen hourly ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions.validate_SOD_Cust_param_homescreenhourly_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  home screen hourly ad call USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" ); 
		  }*/
		  
		  @Test(priority =478, enabled = true)	  
		  @Title("Verifying SOD custum param for  maps details ad call USA_CCPA privacy when Advertising option set to Standard Advertising Settings" )
		  public void  Verifying_SOD_Cust_Param_mapsdetails_adCall_USACCPA_Privacy_StandardAdvertisingSettings() throws  Exception {
		  logStep("Verifying SOD custum param for  maps details ad call USA_CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("================= Verifying SOD custum param for  maps details ad call USA privacy when Advertising option set to Standard Advertising Settings test case started ========================="); 
		  Functions.validate_SOD_Cust_param_deatiledfeed_Optinmode();
		  System.out.println("================= Verifying SOD custum param for  maps details  ad call USA privacy when Advertising option set to Standard Advertising Settings test case End =========================" ); 
		  }
		  
		  
		  @Test(priority = 480, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen marquee ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenmarquee_adCall_USA_CCPA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen marquee ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen marquee ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================" ); 
		  Functions.validate_RDP_homescreen_Optinmode();
		  System.out. println("=================  Verifying rdp keyword supress in home screen marquee ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================");
	   }
		  
		  /*@Test(priority = 482, enabled = true)	  
		  @Title("Verifying rdp keyword supress in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings") 
		  public void
		  Verifying_rdp_keyword_supress_homescreenHourly_adCall_USA_CCPA_Privacy_StandardAdvertisingSettings()  throws  Exception {
		  logStep("Verifying rdp keyword supress in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings"); 
		  System.out.println("================= Verifying rdp keyword supress in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" ); 
		  Functions.validate_RDP_homescreenhourly_Optinmode();
		  System.out. println("================= Verifying rdp keyword supress in home screen hourly ad call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings End =========================");
	   }*/
		
		
		
		  
		  
		  @Test(priority = 484, enabled = true)  
		  @Title("Verifying video call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ) 
		  public void  Verifying_video_adCall_Presence_USA_CCPA_Privacy_StandardAdvertisingSettings()  throws Exception {
		  logStep("Verifying video call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ); 
		  System.out.println("=================Verifying video call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================");
		;
		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out. println("================= Verifying video call presense for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );	  
		  }
		  
		
		
		  
		   @Test(priority = 486, enabled = true)	  
		  @Title("Verifying SOD custum param for  video ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings") 
		  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin_mode_scenario() throws Exception {
		  logStep("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card");
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case  started =========================" );
		  Functions.validate_SOD_Cust_param_video_Optinmode();
		  System.out.println("=================Verifying SOD custum param for  video ad call  USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		  }
		  
		   @Test(priority = 488, enabled = true)  
			  @Title("Verifying rdp keyword supress in videos call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings" ) 
			  public void Verifying_rdp_keyword_supress_videos_Call_USA_CCPA_Privacy_StandardAdvertisingSettings()  throws  Exception {	  
			 System.out. println("================= Verifying rdp keyword supress in videos call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case started =========================" );
			  logStep("Verifying rdp keyword supress in videos call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings");
			  Functions.validate_RDP_video_ad_Optinmode(); 
			  System.out. println("================= Verifying rdp keyword supress in videos call for USA-CCPA privacy when Advertising option set to Standard Advertising Settings test case End =========================" );
		
			  }
		   
		   
			@Test(priority = 490, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call when privacy optin")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optin_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out
						.println("=========================== Criteo SDK inapp/v2 call when privacy optin====================");
				System.out.println("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
				logStep("****** Criteo SDK inapp/v2 call when privacy optin validation Started");
				
			CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", true);

			}

			@Test(priority = 492, enabled = true)
			@Title("Verify Criteo SDK config app call when privacy optin")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optin_for_USACCPA() throws Exception {
				System.out.println("==============================================");
				System.out.println(
						"=========================== Criteo SDK config/app call when privacy optin====================");
				System.out.println("****** Criteo SDK config/app call when privacy optin validation Started");
				logStep("****** Criteo SDK config/app call when privacy optin validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", true);
				CharlesFunctions.archive_folder("Charles");
				

			}

			  

	  
		/*@BeforeTest
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

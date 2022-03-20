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

public class SerbiaPrivacyTest extends TwcAndroidBaseTest
{
	private static final String CONFIG_FILE_PATH = "enableSerbia.config";
	private CharlesProxy proxy;
	private File configFile;

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		System.out.println("****** SERBIA Privacy Test Started");
		logStep("****** SERBIA Privacy Test Started");
		this.configFile = this.rewriteRuleToEnableSERBIA(CONFIG_FILE_PATH);
		proxy = new CharlesProxy("localhost", 8333, CONFIG_FILE_PATH);

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
		
		System.out.println("****** SERBIA  Privacy Test Ended");
		logStep("******SERBIA  Privacy Test Ended");
	}
	
	@Test(priority = 3000)
	public void preConditionsTest_for_Serbia() throws Exception {
		
	}
	@Test(priority =3002,enabled = true)  
	 @Title("Verifying Lotame ad.crwdcntrl.net api call supressing for Serbia privacy") 
	public void Verifying_Loatme_adcrwdcntrlnet_apiCall_supressing_Serbia_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame ad.crwdcntrl.net api call supressing for Serbia privacy testcase started =========================" ); 
	Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out. println("================= Verifying Lotame ad.crwdcntrl.net api call supressing for Serbia privacy  testcase End =========================" );
	  }
	

	@Test(priority =3004,enabled = true)  
	 @Title("Verifying Lotame bcp.crwdcntrl.net api call supressing for Serbia privacy") 
	public void Verifying_Loatme_bcpcrwdcntrlnet_apiCall_supressing_Serbia_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for Serbia privacy testcase started =========================" ); 
	Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out. println("=================Verifying Lotame bcp.crwdcntrl.net api call supressing for Serbia privacy testcase End =========================" );
	  }
	
	@Test(priority =3006,enabled = true)  
	 @Title("Verifying Factual location.wfxtriggers.com api call supressing for Serbia privacy")  
	public void Verifying_Factual_locationwfxtriggerscom_apiCall_supressing_Serbia_Privacy() throws Exception {	  
	 System.out. println("=================Verifying Factual location.wfxtriggers.com api call supressing for Serbia privacy started =========================" ); 
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	  System.out. println("================= Verifying Factual location.wfxtriggers.com api call supressing for Serbia privacy End =========================" );
	  }
	  
	  	 @Test(priority = 3007, enabled = true)	  
	  @Title("Verifying weatherfx api call presence for Serbia privacy when Advertising option set to Standard Advertising Settings")
	  public void  Verifying_weatherfxapiCall_presence_Serbia_Privacy() throws Exception {
	   logStep("Verifying weatherfx api call presence  for for Serbia  privacy testcase started"); 
	   System.out.println("=================Verifying weatherfx api call presence  for for Serbia  privacy testcase started test case started =========================");
	   Functions.validating_WeatherFXAPI();	
	   System.out. println("================= Verifying weatherfx api call presence  for for Serbia  privacy testcase started test case End =========================" ); 
	  }
	

	 /*@Test(priority=3008,enabled = true)  
	  @Title("Verifying supress amazon slot id for  home screen hourly preload ad call Serbia Privacy") 
	  public void Verifying_Supress_amazon_Slotid_homescreenhourly_preload_adcall_Serbia_Privacy()throws Exception { 
	  System.out.println("=================Verifying supress amazon slot id for  home screen hourly preload ad call Serbia Privacy test case Started========================="); 
	//  Functions.get_aaxcal_homescreen_hourly(); 
	  logStep("Verifying supress amazon slot id for  home screen hourly preload ad call Serbia Privacy");
	  Functions.verifyaax_SlotId_supress("869c843c-7cf8-47ae-b6ed-088057e4bc8a");
	  System.out.println("=================Verifying supress amazon slot id in home screen hourly preload ad call for Serbia Privacy  test case  End ========================="); 
	  }*/
	
	 
		@Test(priority = 3010, enabled = true)
		@Title("Verifying supress amazon Slot Id for  feed1 preload ad call Serbia Privacy")
		public void Verifying_supress_amazon_Slotid_feed1_preroladcall_Serbia_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call Serbia Privacy testcase Started =========================");
			logStep("Verifying supress amazon Slot Id for  feed1 prerol ad call Serbia Privacy");
			//Functions.get_aaxcal_feed1();
			 // Functions.verifyaax_SlotId_supress("f4b66249-b6eb-4155-9d90-1e2b04487c99");
			System.out.println("=================Verifying supress amazon Slot Id for  feed1 preload ad call Serbia Privacy testcase End =========================");

		}
	
	@Test(priority = 3012, enabled = true)
	@Title("Verifying supress amazon SlotId for feed2 prerload ad call  Serbia Privacy")
	public void Verifying_supress_amazon_Slotid_feed2_preroladcall_Serbia_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  Serbia Privacy testcase Started =========================");
		logStep("Verifying supress amazon SlotId for feed2 prerload ad call  Serbia Privacy");
		//Functions.get_aaxcal_feed2();
		 // Functions.verifyaax_SlotId_supress("752a96eb-3198-4991-b572-17ec04883b6c");
		System.out.println("=================Verifying supress amazon SlotId for feed2 prerload ad call  Serbia Privacy  testcase End =========================");
	}

	 @Test(priority = 3014, enabled = true)
		@Title("Verifying supress amazon SlotId for  hourly details preload ad call Serbia Privacy")
		public void Verifying_Supress_amazon_Slotid_Hourlydetails_preload_adcall_Serbia_Privacy() throws Exception {
		System.out.println("=================Verifying supress amazon Slot Id for  hourly details preload ad call Serbia Privacy testcase  Started =========================");
		logStep("Verifying supress amazon Slot Id for  hourly details preload ad call Serbia Privacy");
		//Functions.get_aaxcal_Hourly();
		 // Functions.verifyaax_SlotId_supress("9be28769-4207-4d51-8063-dc8e645383b2");
		System.out.println("================= Verifying supress amazon Slot Id for  hourly details preload ad call Serbia Privacy testcase  End =========================");
		}
		
		  @Test(priority =3016, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly1 details big ad  preload call Serbia Privacy")
			public void Verifying_Supress_amazon_Slotid_Hourly1_bigaddetails_preload_adcall_Serbia_Privacy() throws Exception {
				System.out.println(
						"=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call Serbia Privacy  test case Started =========================");
				//Functions.get_aaxcal_Hourly1();
				//  Functions.verifyaax_SlotId_supress("08f0ccea-cab5-449c-963d-dc57ed9ee87d");
				System.out.println("=================Verifying supress amazon SlotId for  hourly1 details big ad  preload call Serbia Privacy test case  End =========================");

			}
			


			@Test(priority = 3018, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly2 details big ad  preload call  Serbia Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly2_bigaddetails_preload_adcall_Serbia_Privacy() throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  Serbia Privacy test case Started =========================");
				//Functions.get_aaxcal_Hourly2();
				// Functions.verifyaax_SlotId_supress("4fbed16a-cc6f-4cb1-94f7-81465acbd47");
				System.out.println("=================Verifying supress amazon SlotId for  hourly2 details big ad  preload call  Serbia Privacy test case  End =========================");

			}



			@Test(priority = 3020, enabled = true)
			@Title("Verifying supress amazon SlotId for  hourly3 details big ad preload call Serbia Privacy")
			public void Verifying_supress_amazon_Slotid_Hourly3_bigaddetails_preload_adcall_Serbia_Privacy()throws Exception {
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call Serbia Privacy test case  Started =========================");
			//	Functions.get_aaxcal_Hourly3();
				// Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
				System.out.println("=================Verifying supress amazon SlotId for  hourly3 details big ad preload call Serbia Privacy  test case End =========================");
			}
			  

		
		@Test(priority = 3022, enabled = true)
		@Title("Verifying supress amazon SlotId for maps details preload ad call Serbia Privacy")
		public void Verifying_supress_amazon_Slotid_mapsdetails_preload_adcall_Serbia_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call Serbia Privacy  testcase  Started =========================");
			logStep("Verifying supress amazon SlotId for maps details preload ad call Serbia Privacy");
			//Functions.get_aaxcal_map_details();
			// Functions.verifyaax_SlotId_supress("2634dc9-b59f-4b2c-b281-bb3be291b7b6");
			System.out.println("=================Verifying supress amazon SlotId for maps details preload ad call Serbia Privacy testcase  End =========================");
		}
	

		@Test(priority = 3024, enabled = true)
		@Title("Verifying supress amazon SlotId for daily details preload ad call Serbia Privacy")
		public void Verifying_supress_amazon_Slotid_Dailydetails_preload_adcall_Serbia_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call Serbia Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for daily details preload ad call Serbia Privacy");
			//Functions.get_aaxcal_Daily();
			// Functions.verifyaax_SlotId_supress("6c5a145d-9198-48f4-adfd-08f05557eace");
			
			System.out.println("=================Verifying supress amazon SlotId for daily details preload ad call serbia Privacy testcase End =========================");
		}
		@Test(priority = 3026, enabled = true)
		@Title("Verifying supress amazon SlotId for videos preload ad call for Serbia Privacy")
		public void Verifying_supress_amazon_Slotid_video_adcall_Serbia_Privacy() throws Exception {
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for Serbia Privacy testcase Started =========================");
			logStep("Verifying supress amazon SlotId for videos preload ad call for Serbia Privacy");
			// Functions.verifyaax_SlotId_supress("f71b7e17-6e34-4f6c-98f6-bbbe9f55586c");
			System.out.println("=================Verifying supress amazon SlotId for videos preload ad call for Serbia Privacy testcase  End =========================");
		}
		/*@Test(priority =3028, enabled = true)  
		  @Title("Verifying home screen hourly ad call presense for Serbia Privacy") 
		  public void  Verifying_homescreenhourly_adCall_Presence_Serbia_privacy()throws Exception {
	          System.out.println("=================Verifying home screen hourly ad call presense for Serbia  privacy  testcase started =========================" );
		  logStep("Verifying home screen hourly ad call presense for Serbia  privacy");
		  Functions.finding_Homescreen_iu_value();
		  System.out.println("=================Verifying home screen hourly ad call presense for Serbia privacy  testcase  End =========================" );	  
		  }*/
		  
		  @Test(priority = 3030, enabled = true)	  
		  @Title("Verifying home screen marquee ad call presense for Serbia privacy")	
		  public void Verifying_homescreenmarquee_adCall_Presence_Serbia_privacy() throws	 Exception {
		  logStep("Verifying home screen marquee ad call presense for Serbia privacy" ); 
		  System.out. println("=================Verifying home screen marquee ad call presense for Serbia privacy test case started =========================" );  
		  Functions.finding_Homescreen_marquee_iu_value();
		  System.out.println("=================Verifying home screen marquee ad call presense for Serbia privacy test case End =========================" );	  
		  }
		

			/*@Test(priority =3032, enabled = true)  
			 @Title("Verifying npa=1 in home screen hourly ad call for Serbia privacy") 
			public void Verifying_npa_equals_1_homescreenHourly_adCall_Serbia_privacy()throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen hourly ad call for Serbia  privacy  testcase started =========================" ); 
			  Functions.validate_npa_homescrenhourly_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen hourly ad call for Serbiam privacy  testcase End =========================" );
			  }*/
		  
			@Test(priority =3034, enabled = true)  
			 @Title("Verifying npa=1 in home screen marquee ad call for Serbia privacy") 
			public void Verifying_npa_equals_1_homescreenmarquee_adCall_Serbia_privacy()throws Exception {	  
			 System.out. println("=================Verifying npa=1 in home screen marquee ad call for Serbia  privacy  testcase started =========================" ); 
			 Functions.validate_npa_homescreenmarquee_dontsellmyinformation();
			  System.out. println("=================Verifying npa=1 in home screen marquee ad call for Serbia privacy  testcase End =========================" );
			  }
		
		
		@Test(priority = 3036, enabled = true)	  
		  @Title("Verifying videos ad call presense for Latam_CO_privacy") 
		  public void Verifying_videos_adCall_Presence_Latam_CO_privacy() throws   Exception {
		System.out. println("=================Verifying videos ad call presense for Latam_CO_privacy() privacy test case started =========================");
		  logStep("Verifying videos ad call presense for Latam_CO_privacy() privacy"); 	

		  Functions.Verify_video_ad_call_Optoutmode(); 
		  System.out.println("=================Verifying videos ad call presense for Latam_CO_privacy() privacy test case started End =========================");  
		  }
		  
		  
		  @Test(priority =3038, enabled = true)  
	 @Title("Verifying npa=1 in videos ad call for Latam_CO_privacy") 
	public void Verifying_npa_equals_1_videos_adCall_Latam_CO_privacy()throws Exception {	  
	 System.out. println("=================Verifying npa=1 in detailed page ad call for Latam_CO_privacy() privacy testcase started =========================" ); 
	Functions.validate_npa_video_ad_dontsellmyinformation();
		//CharlesFunctions.archive_folder("Charles");
	  System.out. println("=================Verifying npa=1 in detailed page ad call for Latam_CO_privacy() privacy testcase End =========================" );
	  }
		
		@Test(priority = 3040, enabled = true)
		@Title("Verify Criteo SDK inapp v2 call")
		public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_Serbia() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
			System.out.println("****** Criteo SDK inapp/v2 call validation Started");
			logStep("****** Criteo SDK inapp/v2 call validation Started");
			CharlesFunctions.createXMLFileForCharlesSessionFile();
			Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

		}

		@Test(priority = 3042, enabled = true)
		@Title("Verify Criteo SDK config app call")
		public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_Serbia() throws Exception {
			System.out.println("==============================================");
			System.out.println("=========================== Criteo SDK config/app call ====================");
			System.out.println("****** Criteo SDK config/app call validation Started");
			logStep("****** Criteo SDK config/app call validation Started");
			
			Functions.verifyCriteo_config_app_Call("Criteo", false);
			CharlesFunctions.archive_folder("Charles");
			
			
		}
	
	

}


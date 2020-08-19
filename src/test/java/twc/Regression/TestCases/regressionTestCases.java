package twc.Regression.TestCases;

import java.io.File;

import org.openqa.selenium.internal.Killable;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;
import twc.Automation.HandleMapLocal.MapLocalFunctions;

//import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Regression.CustomParamValidation.CustomParamFunctions;
import twc.Regression.CustomParamValidation.validate_CustomParameter;
import twc.Regression.Driver.Drivers;
import twc.Regression.General.Functions;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.utils.DeleteFiles;

public class regressionTestCases extends Drivers {

		
	
	
	
	@Test(priority =400, enabled = true)  
	  @Title("Verifying Privacy Card is present on the screen") public void
	  Smoke_Test_Verify_PrivacyCard_onScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppiumFunctions. Kill_Launch_App();
	  Thread.sleep(40000);	  
	  AppiumFunctions.SwipeUp_Counter_privacy(25);
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 401, enabled = true)	  
	  @Title("Selecting the  Optout mode in the privacy card") public void
	  Smoke_Test_Selecting_Opt_out_mode_scenario() throws Exception {	  
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
	  
	  @Test(priority = 402, enabled = true)
	  @Title("Verifying feed_1 ad call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test_Verifying_Feedadcall_Optoutmode_scenario() throws   Exception {
	  System.out. println("=================Verifying Feed_1 ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying feed_1 ad call when user selecting Optoutmode scenario in privacy card");
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData(); 
	   AppiumFunctions.Kill_Launch_App();  
		  Thread.sleep(30000); 
		  AppiumFunctions.SwipeUp_Counter_videos_maps(20);
	//  Functions.SwipeUp_Counter_video_maps_feedcards(10);
		  
	  CharlesFunctions.ExportSession();
	  Functions.verifying_feedcalls(1);
	  System.out. println("================= Verifying Feed_1 ad call when user selecting Optoutmode scenario in privacy card End =========================" ); 
	  }
	  
	  /*@Test(priority = 403, enabled = true)	  
	  @Title("Verifying video call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Smoke_Test_Verifying_videoadcall_Optoutmode_scenario() throws   Exception {
	System.out. println("=================Verifying video Feed ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying video call when user selecting Optoutmode scenario in privacy card"); 	
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("================= Verifying video ad call when user selecting Optoutmode scenario in privacy card End =========================" );  
	  }*/
	  

	  
	  @Test(priority =404, enabled = true)	  
	  @Title("Verifying  maps detail page ad call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_Radar_Maps_detailpageadcall_Optoutmode_scenario()  throws Exception {
	   logStep("Verifying   maps detail page ad call when user selecting Optoutmode scenario in privacy card" );
	   System.out.println("=================Verifying maps detail page Feed ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	   Functions.Verifying_detail_gampadcalls_Optoutmode();
	   System.out.println("================= Verifying maps detail page  Feed ad call when user selecting Optoutmode scenario in privacy card End =========================" );
	   }
	  
	  
	  @Test(priority = 405, enabled = true)	  
	  @Title("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test__Verifying_Bcp_apicall_Optoutmode_scenario() throws   Exception {
	  logStep("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	 
	  @Test(priority = 406, enabled = true)  
	  @Title("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Verifying_adcrw_apicall_Optoutmode_scenario()  throws Exception {  
	  logStep("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("=================Verifying adcrw api call when user selecting Optoutmode scenario in privacy card started =========================");
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying adcrw api call when user selecting Optoutmode scenario in privacy card End =========================");	  
	  }
	  
	  @Test(priority = 407, enabled = true)	  
	  @Title("Verifying Factual api call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Verifying_locaion_apicall_Optoutmode_scenario() throws Exception { 
	  logStep("Verifying Factual api call when user selecting Optoutmode scenario in privacy card"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  @Test(priority =408, enabled = true)  
	  @Title("Verifying amazon prerol aax sloit id's  when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_amaozn_aax_calls_Optoutmode_scenario()  throws Exception {
	  logStep("Verifying amazon prerol aax slot id's when user selecting Optoutmode scenario in privacy card" );
	  System.out.println("=================Verifying amazon prerol slot is's  when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying amazon prerol slot id's when user selecting Optoutmode scenario in privacy card" );
	  Functions.validating_aax_privacy_Optoutmode_scenario(); 
	  System.out.println("================= Verifying amazon prerol slot id's when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority =409, enabled = true)  
	  @Title("Verifying home screen hourly ad call  when user selecting Optoutmode scenario in privacy card" ) 
	  public void  Smoke_Test__Verifying_homescreenhourly_adCalls_Optoutmode_scenario() throws Exception {
   System.out.println("=================Verifying home screen hourly  ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying home screen hourly ad call  when user selecting Optoutmode scenario in privacy card" );
	  Functions.finding_Homescreen_iu_value();
	  System.out.println("================= Verifying home screen hourly  ad call when user selecting Optoutmode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 410, enabled = true)	  
	  @Title("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card" )	
	  public void Smoke_Test__Verifying_marqueehomescreecall_Optoutmode_scenario() throws	 Exception {
	  logStep("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card" ); 
	  System.out. println("=================Verifying homescreen marquee ad calls when user selecting Optoutmode scenario in privacy card started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("================= Verifying homescreen  marquee ad calls when user selecting Optoutmode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 411, enabled = true)	  
	  @Title("Verifying SOD Cust param value for feed_1 call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_SOD_Cust_Param_feed1ad_Optoutmode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for feed_1 call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_homescreen_Optoutmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 screen call when user selecting Optoutmode scenario in privacy card End ========================="  ); 
	  }
	  
	  @Test(priority = 412, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen marquee call when user selecting Optout mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_marquee_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen marquee call when user selecting Optout mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call  when user selecting Optout mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }


	  @Test(priority = 413, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen hourly ad  call when user selecting Optout mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_hourly_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen hourly call when user selecting Optout mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen hourly call  when user selecting Optout mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenHourly_Optoutmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen hourly call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }


	  
	  
  @Test(priority = 414, enabled = true)	  
	  @Title("Verifying SOD Cust param value for maps detaill page ad call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_SOD_Cust_Param_mapsdetails_adCall_Optoutmode_scenario() throws Exception { 
	 System.out. println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying SOD Cust param value for maps detaill page ad call when user selecting Optoutmode scenario in privacy card" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card End =========================" );
	  }
	  
	 /* @Test(priority = 415, enabled = true)	  
	  @Title("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optoutmode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out. println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card End ========================="); 
	  }*/
	  
	  @Test(priority = 416, enabled = true)  
	  @Title("Verifying RDP  value for feed_1 call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_feed1ad_Optoutmode_scenario() throws  Exception {
	   logStep("Verifying RDP value for feed_1 call when user selecting Optoutmode scenario in privacy card");  
	  System.out. println("================= Verifying RDP value for feed_1 ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_RDP_homescreen_Optoutmode(); 
	  System.out.println("================= Verifying RDP value for feed_1 ad call when user selecting Optoutmode scenario in privacy card End ========================="); 
	  }
	  
	  @Test(priority = 417, enabled = true)	  
	  @Title("Verifying RDP  value for homescreen  marquee call when user selecting Optout mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenmarquee_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen marquee call when user selecting Optout mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen marquee call  when user selecting Optout mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying RDP value for homescreen marquee call when user selecting Optout mode scenario in privacy card End =========================");
        }
	  
	  @Test(priority = 418, enabled = true)	  
	  @Title("Verifying RDP  value for homescreen  hourly  call when user selecting Optout mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenhourly_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen hourly call when user selecting Optout mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen hourly call  when user selecting Optout mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescrenhourly_Optoutmode();
	  System.out. println("================= Verifying RDP value for homescreen hourly call when user selecting Optout mode scenario in privacy card End =========================");
        }
	  
	  @Test(priority = 419, enabled = true)	  
	  @Title("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_maps_detailed_adCall_Optoutmode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card"  );	
	  System.out. println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optoutmode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_detailed_feed_Optoutmode(); 
	  System.out.println("================= Verifying RDP value for detailed feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	  
	/*  @Test(priority = 420, enabled = true)	  
	  @Title("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_video_adcall_Optoutmode_scenario() throws Exception {
	  logStep("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card" );  
	  System.out. println("================= Verifying RDP value for video  ad call  when user selecting Optoutmode scenario in privacy card started =========================");
	  Functions.validate_RDP_video_ad_Optoutmode();
	  System.out. println("================= Verifying RDP value for video ad call when user selecting Optoutmode scenario in privacy card End =========================");
	  }*/
	  
	
	////////optinmode////////
	  
	  @Test(priority = 440, enabled = true)	  
	  @Title("Selecting the  Optin mode in the privacy card") public void
	  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
	  logStep("Selecting the  Optin mode in the privacy card");
      System.out. println("=================Slecting Optin mode scenario in privacy card testcase started =========================");
 	 AppiumFunctions. Kill_Launch_App();
 	//  AppFunctions. Kill_Launch_App();
 	  Thread.sleep(40000);	  
 	  AppiumFunctions.SwipeUp_Counter_privacy(25);
	  Thread.sleep(10000); 
	  Functions.selecting_opt_in_mode();
	  AppiumFunctions.Kill_Launch_App();
	  CharlesFunctions.ClearSessions();
	  AppiumFunctions.Kill_Launch_App();
	  CharlesFunctions.ClearSessions();
	  System.out.println("================= Slecting Opt in mode scenario in privacy card  testcase End ========================="); 
	  }
	  

	  
	  @Test(priority = 441, enabled = true)
	  @Title("Verifying feed_1 ad call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test_Verifying_Feed_1_adcall_Optin_mode_scenario() throws Exception {  
	  logStep("Verifying feed_1 ad call when user selecting Optin mode scenario in privacy card"); 
	  System.out.println("=================Verifying feed1 ad call when user selecting Optin mode scenario in privacy card started =========================");
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData(); 
	  AppiumFunctions.Kill_Launch_App();	  
	  Thread.sleep(10000);
	  AppiumFunctions.SwipeUp_Counter_videos_maps(20);
	  CharlesFunctions.ExportSession();
	  Functions.verifying_feedcalls(1); 
	  System.out.println("================= Verifying feed1 ad call when user selecting Optin mode scenario in privacy card End =========================" ); 
	  }
	  
	/*  @Test(priority = 442, enabled = true)  
	  @Title("Verifying video ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void  Smoke_Test__Smoke_Test_Verifying_videoadcall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying video call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("=================Verifying video  ad call when user selecting Optin mode scenario in privacy card started =========================");
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out. println("================= Verifying video ad call when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }*/
	  
	
	  
	  
	  @Test(priority = 443, enabled = true)	  
	  @Title("Verifying maps details page ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_maps_detailpageadcall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying details page ad call when user selecting Optin mode scenario in privacy card"  );
	  System.out.println("=================Verifying detail page Feed ad call when user selecting Optin mode scenario in privacy card started =========================" ); 
	  Functions.Verifying_detail_gampadcalls_Optoutmode();
	  System.out. println("================= Verifying detail page  Feed ad call when user selecting Optin mode scenario in privacy card End ========================="  );
	  }
	  
	  @Test(priority = 444, enabled = true)	  
	  @Title("Verifying BCP  call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test__Verifying_Bcp_apicall_Opti_mode_scenario() throws  Exception { 
	  logStep("Verifying BCP  call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optin mode scenario in privacy card started =========================");	  
	  Functions.validating_bcp_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optin mode scenario in privacy card End =========================" );
	  
	  }
	  
	  @Test(priority = 445, enabled = true)	  
	  @Title("Verifying adcrw api call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test__Verifying_adcrw_apicall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying adcrw api call when user selecting Optin mode scenario in privacy card" );	  
	  System.out. println("=================Verifying adcrw api call when user selecting Optin mode scenario in privacy card started =========================" );  
	  Functions.validating_adcrw_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying adcrw api call when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 456, enabled = true)	  
	  @Title("Verifying Fatual api call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test__Verifying_locaion_apicall_Optin_mode_scenario()  throws Exception {
	   logStep("Verifying Fatual api call when user selecting Optin mode scenario in privacy card" ); 
	   System.out.println("=================Verifying Fatcual api call when user selecting Optin mode scenario in privacy card started =========================");
	   Functions.validating_Fatualcall_privacy_Optinmode_scenarion(); 
	   System.out. println("================= Verifying Fatcual api call when user selecting Oppinmode scenario in privacy card End =========================" );
	 
	  }
	  
	  @Test(priority =457, enabled = true)	  
	  @Title("Verifying amazon prerol slot id's  when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_amaozn_slotid_Optin_mode_scenario() throws Exception {	  
	  logStep("Verifying amazon prerol slot id's when user selecting Optin mode scenario in privacy card" );
	  System.out.println("=================Verifying amazon prerol slot id's when user selecting Optin mode scenario in privacy card started =========================");
	  Functions.validating_aax_privacy_Optinmode_scenario(); 
	  System.out.println("================= Verifying amazonprerol slot id's  when user selecting Optin mode scenario in privacy card End =========================" );
	    }
	  
	  @Test(priority = 458, enabled = true)  
	  @Title("Verifying home screen marquee ad call  when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_homescreenmarquee_calls_Optin_mode_scenario() throws Exception {
	  logStep("Verifying home screen marquee ad call  when user selecting Optin mode scenario in privacy card" ); 
	  System.out. println("=================Verifying homescreen marquee ad calls when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions. finding_Homescreen_marquee_iu_value();
	  System.out.println("================= Verifying homescreen marquee ad calls when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 459, enabled = true)  
	  @Title("Verifying home screen hourly ad call  when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_homescreenhourly_adCall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying home screen hourly ad call  when user selecting Optin mode scenario in privacy card" ); 
	  System.out. println("=================Verifying homescreen hourly ad calls when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions. finding_Homescreen_iu_value();
	  System.out.println("================= Verifying homescreen hourly ad calls when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	  
	  
	  
	  @Test(priority = 460, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen marquee  call when user selecting Optin mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_marquee_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen marquee call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call  when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreen_Optinmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }
	  
	  
	  @Test(priority = 461, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen hourly ad call when user selecting Optin mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_hourly_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen hourly call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen hourly call  when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenhourly_Optinmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen hourly call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }
	  
	  
	  @Test(priority = 462, enabled = true)	  
	  @Title("Verifying SOD Cust param value for  feed_1 ad call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_feed_1_Optinmode_scenario()   throws Exception
	 { 
	 System.out. println("================= Verifying SOD CUST_PARAM value for feed_1 ad call  when user selecting Optin mode scenario in privacy card started =========================");
	  logStep("Verifying SOD Cust param value for  feed ad call when user selecting Optin mode scenario in privacy card"); 
	   Functions.validate_SOD_Cust_param_feed_Optinmode();
	   System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 ad call  when user selecting Optin mode scenario in privacy card End ========================="  ); 
	   }
	  
	  
	  @Test(priority = 463, enabled = true)  
	  @Title("Verifying SOD Cust param value for maps detail page ad call when user selecting Optin mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_mapsdetail_page_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for maps detail page ad call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for maps detailed Feed ad call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions. validate_SOD_Cust_param_deatiledfeed_Optinmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for  maps detailed Feed ad call  when user selecting Optin mode scenario in privacy card End =========================" );
	  }
	  
	 /* @Test(priority = 464, enabled = true)	  
	  @Title("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin_mode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card");
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optinmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card End =========================" );
	  }*/
	  
	  @Test(priority = 465, enabled = true)	  
	  @Title("Verifying RDP  value for home screen  marquee call when user selecting Optin mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenmarquee_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen marquee call when user selecting Optin mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen marquee call  when user selecting Optin mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescreen_Optinmode();
	  System.out. println("================= Verifying RDP value for homescreen marquee call when user selecting Optin mode scenario in privacy card End =========================");
    }
	  
	  @Test(priority = 465, enabled = true)	  
	  @Title("Verifying RDP  value for home screen  hourly call when user selecting Optin mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenhourly_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen hourly call when user selecting Optin mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen hourly call  when user selecting Optin mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescreenhourly_Optinmode();
	  System.out. println("================= Verifying RDP value for homescreen hourly call when user selecting Optin mode scenario in privacy card End =========================");
    }
	  @Test(priority = 466, enabled = true)	  
	  @Title("Verifying RDP  value for feed_1 ad call when user selecting Optin mode scenario in privacy card")
	  public void Smoke_Test_Verifying_RDP_value_feed_1ad_Optin_mode_scenario()  throws Exception {	
	  logStep("Verifying RDP  value for feed_1 ad call when user selecting Optin mode scenario in privacy card" );  
	  System.out. println("================= Verifying RDP value for feed_1 ad  call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions.validate_RDP_feed_Optinmode();
	  System.out.println("================= Verifying RDP value for feed_1 ad call when user selecting Optin mode scenario in privacy card End ========================="); 
	  }
	  
	  
	  @Test(priority = 467, enabled = true)
	  @Title("Verifying RDP value for maps detailed page ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_mapsdetailed_feedad_Optinmode_scenario()  throws Exception {
	  logStep("Verifying RDP value for maps detailed page ad call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying RDP value for maps detailes ad call  when user selecting Optin mode scenario in privacy card started =========================");
	   Functions.validate_RDP_detailed_feed_Optinmode(); 
	   System.out. println("================= Verifying RDP value for maps detailes ad call when user selecting Optin mode scenario in privacy card End =========================" );
	   }
	  
	/*  @Test(priority = 468, enabled = true)  
	  @Title("Verifying RDP value for video  ad call  url when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_video_adcall_Optin_mode_scenario() throws  Exception {	  
	 System.out. println("================= Verifying RDP value for video  ad call url  when user selecting Optin mode scenario in privacy card started =========================" );
	  logStep("Verifying RDP  value for video  ad call url when user selecting Optin mode scenario in privacy card");
	  Functions.validate_RDP_video_ad_Optinmode(); 
	  System.out. println("================= Verifying RDP value for video ad call url when user selecting Optin mode scenario in privacy card End =========================" );
	  }*/
	  
	
	
	
	
	
	
	
	
	
	
	
	
	  
	  
	
	
	
	
	
	
	
	
	
	
	
@BeforeTest
public void Before_Test() throws Exception {
	CharlesFunctions.charlesOpen();
	 AppiumFunctions.UnInstallApp();
	CharlesFunctions.openCharlesBrowser();    
	 CharlesFunctions.ClearSessions();
	CharlesFunctions.startSessionBrowserData();
AppiumFunctions.LaunchAppWithFullReset();
	}

	//@AfterTest
//	public void After_Test() throws Exception {
		// validate_CustomParameter.sf.assertAll();
		// DeleteFiles.deleteFiles(new Fi
		// le("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
		// DeleteFiles d = new DeleteFiles();
		// d.deleteFiles(new
		// File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
		// DeleteFiles.delete(new
		// File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
 	//CharlesFunctions.BrowserClosed();
	//CharlesFunctions.charlesClose();
	//Ad.quit();
	//}
}

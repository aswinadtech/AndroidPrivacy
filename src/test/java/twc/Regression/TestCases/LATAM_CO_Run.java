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
	
	
	
				@Test(priority = 539, enabled = true)
			@Title("Verify Criteo SDK inapp v2 call")
			public void Verify_Criteo_SDK_inapp_v2_Call_privacy_optout_for_Latam_CO() throws Exception {
				System.out.println("==============================================");
				System.out.println("=========================== Criteo SDK inapp/v2 call ====================");
				System.out.println("****** Criteo SDK inapp/v2 call validation Started");
				logStep("****** Criteo SDK inapp/v2 call validation Started");
				CharlesFunctions.createXMLFileForCharlesSessionFile();
				Functions.verifyCriteo_inapp_v2_Call("Criteo", false);

			}

			@Test(priority = 540, enabled = true)
			@Title("Verify Criteo SDK config app call")
			public void Verify_Criteo_SDK_config_app_Call_privacy_optout_for_Latam_CO() throws Exception {
				System.out.println("==============================================");
				System.out.println("=========================== Criteo SDK config/app call ====================");
				System.out.println("****** Criteo SDK config/app call validation Started");
				logStep("****** Criteo SDK config/app call validation Started");
				Functions.verifyCriteo_config_app_Call("Criteo", false);
				CharlesFunctions.archive_folder("Charles");
				
			}
}

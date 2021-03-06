package twc.Regression.General;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import twc.Regression.HandleWithCharles.CharlesConfiguration;
import twc.Regression.HandleWithCharles.CharlesConfiguration.Protocol;
import twc.Regression.HandleWithCharles.CharlesConfiguration.RewriteRuleReplaceType;
import twc.Regression.HandleWithCharles.CharlesConfiguration.RewriteRuleType;
import  twc.Regression.utils.Constants;

import twc.Regression.Driver.Drivers;



public class TwcAndroidBaseTest extends Drivers{

	//private static final MobileAutomationLogger LOGGER = new MobileAutomationLogger(TwcIosBaseTest.class);
	private boolean freshInstallDone = false;

	/**
	 * Create a Charles configuration to rewrite vt1ContentMode mode to the given content mode. Rewrite to severe1 or severe2 to show Breaking
	 * News/Trending module
	 *
	 * @param fileName
	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir
	 * @param contentMode
	 *            - What to change the content mode to
	 * @return Config Files (for deletion in After method)
	 */
	/*public File rewriteRuleToEnableGDPR(String fileName) {
		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);

		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "gdpr", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);


		return configFile;
	}*/
	
	public File rewriteRuleToEnableGDPR(String fileName) {
	final List<File> configFiles = new ArrayList<File>();
	final File parentDir = new File(Constants.PATH_USER_HOME);
	parentDir.mkdirs();
	final File configFile = new File(parentDir, fileName);
	configFile.setWritable(true);

	// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
	CharlesConfiguration config = new CharlesConfiguration();
	//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "gdpr", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "gdpr", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "UK", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

	config.saveConfigurations(fileName);


	return configFile;
}
	
	
	
	
	
	
	public File rewriteRuleToEnableGDPRWithLocale(String fileName) {
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);

		// Create Charles config with header response rewrite for twc-privacy:exempt ->
		// twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "TWC-Privacy", false, "exempt", false, false, false,
				"TWC-Privacy", false, "gdpr", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "US", false, false,
				false, "twc-geoip-country", false, "FR", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");
		config.enableMacOsxProxy(true);
		config.saveConfigurations(fileName);

		return configFile;
	}
	
	/**
	 * Create a Charles configuration to rewrite vt1ContentMode mode to the given content mode. Rewrite to severe1 or severe2 to show Breaking
	 * News/Trending module
	 *
	 * @param fileName
	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir
	 * @param contentMode
	 *            - What to change the content mode to
	 * @return Config Files (for deletion in After method)
	 */
	/*public File rewriteRuleToEnableLGPD(String fileName) {
		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);

		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);


		return configFile;
	}*/
	public File rewriteRuleToEnableLGPD(String fileName) {
	final List<File> configFiles = new ArrayList<File>();
	final File parentDir = new File(Constants.PATH_USER_HOME);
	parentDir.mkdirs();
	final File configFile = new File(parentDir, fileName);
	configFile.setWritable(true);

	// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
	CharlesConfiguration config = new CharlesConfiguration();
	//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);
	   config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "BR", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

	config.saveConfigurations(fileName);


	return configFile;
}

	
	
	/**
	 * Create a Charles configuration to rewrite vt1ContentMode mode to the given content mode. Rewrite to severe1 or severe2 to show Breaking
	 * News/Trending module
	 *
	 * @param fileName
	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir
	 * @param contentMode
	 *            - What to change the content mode to
	 * @return Config Files (for deletion in After method)
	 */
	/*public File rewriteRuleToEnableUSA(String fileName) {
		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);

		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "usa", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);


		return configFile;
	}*/
	
	
	public File rewriteRuleToEnableUSACCPA(String fileName) {
	final List<File> configFiles = new ArrayList<File>();
	final File parentDir = new File(Constants.PATH_USER_HOME);
	parentDir.mkdirs();
	final File configFile = new File(parentDir, fileName);
	configFile.setWritable(true);

	// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
	CharlesConfiguration config = new CharlesConfiguration();
	//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "usa-ccpa", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "usa-ccpa", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "US", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-region", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-regiony", false, "CA", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

	config.saveConfigurations(fileName);


	return configFile;
}
	
	
	
	public File rewriteRuleToEnableUSA(String fileName) {
	final List<File> configFiles = new ArrayList<File>();
	final File parentDir = new File(Constants.PATH_USER_HOME);
	parentDir.mkdirs();
	final File configFile = new File(parentDir, fileName);
	configFile.setWritable(true);

	// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
	CharlesConfiguration config = new CharlesConfiguration();
	//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "usa", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "usa", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "US", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-region", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-regiony", false, "GA", false, RewriteRuleReplaceType.ONLY_FIRST);
	config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

	config.saveConfigurations(fileName);


	return configFile;
}
	
		public File rewriteRuleToEnableLATAMPE(String fileName) {

		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
	configFile.setWritable(true);
		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "latam-pe", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "PE", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");
	config.saveConfigurations(fileName);

		return configFile;

	}
	
	public File rewriteRuleToEnableLATAMDR(String fileName) {

		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);
		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr

		CharlesConfiguration config = new CharlesConfiguration();

		//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "latam-do", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "DO", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);
		return configFile;

	}
	
	/**

	 * Create a Charles configuration to rewrite privacy regime to the given regime (Latain America Colorado) values. 

	 * @param fileName

	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir

	 * @return Config Files (for deletion in After method)

	 */

	public File rewriteRuleToEnableLATAMCO(String fileName) {

		final List<File> configFiles = new ArrayList<File>();

		final File parentDir = new File(Constants.PATH_USER_HOME);

		parentDir.mkdirs();
	final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);
		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr

		CharlesConfiguration config = new CharlesConfiguration();

		//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "latam-co", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "CO", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);
	return configFile;

	}
	
	/**

	 * Create a Charles configuration to rewrite privacy regime to the given regime (EXEMPT) values. 

	 * @param fileName

	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir

	 * @return Config Files (for deletion in After method)

	 */

	public File rewriteRuleToEnableEXEMPT(String fileName) {

		final List<File> configFiles = new ArrayList<File>();

		final File parentDir = new File(Constants.PATH_USER_HOME);

		parentDir.mkdirs();

		final File configFile = new File(parentDir, fileName);

		configFile.setWritable(true);



		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr

		CharlesConfiguration config = new CharlesConfiguration();

		//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "lgpd", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-privacy", false, "exempt", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-country", false, "[A-Za-z0-9\\.\\-]+", true, false, false, "twc-geoip-country", false, "CA", false, RewriteRuleReplaceType.ONLY_FIRST);

		//config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-geoip-region", false, "[A-Za-z0-9\\.\\-]+", false, false, false, "twc-geoip-region", false, "ON", false, RewriteRuleReplaceType.ONLY_FIRST);

		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");



		config.saveConfigurations(fileName);





		return configFile;

	}
	
	/**
	 * Create a Charles configuration to rewrite vt1ContentMode mode to the given content mode. Rewrite to severe1 or severe2 to show Breaking
	 * News/Trending module
	 *
	 * @param fileName
	 *            - Name of file (.config extension) to store configuration. Will be created in user.dir
	 * @param contentMode
	 *            - What to change the content mode to
	 * @return Config Files (for deletion in After method)
	 */
	/*public File rewriteRuleToEnableUSACCPA(String fileName) {
		final List<File> configFiles = new ArrayList<File>();
		final File parentDir = new File(Constants.PATH_USER_HOME);
		parentDir.mkdirs();
		final File configFile = new File(parentDir, fileName);
		configFile.setWritable(true);

		// Create Charles config with header response rewrite for twc-privacy:exempt -> twc-privacy:gdpr
		CharlesConfiguration config = new CharlesConfiguration();
		config.addRule(RewriteRuleType.MODIFY_HEADER, false, true, "twc-privacy", false, "exempt", false, false, false, "twc-privacy", false, "usa-ccpa", false, RewriteRuleReplaceType.ONLY_FIRST);
		config.addLocation(Protocol.HTTPS, "dsx.weather.com", "", "/cms/v5/privacy/en_US/twc-android-flagship/3", "");

		config.saveConfigurations(fileName);


		return configFile;
	}*/

	
}

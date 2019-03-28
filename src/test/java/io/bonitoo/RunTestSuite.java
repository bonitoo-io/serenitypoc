package io.bonitoo;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.embedder.StoryControls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class RunTestSuite extends SerenityStories {

    @Managed
    WebDriver driver;
    final static Logger logger = (Logger) LoggerFactory.getLogger(RunTestSuite.class);

    private static final String STORY_NAME_PATTERN = "**/@jbehave.story.name@.story";

    public RunTestSuite() {
        configuredEmbedder().embedderControls().doIgnoreFailureInStories(false);

        if (System.getProperty("doNotSkipScenariosAfterFailure") == null) {
            configuration().useStoryControls(
                    new StoryControls().doSkipScenariosAfterFailure(false).doResetStateBeforeScenario(false));
        }
        findStoriesCalled(storyNamesFromEnvironmentVariable());
    }

    private String storyNamesFromEnvironmentVariable() {
        String storyProperty = System.getProperty("story");
        //storyProperty= "execute_queries";
        if (storyProperty == null) {
            storyProperty = "*";
        } else {
            if (storyProperty.isEmpty()) {
                throw new RuntimeException("Please specify the story name or name pattern: e.g.: -Dstory=\"*_full\"");
            } else {
                storyProperty.trim();
            }
        }
        return STORY_NAME_PATTERN.replaceAll("@jbehave.story.name@", storyProperty);
    }

    @AfterStory
    public void cleanUpAfterStory() throws IOException, URISyntaxException, InterruptedException {
        String skipCleanupProperty = System.getProperty("skipCleanup");
        if (skipCleanupProperty == null) {
            // any code for clean up after each test story ...
        }
    }

    @BeforeStories
    public void beforeStories() {

        // create tmp folder
        try {
            File tmpDir = new File("tmp");
            if (!tmpDir.exists()) {
                tmpDir.mkdirs();
            } else {
                FileUtils.deleteDirectory(tmpDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

/*
        try {
            //creating test data for Chronograf Selenium test
            //TestDataCreator.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        //      dumpConfigToLog();

//        driver.get(getSystemConfiguration().getBaseUrl() + "/sources/new");
    }

    /*
    private void createDashboardForTesting() {
        driver.get(getSystemConfiguration().getBaseUrl());
        WebElement dashboardPage = driver.findElement(By.cssSelector("nav.sidebar div a[class='sidebar--square'][href$='/dashboards"));
        dashboardPage.click();

        WebElement createDashboardButton = driver.findElement(By.xpath("//button[contains(text(),'Create Dashboard')]"));
        createDashboardButton.click();

    }*/

    private void dumpConfigToLog(){
        System.out.println("DEBUG dumpConfigToLog(): ");


        logger.info("SERENITY CONFIG");
        logger.info("   BASE URL:   " + getSystemConfiguration().getBaseUrl());
        logger.info("   TEST COUNT: " + getSystemConfiguration().getCurrentTestCount());
        logger.info("   SCREEN:");
        logger.info("      WIDTH:   " + driver.manage().window().getSize().width);
        logger.info("      HEIGHT:  " + driver.manage().window().getSize().height);
        logger.info("   ENVARS:       ");
        for(String key : getSystemConfiguration().getEnvironmentVariables().getKeys()){
            logger.info("      " + key + ":   " + getSystemConfiguration().getEnvironmentVariables().getProperty(key));
        }
    }

    @AfterStories
    public void afterStories() {

    }


    @BeforeScenario
    public void setupProfile() throws IOException, URISyntaxException, InterruptedException {
        // all code for setting up Browser profile belongs in here - for example:
        /*
         * org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
         * proxy.setHttpProxy("localhost:3128"); FirefoxProfile profile = new
         * FirefoxProfile(); profile.setPreference("network.proxy.type", 1);
         * profile.setPreference("network.proxy.http", "localhost");
         * profile.setPreference("network.proxy.http_port", 3128);
         * profile.setPreference("dom.max_script_run_time", 30000);
         * profile.setAlwaysLoadNoFocusLib(true); profile.setEnableNativeEvents(true);
         * Serenity.useFirefoxProfile(profile);
         */
    }


}

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import testcomponenets.BaseTest;

public class LoginTestCase extends BaseTest {

    // Test case for login
    @Test
    public void testLoginWithValidCredentials() {
        // Create an instance of the FacebookLoginPage
        FacebookLoginPage loginPage = new FacebookLoginPage(getDriver());

        // Open the login page
        loginPage.openPage();

        // Assert failure (e.g., by checking an error message)
        // Replace with actual error message logic (e.g., checking for an error tex
        
        
        
    }}

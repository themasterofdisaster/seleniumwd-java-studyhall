/*
    Dependency Testing and Test Groups

        Groups is an attribute within the @Test annotation. With groups attribute you can indicate a group name you
        want to assign the test to. This will help you organize your tests. This way you can have a "regression" group
        or a "smoke test" group, and run any of this tests groups by using the assigned name.
 */

package testng;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        //import com.testautomationu.utility.Highlighter;

public class DependencyTestingTestGroups
{
    WebDriver driver;

    @Test (groups = "initialize")
    public void test1_SetUpChrome ()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rex Allen Jones II\\Downloads\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        System.out.println("1. Set Up Chrome");
    }

    @Test (dependsOnGroups = "initialize", groups = "env_application")
    public void test2_OpenOrangeHRM ()
    {
        driver.get("https://opensource-demo.orangehrmlive1234.com/");

        Assert.assertEquals(false, true, "Could Not Open OrangeHRM");
        System.out.println("2. Open OrangeHRM");
    }

    @Test  (dependsOnGroups = "env_application")
    public void test3_SignIn ()
    {
        WebElement textUsername = driver.findElement(By.id("txtUsername"));
       //Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.id("txtPassword"));
        //Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
        //Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("3. Sign In");
    }

    @Test  (dependsOnGroups = "env_application")
    public void test4_SearchUser ()
    {
        WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        //Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
        //Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("4. Search For User");
    }

    @Test  (dependsOnGroups = "env_application")
    public void test5_SearchEmployee ()
    {
        WebElement menuPIM = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
        //Highlighter.highlightElement(driver, menuPIM);
        menuPIM.click();

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("5. Search For Employee");
    }

    @Test  (dependsOnGroups = "env_application")
    public void test6_SearchCandidate ()
    {
        WebElement menuRecruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
        //Highlighter.highlightElement(driver, menuRecruitment);
        menuRecruitment.click();

        WebElement buttonSearch = driver.findElement(By.id("btnSrch"));
        //Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("6. Search For Candidate");
    }

    @Test  (dependsOnGroups = "env_application")
    public void test7_SignOut ()
    {
        WebElement linkWelcome = driver.findElement(By.id("welcome"));
        //Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        //Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("7. Sign Out");
    }
}
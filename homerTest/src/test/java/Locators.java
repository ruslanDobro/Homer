import org.openqa.selenium.By;

public class Locators {
    protected String homePage = "https://www.learnwithhomer.com";
    protected By tryForFreeButton = By.xpath("//*[(text() ='Try For Free')]");
    protected  By childFirstName = By.cssSelector("[placeholder=\"Child's first name\"]");
    protected String name = "Lev";
    protected By nextButton = By.cssSelector("[aria-label=\"Next Step\"]");
    protected By pickAge = By.xpath("//*[(text() ='5')]");
    protected By containerWithInterests = By.cssSelector("div.step2-wrapper");
    protected By interestBugs = By.cssSelector("[alt= Bugs]");
    protected By interestFriendships = By.cssSelector("[alt= Friendships]");
    protected By levelSelection = By.cssSelector(".reading-level-section");
    protected By selectAnnualPlan = By.cssSelector("[value =annual]");
    protected String annualPlan = "Annual Plan";
    protected String zeroPlan = "$0.00";
    protected By getServicePlanSideWindow(String planName) {
        return By.xpath("//*[contains(@class,'bot-cart-info-side')]//*[contains(text(),'"+planName+"')]");
    }

    //protected By servicePlanSideWindow = By.xpath("//*[contains(@class,'bot-cart-info-side')]//*[contains(text(),'Annual Plan')]");

}

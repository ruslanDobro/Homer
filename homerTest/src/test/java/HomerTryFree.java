import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;
//        End to End test
//        Create account for a child using trial period
//        Navigate to home page https://www.learnwithhomer.com
//        Click on the “Try For Free” button at the top right corner of the window application
//        Type in child’s name ”Lev”
//        Click “Next” button
//        Select child’s age by clicking on the number “5”
//        Click “Next” button
//        In the interest window select “Bugs” and “Friendships”
//        Click “Next” button
//        Answer all the questions “Yes” or “All”
//        Click “Next” button
//        Wait for application to generate Onboarding Summary Page
//        Click on “Start Free Trial”
//        Select Annual plan form Select plan options
//        Verify in the Payment summary window “Annual Plan” is selected
//        Verify in the Payment summary window “Total Due Today” is “$0.00”



public class HomerTryFree extends TestBase {

    @Test
    void creatingAccountWithFreeTrial() {
        openHomePage();
        clickTryFree();
        enterChildName();
        clickNext();
        clickAge();
        clickEnter();
        selectInterests();
        clickNext();
        answerQuestions();
        clickNext();
        clickStartTrial();
        selectPlan();
        assertTrue(currentPlanSelected(annualPlan).equalsIgnoreCase(annualPlan));
        assertTrue(currentPlanSelected(zeroPlan).equalsIgnoreCase(zeroPlan));
      }

    private String currentPlanSelected(String plan) {
        return driver.findElement(getServicePlanSideWindow(plan)).getText();
    }

    private void selectPlan() {
        driver.findElement(selectAnnualPlan).click();
    }

    private void clickStartTrial() {
        wait.until(ExpectedConditions.presenceOfElementLocated(levelSelection));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // click on element using javaScript
        js.executeScript("arguments[0].click();", driver.findElement(nextButton));


    }

    private void answerQuestions() {
        var listOfElements = driver.findElements(By.cssSelector(".answer-group button:first-child"));
        for(int i = 0; i < listOfElements.size(); i++) {
            iSleep(1200);
            listOfElements.get(i).click();
        }


    }

    private void selectInterests() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(containerWithInterests));
        driver.findElement(interestBugs).click();
        driver.findElement(interestFriendships).click();
    }

    private void clickEnter() {
        driver.findElement(childFirstName).sendKeys(Keys.ENTER);
    }

    private void clickAge() {
        wait.until(ExpectedConditions.elementToBeClickable(pickAge));
        driver.findElement(pickAge).click();
    }

    private void clickNext() {
            driver.findElement(nextButton).click();
    }

    private void enterChildName() {
        driver.findElement(childFirstName).sendKeys(name);
    }

    private void clickTryFree() {
        driver.findElement(tryForFreeButton).click();

    }

    private void openHomePage() {
        driver.get(homePage);
    }
}

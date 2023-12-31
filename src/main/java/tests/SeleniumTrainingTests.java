package tests;

import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SeleniumTrainingTests extends BaseTest{
    @Test
    public void verifyUserCanEnrollForTraining() throws IOException, TesseractException {
        getSeleniumTrainingPage().open();
        getSeleniumTrainingPage().clickRegFormBtn();
        getScreenshotOfElement(getSeleniumTrainingPage().getCaptchaCodeImg());

        getSeleniumTrainingPage().enterFirstName("Milos");
        getSeleniumTrainingPage().enterLastName("Radman");
        getSeleniumTrainingPage().enterEmail("mr@email.com");
        getSeleniumTrainingPage().enterMobileNumber("2223335");
        getSeleniumTrainingPage().selectCountry("Serbia");
        getSeleniumTrainingPage().enterCity("Novi Sad");
        getSeleniumTrainingPage().enterMessage("Hello.");

        String code = fetchTextFromImg(
                "src/screenshots/captchaScreenshot.png");

        getSeleniumTrainingPage().enterCode(code);
        getSeleniumTrainingPage().clickSendFormBtn();

        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        Assert.assertTrue(getSeleniumTrainingPage().getSuccessMsg().isDisplayed());
    }
}

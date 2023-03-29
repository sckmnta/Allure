package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open Main Page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find and Click Repository {repo}")
    public void searchAndClickRepository(String repo) {
        $(".header-search-input").setValue(repo).submit();
        $(linkText(repo)).click();
    }

    @Step("Open Tab Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Check If Issue Number Avaliable {issue}")
    public void checkIfIssueTabAvaliableWithnumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

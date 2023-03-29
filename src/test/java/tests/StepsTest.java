package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 81;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open Main Page", () -> {
            open("https://github.com");
        });


        step("Find and Click Repository" + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
            $(linkText(REPOSITORY)).click();
        });

        step("Open Tab Issues", () -> {
            $("#issues-tab").click();
        });

        step("Check If Issue Number Avaliable" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });


    }
    @Test
    public void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchAndClickRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIfIssueTabAvaliableWithnumber(ISSUE);
    }

}

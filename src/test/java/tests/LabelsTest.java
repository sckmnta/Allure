package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Issue in repository")
    @Story("Creation of Issue in repository")
    @Owner("sckmnta")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Creation of Issue for authorised user")
    public void staticLabelsTest() {

    }

    @Test
    public void dynamicLabelsTest() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Creation of Issue for authorised user"));
        Allure.feature("Issue in repository");
        Allure.story("Creation of Issue in repository");
        Allure.label("Owner", "sckmnta");
        Allure.label("Severity", SeverityLevel.BLOCKER.value());
        Allure.link("Testing", "https://testing.github.com");


    }
}

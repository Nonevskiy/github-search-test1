package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @BeforeAll
    static void configure() {

        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindSelenideRepository() {

        open("https://github.com/");
        $("[data-target=\"qbsearch-input.inputButtonText\"]").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[class=\"Box-sc-g0xbh4-0 Qaxme\"]").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }
}

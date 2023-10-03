package com.TestSelenium;

import io.cucumber.core.cli.Main;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UtestJoinSteps {

    private WebDriver driver;
    private Actor santiago = Actor.named("Santiago");

    @Given("Santiago is on the Utest homepage")
    public void santiago_is_on_the_utest_homepage() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        santiago.can(BrowseTheWeb.with(driver));
        santiago.wasAbleTo(Open.url("https://utest.com/"));
    }
    
    @When("Santiago clicks the Join Today button")
    public void santiago_clicks_the_registration_button() {
        santiago.attemptsTo(Click.on(Target.the("Join Today Button").located(By.className("unauthenticated-nav-bar__sign-up"))));
    }

    @Then("Santiago enters his name as {string}")
    public void santiago_enters_his_name_as(String name) {
        santiago.attemptsTo(Enter.theValue(name).into(Target.the("First Name").located(By.id("firstName"))));
    }

    @Then("Santiago should see the registration page")
    public void santiago_should_see_the_registration_page() {
        santiago.should(seeThat(Text.of(Target.the("Registration Page Title").located(By.tagName("h1"))), equalTo("Registration Page")));
    }
    
    /* Buen dia, perdon por entregar el trabajo de esta manera pero la verdad he intentado organizar el proyecto con ScreenPlay y no he sabido 
     * como, he visto videos en los videos pero la verdad en este tema estoy completamente solo, me gustaria tener a alguien con quien apoyarme
     * en este tema pero la verdad estoy solo, la verdad lo intente, mil disculpas, La clase UtestJoin si esta corriendo bien con Junit pero en esta
     * no se porque no me corre los escenarios mil disculpas */
     
}

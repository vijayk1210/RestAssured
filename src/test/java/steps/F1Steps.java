package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.module.SimpleModule;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import models.F1;
import org.junit.Assert;
import utilities.ApiUtil;
import static org.hamcrest.Matchers.*;

public class F1Steps {
    F1 f1;
    public static Response response;
    F1.circuitTable cirTab;

    @Given("We have details of formula one")
    public void weHaveDetailsOfFormulaOne() {

    }

    @When("when we send get request for")
    public void whenWeSendGetRequestFor() {
        response = ApiUtil.getRequest("");
    }

    @Then("^Season value should be \"([^\"]*)\" and series should be \"([^\"]*)\"$")
    public void seasonValueShouldBeAndSeriesShouldBe(String seasonVal, String seriesVal) {
        f1 = response.getBody().as(F1.class);
        Assert.assertEquals(seriesVal,f1.getSeries());
        cirTab = response.getBody().as(F1.circuitTable.class);


        Assert.assertEquals(seasonVal,cirTab.getSeason());
        System.out.print("Value of series is "+f1.getSeries());
    }

}

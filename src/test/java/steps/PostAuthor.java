package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import models.AuthorDetails;
import org.junit.Assert;
import utilities.ApiUtil;

public class PostAuthor {
    AuthorDetails authDetail;
    public static Response response;

    @Given("^User post details like \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userPostDetailsLikeIdTitleAndAuthor(String title,String author) {
        authDetail = new AuthorDetails(title,author);
    }

    @When("^Post request is initiated with \"([^\"]*)\"$")
    public void postRequestIsInitiatedWithEndPoint(String endPoint) {
        response = ApiUtil.postRequest(authDetail , endPoint);
    }

    @Then("^Details should be posted successfully with \"([^\"]*)\"$")
    public void detailsShouldBePostedSuccessfullyWithStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, ApiUtil.getResponseCode(response));

    }


}

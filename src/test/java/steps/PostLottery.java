package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import models.LotteryDetails;
import org.junit.Assert;
import utilities.ApiUtil;
import utilities.Generics;

public class PostLottery {
    LotteryDetails lottery;
    LotteryDetails.Winners winner;
    public static Response response;

    @Given("^User post details of lottery like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userPostDetailsOfLotteryLikeAnd(int lottoId, int winnerId, String winningNum, String winnerNum) {
        String[] winnerNumb = Generics.stringToArr(winnerNum,";");
        Integer[] winnerNumbers = Generics.stringArrTointArr(winnerNumb);

        String[] winningNumb = Generics.stringToArr(winningNum,";");
        Integer[] winningNumbers = Generics.stringArrTointArr(winningNumb);

        winner = new LotteryDetails.Winners(lottoId,winningNumbers);
        lottery = new LotteryDetails(winnerId,winningNumbers,winner);
    }

    @When("^Post request for lottery is initiated with \"([^\"]*)\"$")
    public void postRequestForLotteryIsInitiatedWith(String endPoint) {
        response = ApiUtil.postRequest(lottery , endPoint);
    }

    @Then("^Details of lottery should be posted successfully with \"([^\"]*)\"$")
    public void detailsOfLotteryShouldBePostedSuccessfullyWith(int statusCode) {
        Assert.assertEquals(statusCode, ApiUtil.getResponseCode(response));
    }
}

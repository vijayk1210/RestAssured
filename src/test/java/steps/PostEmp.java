package steps;

import com.aventstack.extentreports.model.MediaType;
//import com.sun.security.ntlm.Client;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.EmpDetails;
import org.junit.Assert;
import utilities.ApiUtil;
import utilities.Generics;
import static org.hamcrest.Matchers.*;

public class PostEmp {
    EmpDetails empDetails;
    public static Response response;
    EmpDetails.Address address;

    @Given("^Entering employee details like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enteringEmployeeDetailsLike(String name, String permanent, String street, String city, int zipcode, String phoneNumbers, String role) {
        address = new EmpDetails.Address(street,city,zipcode);

        boolean permanentVal = Boolean.parseBoolean(permanent);
        String[] phoneNum = Generics.stringToArr(phoneNumbers,",");
        Long[] finalPhoneNum = Generics.stringArrToLongArr(phoneNum);

        empDetails = new EmpDetails(name,permanentVal,address,finalPhoneNum,role);

    }

    @When("^Post request for employee details is initiated with \"([^\"]*)\"$")
    public void postRequestForEmployeeDetailsIsInitiatedWith(String endPoint) {
        response = ApiUtil.postRequest(empDetails , endPoint);
    }

    @Then("^Employee Details should be posted successfully with \"([^\"]*)\"$")
    public void employeeDetailsShouldBePostedSuccessfullyWith(int statusCode) {
        Assert.assertEquals(statusCode,ApiUtil.getResponseCode(response));
        //empDetails = response.as(EmpDetails.class);
        //Assert.assertEquals("Chintu", empDetails.getName());

    }

    @Given("^Give employee details like \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void giveEmployeeDetailsLike(String name, String permanent, String street, String city, int zipcode, String phoneNumbers, String role) {
        address = new EmpDetails.Address(street,city,zipcode);

        boolean permanentVal = Boolean.parseBoolean(permanent);
        String[] phoneNum = Generics.stringToArr(phoneNumbers,",");
        Long[] finalPhoneNum = Generics.stringArrToLongArr(phoneNum);

        empDetails = new EmpDetails(name,permanentVal,address,finalPhoneNum,role);
    }

    @When("^Put request for employee details is initiated with \"([^\"]*)\", \"([^\"]*)\"$")
    public void putRequestForEmployeeDetailsIsInitiatedWith(String endPoint,String id) {
        response = ApiUtil.putRequest(empDetails , endPoint, id);
    }

    @Then("^Employee Details should be updated successfully with \"([^\"]*)\"$")
    public void employeeDetailsShouldBeUpdatedSuccessfullyWith(int statusCode) {
        Assert.assertEquals(statusCode,ApiUtil.getResponseCode(response));
    }

    @Given("We have employee details in application")
    public void searchEmployeeWithName() {

    }

    @When("Get request for employee details is initiated with \"([^\"]*)\" as end point and \"([^\"]*)\" as id")
    public void getRequestForEmployeeDetailsIsInitiatedWithAsEndPointAndAsId(String endPoint, String id) {
        response = ApiUtil.getRequest(endPoint , id);
        //response = ApiUtil.getRequest("");
    }

    @Then("^Role should be returned as \"([^\"]*)\"$")
    public void roleShouldBeReturnedAs(String role) {
        /*JsonPath jPath = response.jsonPath();
        String roleActualVal = jPath.get("role");
        Assert.assertEquals(role,roleActualVal);*/
        System.out.print("Content type is "+response.getContentType());
        empDetails = response.as(EmpDetails.class);
        Assert.assertEquals(role,empDetails.getRole());
    }



}

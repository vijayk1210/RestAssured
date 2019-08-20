package utilities;

//import io.restassured.RestAssured;
//import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtil {

    public static Response response;
    //RestAssured.registerParser("text/html", Parser.JSON);
   // registerParser("text/html", Parser.JSON);

    public static Response postRequest( Object obj, String endpoint){
            response = given().contentType("application/json").body(obj).when().post(Generics.getConfigValue("uri").concat(endpoint));

            return response;

    }

    public static Response putRequest( Object obj, String endpoint,String id){
        response = given().contentType("application/json").body(obj).when().put(Generics.getConfigValue("uri").concat(endpoint).concat("/").concat(id));

        return response;

    }

    public static Response getRequest(String id,String endPoint){
        response = given().contentType("text/html; charset=UTF-8").when().get(Generics.getConfigValue("uri").concat(endPoint).concat("/").concat(id));

        return response;

    }

    public static Response getRequest(String endPoint){
        response = given().when().get(Generics.getConfigValue("uri").concat(endPoint));

        return response;

    }

    public static int getResponseCode(Response response){

        return response.statusCode();
    }


    public static void performAuthorizaion(){

      //given().auth().preemptive().basic();

    }

    /*ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(Item.class, new ItemDeserializer());
    mapper.registerModule(module);

    Item readValue = mapper.readValue(json, Item.class);*/
}

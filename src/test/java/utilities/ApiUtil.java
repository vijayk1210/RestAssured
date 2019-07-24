package utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiUtil {

    public static Response response;

    public static Response postRequest( Object obj, String endpoint){
            response = given().contentType("application/json").body(obj).when().post(Generics.getConfigValue("uri").concat(endpoint));

            return response;

    }

    public static Response putRequest( Object obj, String endpoint,String id){
        response = given().contentType("application/json").body(obj).when().put(Generics.getConfigValue("uri").concat(endpoint).concat("/").concat(id));

        return response;

    }

    public static Response getRequest(String id,String endPoint){
        response = given().when().get(Generics.getConfigValue("uri").concat(endPoint).concat("/").concat(id));

        return response;

    }

    public static int getResponseCode(Response response){

        return response.statusCode();
    }


}

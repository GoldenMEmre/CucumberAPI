package hooks.api;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.Authentication;
import utilities.ConfigReader;

public class HooksAPI {

    public static String token;

    public static RequestSpecification spec;

    @Before (order=0)
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }

    @Before (order=1)
    public void beforeGenerateToken(){

            String token = Authentication.generateToken();


    }
}

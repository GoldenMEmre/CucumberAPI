package stepDefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class CommonAPI {

    String fullPath;

    JSONObject reqBody;

    @Given("Api kullanicisi {string} path parametreleri set eder.")
    public void api_kullanicisi_path_parametreleri_set_eder(String rawPaths) {

        spec.pathParams("pp1", "api", "pp2", "profile", "pp3", "allCountries");

        String[] paths = rawPaths.split("/");// ["api,"profile,"allCountries"]

        System.out.println();
        
        /*
        spec.pathParam("pp1","api");
        spec.pathParam("pp2","profile");
        spec.pathParam("pp3","allCountries");
         */

        StringBuilder temPath = new StringBuilder("/{");

        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            HooksAPI.spec.pathParam(key, value);

            temPath.append(key + "}/{");
        }
        temPath.deleteCharAt(temPath.lastIndexOf("{"));
        temPath.deleteCharAt(temPath.lastIndexOf("/"));

        fullPath = temPath.toString();
        System.out.println();
    }

        Response response = given().spec(spec).contentType(ContentType.JSON).header().headers()

    @Then("Login icin {string} ve {string} girilir.")
    public void loginIcinVeGirilir(String email, String password) {
        /*
        {
          "email": "test@test.com",
          "password": "123123123"
        }
         */

        JSONObject reqBody = new JSONObject();

        reqBody.put("email", ConfigReader.getProperty(email));
        reqBody.put("email", ConfigReader.getProperty(password));

    }

    @Then("Login icin Post request gonderilir")
    public void login_icin_post_request_gonderilir() {

        Response response = given()
                                .spec(spec)
                                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                            .when()
                                .body(reqBody.toString())
                                .post(fullPath);


    }
}
    git init

        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/GoldenMEmre/CucumberAPI.git
        git push -u origin main
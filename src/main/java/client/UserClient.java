package client;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojos.User;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final Gson gson = new Gson();

    @Step("Get create new user and check status code")
    public User getBasicUserCreationResponse() {
        User user = new User("test-email" + ThreadLocalRandom.current().nextInt(0, 9999999) + "@yandex.ru", "1234", "saske");
        Response post = given()
                .header("Content-type", "application/json")
                .and()
                .body(gson.toJson(user))
                .when()
                .post("/api/auth/register");
        if(post.statusCode()==200){
            return user;
        }else return null;
    }
}

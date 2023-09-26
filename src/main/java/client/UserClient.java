package client;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import io.restassured.http.Header;
import io.restassured.response.Response;
import pojos.User;

import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final Gson gson = new Gson();

    @Step("Get create new user and check status code")
    public User getBasicUserCreationResponse() {
        User user = getNewBasicUserObject();
        Response post = given()
                .header("Content-type", "application/json")
                .and()
                .body(gson.toJson(user))
                .when()
                .post("/api/auth/register");
        if(post.statusCode()==200){
            user.setAccessToken(post.getBody().path("accessToken"));
            user.setRefreshToken(post.getBody().path("refreshToken"));
            return user;
        }else return null;
    }
    @Step("Delete user data by API")
    public void deleteUser(User user) {
        Response delete = given()
                .header(new Header("Authorization", user.getAccessToken()))
                .header("Content-type", "application/json")
                .and()
                .body(gson.toJson(user))
                .when()
                .delete("/api/auth/user");
        delete.prettyPrint();
    }

    @Step("Create new user object")
    protected User getNewBasicUserObject(){
        return new User("name-email" + ThreadLocalRandom.current().nextInt(0, 9999999) + "@yandex.ru",
                "password"+ ThreadLocalRandom.current().nextInt(0, 9999) ,
                "Name"+ThreadLocalRandom.current().nextInt(0, 9999));
    }

    @Step("Login and delete user")
    public void loginAndDeleteUser(User user){
        Response post = given()
                .header("Content-type", "application/json")
                .and()
                .body(gson.toJson(user))
                .when()
                .post("/api/auth/login");
        user.setAccessToken(post.getBody().path("accessToken"));
        deleteUser(user);
    }
}

package com.restful.booker.testsuite;

import com.restful.booker.restfulinfo.AuthSteps;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AuthCURDTestWithSteps extends TestBase {

    static String username = "admin";
    static String password = "password123";

    @Steps
    AuthSteps authSteps;

    @Title("This will create Auth Token")
    @Test
    public void test001(){
        ValidatableResponse response = authSteps.createAuthToken(username, password);
        response.log().all().statusCode(200);
    }

}

package com.restful.booker.restfulinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.PartialUpdatePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PartialUpdateSteps {

   @Steps
   PartialUpdateSteps partialUpdateSteps;

    @Step("Update the user information and verify the updated information")
    public ValidatableResponse partialUpdateBooking(int bookingID, String firstname, String lastname) {
        PartialUpdatePojo partialUpdatePojo = new PartialUpdatePojo();
        partialUpdatePojo.setFirstname(firstname);
        partialUpdatePojo.setLastname(lastname);


        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=452193a4c68f592")
                .pathParam("bookingID", bookingID)
                .body(partialUpdatePojo)
                .when()

                .patch(EndPoints.UPDATE_BOOKING_BY_ID)
                .then().statusCode(200);

    }
    @Step("Getting the booking information with firstname: {0}")
    public ValidatableResponse getBookingInforByID(int bookingID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=452193a4c68f592")
                .pathParam("bookingID", bookingID)
                .when()
                .get(EndPoints.GET_BOOKING_BY_ID)
                .then().statusCode(200);
    }

}

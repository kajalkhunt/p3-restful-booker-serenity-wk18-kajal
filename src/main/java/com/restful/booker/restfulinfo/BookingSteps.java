package com.restful.booker.restfulinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.BookingPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class BookingSteps {

    @Step("Creating booking with firstname:{0},lastname:{1},totalprice:{2},bookingdates:{3} and additionalneeds:{3}")

    public ValidatableResponse createBooking(String firstname, String lastname, int totalprice, boolean depositpaid, HashMap<Object, Object> bookingdates, String additionalneeds) {
//        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds(additionalneeds);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=452193a4c68f592")
                .body(bookingPojo)
                .when()
                .post(EndPoints.CREATE_BOOKING)
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

    @Step("Update the user information and verify the updated information")
    public ValidatableResponse updateBooking(int bookingID, String firstname, String lastname, int totalprice, boolean depositpaid, HashMap<Object, Object> bookingdates, String additionalneeds) {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalprice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setBookingdates(bookingdates);
        bookingPojo.setAdditionalneeds(additionalneeds);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=452193a4c68f592")
                .pathParam("bookingID", bookingID)
                .body(bookingPojo)
                .when()

                .put(EndPoints.UPDATE_BOOKING_BY_ID)
                .then().statusCode(200);

    }

    @Step("This will delete booking by ID")
    public ValidatableResponse deleteBookingData(int bookingID) {
        return SerenityRest.given().log().all()
                .header("Cookie", "token=452193a4c68f592")
                .header("Content-Type", "application/json")
                .pathParam("bookingID", bookingID)
                .when()
                .delete(EndPoints.DELETE_booking_BY_ID)
                .then().statusCode(201);

    }
    @Step("Getting the booking information with firstname: {0}")
    public ValidatableResponse getBookingInforByIDAfterDeletion(int bookingID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=452193a4c68f592")
                .pathParam("bookingID", bookingID)
                .when()
                .get(EndPoints.GET_BOOKING_BY_ID)
                .then().statusCode(404);
    }

}




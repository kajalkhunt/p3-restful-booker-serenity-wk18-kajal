package com.restful.booker.testsuite;

import com.restful.booker.restfulinfo.BookingSteps;
import com.restful.booker.restfulinfo.PartialUpdateSteps;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class BookingCURDTestWithSteps extends TestBase {

    static String firstname = "Raja";
    static String lastname = "RamSita";
    static int totalprice = 288;
    static boolean depositpaid = true;
    //    static Object checkin =  2023-01-02;
//    static Object checkout =  2023-01-31;
    static HashMap<Object, Object> bookingdates;
    static String additionalneeds = "Breakfast";
    static int bookingID;

    @Steps
    BookingSteps bookingSteps;
    PartialUpdateSteps partialUpdateSteps;


    @Title("This will create a booking")
    @Test
    public void test001() {

        HashMap<Object, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2023-01-01");
        bookingDatesMap.put("checkout", "2024-01-01");

        ValidatableResponse response = bookingSteps.createBooking(firstname, lastname, totalprice, depositpaid, bookingDatesMap, additionalneeds);
        response.log().all().statusCode(200);
        bookingID = response.extract().path("bookingid");
        System.out.println(bookingID);

    }

    @Title("Verify if the user was added to the application")

    @Test
    public void test002() {
        ValidatableResponse response = bookingSteps.getBookingInforByID(bookingID);
        response.log().all().statusCode(200);

    }

    @Title("This will update a booking")
    @Test
    public void test003() {
        firstname = firstname + "_updated";

        HashMap<Object, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2023-01-01");
        bookingDatesMap.put("checkout", "2024-01-01");

        ValidatableResponse response = bookingSteps.updateBooking(bookingID, firstname, lastname, totalprice, depositpaid, bookingDatesMap, additionalneeds);
        response.log().all().statusCode(200);

    }

    @Title("This will update a partial booking ")
    @Test
    public void test004() {
        firstname = firstname + "_updated";
        lastname = lastname + "_updated";

        HashMap<Object, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2023-01-01");
        bookingDatesMap.put("checkout", "2024-01-01");

        ValidatableResponse response = partialUpdateSteps.partialUpdateBooking(bookingID, firstname, lastname);
        response.log().all().statusCode(200);

    }

    @Title("Verify if the booking  was updated partially")

    @Test
    public void test005() {
         partialUpdateSteps.getBookingInforByID(bookingID).statusCode(200);
    }

    @Title("This will delete booking and verify booking is deleted")

    @Test
    public void test006() {
        bookingSteps.deleteBookingData(bookingID).statusCode(200);
        bookingSteps.getBookingInforByIDAfterDeletion(bookingID).statusCode(404);

    }

}

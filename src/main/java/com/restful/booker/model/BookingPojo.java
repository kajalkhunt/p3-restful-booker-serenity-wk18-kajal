package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
//    private Object checkin;
//    private Object checkout;
    private HashMap<Object, Object> bookingdates;
    private String additionalneeds;

    public HashMap<Object, Object> getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HashMap<Object, Object> bookingdates) {
        this.bookingdates = bookingdates;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

//    public double getCheckin() {
//        return checkin;
//    }
//
//    public void setCheckin(double checkin) {
//        this.checkin = checkin;
//    }
//
//    public double getCheckout() {
//        return checkout;
//    }
//
//    public void setCheckout(double checkout) {
//        this.checkout = checkout;
//    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

//    public static BookingPojo getBookingPojo(String firstname, String lastname, int totalprice, HashMap<Object, Object> bookingdates,String additionalneeds) {
//        BookingPojo bookingPojo = new BookingPojo();
//        bookingPojo.setFirstname(firstname);
//        bookingPojo.setLastname(lastname);
//        bookingPojo.setTotalprice(totalprice);
////        bookingPojo.setCheckin(checkin);
////        bookingPojo.setCheckout(checkout);
//        bookingPojo.setBookingdates(bookingdates);
//        bookingPojo.setAdditionalneeds(additionalneeds);
//        return bookingPojo;
//
//    }
}

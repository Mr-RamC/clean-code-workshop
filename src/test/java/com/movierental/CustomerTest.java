package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldReturnValidStatementWithNoRental(){
        Customer customer = new Customer("Ram");

        String statement = customer.statement();

        String toAssertStatement = "Rental Record for Ram\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(toAssertStatement, statement);
    }
    @Test
    public void shouldReturnValidStatementWithAtleastOneRental(){
        Customer customer = new Customer("Ram");

        customer.addRental(new Rental(new Movie("Terminator", Movie.NEW_RELEASE), 1));

        String statement = customer.statement();

        String expectedStatement = "Rental Record for Ram\n" +
                "\tTerminator\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expectedStatement, statement);
//        assertEquals(expectedStatement, statement);
    }
}
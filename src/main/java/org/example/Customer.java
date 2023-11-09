package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";

    for (Rental rental : rentals) {

      // determines the amount for each line

      frequentRenterPoints += rental.getFrequentRenterPoints();

      totalAmount += rental.calculateAmount();
      result += rental.getResult();

    }

    result += "You owed " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

    return result;
  }

  private String name;

  private List<Rental> rentals = new ArrayList<>();
}
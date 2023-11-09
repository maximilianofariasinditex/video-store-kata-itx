package org.example;

public class Rental {

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  String getResult() {
    return "\t" + movie.getTitle() + "\t" + calculateAmount() + "\n";
  }

  int getFrequentRenterPoints() {
    if (movie.getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
      return 2;
    }
    return 1;
  }

  double calculateAmount() {
    double thisAmount = 0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        thisAmount = calculateAmount(2, 2);
        break;
      case Movie.NEW_RELEASE:
        thisAmount += getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount = calculateAmount(3, 1.5);
        break;
    }
    return thisAmount;
  }

  private double calculateAmount(int rentedDays, double thisAmount) {
    if (getDaysRented() > rentedDays) {
      thisAmount += (getDaysRented() - rentedDays) * 1.5;
    }
    return thisAmount;
  }

  public int getDaysRented() {
    return daysRented;
  }

  private Movie movie;

  private int daysRented;
}
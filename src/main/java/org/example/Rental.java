package org.example;

public class Rental
{
  public Rental (Movie movie, int daysRented) {
    this.movie 		= movie;
    this.daysRented = daysRented;
  }

  int getFrequentRenterPoints() {
    int frequentRenterPoints = 1;
    if (getMovie ().getPriceCode () == Movie.NEW_RELEASE
        && getDaysRented () > 1)
      frequentRenterPoints++;
    return frequentRenterPoints;
  }

  double calculateAmount() {
    double thisAmount = 0;
    switch (getMovie ().getPriceCode ()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (getDaysRented () > 2)
          thisAmount += (getDaysRented () - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += getDaysRented () * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (getDaysRented () > 3)
          thisAmount += (getDaysRented () - 3) * 1.5;
        break;
    }
    return thisAmount;
  }

  public int getDaysRented () {
    return daysRented;
  }

  public Movie getMovie () {
    return movie;
  }

  private Movie movie;
  private int daysRented;
}
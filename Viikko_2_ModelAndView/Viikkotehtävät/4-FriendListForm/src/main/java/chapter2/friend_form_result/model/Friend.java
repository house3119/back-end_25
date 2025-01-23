package chapter2.friend_form_result.model;

public class Friend {
  String firstName, lastName;

  public Friend(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Friend() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Friend [firstName=" + firstName + ", lastName=" + lastName + "]";
  }

}

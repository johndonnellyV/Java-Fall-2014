//John Donnelly
//This class represents a customer

public class Customer {
  
     //represents a customers first name
  private String firstName = "";
     //represests a customers last name
  private String lastName = "";
     //represents a customers address
  private String address = "";
     //represents an electric account for a customer
  private Account electricAccount;
     //represents a gas account for a customer
  private Account gasAccount;
     //represents a water account for a customer
  private Account waterAccount;
     //represents the current date
  private Date date;
  
  //sets last name and address
  public Customer(String lastName, String address) {
    this.lastName = lastName;
    this.address = address;
  }
  
  //sets the full name, address, and date
  public Customer(String firstName, String lastName, String address, Date date) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.date = date;
  }
  
  
  //changes the first name associated with the customer
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  //returns the first name associated with the customer
  public String getFirstName() {
    return firstName;
  }
  
  //changes the last name associated with the customer
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  //returns the last name associated with the customer
  public String getLastName() {
    return lastName;
  }
  
  //changes the address associated with the customer
  public void setAddress(String address) {
    this.address = address;
  }
  
  //returns the address associated with the customer
  public String getAddress() {
    return address;
  }
  
  //assigns an account for electricity usage for this customer
  public void setElectricAccount(Account electricAccount) {
    this.electricAccount = electricAccount;
  }
  
  //returns the account for electricity usage by this customer
  public Account getElectricAccount() {
    return electricAccount;
  }
  
  //assigns an account for natural gas usage for this customer
  public void setGasAccount(Account gasAccount) {
    this.gasAccount = gasAccount;
  }
  
  //returns the account for natural gas usage by this customer
  public Account getGasAccount() {
    return gasAccount;
  }
  
  //assigns an account for water usage for this customer
  public void setWaterAccount(Account waterAccount) {
    this.waterAccount = waterAccount;
  }
  
  //returns the account for water usage by this customer
  public Account getWaterAccount() {
    return waterAccount;
  }
  
  //sets a Date instance associated with this customer
  public void setDate(Date date) {
    this.date = date;
  }
  
  // returns a Date instance associated with this customer
  public Date getDate() {
    return date;
  }
  
  //calls the associated method of the Date class to increment the date. Calls the processDate method of each account that exists for the customer
  public void incrementDate() {
    date.incrementDay();
  }
}

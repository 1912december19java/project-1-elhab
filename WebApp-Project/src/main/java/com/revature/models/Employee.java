package com.revature.models;

public class Employee {

  public Employee() {

  }
  
  private int id;
  private String name;
  private long contact;
  private String email;
  private String username;
  private String password;
  private String position;
  private String rating;
  private double salary;
  public Employee(int id, String name, long contact, String email,
      String username, String password, String position, String rating, double salary) {
    super();
    this.id = id;
    this.name = name;
    this.contact = contact;
    this.email = email;
    this.username = username;
    this.password = password;
    this.position = position;
    this.rating = rating;
    this.salary = salary;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public long getContact() {
    return contact;
  }
  public void setContact(long contact) {
    this.contact = contact;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getRating() {
    return rating;
  }
  public void setRating(String rating) {
    this.rating = rating;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name  + ", contact="
        + contact + ", email=" + email + ", username=" + username + ", password=" + password
        + ", position=" + position + ", rating=" + rating + ", salary=" + salary + "]";
  }
  
}

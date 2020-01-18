package com.revature.models;

public class Manager {

  public Manager() {
  }
  
  private int id;
  private String name;
  private String department;
  private long contact_number;
  private String email_adress;
  private String username;
  private String password;
  private double salary;
  
  public Manager(int id, String name, String department, long contact_number, String email_adress,
      String username,String password, double salary) {
    super();
    this.id = id;
    this.name = name;
    this.department = department;
    this.contact_number = contact_number;
    this.email_adress = email_adress;
    this.username = username;
    this.password = password;
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

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public long getContact_number() {
    return contact_number;
  }

  public void setContact_number(long contact_number) {
    this.contact_number = contact_number;
  }

  public String getEmail_adress() {
    return email_adress;
  }

  public void setEmail_adress(String email_adress) {
    this.email_adress = email_adress;
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

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Manager [id=" + id + ", name=" + name + ", department=" + department
        + ", contact_number=" + contact_number + ", email_adress=" + email_adress + ", username="
        + username + ", password=" + password + ", salary=" + salary + "]";
  }


}


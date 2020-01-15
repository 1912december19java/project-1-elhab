package com.revature.models;

public class Reimbursment {



  private int id;
  private String request_type;
  private double amount;
  private String status;
  private int employee_id;
  private int managers_id;
  private String receipt_image;

  public Reimbursment() {

  }

  public Reimbursment(int id,String request_type, double amount, String status, int employee_id,
      int managers_id, String receipt_image) {
    super();
    this.id=id;
    this.request_type = request_type;
    this.amount = amount;
    this.status = status;
    this.employee_id = employee_id;
    this.managers_id = managers_id;
    this.receipt_image = receipt_image;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getRequest_type() {
    return request_type;
  }

  public void setRequest_type(String request_type) {
    this.request_type = request_type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(int employee_id) {
    this.employee_id = employee_id;
  }

  public int getManagers_id() {
    return managers_id;
  }

  public void setManagers_id(int managers_id) {
    this.managers_id = managers_id;
  }

  public String getReceipt_image() {
    return receipt_image;
  }

  public void setReceipt_image(String receipt_image) {
    this.receipt_image = receipt_image;
  }

  @Override
  public String toString() {
    return "Reimbursment [id=" + id + ", request_type=" + request_type + ", amount=" + amount
        + ", status=" + status + ", employee_id=" + employee_id + ", managers_id=" + managers_id
        + ", receipt_image=" + receipt_image + "]";
  }
}

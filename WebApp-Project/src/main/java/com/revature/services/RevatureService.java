package com.revature.services;

import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Reimbursment;
import com.revature.repositories.DaoPostgress;

public class RevatureService<Reimbursment> {

  public RevatureService() {
    
  }

  
  private DaoPostgress daoPostgress;
//  
  public RevatureService(DaoPostgress daoPostgress) {
    this.daoPostgress = daoPostgress;
  }
  
  public Employee getEmployee(String username) {
    
    return daoPostgress.getEmployee(username);
  }

 public List<com.revature.models.Reimbursment> getReimbersment(int employee_id) {
    return  daoPostgress.getReimbursment(employee_id);
 }

  public void saveReimbursment(String type, double amount, int employeeId, String receipImage) {
  
    daoPostgress.saveReimbursment( type, amount,employeeId, receipImage);
  }
  public List<com.revature.models.Reimbursment> getReimbersments(String status){
    return daoPostgress.getReimbursments(status);
  }
  public void updateEmployeeupdateEmployee(String position, String email, Long contact, String username, String password, String name) {
    daoPostgress.updateEmployee(position, email, contact, username, password, name);
  }
  
  public Manager getManager(String username) {
    return daoPostgress.getManager(username);
  }
  public void updateReimStatus(String status, String username) {
    daoPostgress.updateReimStatus(status, username);
  }
  public List<String> getAllImageRecei(){
    return daoPostgress.getAllImageRecei();
  }
  public List<Employee> getAllEmployee(){
    return daoPostgress.getAllEmployee();
  }
 
}

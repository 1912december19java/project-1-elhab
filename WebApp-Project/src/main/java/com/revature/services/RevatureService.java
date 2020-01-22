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

 public List<com.revature.models.Reimbursment> getReimbursment(int employee_id) {
    return  daoPostgress.getReimbursment(employee_id);
    //getReimbursmen
 }

  public void saveReimbursment(String type, double amount, int employeeId, String receipImage) {
  
    daoPostgress.saveReimbursment( type, amount,employeeId, receipImage);
  }
  public List<com.revature.models.Reimbursment> getReimbursments(String status){
    return daoPostgress.getReimbursments(status);
  }
  public void updateEmployee(String position, String email, Long contact, String username, String password, String name, int id) {
    daoPostgress.updateEmployee(position, email, contact, username, password, name, id);
  }
  
  public Manager getManager(String username) {
    return daoPostgress.getManager(username);
  }
  public void updateReimStatus(String status, int id) {
    daoPostgress.updateReimStatus(status, id);
  }
  public List<String> getAllImageRecei(){
    return daoPostgress.getAllImageRecei();
  }
  public List<Employee> getAllEmployee(){
    return daoPostgress.getAllEmployee();
  }
  public List<com.revature.models.Reimbursment> getPendingRequests(int employee_id) {
    return  daoPostgress.getPendingRequests(employee_id);
  }
  public List<Reimbursment> getResolvedRequests(int employee_id) {
    return (List<Reimbursment>) daoPostgress.getResolvedRequests(employee_id);
    
  }
}

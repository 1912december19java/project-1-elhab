package com.revature.repositories;

import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Reimbursment;

public interface Dao {
  
  public Employee getEmployee(String username) ;
  public void  saveReimbursment(String type, double amount, int employeeId, String receipImage);
  public List<Reimbursment> getReimbursments(String status);
  public void updateEmployee(String position, String email, Long contact, String username, String password, String name);
  
  public Manager getManager(String username);
  public void updateReimStatus(String status, int id);
//  public List<Reimbursment> getAllReimb(String status);
  public List<String> getAllImageRecei();
  public List<Employee> getAllEmployee();
  public List<Reimbursment> getReimbursment(int employee_id);

}

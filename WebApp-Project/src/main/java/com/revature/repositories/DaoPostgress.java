package com.revature.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Reimbursment;

public class DaoPostgress implements Dao {

  public DaoPostgress() {

  }
  private static Connection conn;
  private static String protocol = "jdbc:postgresql://";
  
  // This static block run when the class loads, after static fields are initialized.
  static {
    // This explicitly loads the Driver class:
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(
          protocol + System.getenv("connHost") + ":5432/" + System.getenv("dbname"),
          System.getenv("username"), System.getenv("password")

      );

    } catch (SQLException e) {
    
      e.printStackTrace();
    }
  }
//   get an employee information if existed
  public Employee getEmployee(String username) {
    Employee employee = null;
    ResultSet rs = null;
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM employee where username = ? "); 
      stm.setString(1,username);
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        employee = new Employee (rs.getInt("id"), rs.getString("name"),rs.getLong("contact_number"),rs.getString("email_adress"),
            rs.getString("username"),rs.getString("password"), rs.getString("position_role"),rs.getString("rating"),rs.getDouble("salary")
                                 );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return employee;
  }

  //save a new reimbursement request by the employye
 
  public void saveReimbursment(String type, double amount, int employeeId, String receipImage) {
    PreparedStatement stmt = null;
    try {
   
      stmt = conn.prepareStatement(
          "INSERT INTO reimbursments(request_type, amount,status, employee_id, receipt_image) VALUES (?,?,?,?,?)");

      stmt.setString(1, type);
      stmt.setDouble(2, amount);
      stmt.setString(3, "pending");
      stmt.setInt(4, employeeId);
      stmt.setString(5,receipImage );
      
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
//get a list of reimbursement requests depending on the status or all
  public List<Reimbursment> getReimbursments(String status) {
    List<Reimbursment> reimbursment = new ArrayList<Reimbursment>();
    ResultSet rs = null;
    PreparedStatement stmt = null;
  
    
    switch (status) {
      
    case "pending":
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ? "); 
      stm.setString(1,"pending");
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
    
    case "approved":
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ? "); 
      stm.setString(1,"approved");
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
    
    case "denied":
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ? "); 
      stm.setString(1,"denied");
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
    case "all":
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments"); 
      
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
    case "rseolved":
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ? or status = ?"); 
      stm.setString(1,"denied");
      stm.setString(2,"approved");
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
    }
    
    return null;
  }

  public void updateEmployee(String position, String email, Long contact, String username, String password, String name, int id ) {
    PreparedStatement stmt = null;
    try {
//      UPDATE employee SET position_role='a', email_adress='a', contact_number=555555,  username='a', password='', name = 'a' WHERE id = 11;
        stmt = conn.prepareStatement( "UPDATE employee SET position_role=?, email_adress=?, contact_number=?,  username=?, password=?, name = ? WHERE id = ?");
      

      stmt.setString(1, position);
      stmt.setString(2, email);
      stmt.setLong(3,contact);
      stmt.setString(4, username);
      stmt.setString(5,password);
      stmt.setString(6,name);
      stmt.setInt(7, id);
      
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public Manager getManager(String username) {
    Manager manager = null;
    ResultSet rs = null;
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM managers where username = ? "); 
      stm.setString(1,username);
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        manager= new Manager (rs.getInt("id"), rs.getString("name"),rs.getString("department"),rs.getLong("contact_number"),rs.getString("email_adress"),
            rs.getString("username"),rs.getString("password"),rs.getDouble("salary") );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return manager;
  }

  public void updateReimStatus(String status,int id) {
    PreparedStatement stmt = null;
    try {
        stmt = conn.prepareStatement("UPDATE reimbursments SET status =  ?  WHERE id = ?");
      

      stmt.setString(1, status);
      stmt.setInt(2, id);
      
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }



  public List<String> getAllImageRecei() {
    
    List<String> imageReceipt = new ArrayList<String>();
    ResultSet rs = null;
    
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT receipt_image FROM reimbursments "); 
      
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        imageReceipt.add(rs.getString("receipt_image"));
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return imageReceipt;
  }
// get all employees from database.
  public List<Employee> getAllEmployee() {
    List<Employee> employee = new ArrayList<Employee>();
    ResultSet rs = null;
//    PreparedStatement stmt = null;
    
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM employee "); 
      
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        employee.add(new Employee (rs.getInt("id"), rs.getString("name"),rs.getLong("contact_number"),rs.getString("email_adress"),
            rs.getString("username"),rs.getString("password"), rs.getString("position_role"),rs.getString("rating"),rs.getDouble("salary")
            )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    
    return employee;
  }
//get a reimbursements requests  of an employee
  public List<Reimbursment> getReimbursment(int employee_id) {
    
    List<Reimbursment> reimbursment = new ArrayList<Reimbursment>();
    ResultSet rs = null;
    PreparedStatement stmt = null;
    
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where employee_id = ? "); 
      stm.setInt(1,employee_id);
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
  }

  public List<Reimbursment> getResolvedRequests(int employee_id) {
    
    List<Reimbursment> reimbursment = new ArrayList<Reimbursment>();
    ResultSet rs = null;
    PreparedStatement stmt = null;
  
    try {
//      SELECT * FROM reimbursments where (status = 'approved' or status = 'denied')AND employee_id=1;
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ? AND employee_id=? "); 
//      or status = ? 
//      stm.setString(1,"denied");
      stm.setString(1,"approved");
      stm.setInt(2,employee_id);
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
  }
  public List<Reimbursment> getPendingRequests(int employee_id) {
    
    List<Reimbursment> reimbursment = new ArrayList<Reimbursment>();
    ResultSet rs = null;
    PreparedStatement stmt = null;
  
    try {
      PreparedStatement stm = conn.prepareStatement("SELECT * FROM reimbursments where status = ?  AND employee_id = ? "); 
      stm.setString(1,"pending");      
      stm.setInt(2,employee_id);
      if (stm.execute()) {
        rs = stm.getResultSet();
      }
      while (rs.next()) {

        reimbursment.add(new Reimbursment(rs.getInt("id"),rs.getString("request_type"),rs.getDouble("amount"),rs.getString("status"),
            rs.getInt("employee_id"), rs.getInt("managers_id"),rs.getString("receipt_image") )  );
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }

    
    return reimbursment;
  }

}

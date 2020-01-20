package revature.com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Reimbursment;
import com.revature.repositories.Dao;
import com.revature.repositories.DaoPostgress;
import com.revature.services.RevatureService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "Testing", urlPatterns = {"/dao/*"})
public class EmployeeWeb extends HttpServlet {

  private RevatureService revatureService;
  private ObjectMapper om;
  ServletRequest session  ;
  
  @Override
  public void init() throws ServletException {
    this.revatureService =  new RevatureService(new DaoPostgress());
    this.om = new ObjectMapper();
    
    super.init();
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Hello!");
  HttpSession session = req.getSession();
//  session.setAttribute("username", username);

   String[] tokens = req.getRequestURI().split("/");
    
    if(tokens[3].equals("login")) {
      System.out.println(tokens[3]);
   
    
    String username =req.getParameter("username");
    String password =req.getParameter("password");

    Employee employee= revatureService.getEmployee(username);


    System.out.println(employee);
    String employeeUsername =employee.getUsername();
    String employeePassword =employee.getPassword();

   
    if(username.equals(employeeUsername) & password.equals(employeePassword)){
      if(session.isNew()) {
      session.setAttribute("id", employee.getId());
    }
      resp.getWriter().write(om.writeValueAsString(employee));
    } else resp.getWriter().write(om.writeValueAsString(null));
    }
    else if(tokens[3].equals("resolved")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Reimbursment> reimbursment =  revatureService.getResolvedRequests(id);
      resp.getWriter().write(om.writeValueAsString(reimbursment));
    }else if(tokens[3].equals("pending")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Reimbursment> reimbursment =  revatureService.getPendingRequests(id);
      resp.getWriter().write(om.writeValueAsString(reimbursment));
    }else if(tokens[3].equals("update")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      String position = String.valueOf(req.getParameter("position"));
      String email = String.valueOf(req.getParameter("email"));
      Long contact = Long.valueOf(req.getParameter("contact"));
      String username = String.valueOf(req.getParameter("username"));
      String password = String.valueOf(req.getParameter("password"));
      String name = String.valueOf(req.getParameter("name"));
      revatureService.updateEmployee(position, email, contact, username, password, name);
    }else if(tokens[3].equals("submit")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      String type = String.valueOf(req.getParameter("type"));
      Double amount = Double.valueOf(req.getParameter("amount"));
      Integer employeeId = Integer.valueOf(req.getParameter("employeeId"));
      String receipImage = String.valueOf(req.getParameter("receipImage"));
      System.out.println("here");
      revatureService.saveReimbursment(type, amount, employeeId, receipImage);
      resp.getWriter().write(om.writeValueAsString("done"));
      System.out.println("done");
    }
    }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("URI: " + req.getRequestURI());
    String[] tokens = req.getRequestURI().split("/");
    if(tokens[3].equals("login")) {
      doGet(req, resp);
    }
   
   String username=(String) session.getAttribute("username");
   System.out.println(username);
          
    }

}
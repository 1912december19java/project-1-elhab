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

@WebServlet(name = "Manager", urlPatterns = {"/manager/*"})
public class ManagerWeb extends HttpServlet {

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

    Manager manager= revatureService.getManager(username);

    System.out.println(username);
    System.out.println(manager);
    String managerUsername =manager.getUsername();
    String managerPassword =manager.getPassword();

   
    if(username.equals(managerUsername) & password.equals(managerPassword)){
      if(session.isNew()) {
      session.setAttribute("id", manager.getId());
    }
      resp.getWriter().write(om.writeValueAsString(manager));
    } else resp.sendRedirect("http://www.javatpoint.com");  ;
    }
    else if(tokens[3].equals("resolved")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Reimbursment> reimbursment =  revatureService.getReimbursments("resolved");
      resp.getWriter().write(om.writeValueAsString(reimbursment));
    }else if(tokens[3].equals("pending")) {
      System.out.println(session.getAttributeNames());
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Reimbursment> reimbursment =  revatureService.getReimbursments("pending");
      resp.getWriter().write(om.writeValueAsString(reimbursment));
    }else if(tokens[3].equals("employees")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Employee> employees = revatureService.getAllEmployee();
      resp.getWriter().write(om.writeValueAsString(employees));
    }else if(tokens[3].equals("receipts")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<String> images = revatureService.getAllImageRecei();
      resp.getWriter().write(om.writeValueAsString(images));
    }else if(tokens[3].equals("employee")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      List<Reimbursment> reimbursment = revatureService.getReimbursment(id);
      resp.getWriter().write(om.writeValueAsString(reimbursment));
    }else if(tokens[3].equals("updateReimbursment")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
      String status =req.getParameter("status");
      revatureService.updateReimStatus(status, id);
      resp.getWriter().write(om.writeValueAsString("done"));
      System.out.println("reached");
    }else if(tokens[3].equals("AllReimbursments")) {
      Integer id = Integer.valueOf(req.getParameter("id"));
     List<Reimbursment> reimbursment = revatureService.getReimbursments("all");
      resp.getWriter().write(om.writeValueAsString(reimbursment));
      System.out.println("reached");
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
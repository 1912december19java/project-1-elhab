package revature.com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.models.Employee;
import com.revature.models.Reimbursment;
import com.revature.repositories.Dao;
import com.revature.repositories.DaoPostgress;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "Testing", urlPatterns = {"/dao"})
public class ServletTest extends HttpServlet {

  private ObjectMapper om =new ObjectMapper(); 
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Hello!");
    
    DaoPostgress cd = new DaoPostgress();
//    System.out.println(cd.getAllReimb("Approved"));
//    
//    System.out.println(cd.getReimbursment(1));
//    Reimbursment em = cd.getReimbursment(1);
//    resp.getWriter().write(om.writeValueAsString(em));
//    
    List<Reimbursment> rm =cd.getReimbursment(1);
    System.out.println(rm.get(0).getManagers_id());
    Reimbursment ex=rm.get(0);
    resp.getWriter().write(om.writeValueAsString(ex));
   
}
}
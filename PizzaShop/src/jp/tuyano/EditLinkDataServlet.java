package jp.tuyano;
 
import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditLinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String mail = req.getParameter("mail");
        String comment = req.getParameter("comment");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        LinkData2 data = (LinkData2)manager.getObjectById(LinkData2.class,id);
        data.setTitle(title);
        data.setAddress(address);
        data.setComment(comment);
        manager.close();
        resp.sendRedirect("/history.html");
    }
}
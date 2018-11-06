/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ruizhipu
 */
public class movie extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        HttpSession session=request.getSession(true);
        myBean ub = new myBean();
        session.setAttribute("ub",ub);
        //depending on which form on index.jsp was used we login or register
        //failure returns to index.jsp, success spawns cw
        //the userbean is used to transfer information
        if(request.getParameter("log")!=null)
            if(request.getParameter("name").equals("admin") && request.getParameter("password").equals("admin"))
            {
            ub.setStatus("LOGIN SUCCESS");
            ub.setName(request.getParameter("name"));
            ub.setId(1);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/movielist.jsp");
            rd.forward(request, response);
            }
            else{
            ub.setStatus("LOGIN FAILURE RETRY");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
            }
            
        /*
        if(request.getParameter("reg")!=null)
            {
            if (!request.getParameter("password2").equals(request.getParameter("password1")))
                {
                ub.setloginStatus("Registration Failed, passwords didn't match");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                }
            else
                {int status = dbm.registerUser(
                request.getParameter("fname"), request.getParameter("lname"),
                request.getParameter("email"), request.getParameter("uname"),
                request.getParameter("password1"));
                if(status==1)
                    {
                    ub.setloginStatus(dbm.getUserName(request.getParameter("username"))+" is now registered and logged in.");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/cw.jsp");
                    rd.forward(request, response);
                    }
                else{
                    ub.setloginStatus("Registration Failed, existing username, please try again");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                    }
                }
            }
        */
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Hello.java
 *
 * Created on February 27, 2007, 12:39 PM
 */

package server;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ruizhipu
 * @version
 */
public class addmovie extends HttpServlet {
    private Connection conn;
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
        Date start=null, connection = null, process =null, cclose =null;
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Boolean valid = false;
        String clean_author, clean_title, clean_message;
        Statement st;
        Matcher matcher;
         
        
                String strId = null;
        String strname = null;
        String strdate = null;
        Boolean currentStatus = false;
        
        //directly get the parameter from the webpage
        try{
            strId = request.getParameter("Id");
            strname = request.getParameter("Name");
            strdate = request.getParameter("Time");
            currentStatus = true;
        }catch(NullPointerException ne){
            if(strId == null){
                System.out.println("nullpointer occured at Id");
            }else if(strname == null){
                System.out.println("nullpointer occured at Name");
            }else{
                System.out.println("nullpointer occured at strdate");
            }
        }
        
        
        
        //clean the inputs using regular expressions
        // Compile regular expression
        Pattern pattern = Pattern.compile("[;:,#&'\".!?]");
        // Replace all occurrences of pattern in input
        matcher = pattern.matcher(request.getParameter ("Id"));
        clean_author = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("Name"));
        clean_title = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("Time"));
        clean_message = matcher.replaceAll("|");
        //open the DBMS and insert the record
        try{
            Integer.parseInt(clean_author);
            //Date date=new SimpleDateFormat("yyyy-MM-dd").parse(clean_message);
            start = new Date();            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/assignment3";
            conn = DriverManager.getConnection(connectionURL, "rup11", "rup11");
            //conn=DriverManager.getConnection(database, "","");
            connection = new Date();
            st = conn.createStatement();
            String q1 = new String("INSERT INTO MOVIE (ID, NAME, TIME)"+
                " VALUES (" +
                clean_author +",'"+
                clean_title+"', '" +
                //df.format(start) + "', '" +
                clean_message + "')");
                System.out.println(q1);
                st.execute(q1);
                process = new Date();
                conn.close();
                cclose  = new Date();
                valid=true;
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addmovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello " + clean_author+ "</h1>");
        out.println("<p>We stored the following:</p><ol>");
        out.println("<p>"+clean_title+"</p>");
        out.println("<p>"+clean_message+"</p>");
        out.println("</ol>");
        out.println("<h3>Processing time for connection was: "+ (connection.getTime()-start.getTime())+" milliseconds</h3>");
        out.println("<h3>Processing time for insert was: "+ (process.getTime()-connection.getTime())+" milliseconds</h3>");
        out.println("<h3>Processing time for close was: "+ (cclose.getTime()-process.getTime())+" milliseconds</h3>");
        out.println("<h3><a href =\"allthemovie\">Click here for list</a></h3>");        
        out.println("</body>");
        out.println("</html>");
        }
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Storage Problem</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello " + request.getParameter ("Id") + "</h1>");
        out.println("<p>We were unable to store the movie:</p><ol><p>");
        out.println(request.getParameter("Name"));
        out.println("</p></ol>");
        out.println("<a href =\"allthemovie\">Click here for list</a>");        
        out.println("</body>");
        out.println("</html>");   
        }
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

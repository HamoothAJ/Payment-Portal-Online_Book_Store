package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditPaymentRecord
 */
@WebServlet("/edit")
public class EditPaymentRecord extends HttpServlet {
	private static final String query = "update carddetails set name=?,type=?,number=?,cvc=?,expdate=?,amount=? where ID=?";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPaymentRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 //get PrintWriter
		PrintWriter pw = response.getWriter();
		
		//set content type
		response.setContentType("text/html");
		
		pw.println("<link rel='stylesheet' href='Style/Style.css'></link>");
		
		//get the values
		int id = Integer.parseInt(request.getParameter("user_id"));
		
		String name = request.getParameter("userName");
        String type = request.getParameter("type");
        String number = request.getParameter("cardnumber");
        String cvc = request.getParameter("cvc");
        String expdate = request.getParameter("exdate");
        String amount = request.getParameter("amount");
        
      //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///paymentdb","root","12345");
                PreparedStatement ps = con.prepareStatement(query);){
                //set the values
                ps.setString(1, name);
                ps.setString(2, type);
                ps.setString(3, number);
                ps.setString(4, cvc);
                ps.setString(5, expdate);
                ps.setString(6, amount);
                ps.setInt(7, id);
                
              //execute the query
                int count = ps.executeUpdate();
                
                if(count==1) {
                    pw.println("<h2>Record Edited Successfully</h2>");
                }else {
                    pw.println("<h2>Record Not Edited</h2>");
                }
            }
    		catch(SQLException se) {
    			se.printStackTrace();
    	        pw.println("<h2>"+se.getMessage()+"</h2>");
    	    }catch(Exception e) {
    	        e.printStackTrace();
    	    }
    	   
        	pw.println("<a href='index.jsp'><button>Payment Page</button></a>");
        	pw.println("&nbsp; &nbsp;");
        	pw.println("<a href='ShowPaymentDetails'><button>Show Payment Details</button></a>");
    	   
        	 //close the stream
    	    pw.close();
            
                
    	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

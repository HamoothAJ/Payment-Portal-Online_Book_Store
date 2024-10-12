package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditPaymentScreen
 */
@WebServlet("/editurl")
public class EditPaymentScreen extends HttpServlet {
	private static final String query = "select name,type,number,cvc,expdate,amount from carddetails where ID=?";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPaymentScreen() {
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
		
		 //load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///paymentdb","root","12345");
                PreparedStatement ps = con.prepareStatement(query);){
            //set value 
            ps.setInt(1, id);
            //resultSet
            ResultSet rs = ps.executeQuery();
            rs.next();
            pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
            pw.println("<form action='edit?user_id="+id+"' method='post' style = 'width:60%; height:50%; margin-top:50px; display:flex; padding: 100px;'>");
            pw.println("<table cellpadding=\\\"5\\\" cellspacing=\\\"12\\\" style='disply:flex;'>");
            pw.println("<tr>");
            pw.println("<td>Card Holder's Name</td>");
            pw.println("<td><input type='text' name='userName' value='"+rs.getString(1)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td>Card Type</td>");
            pw.println("<td><input type='text' name='type' value='"+rs.getString(2)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td>Card Number</td>");
            pw.println("<td><input type='text' name='cardnumber' value='"+rs.getString(3)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td>CVC</td>");
            pw.println("<td><input type='text' name='cvc' value='"+rs.getString(4)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td>Exp.Date</td>");
            pw.println("<td><input type='text' name='exdate' value='"+rs.getString(5)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td>Amount</td>");
            pw.println("<td><input type='text' name='amount' value='"+rs.getString(6)+"'></td>");
            pw.println("</tr>");
            pw.println("<td><br></td>");
            pw.println("<tr>");
            pw.println("<td><button type='submit'>Edit</button></td>");
            pw.println("<td><button type='reset'>Cancel</button></td>");
            pw.println("</tr>");
            pw.println("</table>");
            pw.println("</form>");
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='index.jsp'><button>Payment Page</button></a>");
        
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

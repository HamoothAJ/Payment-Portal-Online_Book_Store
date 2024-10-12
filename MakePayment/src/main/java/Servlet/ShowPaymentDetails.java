package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Servlet implementation class ShowPaymentDetails
 */
@WebServlet("/ShowPaymentDetails")
public class ShowPaymentDetails extends HttpServlet {
	private static final String query = "select ID,name,type,number,cvc,expdate,amount from carddetails";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPaymentDetails() {
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
		
		pw.println("<marquee><h1 c style = \":rgb(0, 128, 255);\">User Payment Details</h1></marquee>");
	
		//load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///paymentdb","root","12345");
                PreparedStatement ps = con.prepareStatement(query);)
        {
            //resultSet
            ResultSet rs = ps.executeQuery();
            
            pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
            pw.println("<table class = 'show' cellpadding=\"5\" cellspacing=\"12\">");
            pw.println("<tr>");
            pw.println("<th><h2>ID</h2></th>");
            pw.println("<th><h2>Name</h2></th>");
            pw.println("<th><h2>Card Type</h2></th>");
            pw.println("<th><h2>Card Number</h2></th>");
            pw.println("<th><h2>CVC</h2></th>");
            pw.println("<th><h2>Exp.Date</h2></th>");
            pw.println("<th><h2>Amount</h2></th>");
            pw.println("<th><h2>Edit</h2></th>");
            pw.println("<th><h2>Delete</h2></th>");
            pw.println("</tr>");
            while(rs.next()) {
                pw.println("<tr>");
                pw.println("<td>"+rs.getInt(1)+"</td>");
                pw.println("<td>"+rs.getString(2)+"</td>");
                pw.println("<td>"+rs.getString(3)+"</td>");
                pw.println("<td>"+rs.getString(4)+"</td>");
                pw.println("<td>"+rs.getString(5)+"</td>");
                pw.println("<td>"+rs.getString(6)+"</td>");
                pw.println("<td>"+rs.getString(7)+"</td>");
                pw.println("<td><a href='editurl?user_id="+rs.getInt(1)+"'>Edit</a></td>");
                pw.println("<td><a href='deleteurl?user_id="+rs.getInt(1)+"'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table><br>");
        }catch(SQLException se) {
            pw.println("<h>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<button><a href='index.jsp'>Payment Page</a></button>");
        
        //close the stream
        pw.close();
    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

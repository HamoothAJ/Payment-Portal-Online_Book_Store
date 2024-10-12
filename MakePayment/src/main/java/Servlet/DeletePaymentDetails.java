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
 * Servlet implementation class DeletePaymentDetails
 */
@WebServlet("/deleteurl")
public class DeletePaymentDetails extends HttpServlet {
	private static final String query = "delete from carddetails where ID = ?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePaymentDetails() {
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
		
		int id = Integer.parseInt(request.getParameter("user_id"));
	
		//load the JDBC driver
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
		catch(Exception e) {
            e.printStackTrace();
        }
		
		//generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///paymentdb","root","12345");
                PreparedStatement ps = con.prepareStatement(query);){
            //set the values
            ps.setInt(1, id);
            //execute the query
            int count = ps.executeUpdate();
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2>Record Deleted Successfully</h2>");
            }else {
                pw.println("<h2>Record Not Deleted</h2>");
            }
        }catch(SQLException se) {
            pw.println("<h2>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='index.jsp'><button>Payment</button></a>");
        pw.println("&nbsp; &nbsp;");
        pw.println("<a href='ShowPaymentDetails'><button>Show Payment Details</button></a>");
        pw.println("</div>");
        
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

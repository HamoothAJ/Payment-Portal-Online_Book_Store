package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
    private static final String query = "insert into carddetails(name,type,number,cvc,expdate,amount) values(?,?,?,?,?,?)";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayment() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logic to handle GET requests (if any)
        // You can leave this empty if not needed
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource ds = null;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Perform JNDI lookup to obtain DataSource
            ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/paymentdb");
            con = ds.getConnection();
            ps = con.prepareStatement(query);

            String name = request.getParameter("userName");
            String type = request.getParameter("type");
            String number = request.getParameter("cardnumber");
            String cvc = request.getParameter("cvc");
            String expdate = request.getParameter("exdate");
            String amount = request.getParameter("amount");

            ps.setString(1, name);
            ps.setString(2, type);
            ps.setString(3, number);
            ps.setString(4, cvc);
            ps.setString(5, expdate);
            ps.setString(6, amount);

            int count = ps.executeUpdate();

            if (count == 1) {
                PrintWriter pw = response.getWriter();
                pw.println("Record Registered Successfully");
                pw.println("<a href=index.jsp>Show Payment Details</a>");
                pw.close();
            } else {
                PrintWriter pw = response.getWriter();
                pw.println("<h2>Record Not Registered</h2>");
                pw.println("<a href='index.jsp'><button>Payment Page</button></a>");
                pw.close();
            }

        } catch (SQLException se) {
            se.printStackTrace();
            PrintWriter pw = response.getWriter();
            pw.println("<h2>" + se.getMessage() + "</h2>");
            pw.close();
        } catch (NamingException e) {
            e.printStackTrace();
            PrintWriter pw = response.getWriter();
            pw.println("<h2>" + e.getMessage() + "</h2>");
            pw.close();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

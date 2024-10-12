<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
      
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link rel = "stylesheet" href ="Style/Style.css">

</head>
<body>
	
    <marquee><h1 style = "color:rgb(128, 255, 255); font-size:38px; height: 10px;" >EVOCO</h1></marquee>
    <center>
    
    <h1 style = "font-size:38px;" class="pay"><i>Card Payment Details</i></h1>
    <form action="AddPayment" method="post"><div style="opacity:0.6;">
        </div>
        
        <table class="table table-hover">
        
        <tr>
         <td><h2>Card Holder's Name : </h2></td>
         <td><input type="text" name="userName" required>
         </td>
        </tr>
        
        <tr>
        <td><h2>Card Type : </h2></td>
        <td><input type="radio" name="type" value="Credit_Card">Credit Card &nbsp;
            <input type="radio" name="type" value="Debit_Card">Debit Card
        </td>
        </tr>
         
        <tr>
         <td><h2>Card Number : </h2></td>
         <td><input type="text" name="cardnumber"  title="Please enter a 16 digit number"></td>
        </tr> 
       
        <tr>
         <td><h2>CVC : </h2></td>
         <td><input type="text" name="cvc" required pattern="\d{3}" title="Please enter a 3 digit number"></td>
        </tr> 
        
        <tr>
         <td><h2>Exp.Date : </h2></td>
         <td><input type="month" name="exdate" required>
           </td>
        </tr> 
        
        <tr>
         <td><h2>Amount : </h2></td>
         <td><input type="text" name="amount" required >
           </td>
        </tr> 
        
        <td><br></td>
        <tr>
        <td>
        	<button type="submit">PAY NOW</button>
        </td>
        
        <td>
        	<button style="font-color:rgb(0, 64, 128);" type="reset">CANCEL</button>
        </td> 
        
        </tr>
        </table><br><br>
        <button style="background-color:rgb(225, 255, 255); border-radius:40px;" margin-bottom: 50px><a href="ShowPaymentDetails">Show Payment Details</a></button>
    </form>
    </center>
    
</body>
</html>
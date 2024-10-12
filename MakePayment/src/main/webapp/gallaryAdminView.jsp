<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/gallaryAdminView.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="banner" style="background-image: url('images/al-elmes-ULHxWq8reao-unsplash.jpg')">
        <div class="navbar">
            <img src="images/WhatsApp Image 2024-03-14 at 00.07.14_f9efd4fb.jpg" alt="logo" class="logo">
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="gallary.php">About Us</a></li>
                <li><a href="booking.php">Event Rental</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Portfolio</a></li>
                <li><a href="#">Client</a></li>
              	<a href="#" class="button">Chat with us</a>
              	<li><a href="#" class="fa fa-user"></a></li> 	
            </ul>
        </div>
        
        <br>

        
        <div class="backround">
            <div class="booking-form">
                <form action="insert" method="post">
                    <label for="EventID">Event ID</label><br>
                    <input type="text" placeholder="EVEXXXXXX" name="eventID"><br>

                    <label for="name">Name</label><br>
                    <input type="text" placeholder="ancdefg" name="name"><br>

                    <label for="Description">Description</label><br>
                    <input type="text" placeholder="Enter description" name="description"><br><br>
                    
                    <label for="PlannerID">Event Planner ID</label><br>
                    <input type="text" placeholder="plnXXXX" name="plannerID"><br><br>  
                    
          <!--           <lable for="files">Upload images</lable>
                    <input type="file" name="files" multiple><br><br>-->

                    <label for="Location" id="location">Location</label><br>
                    <input type="text" placeholder="South Millway" name="location"><br>

                    <input type="submit" value="Confirm Booking" name="confirm" class="button"><br>
                    <input type="submit" value="Clear" name="clear" class="button">
            
                </form>

            </div>
        </div>
    </div>
	
		
        
	 <%@include file="footer.jsp"%>

</body>
</html>
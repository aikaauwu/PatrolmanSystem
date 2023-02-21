<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>


.content2{
    background: #C5DEDC;
	margin-top: 1px;
	width: 1070px;
	padding: 20px;
	margin-left: 150px;
	height: 600px;
	color:white;
	position: relative;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.content2 h1{
    color: black;
	text-align: center;
	font-family:'Montserrat Alternates', sans-serif;
	margin-top: 50px;
	letter-spacing: 15px;
}

.wrap{
	position: relative;
	height: 100px;
	margin-top: 60px;
	margin-left: 115px;
}

.card-img {
  display: block;
  width: 30%;
  height: 102px;
  object-fit: cover;
  margin-left: 118px;
  margin-top: 50px;
}

.card{
    width: 350px;
	height: 250px;
    display: inline-table;
	border-radius: 5px;
    background: white;
    box-shadow: 5px 5px 15px rgba(0,0,0,0.9);
    text-align: center;
	margin: 30px;
	transition: transform0.5s;
	cursor: pointer;
}
.card:hover{
    transform: translateY(-10px);
}
.card1 h3{
    font-family: 'Quicksand', sans-serif;
	text-align:center;
	color: #737373;
	letter-spacing: 5px;
}

.card2 h3{
    font-family: 'Quicksand', sans-serif;
	text-align:center;
	color: #737373;
	letter-spacing: 5px;
}
.card3 h3{
    font-family: 'Quicksand', sans-serif;
	text-align:center;
	color: #737373;
	letter-spacing: 5px;
	
}
a:link, a:visited {
  background-color: #7393B3;
  color: black;
  border: 2px solid #bfbfbf;
  padding: 15px 3px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  

}

a:hover, a:active {
  background-color: #7ADBD3;
  color: white;
}
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #7393B3;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 10px;
  text-decoration: none;
  font-size: 15px; 
  line-height: 10px;
  border-radius: 10px;
  
}
a:link, a:visited {
  background-color: #7393B3;
  color: black;
  border: 2px solid #7393B3;
  padding: 15px 3px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  

}

a:hover, a:active {
  background-color: #7ADBD3;
  color: white;
}


.header-right {
  float: right;
  cursor: pointer;
}




</style>
</head>
<body style="margin:0; padding:0; font-family:Arial;background-color:#7393B3;">
   
<div class="header">

  <div class="header-right">
  Welcome, <%=request.getAttribute("residentUsername") %> 
    <a href="ResidentViewProfileServlet?residentUsername=<%=request.getAttribute("residentUsername") %> ">PROFILE</a>
    <a href="index.jsp">LOGOUT</a>
    
  

  </div>
</div>
 

<div id="top" class="content2" style = "centre">
	    <h1><b>. RESIDENT  .</b></h1>
		    <div class="wrap">
                <div class = "card card1">
			        <b href="PSchedule.html"><img class="card-img" src="img/calander img.png" alt="SCHEDULE" /></b>
		            <h3>SCHEDULE</h3>
		
				<a href="res viewSchedule.jsp" target="_blank">View Schedule</a>
				<hr>.</hr>
				
				

		        </div>
				
		        <div class = "card card2">
			        <b href="PReport.html"><img class="card-img" src="img/report p.png" alt="REPORT" /></b>
			        <h3>REPORT</h3>
				
					<a href="res viewReport.jsp" target="_blank">View Report</a>
					<hr>.</hr>
				
		        </div>
				
		   </div> 	   
	</div>

</div>
</body>
</html>
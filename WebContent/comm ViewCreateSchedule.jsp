<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.top{
    border: none;
    padding-top: 10px;
    height: 10%;

	
}

.navbar{
	width: 100%;
	margin: auto;
	display: flex;
	align-items: center;
	justify-content: space-between;	
	background-color: #A1B1F8;
	margin-top:-10px;
	height: 80px;
	
    
}
.nav-logo img{
	width: 200px;
	cursor: pointer;
   
}
.content img{
    margin-left: 200;
	margin-top: 100px;
	
}
.container{
  background: #A1B1F8;
  width: 1325px;
  height: 500px;
  padding: 30px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  margin-left: 10px;
  margin-top: 50px;
}
.container .text{
  font-size: 35px;
  font-weight: 600;
  text-align: center;
  font-family: 'Montserrat', sans-serif;
  text-transform:uppercase;
}
.container form{
  margin-top: 0px;
}
.container form .data{
  height: 45px;
  width: 100%;
  margin: 40px 0;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
.button {
  border: none;
  color: white;
  padding: 8px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {background-color: #FE4E27;} /* Green */

form .btn{
  margin: 30px 0;
  height: 45px;
  width: 100%;
  position: relative;
}
form .btn button{
    border: none;
	border-radius:5px;
	padding: 10px 195px;
	position: absolute;
	text-align: center;
	font-size:20px;
	text-transform: uppercase;
	transition-duration: 0.5s;
	cursor: pointer;
	background-color: 	#FF1D39 ;
	border: 2px solid #bfbfbf;
	color: white;
	letter-spacing: 3px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
form .btn:hover button{
    background-color: #94948F;
	border: 2px solid white;
}


.btn-group button {
  background-color: #728FCE; /* Green background */
  border: 1px solid white; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon ajax*/
  float: left; /* Float the buttons side by side ajax*/

}

</style>
</head>
<body style="margin:0; padding:0; font-family:Arial;background-color:white;">
    <div class="top">
			<div class="navbar">
			    <div class="nav-logo" style="margin-left: 10%; margin-top: 1%;">
		          
			    </div>
				
				<a href="HOMEPAGE COM.jsp"><img style="margin-left: -100px;" src="img/logout.png"></a>
			</div>
			
			<div class="center">
	
         
  <div class="imgcontainer">
<div class="container">
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
       <h2>CREATE SCHEDULE</h2>

<table>
  <tr>
     <th>ID</th>
	<th>Username</th>
    <th>Schedule ID</th>
    <th>Time</th>
	<th>Date</th>
	<th>Action</th>	  
  </tr>
  <tr>
    <td>-</td>
    <td>-</td>
    <td>-</td>
	 <td>-</td>
	 <td>-</td>
	   <td><a href="comm CreateSchedule.jsp" class="button button1"><b>CREATE </b></a></td>
  </tr>
  <tr>
    <td>-</td>
    <td>-</td>
    <td>-</td>
	 <td>-</td>
	 <td>-</td>
	   <td><a href="comm CreateSchedule.jsp" class="button button1"><b>CREATE </b></a></td>
	 
	
	 
  </tr>
 
</table>
</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

.container{
  background: #fff;
  width: 470px;
  height: 550px;
  padding: 30px;
  position: absolute;
  top: 10%;
  left: -10%;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  margin-left: 500px;
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
form .data label{
  font-size: 20px;
  font-family: 'Encode Sans SC', sans-serif;
}
form .data input{
  height: 100%;
  width: 100%;
  padding-left: 10px;
  font-size: 17px;
  border: 1px solid silver;
}
form .data input:focus{
  border-color: #3498db;
  border-bottom-width: 2px;
}
form .btn{
  margin: 30px 0;
  height: 15px;
  width: 100%;
  position: relative;
}
form .btn button{
    border: none;
	border-radius:5px;
	height: 35px;
  	width:50%;
	position: absolute;
  	left: 120px;
 	top: 20px;
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

.btn-group button {
  background-color: #728FCE; 
  border: 1px solid white; 
  color: white; 
  padding: 10px 24px; 
  cursor: pointer; 
  float: left; 

}

.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

.btn-group button:hover {
  background-color: #D5D6EA;
}
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;

a {text-decoration:none;}
</style>

</head>
<body style="margin:0; padding:0; font-family:Arial;background-color:#6667AB;">
    <div class="top">
			<div class="navbar">
			    <div class="nav-logo" style="margin-left: 10%; margin-top: 1%;">
		          
			    </div>
				
				<a href="HOMEPAGE COM.jsp"><img style="margin-left: -100px;" src="img/logout.png"></a>
			</div>
	<div class="center">
	
         <div class="container">
	      <a href="HOMEPAGE COM.jsp"><img src="img/close.png"></a>
		 
            <div class="text"><b>CREATE PATROLMAN</b></div>
			<div id="frmRegistration">
            <form action="CreatePatrolmanServlet">
			<div class="hero">
			
			<form action="CreatePatrolmanServlet" method="post">
  <div class="imgcontainer">
  </div>


			<div class="data">
                  <label>Patrolman ID:</label> 
                  <input type="text" name = "patrolmanId" required>			  
               </div>
			
               <div class="data">
                  <label>Resident ID:</label> 	
                  <input type="text" name = "residentId" required>				  
               </div>
			   
               <div class="data">
                  <label>Username:</label>  
                  <input type="text" name = "patrolmanUsername" required> 					
               </div>
               
			   <div class="data">
                  <label>Password:</label>    
					<input type="password" name = "patrolmanPassword" required>
               </div>
			  
               <div class="btn">
                 <button type="submit" ><b>SUBMIT</b></button>
               </div>
               
               <div class="btn">
               	 <button type="reset"> <b>CLEAR</b></button>
               </div>
			   
            </form>
			</div>
         </div>
      </div>
			
</body>

</html>
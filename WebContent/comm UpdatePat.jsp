<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>


<head>
<script>
function validate(){
	if (document.form.residentName.value == ""){
	alert ( "Please fill in the name" );
	document.loginform.userName.focus();
	return false;
	}
	if (document.form.residentPhoneNum.value == ""){
	alert ( "Please fill in the phone number." );
	document.userform.password.focus();
	return false;
	}
	if (document.form.residentAddress.value == ""){
		alert ( "Please fill in the address." );
		document.userform.password.focus();
		return false;
		}
	if (document.form.residentEmail.value == ""){
		alert ( "Please fill in the email." );
		document.userform.password.focus();
		return false;
		}
	if (document.form.residentUsername.value == ""){
		alert ( "Please fill in the username." );
		document.userform.password.focus();
		return false;
		}
	if (document.form.residentPassword.value == ""){
		alert ( "Please fill in the password." );
		document.userform.password.focus();
		return false;
		}
	alert ( "Successfully Updated" );
	return true;
	}

</script>

<meta charset="ISO-8859-1">
<style>
.container{
  background: #fff;
  width: 470px;
  height: 800px;
  padding: 30px;
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
  height: 45px;
  width: 100%;
  position: relative;
}
form .btn button{
    border: none;
	border-radius:5px;
	padding: 10px 190px;
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



.btn-group button {
  background-color: #728FCE; /* Green background */
  border: 1px solid white; /* Green border */
  color: white; /* White text */
  padding: 10px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: left; /* Float the buttons side by side */

}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}



/* Add a background color on hover */
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

    <div class="center">
	
         <div class="container">
	      <a href="ListPatrolmanControllerUpdate"><img src="img/close.png"></a>
		 
            <div class="text"><b>Update Patrolman Profile</b></div>
			<div id="frmRegistration">
			<div class="hero">
			
			<form name = "form" action="UpdatePatrolman" method="post" onsubmit="return validate()">
  <div class="imgcontainer">
  </div>


			<div class="data">
                  <label>Patrolman ID: 
                  <input type="text" name="patrolmanId" value="<c:out value="${patrolman.patrolmanId}"/>"/></label> 			  
               </div>
			
               <div class="data">
                  <label>Resident ID:
                  <input type="text" name="residentId" value="<c:out value="${patrolman.residentId}"/>"/></label> 			  
               </div>
			   
               <div class="data">
                  <label>Username:
                  <input type="text" name="patrolmanUsername" value="<c:out value="${patrolman.patrolmanUsername}"/>"/></label>   
				
               </div>
			   <div class="data">
                  <label>Password:</label>    
					<input type="text" name="patrolmanPassword" value="<c:out value="${patrolman.patrolmanPassword}"/>"/>
               </div>
			  
               <div class="btn">
                 <button type="submit"><b>DONE</b></button>
               </div>
			   
			   
			  
			   
            </form>
			</div>
         </div>
      </div>
</body>
</html>
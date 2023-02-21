<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.container{
  background: #fff;
  width: 410px;
  height: 700px;
  padding: 30px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  margin-left: 550px;
  margin-top: 80px;
}
.container .text{
  font-size: 35px;
  font-weight: 600;
  text-align: center;
  font-family: 'Montserrat', sans-serif;
  text-transform:uppercase;
}
.container form{
  margin-top: -20px;
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
	padding: 10px 140px;
	position: absolute;
	text-align: center;
	font-size:20px;
	text-transform: uppercase;
	transition-duration: 0.5s;
	cursor: pointer;
	background-color: #7393B3;
	border: 2px solid #bfbfbf;
	color: white;
	letter-spacing: 3px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
form .btn:hover button{
    background-color: #7ADBD3;
	border: 2px solid white;

}

</style>
</head>
<body style="margin:0; padding:0; font-family:Arial;background-color:#7393B3;">
    <div class="center">
         <div class="container">
		 <a href="login res.jsp"><img src="img/close.png"></a>
            <div class="text"><b>sign Up </b></div>
            <form action="CreateResidentServlet" method="post">
            
            <div class="data">
                  <label>Resident Id:</label>
                  <input type="number" name="residentId" >
               </div>
               
			   <div class="data">
                  <label>Name</label>
                  <input type="text" name="residentName" required>
               </div>
               <div class="data">
                  <label>Phone Number</label>
                  <input type="number" name="residentPhoneNum"  required>
               </div>
               <div class="data">
                  <label>Address</label>
                  <input type="text" name="residentAddress"  required>
               </div>
			   <div class="data">
                  <label>Email</label>
                  <input type="email" name="residentEmail"  required>
               </div>
			   <div class="data">
                  <label>Username</label>
                  <input type="text" name="residentUsername" required>
               </div>
			   <div class="data">
                  <label>Password</label>
                  <input type="password" name="residentPassword"  required>
               </div>
		
               <div class="btn">
                  <button type="submit" name="login"><b>Register</b></button>
               </div>
            </form>
         </div>
      </div>
      
     
</body>
</html>
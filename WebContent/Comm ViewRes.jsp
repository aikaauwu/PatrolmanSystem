<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>
</head>
<body style="margin:0; padding:0; font-family:Arial;background-color:white;">
    <div class="top">
			<div class="navbar">
			
			    <div class="nav-logo" style="margin-left: 10%; margin-top: 1%;">
		          
			    </div>
				
				<a href="HOMEPAGE COM.jsp"><img style="margin-left: -100px;" src="img/logout.png"></a>
			</div>
			
	</div>
			
			
	<div class="center">
	
         
  		<div class="imgcontainer">
				<div class="container">
 				<div class="row">
    			<div class="col-12">
     
     	 <table class="table table-bordered">
       
       <h2>VIEW RESIDENTS</h2>

			<table>
							<tr>
								<th>Resident Id</th>
								<th>Name</th>
								<th>Address</th>
								<th>Email</th>
								<th>UserName</th>
								<th>Password</th>
								<th>Phone Number</th>
								<th colspan="3"></th>
							</tr>
							<c:forEach items="${residents}" var="resident">
								<tr>
									<td><c:out value="${resident.residentId}" /></td>
									<td><c:out value="${resident.residentName}" /></td>
									<td><c:out value="${resident.residentAddress}" /></td>
									<td><c:out value="${resident.residentEmail}" /></td>
									<td><c:out value="${resident.residentUsername}" /></td>
									<td><c:out value="${resident.residentPassword}" /></td>
									<td><c:out value="${resident.residentPhoneNum}" /></td>
									<td><a href="CommViewResidentDetailServlet?action=view&residentId=<c:out value="${resident.residentId}"/>" class="button">View</a></td>
							</c:forEach>
			</table>
			
			</table>	
			
			
						
			</div>
					</div>
					</div>
				</div>
				</div>
</body>
</html>
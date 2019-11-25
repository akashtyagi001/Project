<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Allocation </title>

</head>

<body>
<div class="jumbotron">
  <h1>ABC COMPANY</h1>
  <h3 align="center">ALLOCATION PAGE</h3>
  </div>

<%--<hr/>

		<div align="center">

		<h1 style="text-align: center;font-family: verdana;color:#000080">Allocate Here! </h1>

		

		<core:if test="${not empty msg}">

		<div style="text-align: center;font-family: verdana;color:#000080" class="alert alert-success">${msg}

		</div>

		</core:if>

		

		

		<hr/>
--%>
<form action="submitAllocate"  method="get">

				<label>Projects:</label>

			<select name="projectId" class="form-control">

			 	 <core:forEach items="${proj}" var="pOb">

					<option value="${pOb.projectId}">${pOb.projectName}</option>

				 </core:forEach>

			</select><br>

 			<div>

			<label>Role:</label>

				<select name="roleId" class="form-control">

				 	 <core:forEach items="${role}" var="rOb">

						<option value="${rOb.roleId}">${rOb.roleName} </option>

					 </core:forEach>

				</select><br>

			</div>
			
			

			
			
			

 		<label>Location:</label>

			<div>

				<div class="custom-control custom-radio" class="form-control">	

					 <input type="radio" name="location" value="Onsite" checked> Onsite<br>

 					 <input type="radio" name="location" value="Offshore"> Offshore<br>

					

					

					

				</div>

			</div>	

			<label>Employee:</label>

			<select name="employeeId" class="form-control">

			  

				 	 <core:forEach items="${dObj}" var="EOb">

						<option value="${EOb.employeeId}">${EOb.employeeName} </option>

					 </core:forEach>

				</select><br>

				

			</div>

				<div class="form-group" class="form-control">

				    <button type="submit" class="btn btn-primary">Submit</button>

				 </div>

			</form>
			<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #D49292;
   color: white;
   text-align: center;
}
</style>
<div class="footer">
  <p>© 2019 Copyright:ABC COMPANY</p>
</div>

</body>

</html>
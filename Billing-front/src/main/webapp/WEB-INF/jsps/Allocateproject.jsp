<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Allocation </title>

</head>

<body>

<form action="Allocation"  method="get">

				<label>Projects:</label>

			<select name="projectId">

			 	 <core:forEach items="${proj}" var="pOb">

					<option value="${pOb.proID}">${pOb.name}</option>

				 </core:forEach>

			</select><br>

 			<div>

			<label>Role:</label>

				<select name="roleId">

				 	 <core:forEach items="${role}" var="rOb">

						<option value="${rOb.roleID}">${rOb.roleName} </option>

					 </core:forEach>

				</select><br>

			</div>

 		<label>Location:</label>

			<div>

				<div class="custom-control custom-radio">	

					 <input type="radio" name="location" value="Onsite" checked> Onsite<br>

  <input type="radio" name="location" value="Offshore"> Offshore<br>

	</div>

			</div>	

			<label>Role:</label>

			<select name="devId">

			  

				 	 <core:forEach items="${dObj}" var="rOb">

						<option value="${rOb.devId}">${rOb.name} </option>

					 </core:forEach>

				</select><br>

				

			</div>

				<div class="form-group">

				    <button type="submit" class="btn btn-primary">Submit</button>

				 </div>

			</form>

</body>

</html>
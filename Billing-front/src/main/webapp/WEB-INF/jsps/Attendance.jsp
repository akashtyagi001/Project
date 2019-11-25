<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Attendance</title>

</head>
<body>
<div class="jumbotron">
  <h1>ABC COMPANY</h1>
  <h3 >ATTENDANCE PAGE</h3>
  </div>
<f:form action="submitAttendance" modelAttribute="dataObj" method="get">
<div>
<label>Projects:</label>
			<f:select path="ProjObj.projectId" class="form-control">
            <core:forEach items="${proj}" var="pOb">
            <f:option value="${pOb.projectId}">${pOb.projectName}</f:option>
             </core:forEach>
             
             </f:select><br>
             
             </div>
             
             <div>
		<label>Employee Name :</label>
		<f:select path="EmpObj.employeeId" class="form-control">
 	 		<core:forEach items="${dObj}" var="dOb">
 	 			<f:option value="${dOb.employeeId}">${dOb.employeeName}</f:option>
			</core:forEach>
		</f:select><br>
		</div>
		
		<div>
		<label>Month :</label>
		<f:select path="month" class="form-control" required="true" >
		<f:option value="january">January</f:option>
			<f:option value="february">February</f:option>
			<f:option value="march">March</f:option>
			<f:option value="april">April</f:option>
			<f:option value="may">May</f:option>
			<f:option value="june">June</f:option>
			<f:option value="july">July</f:option>
			<f:option value="august">August</f:option>
			<f:option value="september">September</f:option>
			<f:option value="october">October</f:option>
			<f:option value="november">November</f:option>
			<f:option value="december">December</f:option>
		</f:select>
		<br>
		</div>
		
		<div>
		<label>Year :</label>
		<f:select path="year" id="year" class="form-control" required="true">
			<f:option value="0">Select year</f:option>
		</f:select>
		
		<script type="text/javascript">
			for(y=2015;y<2029;y++){
				var optn = document.createElement("OPTION");
				optn.text=y;
				optn.value=y;
				
				if(y==2019){
					optn.selected=true;
				}
				document.getElementById('year').options.add(optn);
			}
		</script>
		</div>
		<br>
		<div>
		<label>Half day:</label>
		<f:input path="halfDay" size="30" class="form-control" placeholder="Enter Number of Half Days" required="true"/><br>
		</div>
		
		<div>	
			<label>Full Day:</label>
			<f:input path="fullDay" size="30" class="form-control" placeholder="Enter Number of Full Days" required="true"/><br>
		</div>
		
		<div class="form-group">
		    <button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</f:form>
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

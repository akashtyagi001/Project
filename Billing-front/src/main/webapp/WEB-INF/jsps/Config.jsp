<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>

    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Configure</title>

</head>

<body>
<core:if test="${not empty msg}">

	    		<div class="alert alert-success">

	    			${msg}

	    		</div>

    		</core:if>	

    		<core:if test="${not empty errorMsg}">

	    		<div class="alert alert-danger">

	    			${errorMsg}

	    		</div>

    		</core:if>	
<h1>WELCOME TO CONFIGURE PAGE</h1>

 <f:form action="ProjectConfig" modelAttribute="pObj" method="get" id="projectform">

 			<label>Projects:</label>

			<f:select path="ProjObj.projectId" >

			 	 <core:forEach items="${proj}" var="pOb">

					<f:option value="${pOb.projectId}">${pOb.projectName}</f:option>

				 </core:forEach>

			</f:select><br>

 			<div>

			<label>Role:</label>

				<f:select path="RoleObj.roleId">

				 	 <core:forEach items="${role}" var="rOb">

						<f:option value="${rOb.roleId}">${rOb.roleName} </f:option>

					 </core:forEach>

				</f:select><br>

			</div>

 		<label>Location:</label>

			<div>

				<div class="custom-control custom-radio">	

					<f:radiobutton path="location" value="Onsite" id="Onsite"/>

					<label  for="Onsite">Onsite</label>

				</div>

				<div class="custom-control custom-radio">

					<f:radiobutton path="location" value="Offshore"  id="Offshore" checked = "checked"/>

					<label  for="Offshore">Offshore</label>

				</div>

			</div>	

 			<br><div >

	    			<label>Per Hour Billing  : </label> <f:input type="number" path="bill" size="30" cssClass="form-control" placeholder="Enter Per Hour Billing" required="required"/>

	    			<f:errors path="bill"></f:errors>			   

			 </div>

			

			<div class="form-group">

			    <button type="submit" class="btn btn-primary">Submit</button>

			 </div>

 

 </f:form>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgAllFieldsRequired" code="newUserRegistration.message.allFieldsRequired" />
<spring:message var="pageTitle" code="newUserRegistration.pageTitle" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style/assets/reg.css" />
		<link rel="stylesheet" type="text/css" href="style/lib/Bootstrap/bootstrap.min.css" />
		<title>Insert title here</title>
	</head>
	<body class = "body">
		<div class = "menu">
			
				<form:form action="users" modelAttribute="account">
					<h3>Rejestracja nowego uzytkownika</h3>
					<form:errors path="*">
						<div id = "error_global"><spring:message code="error.global" /></div>
					</form:errors>
					<center><table>	
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.username" /></td>
							<td><form:input path="username" /></td>
						</tr>
						<div id= "error_username"><form:errors path="username" htmlEscape="false" /></div>
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.password" /></td>
							<td><form:password path="password" /></td>
						</tr>
						<div id = "error_password"><form:errors path="password" htmlEscape="false" /></div>
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.confirmPassword" /></td>
							<td><form:password path="confirmPassword" /></td>
						</tr>
						<div id = "error_confirmPassword"><form:errors path="confirmPassword" htmlEscape="false" /></div>
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.email" /></td>
							<td><form:input path="email" /></td>
						</tr>
						<div id = "error_email"><form:errors path="email" htmlEscape="false" /></div>
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.firstName" /></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<div id = "error_firstName"><form:errors path="firstName" htmlEscape="false" /></div>
						<tr>
							<td align="right"><spring:message code="newUserRegistration.label.lastName" /></td>
							<td><form:input path="lastName" /></td>
						</tr>
					</table></center>
					<div id= "error_lastName"><form:errors path="lastName" htmlEscape="false" /></div>
					
						<div><form:checkbox id="marketingOk" path="marketingOk" />Wysylaj mi informacje o produkcie</div>
						<div><form:checkbox id="acceptTerms" path="acceptTerms" />Zgadzam sie z warunkami korzystania z serwisu</div>
						<div id = "error_acceptTerms"><form:errors path="acceptTerms" htmlEscape="false" /></div>
						<div><input type="submit" class="btn btn-primary" value="Zarejestruj" /></div>
	
					
				</form:form>
				</br>
		</div>
	
	</body>
</html>
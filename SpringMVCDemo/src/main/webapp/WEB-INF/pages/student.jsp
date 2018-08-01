<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>

<body>

Welcome ${userName} -----------------<a href="/logout">Logout</a><br/>

<form:form action="/student/addStudent" method="POST" modelAttribute="student">
    	Name : <form:input path="name"/><form:errors path="name"/><br/>
        City : <form:input path="city"/><form:errors path="city"/><br/> 
        <input type="submit" value="add" />
    </form:form>
</body>
</html>
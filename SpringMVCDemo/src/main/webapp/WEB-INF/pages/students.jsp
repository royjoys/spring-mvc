<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>

<body>
Welcome ${userName} -----------------<a href="/logout">Logout</a><br/>

    <table border="1">
    	<thead>
    		<tr>
    			<th>Name</th>
    			<th>City</th>
    		</tr>
    	</thead>
    	<tbody>
	    	<c:forEach items="${students}" var="student">
	    		<tr>
	    			<td>${student.name}</td>
	    			<td>${student.city}</td>
	    		</tr>
    		</c:forEach>
    	</tbody>
    </table>

<br/>
<a href="/student/addStudent">Add Student</a>
</body>
</html>
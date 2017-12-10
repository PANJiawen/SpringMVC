<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:useBean id="group" scope="request" class="devoir.copy.Group"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new user</title>
</head>
	<body>	<p>Please</p>
			<form action="newuser" method="get">
			<p>
       			<label for="id">Enter the ID</label>
        		<input type="number" name="id" size="30" maxlength="10" />
    		</p>
    		<p>
        		<label for="pw">Enter the password</label>
        		<input type="password" name="pw" size="30" maxlength="10" />
    		</p>	
				<input type="submit" name="boutonOK" value="Valider"/>
			</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Want a person ?</title>
</head>
<body>
	<form action="login" method="get">
	<h1>please</h1>
	
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
	
	<form action="inscrir" method="get">
		<input type="submit" name="bouton" value="s'inscrir"/>
	</form>

</body>
</html>
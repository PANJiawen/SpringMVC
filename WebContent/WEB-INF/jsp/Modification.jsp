<%@ page pageEncoding="UTF-8"%>

<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"
%>

<jsp:useBean id="person" scope="request" class="devoir.copy.Person"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="apparence/formulaireCSS.css" />
</head>
<body>
	<% 
		int personid = (int)session.getAttribute("personid");		
        out.print(" welcome person :" + personid);
    %>
	
	
	
	

	<form action="person" method="post">
	<p>
        <label for="id">Enter the ID</label>
        <input type="text" name="id" size="30" maxlength="10" />
    </p>
	
	<input type="submit" name="boutonOK" value="Valider"/>
	</form>
	
	<p>person id : 
		

		<%= person.getId() %>
	</p>group id : 
		<p>
		<%= person.getIdg() %>
	</p>
	<p>name :
		<%= person.getName() %>
	</p>
	<p>first name :
		<%= person.getNamep() %>
	</p>
	<p>sit web :
		<%= person.getSitW() %>
	</p>
	<p>mail : 
		<%= person.getMail() %>
	</p>
	<p> birthday : 
		<%= person.getDateN() %>
	</p>

	<form action="save" method="post">
	<input type="submit" name="boutonOK" value="save"/>
	</form>

	
	<form action="loginout" method="post">
	<input type="submit" name="boutonOK" value="Login out"/>
	</form>
	
	
</body>
</html>
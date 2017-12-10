<%@ page pageEncoding="UTF-8"%>

<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"
%>

<jsp:useBean id="group" scope="request" class="devoir.copy.Group"></jsp:useBean>
<jsp:useBean id="person" scope="request" class="devoir.copy.Person"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
        <title>Home</title>
        <link type="text/css" rel="stylesheet" href="apparence/formulaireCSS.css" />
</head>
<body>
	<% 
		long personid = (Long)session.getAttribute("personid");		
        out.print(" welcome person :" + personid);
    %>
	
	
	<form action="group" method="post">
	<p>
        <label for="id">Enter the ID</label>
        <input type="text" name="id" size="30" maxlength="10" />
    </p>
	
	<input type="submit" name="boutonOK" value="Valider"/>	
	</form>
	
	<p>this is a group
		<%= group.getIdg() %>
	</p>
		<p>this is a group
		<%= group.getName() %>
	</p>
	
	<form action="person" method="post">
	<p>
        <label for="id">Enter the ID</label>
        <input type="text" name="id" size="30" maxlength="10" />
    </p>
	
	<input type="submit" name="boutonOK" value="Valider"/>
	</form>
	
	<p>person id : 
		<%= person.getId() %>
	</p> 
		<p>group id :
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



	<form action="personlist" method="post">
	<p>
        <label for="id">Enter the ID</label>
        <input type="text" name="id" size="30" maxlength="10" />
    </p>
	
	<input type="submit" name="boutonOK" value="Valider"/>
	</form>
	
	<c:forEach var="person" items="${persons}">
	<li>This is a person with ${person}</li>
	</c:forEach>
	
	<form action="modification" method="post">
	<input type="submit" name="boutonOK" value="modification"/>
	</form>
	
	
	<form action="loginout" method="post">
	<input type="submit" name="boutonOK" value="Login out"/>
	</form>
	
	
</body>
</html>
<%@ page pageEncoding="UTF-8"%>

<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"
%>
<jsp:useBean id="user" scope="request" class="devoir.copy.User"></jsp:useBean>
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
		long userid = (long)session.getAttribute("userid");		
        out.print(" welcome user :" + userid);
    %>
	
	<h1>Please</h1>>
	<form action="group2" method="post">
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
	
	<form action="person2" method="post">
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

	<form action="personlist2" method="post">
	<p>
        <label for="id">Enter the ID</label>
        <input type="number" name="id" size="30" maxlength="10" />
    </p>
	
	<input type="submit" name="boutonOK" value="Valider"/>
	</form>
	
	<c:forEach var="person" items="${persons}">
	<li>This is a person with${person}</li>
	</c:forEach>

	<form action="loginout" method="post">
	<input type="submit" name="boutonOK" value="Login out"/>
	</form>
	
	
</body>
</html>
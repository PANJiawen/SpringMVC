<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:url var="edit" value="/actions/devoir/connection" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new user</title>
</head>
<body>
	<form action="edition" method="post">
    <p>
        <label for="num">Votre Num onegai :</label>
        <input type="text" name="num" size="30" maxlength="10" />
    </p>
    <p>
        <label for="p">Votre Prenon onega :</label>
        <input type="text" name="p" size="30" maxlength="10" />
    </p>
    <p>
        <label for="n">Votre Nom onegai :</label>
        <input type="text" name="n" size="30" maxlength="10" />
    </p>
    <p>
        <label for="dt">Votre Date de naissance :</label>
        <input type="text" name="dt" size="30" maxlength="10" />
    </p>
    <p>
        <label for="ml">Votre Mail pour finir :</label>
        <input type="text" name="ml" size="30" maxlength="10" />
    </p>
    <input type="submit" name="boutonOK" value="Valider"/>
    <!--<input type="submit" name="boutonOK" value="Valider" />-->
    
	</form>
</body>
</html>

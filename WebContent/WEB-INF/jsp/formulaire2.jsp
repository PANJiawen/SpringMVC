<%@ page pageEncoding="UTF-8"%>

<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"
%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<jsp:useBean id="person" scope="request" class="devoir.copy.Person"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
		
		<meta charset="utf-8" />
        <title>Modification</title>
        <link type="text/css" rel="stylesheet" href="apparence/formulaireCSS.css" />
</head>
<body>
		<h1>Please</h1>
		<form method="post" action="save">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="idg">Numero de group</label>
                <input type="number" id="idg" name="idg" value="${person.getIdg()}" size="20" maxlength="20" />
				<br />
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="${person.getName()}" size="20" maxlength="20" />
				<br />
				<label for="prenom">PreNom d'utilisateur</label>
                <input type="text" id="prenom" name="prenom" value="${person.getNamep()}"  size="20" maxlength="20" />
                <br />
				<label for="daten">Date de N</label>
                <input type="text" id="daten" name="daten" value="${person.getDateN()}"  size="20" maxlength="20" />
                <br />
                
                
                <label for="sitw">Adresse sit-web <span class="requis"></span></label>
                <input type="text" id="sitw" name="sitw" value="${person.getSitW()}" size="20" maxlength="60" />
                <br />
                <label for="email">Adresse email <span class="requis"></span></label>
                <input type="text" id="email" name="email" value="${person.getMail()}" size="20" maxlength="60" />
                <br />
                
                
                
                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="text" id="motdepasse" name="motdepasse" value="${person.getPassword()}" size="20" maxlength="20" />
                <br />          

                <input type="submit" value="Save" class="sansLabel" />
                <br />
                
                
            </fieldset>
        </form>

</body>
</html>
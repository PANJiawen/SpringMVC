<%@ page pageEncoding="UTF-8"%>

<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"
%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="apparence/formulaireCSS.css" />
</head>
<body>
		<form method="post" action="user_inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />
                
                <b> ${form.erreurs['email']} </b>

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />
                
                <b> ${form.erreurs['motdepasse']} </b>

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />
                
                <b> ${form.erreurs['confirmation']} </b>
                
                <label for="prenom">PreNom d'utilisateur</label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />
                
                <b> ${form.erreurs['email']} </b>

                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                
                <b> ${form.erreurs['email']} </b>

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
            </fieldset>
        </form>
        
        <c:if test="${! empty param }">
        	${param}
        </c:if>
        
        <c:import url="pied_de_page.html"/>
</body>
</html>
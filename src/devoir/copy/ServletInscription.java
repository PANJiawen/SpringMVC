package devoir.copy;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInscription
 */

@WebServlet(description = "Charger d'inscrire un nouveau user", urlPatterns = { "/inscription" })
public class ServletInscription extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() 
    {	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		Boolean mail = false;
		Boolean web = false;
		Boolean nom = false;
		Boolean prenom = false;
		Boolean dateN = false;
		Boolean pass = false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setLenient(false);
		
		if(request.getParameter("nom").matches("^([A-Za-z]+)$")) nom = true;
		
		if(request.getParameter("prenom").matches("^([A-Za-z]+)$")) prenom = true;
		
		if(request.getParameter("motdepasse").matches("^([A-Za-z0-9_@]+)$")) pass = true;
		
		if(request.getParameter("mail").matches("^([a-z0-9]+)\\@([a-z0-9]+)\\.([a-z]){2,4}$")) mail = true;
		
		if(request.getParameter("web").matches("^(www\\.){0,1}([a-z0-9])+\\.([a-z]+)$")) web = true;
		
		//if(request.getParameter("date").matches("^([a-z0-9]+)\\@([a-z0-9]+)\\.([a-z]){2,4}$")) nom = true;
		
		// TEST A FAIRE - DATE < DATE ACTUELLE + MOI <= 12 et jour <= 31
		try {
			Date javaDate = sdf.parse(request.getParameter("date"));
			dateN = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			dateN = false;
		}
		
		
	    
	 }
		
}



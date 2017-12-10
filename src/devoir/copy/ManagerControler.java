package devoir.copy;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/devoir")
public class ManagerControler
{

   @Autowired
    IDirectoryManager manager;
   @Autowired
   	ITools tools;

    protected final Log logger = LogFactory.getLog(getClass());
    
    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public ModelAndView group(HttpServletRequest req, HttpServletResponse rep) {
        logger.info("find out a group with idg for person");
        if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
        long id = Long.parseLong(req.getParameter("id"));          
        Group group = manager.findGroup(id);
        return new ModelAndView("PersonHome", "group", group);
        }
        return new ModelAndView("PersonHome2");
    }
    
    @RequestMapping(value = "/group2", method = RequestMethod.POST)
    public ModelAndView group2(HttpServletRequest req, HttpServletResponse rep) {
        logger.info("find out a group with idg");
        if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
        long id = Long.parseLong(req.getParameter("id"));          
        Group group = manager.findGroup(id);
        return new ModelAndView("UserHome", "group", group);
        }
        return new ModelAndView("UserHome2");
    }
    
    @RequestMapping(value = "/person",method = RequestMethod.POST)
    public ModelAndView Person(HttpServletRequest req, HttpServletResponse rep) 
    {
    	
    	logger.info("find out a person with idp for a person");
    	if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
    	long id = Long.parseLong(req.getParameter("id"));
    	Person person = manager.findPerson(id);
    	return new ModelAndView("PersonHome", "person", person);
    	}
    	return new ModelAndView("PersonHome2");
    }
    
    @RequestMapping(value = "/person2",method = RequestMethod.POST)
    public ModelAndView Person2(HttpServletRequest req, HttpServletResponse rep) 
    {
    	
    	logger.info("find out a person with idp for a user");
    	if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
    	long id = Long.parseLong(req.getParameter("id"));
    	Person person = manager.findPerson(id);
    	return new ModelAndView("UserHome", "person", person);
    	}
    	return new ModelAndView("UserHome2");
    }
    
    
    // à modifier
    @RequestMapping(value = "/personlist",method = RequestMethod.POST)
    public ModelAndView PersonList(HttpServletRequest req, HttpServletResponse rep) 
    {

    	logger.info("find out all person with idg for a person");
    	if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
    	HttpSession session = req.getSession();
    	long id = Long.parseLong(req.getParameter("id"));
    	long idp = (long) session.getAttribute("personid");
    	Collection<Person> persons = manager.findAllPersons(idp,id); 	
    	return new ModelAndView("PersonHome", "persons", persons);
    	}
    	return new ModelAndView("PersonHome2");
    }
    
    @RequestMapping(value = "/personlist2",method = RequestMethod.POST)
    public ModelAndView PersonList2(HttpServletRequest req, HttpServletResponse rep) 
    {

    	logger.info("find out all person with idg for a user");
    	if ((req.getParameter("id") != "")&&(!tools.checkE(req.getParameter("id")))) {
    	HttpSession session = req.getSession();
    	long id = Long.parseLong(req.getParameter("id"));
    	long idp = (long) session.getAttribute("personid");
    	Collection<Person> persons = manager.findAllPersons(idp,id); 	
    	return new ModelAndView("UserHome", "persons", persons);
    	}
    	return new ModelAndView("UserHome2");
    }
    
    
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView Login(HttpServletRequest req, HttpServletResponse rep) throws IOException 
    {	
    	
    	logger.info("do the login");
    	boolean bb=(req.getParameter("id") != "");
    	boolean bbb=(req.getParameter("pw") != "");
    	boolean bbbb=(tools.checkE(req.getParameter("id")));
    	System.out.println(bb);
    	System.out.println(bbb);
    	System.out.println(bbbb);
    	boolean b=((req.getParameter("id") != "")&&(req.getParameter("pw") != "")&&(tools.checkE(req.getParameter("id"))));
    	System.out.println(b);
    	if ((req.getParameter("id") != "")&&(req.getParameter("pw") != "")&&(!tools.checkE(req.getParameter("id")))) {    		
        	Person p = new Person();
        	User u = new User();
        	long id = Long.parseLong(req.getParameter("id"));
        	String pw = req.getParameter("pw");
        	System.out.println("11111");
        	if(manager.login(id, pw))
        		{	System.out.println("222222");
            		HttpSession session = req.getSession();
            		p.setId(id);
            		System.out.println("444444");
            		session.setAttribute("personid", p.getId());
            		System.out.println("555555");
            		return new ModelAndView("PersonHome");
        		}
        	else if(manager.loginu(id, pw)) 
        		{	System.out.println("3333333");
        			HttpSession session = req.getSession();
        			u.setIdu(id);
        			session.setAttribute("userid", u.getIdu());
        			return new ModelAndView("UserHome");
        		}
         	
        	}else return new ModelAndView("ViewLogin");

			return new ModelAndView("ViewLogin");


    }
    

    @RequestMapping(value = "/loginout",method = RequestMethod.POST)
    public ModelAndView Loginout(HttpServletRequest req, HttpServletResponse rep) throws IOException 
    {
    	logger.info("do the login out");
    	HttpSession session = req.getSession();
    	session.invalidate();
    	return new ModelAndView("ViewLogin2");
    }
    
    
    
    @RequestMapping(value = "/modification",method = RequestMethod.POST)
    public ModelAndView Modification(HttpServletRequest req, HttpServletResponse rep) 
    {
    	
    	logger.info("Doing modification");
    	HttpSession session = req.getSession();
    	long id = (long) session.getAttribute("personid");
    	Person person = manager.findPerson(id);
    	return new ModelAndView("formulaire", "person", person);
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView Save(HttpServletRequest req, HttpServletResponse rep) throws ParseException 
    {
    	
    	logger.info("Doing save");
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Person p = new Person();
    	HttpSession session = req.getSession();
    	long id = (long) session.getAttribute("personid");
    	System.out.println(req.getParameter("daten"));
    	
    	if(tools.checkMail(req.getParameter("email"))&&
    			tools.checkIdg(req.getParameter("idg"))&&
    			tools.checkName(req.getParameter("nom"))&&
    			tools.checkPName(req.getParameter("prenom"))&&
    			tools.checkSitW(req.getParameter("sitw"))&&
    			tools.checkPassword(req.getParameter("motdepasse"))   			
    			){   		
    				p = manager.findPerson(id);
    				return new ModelAndView("formulaire2","person", p);
    	}
    	else 
    		{       		
        		p.setId(id);
        		p.setName(req.getParameter("nom"));
        		p.setNamep(req.getParameter("prenom"));
        		p.setIdg(Long.parseLong(req.getParameter("idg"))); 
        		p.setSitW(req.getParameter("sitw"));    	
        		p.setMail(req.getParameter("email"));
        		p.setDateN(new java.sql.Date(formatter.parse(req.getParameter("daten")).getTime()));
        		p.setPassword(req.getParameter("motdepasse"));
        		manager.savePerson(p);
    		}
	
    	return new ModelAndView("PersonHome");
    }
    
    @RequestMapping(value = "/inscrir",method = RequestMethod.GET)
    public ModelAndView Inscrir(HttpServletRequest req, HttpServletResponse rep) 
    { 	
    	logger.info("doing l'inscription");
    	return new ModelAndView("NewUser");
    }
    
    @RequestMapping(value = "/newuser",method = RequestMethod.GET)
    public ModelAndView NewUser(HttpServletRequest req, HttpServletResponse rep) 
    {	
    	
    	logger.info("doing new user");
    	if ((req.getParameter("id") != "")&&(req.getParameter("pw") != "")&&(!tools.checkE(req.getParameter("id")))) {    	
    	long id = Long.parseLong(req.getParameter("id"));
    	String pw = req.getParameter("pw");
    		if(manager.checkID(id))
    		{	
    			manager.newUser(id, pw);
    			return new ModelAndView("ViewLogin2");
    		}
    		
    	}else return new ModelAndView("NewUser2");
    			
    		return new ModelAndView("NewUser2");

    }
    	

    
}
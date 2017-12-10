package devoir.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;


@Service("Tools")
public class Tools implements ITools{
	
    private String url      = "jdbc:mysql://localhost:3306/pan";
    private String user     = "root";
    private String password = "root";
    private String driverName = "com.mysql.jdbc.Driver";
    
    public void init()
    {

    	try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Connection createConnection() throws SQLException
    {
    	Connection c =  DriverManager.getConnection(url, user, password);
    	System.out.println("New connection is on");
		return c;
	}

    public Statement createStatement(Connection conn) throws SQLException 
    {
		return conn.createStatement();
    }
    
    public PreparedStatement createPrepearStatement(Connection conn,String requete) throws SQLException 
    {
		return conn.prepareStatement(requete);
    }

    
	@Override
	public boolean checkID(long id) {
		
		System.out.println("checking id");
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		boolean b = false;
		String requete = "select *  from Personss where id ="+id;
		String requete2 = "select * from User where idu"+id;
	
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			conn = createConnection();
			state = createStatement(conn);
			
			result = state.executeQuery(requete);			
			if(!result.next()) b=true;
			
			result = state.executeQuery(requete2);
			if(!result.next()) b=true;
			
	    	state.close();
	    	result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean checkMail(String mail) {
		boolean b =  true;	
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(mail);
        if (mat.find()) {
            b = false;
        }
		return b;
	}

	@Override
	public boolean checkName(String name) {

		boolean b= false;		
        final String pattern1 = "^([A-Za-z]+)$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(name);
        if (mat.find()) {
            b = true;
        }
		return b;
		
	}

	@Override
	public boolean checkPName(String Pname) {
		boolean b= false;		
        final String pattern1 = "^([A-Za-z]+)$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(Pname);
        if (mat.find()) {
            b = true;
        }
		return b;
	}

	@Override
	public boolean checkIdg(String idg) {
		
		boolean b= false;		
		  for (int i = idg.length();--i>=0;){    
			   if (Character.isDigit(idg.charAt(i))){  
				b=true;
			    return b;  
			   }  
			  }  
		return b;
		
	}

	@Override
	public boolean checkSitW(String sitw) {
		boolean b= true;		
        final String pattern1 = "^(www\\.){0,1}([a-z0-9])+\\.([a-z]+)$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(sitw);
        if (mat.find()) {
            b = false;
        }
		return b;
	}

	@Override
	public boolean checkDateN(String date) {
        boolean b = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            b = false;
        }
        return b;
	}

	@Override
	public boolean checkPassword(String pw) {
		
		boolean b= false;		
        final String pattern1 = "^([A-Za-z0-9_@]+)$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(pw);
        if (mat.find()) {
            b = true;
        }
		return b;
	}
	
	
	@Override
	public boolean checkE (String str) {
		
		boolean b = false;
		b = str.contains("e");
		return b;
		
		}
	@Override
	public boolean checkPageType(long id) {
		System.out.println("checking type of page");
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		boolean b=false;
		String requete = "select *  from Personss where id ="+id;
	
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			conn = createConnection();
			state = createStatement(conn);			
			result = state.executeQuery(requete);			
			b=result.next();					
	    	state.close();
	    	result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	
	}

}

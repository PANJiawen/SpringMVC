package devoir.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.stereotype.Service;

import com.mysql.jdbc.ResultSetMetaData;


import springapp.model.Product;





@Service("ManagerService")
public class ManagerService implements IDirectoryManager{

    private String url      = "jdbc:mysql://localhost:3306/pan";
    private String user     = "root";
    private String password = "root";
    private String driverName = "com.mysql.jdbc.Driver";
	private Map<Integer, Group> groups;
	
	
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
	public Person findPerson(long personId) {
		
		
		Person p = new Person();
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		String requete =  "select * from Personss where idp = "+personId;
		System.out.println("requete = " + requete);
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			
			conn = createConnection();
			state = createStatement(conn);
			result = state.executeQuery(requete);
			
			while (result.next()){
				p.setId(result.getInt(1));
				p.setIdg(result.getInt(2));
				p.setName(result.getString(3));
				p.setNamep(result.getString(4));
				p.setMail(result.getString(5));
				p.setSitW(result.getString(6));
				p.setDateN(result.getDate(7));
				p.setPassword(result.getString(8));
			}
			
	    	state.close();
	    	result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Group findGroup(long groupId) {
		
		Group g = new Group();
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		String requete =  "select * from Groups where idg = "+groupId;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}	
		try {			
			conn = createConnection();
			state = createStatement(conn);
			result = state.executeQuery(requete);
			
			while (result.next()){
						g.setIdg(result.getInt(1));
						g.setName(result.getString(2));
			}
			
	    	state.close();
	    	result.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public Collection<Person> findAllPersons(long personid,long groupId) {
		
		Connection conn = null;
		Statement state = null;
    	Collection<Person> c2 = new ArrayList<Person>();
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSet result = null;
		ResultSetMetaData resultMeta = null;
		String requete =  "select * from Personss where idg = "+groupId;
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			conn = createConnection();
			state = createStatement(conn);
			result = state.executeQuery(requete);
			resultMeta =(ResultSetMetaData) result.getMetaData();
			int columnCount = resultMeta.getColumnCount();
			
			while (result.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
				rowData.put(resultMeta.getColumnName(i), result.getObject(i));
				
				}
				list.add(rowData);
			}
			System.out.println(list);
			c2.addAll((Collection<? extends Person>) list);
	    	state.close();
	    	result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	
	return c2;
	}

	@Override
	public boolean login(long id, String password) {
		
		Connection conn = null;
		Statement state = null;
		ResultSet personresult = null;
		boolean b = false;
		String personrequete =  "select * from personss where idp = "+id+" and pw = \""+password+"\"";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			conn = createConnection();
			state = createStatement(conn);
			personresult = state.executeQuery(personrequete);

			if(personresult.next()) {b=true;}

			state.close();
			personresult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	@Override
	public boolean loginu(long userid, String pw) {
		
		boolean b =false;		
		Connection conn = null;
		Statement state = null;
		ResultSet userresult = null;		
		String requete =  "select * from user where idu = "+userid+" and password = \""+pw+"\"";		

		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			conn = createConnection();
			state = createStatement(conn);
			userresult = state.executeQuery(requete);
			b = userresult.next();
			state.close();
			userresult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	
	/*
	@Override
	public boolean loginu(int personId, String password) {
		
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		boolean b = false;
		String requete =  "select * from Personss where idp = "+personId+" and pw = \""+password+"\"";
		System.out.println(requete);
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn = createConnection();
			state = createStatement(conn);
			result = state.executeQuery(requete);
			b = result.next();
			state.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	*/
	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePerson( Person p) {
		
		Connection conn = null;
		Statement state = null;
		boolean result = false;
		String requete =  "update Personss set idg = "+p.getIdg()+",nomp = \""+
						   p.getName()+"\",pnomp = \""+p.getNamep()+"\",mail = \""+
						   p.getMail()+"\", sitW = \""+p.getSitW()+"\",daten = '"+
						   p.getDateN()+"', pw = \""+p.getPassword()+
						   "\" where idp = "+p.getId();
		System.out.println(requete);
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			conn = createConnection();
			state = createStatement(conn);
			result = state.execute(requete);
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void newUser(long id, String password) {
		
		Connection conn = null;
		Statement state = null;
		boolean result = false;
		User u = new User();
		String requete =  "insert into User values ("+id+", "+password+")"; 
		System.out.println(requete);		
		u.setIdu(id);
		u.setPasswordu(password);

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try 
		{
			conn = createConnection();
			state = createStatement(conn);
			result = state.execute(requete);
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public boolean checkID(long id) {
		
		System.out.println("checking id");
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		boolean b = false;
		String requete = "select *  from Personss where idp ="+id;
		String requete2 = "select * from User where idu ="+id;
		System.out.println(requete);
		System.out.println(requete2);
	
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			
			conn = createConnection();
			state = createStatement(conn);
			
			result = state.executeQuery(requete);			
			if(result.next()) return b;		
			
			result = state.executeQuery(requete2);
			if(result.next()) return b;
			else b=true;
			
	    	state.close();
	    	result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

}

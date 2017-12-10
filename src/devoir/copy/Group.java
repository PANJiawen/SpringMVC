package devoir.copy;

import java.sql.Date;

public class Group {
	private long idg; 
	private String nomg; 

	
	 public Group() {}
	 
	 
	 public long getIdg() 
	 {
		  return idg;
	 }
	 
	 public void setIdg(long idg) 
	 {
		  this.idg = idg;
	 }
	 
	 public String getName() 
	 {
		  return nomg;
	 }
	 
	 public void setName(String nomg) 
	 {
		  this.nomg = nomg;
	 }
	 
}

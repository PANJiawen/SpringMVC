package devoir.copy;

import java.sql.Date;

public class Person 
{
	private long idp;
	private long idg; 
	private String nomp; 
	private String prenomp;
	private Date dateN;
	private String mail; 
	private String sitW; 
	private String password;
	 	 
	 public long getId() 
	 {
		  return idp;
	 }
	 
	 public void setId(long idp) 
	 {
		  this.idp = idp;
	 }
	 
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
		  return nomp;
	 }
	 
	 public void setName(String nom) 
	 {
		  this.nomp = nom;
	 }
	 
	 public String getNamep() 
	 {
		  return prenomp;
	 }
	 
	 public void setNamep(String prenomp) 
	 {
		 this.prenomp = prenomp;
	 }
	 
	 
	 public String getMail() 
	 {
		  return mail;
	 }
	 
	 public void setMail(String mail) {
		  this.mail = mail;
	 }
	 
	 public Date getDateN() 
	 {
		 return dateN;
	 }
	 
	 public void setDateN(Date date) 
	 {
		 this.dateN = date;
	 }
	 
	 public String getSitW() 
	 {
		 return sitW;
	 }
	 
	 public void setSitW(String sitW) 
	 {
		 this.sitW = sitW;
	 }
	 
	 public String getPassword() 
	 {
		 return password;
	 }
	 
	 public void setPassword(String password) 
	 {
		 this.password = password;
	 }
	 
	 public String getString() {
		 return this.getName() + " " + this.getNamep();
	 }
	 
}
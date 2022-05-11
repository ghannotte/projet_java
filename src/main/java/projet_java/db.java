package projet_java;


import java.util.*;
import java.io.File;
import java.io.*;
import java.nio.*;
import java.sql.*;
 

public class db extends init_database implements import_all{
	
	
	 public static void  insert(String[] dbname) {
		         List u =import_csv.creat("dbconfig.csv");
		         String[] a=finder_class.split(u);
		         String uri = "jdbc:mysql://localhost:3306/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false";
				 String query1 = "INSERT INTO assure " + "VALUES ("+dbname[0]+","+"'"+dbname[1]+"'"+","+"'"+dbname[2]+"'"+","+"'"+dbname[3]+"'"+","+"'"+dbname[4]+"'"+","+"'"+dbname[5]+"'"+","+dbname[6]+","+dbname[7]+","+dbname[8]+")";
				 String query2 = "INSERT INTO historic " + "VALUES ("+dbname[6]+","+"'INSERT',"+"'"+dbname[9]+"'"+")";
				 String users= a[1].toString();
				 String mdps= a[2].toString();
				 System.out.println(query1);
				 
				 
				 try(Connection conn = DriverManager.getConnection(uri,users.replaceAll("[\\[\\]]", ""), mdps.replaceAll("[\\[\\]]", ""));
				         Statement stmt = conn.createStatement();
				      ) {		      
				         stmt.executeUpdate(query1.replaceAll("[\\[\\]]", ""));
				         stmt.executeUpdate(query2); 
				      } catch (SQLException e) {
				    	  //e.printStackTrace();
				    	  tool_file.write(dbname,"rejet/rejet_"+dbname[9]+".csv",true);
				    	   
				   }
	 }				 
				 public static void  check(String[] dbname) {
			         List u =import_csv.creat("dbconfig.csv");
			         String[] a=finder_class.split(u);
			         String uri = "jdbc:mysql://localhost:3306/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false";
					 String query1 = "SELECT * FROM assure WHERE ID_Remboursement="+dbname[6];
					 String users= a[1].toString();
					 String mdps= a[2].toString();
					 
					 
					 try(Connection conn = DriverManager.getConnection(uri,users.replaceAll("[\\[\\]]", ""), mdps.replaceAll("[\\[\\]]", ""));
					         Statement stmt = conn.createStatement();
					      ) {		      
						 ResultSet result=  stmt.executeQuery(query1.replaceAll("[\\[\\]]", ""));
						 if(result.next()==false) {
							 db.insert(dbname);
							 
						 }else {
							 db.update(dbname);
							 
						 }
						 
					      } catch (SQLException e) {
					    	  //e.printStackTrace();
					      }
					    	   
					   }
					 public static void  update(String[] dbname) {
				         List u =import_csv.creat("dbconfig.csv");
				         String[] a=finder_class.split(u);
				         String uri = "jdbc:mysql://localhost:3306/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false";
						 String query1 = "UPDATE assure " + "SET Numero_Securite_Sociale='"+dbname[0]+"',"+"Nom='"+dbname[1]+"',Prenom='"+dbname[2]+"',Date_Naissance='"+dbname[3]+"',Numero_Telephone='"+dbname[4]+"',E_Mail='"+dbname[5]+"',Code_Soin='"+dbname[7]+"',Montant_Remboursement='"+dbname[8]+"' WHERE ID_Remboursement="+dbname[6];
						 String query2 = "INSERT INTO historic " + "VALUES ("+dbname[6]+","+"'UPDATE',"+"'"+dbname[9]+"'"+")";
						 String users= a[1].toString();
						 String mdps= a[2].toString();
						 System.out.println(query1);
						 
						 
						 try(Connection conn = DriverManager.getConnection(uri,users.replaceAll("[\\[\\]]", ""), mdps.replaceAll("[\\[\\]]", ""));
						         Statement stmt = conn.createStatement();
						      ) {		      
						         stmt.executeUpdate(query1.replaceAll("[\\[\\]]", ""));
						         stmt.executeUpdate(query2); 
						      } catch (SQLException e) {
						    	  //e.printStackTrace();
						    	  tool_file.write(dbname,"rejet/rejet_"+dbname[9]+".csv",true);
						    	   
						   }
				 
				 	
	 }
 }

package projet_java;


import java.util.*;
import java.io.File;
import java.io.*;
import java.nio.*;
import java.sql.*;
 

public class db extends init_database implements import_all{
	
	
	 public static void  insert(String[] dbname) {
		         List u =import_csv.creat("dbconfig.csv"); //je récupére la conf de ma database
		         String[] a=finder_class.split(u);//je split les éléements de cette conf
		         String uri = "jdbc:"+a[4]+"://localhost:"+a[3]+"/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false"; //j'initialise ma connection à la base
		       //je créer ma requéte d'inserte dans la table remboursement. Les valeurs corespondent à la ligne d'un des csv qui est dans une liste de string
				 String query1 = "INSERT INTO remboursement " + "VALUES ("+dbname[0]+","+"'"+dbname[1]+"'"+","+"'"+dbname[2]+"'"+","+"'"+dbname[3]+"'"+","+"'"+dbname[4]+"'"+","+"'"+dbname[5]+"'"+","+dbname[6]+","+dbname[7]+","+dbname[8]+")";
				 String query2 = "INSERT INTO historic " + "VALUES ("+dbname[6]+","+"'INSERT',"+"'"+dbname[9]+"'"+")"; //je créer ma requéte pour ajouter la nouvelle insert dans la table historique
				 String users= a[1].toString();//je récupére le user mysql
				 String mdps= a[2].toString();//je récupére le mdp mysql
				 System.out.println(query1);
				 
				 
				 try{Connection conn = DriverManager.getConnection(uri,users.replaceAll("[\\[\\]]", ""), mdps.replaceAll("[\\[\\]]", ""));//je me connecte à la base grace à la conf
				         Statement stmt = conn.createStatement();
				      		      
				         stmt.executeUpdate(query1.replaceAll("[\\[\\]]", "")); //j'inserte mes 2 requétes 
				         stmt.executeUpdate(query2); 
				      } catch (SQLException e) {
				    	  //e.printStackTrace();
				    	  tool_file.write(dbname,"rejet/rejet_"+dbname[9]+".csv",true); //en cas de rejet, j'ajoute la ligne dans le fichier csv rejet avec le bon timestamp
				    	   
				   }
	 }				 
				 public static void  check(String[] dbname) {
			         List u =import_csv.creat("dbconfig.csv");
			         String[] a=finder_class.split(u);
			         String uri = "jdbc:"+a[4]+"://localhost:"+a[3]+"/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false";
					 String query1 = "SELECT * FROM remboursement WHERE ID_Remboursement="+dbname[6];//j'initialise le test pour savoir si un id de payement est dans la base
					 String users= a[1].toString();
					 String mdps= a[2].toString();
					 
					 
					 
					 try(Connection conn = DriverManager.getConnection(uri,users.replaceAll("[\\[\\]]", ""), mdps.replaceAll("[\\[\\]]", ""));
					         Statement stmt = conn.createStatement();
					      ) {		      
						 ResultSet result=  stmt.executeQuery(query1.replaceAll("[\\[\\]]", ""));//je lance la requéte pour savoir si l'id est présent
						 if(result.next()==false) {
							 db.insert(dbname); //si non j'appelle la methode insert
							 
						 }else {
							 db.update(dbname);//si oui j'appelle la methode update
							 
						 }
						 
					      } catch (SQLException e) {
					    	  //e.printStackTrace();
					      }
					    	   
					   }
					 public static void  update(String[] dbname) { // exactement la méme méthode que pour l'insert, seul la requéte changes pour faire un update
				         List u =import_csv.creat("dbconfig.csv");
				         String[] a=finder_class.split(u);
				         String uri = "jdbc:"+a[4]+"://localhost:"+a[3]+"/"+a[0].replaceAll("[\\[\\]]", "")+"?serverTimezone=UTC&useSSL=false";
						 String query1 = "UPDATE remboursement " + "SET Numero_Securite_Sociale='"+dbname[0]+"',"+"Nom='"+dbname[1]+"',Prenom='"+dbname[2]+"',Date_Naissance='"+dbname[3]+"',Numero_Telephone='"+dbname[4]+"',E_Mail='"+dbname[5]+"',Code_Soin='"+dbname[7]+"',Montant_Remboursement='"+dbname[8]+"' WHERE ID_Remboursement="+dbname[6];
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

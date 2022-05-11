package projet_java;

import java.sql.*; 
import java.util.*;
import java.io.File;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.util.regex.*;
import java.nio.file.Path;

public class init_database {
	
	static  String url = "jdbc:mysql://localhost:3306?serverTimezone=UTC&useSSL=false";

	   
	   
	   public static void  Creatdb(String dbname,String user,String mdp) {
		 
		   try(Connection conn = DriverManager.getConnection(url,user, mdp);
			         Statement stmt = conn.createStatement();
			      ) {		      
			         String sql = "CREATE DATABASE "+dbname;
			         stmt.executeUpdate(sql);
			         System.out.println("Database "+dbname+" est cree");
			      } catch (SQLException e) {
			    	  e.printStackTrace();
			    	  
			    	  
			      } 
		   
		  String urls = "jdbc:mysql://localhost:3306"+"/"+dbname+"?serverTimezone=UTC&useSSL=false";
		  
		   try(Connection conn = DriverManager.getConnection(urls,user, mdp);
			         Statement stmt = conn.createStatement();
			      ) {
			         
			         String sql2 = "CREATE Table assure(Numero_Securite_Sociale int,Nom varchar(20), Prenom varchar(20), Date_Naissance date, Numero_Telephone varchar(13) , E_Mail varchar(20), ID_Remboursement int , Code_Soin int, Montant_Remboursement int)";
			         String sql3 = "CREATE Table historic(ID_Remboursement int,Methode varchar(10), timestamp timestamp)";
			         stmt.executeUpdate(sql2);
			         stmt.executeUpdate(sql3);
			         System.out.println("Table assure est crée");
			      } catch (SQLException e) {
			    	  
			      }
		   String[] log = new String[3];;
		   log[0]=dbname;
		   log[1]=user;
		   log[2]=mdp;
		   tool_file.write(log,"dbconfig.csv",false);
		   tool_file.initdir();
		  	   
      }
		   
	   
	   
}

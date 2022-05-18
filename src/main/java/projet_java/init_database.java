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
	


	   
	   
	   public static void  Creatdb(String dbname,String user,String mdp,String dbtype,String port) throws Exception{
		   String url = "jdbc:"+dbtype+"://localhost:"+port+"/?serverTimezone=UTC&useSSL=false";//j'initialise l'url de la connection avec le type de base et le port donné en paramétre
		   try{Class.forName("com.mysql.cj.jdbc.Driver");Connection conn = DriverManager.getConnection(url,user, mdp);//avec cette url et les identifants également passé en paramétre, je me connecte à la base
			         Statement stmt = conn.createStatement();	
			      		      
			         String sql = "CREATE DATABASE "+dbname;//je crée ma requéte de création de la base avec l'argument
			         stmt.executeUpdate(sql);//j'éxécute la requéte
			         System.out.println("Database "+dbname+" est cree");
			      } catch (SQLException e) {
			    	  e.printStackTrace();
			    	  
			    	  
			      } 
		   
		  String urls = "jdbc:"+dbtype+"://localhost:"+port+"/"+dbname+"?serverTimezone=UTC&useSSL=false";
		  
		   try{Class.forName("com.mysql.cj.jdbc.Driver");Connection conn = DriverManager.getConnection(urls,user, mdp);
			         Statement stmt = conn.createStatement();
			     
			         //je crée mes tables remboursement et historic
			         String sql2 = "CREATE Table remboursement(Numero_Securite_Sociale int,Nom varchar(20), Prenom varchar(20), Date_Naissance date, Numero_Telephone varchar(13) , E_Mail varchar(20), ID_Remboursement int , Code_Soin int, Montant_Remboursement int)";
			         String sql3 = "CREATE Table historic(ID_Remboursement int,Methode varchar(10), timestamp timestamp)";
			         stmt.executeUpdate(sql2);
			         stmt.executeUpdate(sql3);
			         System.out.println("Table historique est crée");
			         System.out.println("Table remboursement est crée");
			      } catch (SQLException e) {
			    	  
			      }
		   String[] log = new String[5];//je push dans cette liste le type de base, le port, identifiant sur la base, le mdp de cette id et le nom de la base
		   log[0]=dbname;
		   log[1]=user;
		   log[2]=mdp;
		   log[3]=port;
		   log[4]=dbtype;
		   tool_file.write(log,"dbconfig.csv",false);//j'écris le contenu de la liste dans le fichier dbconfig.csv ./!\ si votre entreprise à un audit de sécurité, caché cette ligne de code /!\
		   tool_file.initdir();//je crée mes dossier rejet et traite
		  	   
      }
		   
	   
	   
}

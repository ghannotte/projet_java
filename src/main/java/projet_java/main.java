package projet_java;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {

	
	public static void main(String args[]) {
	
	int a=1;
	while (a>0) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("1:import csv 2:init db O:quitter  ");
		
	    String choixstring = myObj.nextLine();
	    int choix=Integer.parseInt(choixstring);  
		
		
		if(choix == 1){
			
			Scanner paths = new Scanner(System.in);
		    System.out.println("Enter directory path (format attendu: C:\\Users\\User\\Desktop\\ )");
		    String path = paths.nextLine();
		    
			List imports = finder_class.imports(path);	
			
			
			for (int i = 0; i < imports.size(); i++) {
				
				String[] c= finder_class.split(imports.get(i));
				
				db.check(c);
				
				
			}
		}
	    else if(choix == 2){
	    	Scanner dbnames = new Scanner(System.in);
			System.out.println("Enter database name");
		    String dbname = dbnames.nextLine();
		    
		    Scanner dbusers = new Scanner(System.in);
		    System.out.println("Enter mysql user");
		    String dbuser = dbusers.nextLine();
		    
		    Scanner dbroots = new Scanner(System.in);
		    System.out.println("Enter mysql mdp");
		    String dbroot = dbroots.nextLine();
		    
		    init_database.Creatdb(dbname,dbuser,dbroot);	        
	    }
	     
	    else if(choix == 0){
	    
	        break;
	    }
	    
	    else{
	    
	    	break;
	    }
		
	}
	}
}


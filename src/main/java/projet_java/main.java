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
		System.out.println("1:import csv 2:init db 3:query db ");
		
	    String choixstring = myObj.nextLine();
	    int choix=Integer.parseInt(choixstring);  
		
		
		if(choix == 1){
									
			List imports = finder_class.imports("C:\\Users\\User\\Desktop\\");	
			
			
			for (int i = 0; i < imports.size(); i++) {
				
				String[] c= finder_class.split(imports.get(i));
				
				db.check(c);
				
				
			}
		}
	    else if(choix == 2){
	    	Scanner dbnames = new Scanner(System.in);
			System.out.println("Enter database name");
		    String dbname = dbnames.nextLine();
		    init_database.Creatdb(dbname);	        
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


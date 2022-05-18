package projet_java;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {

	
	public static void main(String args[]) throws Exception {
	
		
		
	    int choix=Integer.parseInt(args[0]);  //l'utilisateur fais son choix 1 pour inserer un csv et 2 pour initialiser la database
		
		
		if(choix == 1){
			

		    String path = args[1];
		    
			List imports = finder_class.imports(path);	// Cette classe va me retourner une liste avec toutes les lignes de tous les csv dans le repertoire indiqué dans la commande
			
			
			for (int i = 0; i < imports.size(); i++) { //pour chaque ligne de la list imports
				
				String[] c= finder_class.split(imports.get(i)); //je split la ligne
				
				db.check(c); //j'envoie vers cette classe qui fera un inserte ou uptdate dans la base choisit
				
				
			}
		}
	    else if(choix == 2){
		    init_database.Creatdb(args[3],args[4],args[5],args[2],args[1]);	 // j'initialise ma database avec, le type de base, le port, identifiant sur la base, le mdp de cette id et le nom de la base        
	    }

	}
}


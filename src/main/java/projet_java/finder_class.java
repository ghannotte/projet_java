package projet_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class finder_class implements import_all {

	 public static List imports(String path) {
			
		 List targets = finder.scan(path); //je crée une liste avec tous les fichier csv qui respectent la régle de nomage
		 List imports = new ArrayList();

		 
		

		 for (int i = 0; i < targets.size(); i++) { // pour chaque fichier csv
			 
			 String timestamp= tool_file.timestamp(targets.get(i));// je récupére le timestamp dans le nom du fichier
			 Object b = targets.get(i);// je récupére le nom du csv
			 String c=b.toString(); //je convertit en string
			 List a = import_csv.creat(c);// j'importe le csv dans cette liste avec cette classe
			 for(int j = 1; j < a.size(); j++) {//j'ajoute cette liste dans une nouvelle, et pour chaque ligne, je lui associe le timestamp
			 imports.add(a.get(j)+","+timestamp);
			
			 }
			 tool_file.moveFile(c,"traite/");//je déplace le fichier traité dans le repertoire traite grace à cette classe
			 
		    }
		 

		 return imports;
		 
	 }
	
	 public static String[] split(Object entry){
		 
		 
		 String b =entry.toString();
		 
			String[] c = b.split(",");
			
			return c;
			
	 }
	 
	 
}

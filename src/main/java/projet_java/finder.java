package projet_java;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public interface finder {

	
	 public static List scan(String path){
			
		  
		   List files = new ArrayList();
		   List result = new ArrayList();
		   Path dir = Paths.get(path); //j'inialise une variable path avec le path donné en arguement
		   String entri ;
	        try {
	            DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.csv"); //je vais filtrer et récupére le path des fichiers csv
	            for (Path entry: ds) {	 //pour chacun des path           	
	            	entri=entry.toString();
	            	
	            	if(entri.matches(".*_[0-9]{14,15}.csv")){//je vérifie avec la regex qu'ils ont le bon format
	                files.add(entri);//si oui je les rajoutes à la liste
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
		   return files;
		 }
}

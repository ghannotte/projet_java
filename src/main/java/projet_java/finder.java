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
		   Path dir = Paths.get(path);
		   String entri ;
	        try {
	            DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.csv");
	            for (Path entry: ds) {	            	
	            	entri=entry.toString();
	            	
	            	if(entri.matches(".*_[0-9]{14,15}.csv")){
	                files.add(entri);
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        
		   return files;
		 }
}

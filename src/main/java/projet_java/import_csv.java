
package projet_java;
import java.io.File;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public interface import_csv{
	
	
	
		  
	   public static List creat(String path) {
	       String file = path;
	       String delimiter = ",";
	       String line;
	    
	       List lines = new ArrayList();
	        try (BufferedReader br =
	                     new BufferedReader(new FileReader(file))) {
	            while((line = br.readLine()) != null){
	            	lines.add(line);	                
	            }
	            
	        } catch (Exception e){
	            System.out.println(e);
	        }
	        
	        return lines;
	    }
	  
	   
	
}	

	 
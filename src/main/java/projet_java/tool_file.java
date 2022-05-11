package projet_java;
import java.util.*;
import java.io.File;
import java.io.*;
import java.nio.*;
import java.util.regex.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public interface tool_file {

	
	public static void  write(String[] dbname, String filename,boolean state) {
	
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, state)));) {
  		  
            for (String sousTab:  dbname) {
            	
            	out.write(sousTab+",");
            	
            }
            out.write("\n");
            out.close();
  	           }  catch (IOException e) {
                  e.printStackTrace();
               }
	
	        }
	
	public static void moveFile(String sourcePath, String targetPath) {

		String[] fields = sourcePath.split(Pattern.quote(File.separator));
		System.out.println(fields[fields.length-1]);
		
		File srcFile = new File(sourcePath);
		srcFile.renameTo(new File(targetPath+fields[fields.length-1]));
	}
	
	public static String timestamp(Object path) {
		String times=path.toString();
		String timestamp=path.toString();         
		Pattern pattern = Pattern.compile("[0-9]{14,15}");
		Matcher  matcher = pattern.matcher(times);	            
		while(matcher.find()) {      	            
		return timestamp=matcher.group();
		}	
		return timestamp;		
	}
	
	
	public static void initdir()  {
		File theDir = new File("rejet");
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
		File theDir2 = new File("traite");
		if (!theDir2.exists()){
		    theDir2.mkdirs();
		}
	}
	
	
}

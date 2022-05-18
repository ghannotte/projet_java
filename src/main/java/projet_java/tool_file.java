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
	
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, state)));) {//j'initialise un printWriter qui va ciblé le fichier souhaité. La classe peut soit écrire à la suite, soit écraser
  		  
            for (String sousTab:  dbname) {
            	
            	out.write(sousTab+",");// j'écit le contenu dans une ligne avec un format csv
            	
            }
            out.write("\n");
            out.close();
  	           }  catch (IOException e) {
                  e.printStackTrace();
               }
	
	        }
	
	public static void moveFile(String sourcePath, String targetPath) {

		String[] fields = sourcePath.split(Pattern.quote(File.separator));//je récupére le nom du fichier que je veux bouger
		System.out.println(fields[fields.length-1]);
		
		File srcFile = new File(sourcePath);///je charge le fichier à la source
		srcFile.renameTo(new File(targetPath+fields[fields.length-1]));//je le déplace à la destination. Cette commande va bien effacer le fichier à la source. Cependant si un fichier à exactement le méme nom dans le rep de destination, il ne ce passera rien.
	}
	
	public static String timestamp(Object path) {
		String times=path.toString();//je path avec le nom du fichier
		String timestamp=path.toString();         
		Pattern pattern = Pattern.compile("[0-9]{14,15}");//j'initialise la regex pour recupérer le timestamp
		Matcher  matcher = pattern.matcher(times);//j'itialise un matcheur avec la regex et le path avec le nom du fichier	            
		while(matcher.find()) {      	            
		return timestamp=matcher.group();//je récupére le timestamp
		}	
		return timestamp;		
	}
	
	
	public static void initdir()  {//je crée mes deux fichier rejet et traité dans le repetoire courant du projet (ou il a le pom.xml)
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

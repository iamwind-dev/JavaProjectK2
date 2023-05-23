package mid.term;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
 
public class DirectoryCopyProgram {
 
    public static void main(String[] args) throws IOException {
    
        File sourceFolder = new File("D:\\temp");
   
        File targetFolder = new File("D:\\tempNew");
    
        copyFolder(sourceFolder, targetFolder);
    }
 
   
    private static void copyFolder(File sourceFolder, File targetFolder) 
            throws IOException {

        if (sourceFolder.isDirectory()) {
           
            if (!targetFolder.exists()) {
                targetFolder.mkdir();
                System.out.println("Thu muc da duoc tao " + targetFolder);
            }

            String files[] = sourceFolder.list();
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File tarFile = new File(targetFolder, file);
              
                copyFolder(srcFile, tarFile);
            }
        } else {
          
            Files.copy(sourceFolder.toPath(), targetFolder.toPath(), 
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File da duoc copy " + targetFolder);
        }
    }
}






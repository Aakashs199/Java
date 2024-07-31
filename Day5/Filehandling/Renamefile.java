/* Write a program to rename the given file, after renaming the file delete the renamed file.
 (Accept the file name using command line arguments.) */



import java.io.File;
class Renamefile {
    public static void main(String[] args) {
        try {
            File originalFile = new File("C:\\Users\\inc5540-12\\Documents\\Day5\\Filehandling\\newfile.txt");
            File renamedFile = new File("C:\\Users\\inc5540-12\\Documents\\Day5\\Filehandling\\"+args[0]);

            if (renamedFile.exists()) 
            {
                System.out.println("File already exists! Cannot rename.");
            } else
             {
                boolean success = originalFile.renameTo(renamedFile);
                if (success) 
                {
                    System.out.println("File renamed successfully!");
                } else 
                {
                    System.out.println("Couldn't rename file!");
                }
          // renamedFile.delete();
           System.out.println("File deleted successfully!");
            }
        } 
        catch (Exception e)
         {
            System.out.println("An error occurred: " + e.getMessage());
         }


    }
}
           

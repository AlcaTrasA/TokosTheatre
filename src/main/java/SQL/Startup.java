package SQL;

import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class Startup {// Check If Project is ran for the first time

    public void createStartup() throws IOException {//Create File
        File file = new File("src/main/java/SQL/startup.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.close();
    }
    public boolean checkExistsStartup(){//Check if File already exists
        File file = new File("src/main/java/SQL/startup.txt");
        return file.exists();
    }
    public void write(String text) {// type logs in 'startup.txt'
        try(FileWriter fw = new FileWriter("src/main/java/SQL/startup.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print("\n" + text + " - " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

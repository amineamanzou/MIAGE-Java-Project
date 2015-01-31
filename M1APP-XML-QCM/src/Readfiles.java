
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Readfiles {

    public static String getDictionaryFilePath(String filename) throws Exception {
        String dictionaryFolderPath = null;
        File configFolder = new File(filename);
        try {
            dictionaryFolderPath = configFolder.getAbsolutePath();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return dictionaryFolderPath;
    }

    public static File appendFiles(String questions, String answers) throws IOException, Exception {
        String[] filename = {questions, answers};
        File file = new File("test.txt");
        FileWriter output = new FileWriter(file);
        try {
            for (int i = 0; i < filename.length; i++) {
                BufferedReader objBufferedReader = new BufferedReader(new FileReader(getDictionaryFilePath(filename[i])));
                String line;
                while ((line = objBufferedReader.readLine()) != null) {
                    output.write(line);
                }
                objBufferedReader.close();
            }
            output.close();
            System.out.println(file.getAbsolutePath());
            return file;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

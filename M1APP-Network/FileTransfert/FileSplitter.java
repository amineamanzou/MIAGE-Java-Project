import java.io.FileInputStream;
import java.io.FileOutputStream;

// Just for training
class FileSplitter {

    public static void main(String args[]) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int size = 5000;
        byte buffer[] = new byte[size];

        int count = 0;
        while (true) {
            int i = fis.read(buffer, 0, size);
            if (i == -1)
                break;

            String filename = args[1] + count;
            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(buffer, 0, i);
            fos.flush();
            fos.close();

            ++count;
        }
    }
}
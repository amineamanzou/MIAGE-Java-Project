import java.io.Serializable;
 
public class FileEvent implements Serializable {
 
    public static void main(String[] args) {
        FileEvent event = new FileEvent("toto.txt");
        event.debug();
    }

    public FileEvent(String filename) {
        this.bufferSize = 5000;
        this.setFilename(filename);
        this.setDestinationDirectory("./Received/image.png");
        this.setSourceDirectory("./");
    }
 
    private static final long serialVersionUID = 1L;
 
    private String destinationDirectory;
    private String sourceDirectory;
    private String filename;
    private long fileSize;
    private byte[] fileData;
    private int bufferSize;
    private String status;
 
    public static void debug(){

    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }
 
    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }
 
    public String getSourceDirectory() {
        return sourceDirectory;
    }
 
    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }
 
    public String getFilename() {
        return filename;
    }
 
    public void setFilename(String filename) {
        this.filename = filename;
    }
 
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public byte[] getFileData() {
        return fileData;
    }
 
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}

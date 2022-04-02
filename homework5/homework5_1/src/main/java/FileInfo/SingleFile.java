package FileInfo;

public class SingleFile extends File {
    private final String fileExtension;

    public SingleFile(String fileName, String fileExtension) {
        super(fileName);
        this.fileExtension = fileExtension;
    }

    @Override
    public String getName() {
        return name + "." + fileExtension;
    }
}

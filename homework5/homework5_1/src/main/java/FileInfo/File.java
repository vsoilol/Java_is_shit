package FileInfo;

public class File extends FileComponent
{
    private final String extension;

    public File(String name, String extension)
    {
        super(name);
        this.extension = extension;
    }

    @Override
    public String getName(){
        return name + "." +  extension;
    }

    @Override
    public void addFileComponent(FileComponent component)
    {
        throw new UnsupportedOperationException("File: Trying to add new file to regular file.");
    }

    @Override
    public FileComponent getFileComponentByName(String name) {
        throw new UnsupportedOperationException("File: Trying to get file from regular file.");
    }
}

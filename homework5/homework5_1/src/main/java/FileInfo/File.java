package FileInfo;

public class File extends FileComponent
{
    public File(String name)
    {
        super(name);
    }

    @Override
    public void addFileComponent(FileComponent component)
    {
        throw new UnsupportedOperationException("File: Trying to add new file to regular file.");
    }

    @Override
    public void printSubFileComponents()
    {
        throw new UnsupportedOperationException("Cannot print children of a normal file.");
    }
}

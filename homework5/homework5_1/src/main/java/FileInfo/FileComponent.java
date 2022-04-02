package FileInfo;

import java.util.Objects;

public abstract class FileComponent
{
    protected String name;

    public FileComponent(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public abstract void addFileComponent(FileComponent component);
    public abstract void printSubFileComponents();
    //public abstract boolean isDirectory();
}

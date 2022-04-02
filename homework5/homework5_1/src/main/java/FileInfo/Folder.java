package FileInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Folder extends FileComponent
{
    private ArrayList<FileComponent> subFileComponents = new ArrayList<>();

    public Folder(String name)
    {
        super(name);
    }

    public ArrayList<FileComponent> getSubFileComponents() {
        return subFileComponents;
    }

    @Override
    public void addFileComponent(FileComponent component)
    {
        subFileComponents.add(component);
    }

    @Override
    public FileComponent getFileComponentByName(String name) {
        return subFileComponents.stream()
                .filter(file -> Objects.equals(file.getName(), name))
                .findFirst()
                .orElse(null);
    }
}

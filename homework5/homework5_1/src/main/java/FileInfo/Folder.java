package FileInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Folder extends File {
    private final List<File> children;

    public Folder(String directoryName, List<File> children) {
        super(directoryName);
        this.children = new ArrayList<File>(children);
    }

    public Folder(String directoryName) {
        super(directoryName);
        this.children = new ArrayList<File>();
    }

    public void addChild(File file) {
        this.children.add(file);
    }

    public File getChildFileByName(String name) {
        return children.stream()
                .filter(file -> file.isNameEqual(name))
                .findFirst()
                .orElse(null);
    }

    public List<File> getFiles() {
        return children;
    }

    @Override
    public String getName() {
        return name + "/";
    }
}

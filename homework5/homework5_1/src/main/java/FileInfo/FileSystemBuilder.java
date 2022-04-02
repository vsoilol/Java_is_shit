package FileInfo;

import javax.management.OperationsException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class FileSystemBuilder {
    private Folder root;
    private Folder currentDirectory;

    public FileSystemBuilder(String rootFolder)
    {
        this.root = new Folder(rootFolder);
        this.currentDirectory = root;
    }

    public File addFile(String name)
    {
        var file = new File(name);
        currentDirectory.add(file);
        return file;
    }

    public Folder setCurrentFolder(String currentFolderName)
    {
        var folderStack = new Stack<Folder>();
        folderStack.push(this.root);

        while (!folderStack.empty())
        {
            var currentDir = folderStack.pop();

            if(Objects.equals(currentFolderName, currentDir.name))
            {
                this.currentDirectory = currentDir;
                return currentDir;
            }

            //iterate through childrens
            //As directory can have file and directory both we have specify what are we iterating
            var childFolders = (ArrayList<Folder>) currentDir
                    .getSubFileComponents()
                    .stream()
                    .filter(item -> item instanceof Folder);

            for (Folder item: childFolders) {
                folderStack.push(item);
            }
        }
        //let the user know that he is looking for wring directory.
        throw new IllegalStateException("Directory name: '" + currentFolderName +  "' not found!");
    }

    public Folder addFolder(String name)
    {
        var dir = new Folder(name);
        this.currentDirectory.add(dir);
        this.currentDirectory = dir;
        return dir;
    }
}

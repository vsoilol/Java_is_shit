package FileInfo;

import java.util.List;

public class FileService {
    public void addFileTreeByPath(Folder parent, String[] filesName) {
        for (int i = 1; i < filesName.length; i++) {
            File child = parent.getChildFileByName(filesName[i]);

            if (child == null) {
                child = addNewChild(parent, filesName[i]);
            }

            if(child instanceof Folder){
                parent = ((Folder) child);
            }
        }
    }

    public void createFileTreeView(StringBuilder stringBuilder, File file, int amountStartTabs) {
        String tabs = "\t".repeat(amountStartTabs);
        stringBuilder.append(tabs + file.getName() + "\n");

        if (file instanceof Folder) {
            List<File> childFiles = ((Folder) file).getFiles();

            for (File childFile : childFiles) {
                createFileTreeView(stringBuilder, childFile, amountStartTabs + 1);
            }
        }
    }

    private File addNewChild(Folder parent, String fileName) {
        File newChild;

        if (fileName.contains(".")) {
            var nameWithExtension = fileName.split("\\.");
            newChild = new SingleFile(nameWithExtension[0], nameWithExtension[1]);
        } else {
            newChild = new Folder(fileName);
        }

        parent.addChild(newChild);

        return newChild;
    }
}

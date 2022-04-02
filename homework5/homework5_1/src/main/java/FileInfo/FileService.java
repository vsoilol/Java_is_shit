package FileInfo;

import java.util.List;

public class FileService {
    public void addFileTreeByPath(Folder parent, String[] filesName) {
        for (int i = 1; i < filesName.length; i++) {
            FileComponent child = parent.getChildFileByName(filesName[i]);

            if (child == null) {
                child = addNewChild(parent, filesName[i]);
            }

            if(child instanceof Folder){
                parent = ((Folder) child);
            }
        }
    }

    public void createFileTreeView(StringBuilder stringBuilder, FileComponent file, int amountStartTabs) {
        String tabs = "\t".repeat(amountStartTabs);
        stringBuilder.append(tabs + file.getName() + "\n");

        if (file instanceof Folder) {
            List<FileComponent> childFiles = ((Folder) file).getSubFileComponents();

            for (FileComponent childFile : childFiles) {
                createFileTreeView(stringBuilder, childFile, amountStartTabs + 1);
            }
        }
    }

    private FileComponent addNewChild(Folder parent, String fileName) {
        FileComponent newChild;

        if (fileName.contains(".")) {
            var nameWithExtension = fileName.split("\\.");
            newChild = new File(nameWithExtension[0]);
        } else {
            newChild = new Folder(fileName);
        }

        parent.add(newChild);

        return newChild;
    }
}

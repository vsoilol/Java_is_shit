package FileInfo;

import Validators.FileSystemBuilderValidator;

public class FileSystemBuilder {
    private final FileSystemBuilderValidator validator;

    private final Folder root;
    private Folder currentDirectory;

    public FileSystemBuilder(FileSystemBuilderValidator validator, String rootFolder)
    {
        this.validator = validator;
        this.root = new Folder(rootFolder);
        this.currentDirectory = root;
    }

    public Folder getRootFolder() {
        return root;
    }

    public void addFileTreeByFilesName(String[] filesName){
        validator.checkFilesName(filesName, root.getName());
        currentDirectory = root;

        for (int i = 1; i < filesName.length; i++) {
            String fileName = filesName[i];

            FileComponent childFileComponent = currentDirectory.getFileComponentByName(fileName);

            if(childFileComponent == null){
                addNewFileComponent(fileName);
                continue;
            }

            if(childFileComponent instanceof Folder && i != filesName.length - 1){
                currentDirectory = (Folder)childFileComponent;
                continue;
            }

            throw new IllegalArgumentException("'" + childFileComponent.getName() + "' is already exist");
        }
    }

    private void addNewFileComponent(String fileName) {
        if (fileName.contains(".")) {
            var nameWithExtension = fileName.split("\\.");
            addFile(nameWithExtension[0], nameWithExtension[1]);
        } else {
            addFolder(fileName);
        }
    }

    private void addFile(String name, String extension)
    {
        File file = new File(name, extension);
        currentDirectory.addFileComponent(file);
    }

    private void addFolder(String name)
    {
        Folder folder = new Folder(name);
        this.currentDirectory.addFileComponent(folder);
        this.currentDirectory = folder;
    }
}

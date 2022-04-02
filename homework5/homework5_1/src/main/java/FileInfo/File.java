package FileInfo;

import Resources.ErrorMessages;

public class File extends FileComponent {
    private final String extension;

    public File(String name, String extension) {
        super(name);
        this.extension = extension;
    }

    @Override
    public String getName() {
        return name + "." + extension;
    }

    @Override
    public void addFileComponent(FileComponent component) {
        throw new UnsupportedOperationException(ErrorMessages.ADD_FILE_COMPONENT_TO_FILE);
    }

    @Override
    public FileComponent getFileComponentByName(String name) {
        throw new UnsupportedOperationException(ErrorMessages.GET_FILE_COMPONENT_FROM_FILE);
    }
}

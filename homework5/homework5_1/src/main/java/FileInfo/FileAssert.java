package FileInfo;

import Resources.ErrorMessages;

public class FileAssert {
    public static String printDirectoryTree(FileComponent folder) {
        if (folder instanceof File) {
            throw new IllegalArgumentException(ErrorMessages.FILE_COMPONENT_IS_NOT_FOLDER.formatted(folder.name));
        }

        int indent = 0;

        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);

        return sb.toString();
    }

    private static void printDirectoryTree(FileComponent folder, int indent, StringBuilder sb) {
        if (folder instanceof File) {
            throw new IllegalArgumentException(ErrorMessages.FILE_COMPONENT_IS_NOT_FOLDER.formatted(folder.name));
        }

        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(folder.getName());
        sb.append("/");
        sb.append("\n");

        for (FileComponent file : ((Folder)folder).getSubFileComponents()) {
            if (file instanceof Folder) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }

    }

    private static void printFile(FileComponent file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }
}

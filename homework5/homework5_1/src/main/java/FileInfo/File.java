package FileInfo;

import java.util.Objects;

public abstract class File {
    protected final String name;

    protected File(String name) {
        this.name = name;
    }

    public boolean isNameEqual(String name) {
        return Objects.equals(this.name, name);
    }

    public abstract String getName();
}

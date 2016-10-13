package model;

import java.io.File;
import java.io.Serializable;

/**
 * Created by imant
 */
public class Mp3File implements Serializable {

    private String name;
    private String path;

    public Mp3File(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

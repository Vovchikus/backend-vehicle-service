package com.aws.codestar.projecttemplates.model;

public class Image {

    public static final String DEFAULT_EXT = "jpg";
    public static final Integer DEFAULT_SMALL_WIDTH = 300;
    private String uniqueName;
    private String extension;

    public enum Name {
        ORIGINAL {
            public String toString() {
                return "original";
            }
        },
        SMALL {
            public String toString() {
                return "small";
            }
        },
    }

    public String getExtension() {
        return Image.DEFAULT_EXT;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }
}

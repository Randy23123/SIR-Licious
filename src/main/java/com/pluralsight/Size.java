package com.pluralsight;

public class Size {
    private static String sizeType;

    public Size(String sizeType) {
        this.sizeType = sizeType;
    }

    public static String getSizeType() {
        return sizeType;
    }
}


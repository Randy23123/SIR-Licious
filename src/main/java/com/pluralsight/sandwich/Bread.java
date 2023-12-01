package com.pluralsight.sandwich;

public class Bread {
    private final String breadType;
    protected static String sizeType;

    public Bread(String breadType, String sizeType) {
        this.breadType = breadType;
        Bread.sizeType = sizeType;
    }

    public String getBreadType() {
        return breadType;
    }

    public static String getSizeType() {
        return sizeType;
    }

    public static void setSizeType(String sizeType) {
        Bread.sizeType = sizeType;
    }
}


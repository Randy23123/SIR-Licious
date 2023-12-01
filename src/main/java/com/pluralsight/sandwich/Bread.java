package com.pluralsight.sandwich;

public class Bread {
    private final String breadType;
    protected static String sizeType;

    // Constructor
    public Bread(String breadType, String sizeType) {
        this.breadType = breadType;
        Bread.sizeType = sizeType;
    }

    // Getter method for breadType
    public String getBreadType() {
        return breadType;
    }

    // Getter method for sizeType (static)
    public static String getSizeType() {
        return sizeType;
    }

    // Setter method for sizeType (static)
    public static void setSizeType(String sizeType) {
        Bread.sizeType = sizeType;
    }
}



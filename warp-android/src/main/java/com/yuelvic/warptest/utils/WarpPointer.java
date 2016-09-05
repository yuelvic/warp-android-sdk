package com.yuelvic.warptest.utils;

/**
 * Created by yuelvic on 9/2/16.
 */
public class WarpPointer {

    private String type;
    private String className;
    private int id;

    public WarpPointer(String className, int id) {
        this.type = "Pointer";
        this.className = className;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

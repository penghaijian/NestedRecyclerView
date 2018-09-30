package com.zzeng.nestedrecyclerview;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 12:00
 */

public class Content {

    private Class clazz;
    private int id;
    private String name;
    private int drawableId;

    public Content() {
    }

    public Content(Class clazz, int id, String name, int drawableId) {
        this.clazz = clazz;
        this.id = id;
        this.name = name;
        this.drawableId = drawableId;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

}

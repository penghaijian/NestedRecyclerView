package com.zzeng.nestedrecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 12:00
 */

public class Head {

    private String headName;
    private List<Content> contentList;

    public Head() {
    }

    public Head(String headName, List<Content> contentList) {
        this.headName = headName;
        this.contentList = contentList;
    }

    public String getHeadName() {
        return headName == null ? "" : headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public List<Content> getContentList() {
        if (contentList == null) {
            return new ArrayList<>();
        }
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}

package com.example.android1.bean;

import java.io.Serializable;

/**
 * Created by 张亚丹 on 2019/6/17.
 */

public class GoldBean implements Serializable{
    private String name;
    private Boolean search;

    public GoldBean(String name, Boolean search) {
        this.name = name;
        this.search = search;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "GoldBean{" +
                "name='" + name + '\'' +
                ", search=" + search +
                '}';
    }
}

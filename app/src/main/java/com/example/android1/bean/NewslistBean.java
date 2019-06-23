package com.example.android1.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 张亚丹 on 2019/6/10.
 */
@Entity
public class NewslistBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String description;
    private String ctime;
    private String picUrl;
    @Generated(hash = 600503492)
    public NewslistBean(Long id, String title, String description, String ctime,
            String picUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ctime = ctime;
        this.picUrl = picUrl;
    }
    @Generated(hash = 923354944)
    public NewslistBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCtime() {
        return this.ctime;
    }
    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
    public String getPicUrl() {
        return this.picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

}
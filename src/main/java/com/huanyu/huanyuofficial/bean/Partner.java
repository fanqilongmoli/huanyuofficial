package com.huanyu.huanyuofficial.bean;

import com.huanyu.huanyuofficial.bean.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Partner extends BaseEntity {
    private String name;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}

package com.huanyu.huanyuofficial.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    //  产品表   id 系列名 产品名 概述 产品特点 试用行业及领域  主图  辅助图  外形尺寸

    // 技术参数  id name vaule

    // 产品选型  id nodeLevel name value
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pSeries;
    private String ptName;
    private String des;
    private String pFeature;
    private String pSYHYLY;
    private String mainPic;
    private String secondPic;
    private String sizeLook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpSeries() {
        return pSeries;
    }

    public void setpSeries(String pSeries) {
        this.pSeries = pSeries;
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getpFeature() {
        return pFeature;
    }

    public void setpFeature(String pFeature) {
        this.pFeature = pFeature;
    }

    public String getpSYHYLY() {
        return pSYHYLY;
    }

    public void setpSYHYLY(String pSYHYLY) {
        this.pSYHYLY = pSYHYLY;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getSecondPic() {
        return secondPic;
    }

    public void setSecondPic(String secondPic) {
        this.secondPic = secondPic;
    }

    public String getSizeLook() {
        return sizeLook;
    }

    public void setSizeLook(String sizeLook) {
        this.sizeLook = sizeLook;
    }

}

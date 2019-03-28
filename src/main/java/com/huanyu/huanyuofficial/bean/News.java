package com.huanyu.huanyuofficial.bean;

import com.huanyu.huanyuofficial.bean.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class News extends BaseEntity {

    private String mainImage;
    private String detail;
    private String title;
    private String[] newsImages;

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getNewsImages() {
        return newsImages;
    }

    public void setNewsImages(String[] newsImages) {
        this.newsImages = newsImages;
    }
}

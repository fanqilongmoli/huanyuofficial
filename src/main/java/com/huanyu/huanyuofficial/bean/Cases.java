package com.huanyu.huanyuofficial.bean;

import com.huanyu.huanyuofficial.bean.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Cases extends BaseEntity {

private Integer casesType;
private String name;
private String[] caseImages;
@Lob
@Column(columnDefinition="TEXT")
private String detail;

    public Integer getCasesType() {
        return casesType;
    }

    public void setCasesType(Integer casesType) {
        this.casesType = casesType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCaseImages() {
        return caseImages;
    }

    public void setCaseImages(String[] caseImages) {
        this.caseImages = caseImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

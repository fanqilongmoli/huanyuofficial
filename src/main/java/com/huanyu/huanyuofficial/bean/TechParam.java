package com.huanyu.huanyuofficial.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TechParam {

    // 技术参数  id name vaule

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Long pid;

    private String name;


    private String value;

    private String showType; //表格 1   文本 0

    private Integer sort;

    private Boolean showInTable;

    public Boolean isShowInTable() {
        return showInTable;
    }

    public void setShowInTable(Boolean showInTable) {
        this.showInTable = showInTable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }
}

package com.huanyu.huanyuofficial.bean;

import com.huanyu.huanyuofficial.bean.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class UserMessage extends BaseEntity {
   /*  "name": "",
             "call": "先生",
             "phone": "",
             "content": ""*/

   private String name;
   private String UserCall;
   private String phone;
    @Lob
    @Column(columnDefinition="TEXT")
   private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCall() {
        return UserCall;
    }

    public void setUserCall(String userCall) {
        UserCall = userCall;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

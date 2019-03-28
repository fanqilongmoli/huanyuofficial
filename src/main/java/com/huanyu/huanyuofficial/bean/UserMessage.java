package com.huanyu.huanyuofficial.bean;

import javax.persistence.Entity;

@Entity
public class UserMessage {
   /*  "name": "",
             "call": "先生",
             "phone": "",
             "content": ""*/

   private String name;

   private String call;
   private String phone;
   private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
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

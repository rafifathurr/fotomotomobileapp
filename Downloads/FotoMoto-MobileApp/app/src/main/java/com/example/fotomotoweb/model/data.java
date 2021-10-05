package com.example.fotomotoweb.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class data implements Serializable{
    private String cust_name;
    private String cust_email;
    private String cust_phone;
    private String cust_subject;
    private String date_book;
    private String cust_additional;
    private String date_submit;
    private String key;

    public data(){
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getCust_name() {
        return cust_name;
    }
    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public String getCust_email() {
        return cust_email;
    }
    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }
    public String getCust_phone() {
        return cust_phone;
    }
    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }
    public String getCust_subject() {
        return cust_subject;
    }
    public void setCust_subject(String cust_subject) {
        this.cust_subject = cust_subject;
    }
    public String getDate_book() {
        return date_book;
    }
    public void setDate_book(String date_book) {
        this.date_book = date_book;
    }
    public String getCust_additional() {
        return cust_additional;
    }
    public void setCust_additional(String cust_additional) {
        this.cust_additional = cust_additional;
    }
    public void setDate_submit(String date_submit) {
        this.date_submit = date_submit;
    }
    public String getDate_submit() {
        return date_submit;
    }
    @Override
    public String toString() {
        return
                " "+cust_name+"\n"+
                " "+cust_email+"\n"+
                " "+cust_phone+"\n"+
                " "+cust_subject+"\n"+
                " "+date_book+"\n"+
                " "+cust_additional+"\n"+
                " "+date_submit+"\n";
    }

    public data(String nm, String eml, String ph, String ty, String dt, String ad, String dts){
        cust_name = nm;
        cust_email = eml;
        cust_phone = ph;
        cust_subject = ty;
        date_book = dt;
        cust_additional = ad;
        date_submit = dts;
    }
}


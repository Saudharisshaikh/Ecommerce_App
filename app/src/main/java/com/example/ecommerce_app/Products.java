package com.example.ecommerce_app.Model;

public class Products {

private  String pname,pdescription,pprice,pimage,pdate,ptime,pid,pcategory;

    public Products() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPcategory() {
        return pcategory;
    }

    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    public Products(String pname, String pdescription, String pprice, String pimage, String pdate, String ptime, String pid, String pcategory) {
        this.pname = pname;
        this.pdescription = pdescription;
        this.pprice = pprice;
        this.pimage = pimage;
        this.pdate = pdate;
        this.ptime = ptime;
        this.pid = pid;
        this.pcategory = pcategory;
    }
}

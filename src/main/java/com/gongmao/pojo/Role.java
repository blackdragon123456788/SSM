package com.gongmao.pojo;

//实体类模型，映射数据字段的模型/对象
public class Role {
    private int rid;
    private String rname;
    private String rdesc;
    private String rwork;
    private int rnumber;
    private String rkind;

    // new 对象(属,性属性,属性)
    //
    public Role(){

    }
    public Role(int rid, String rname, String rdesc) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
    }

    public Role(int rid, String rname, String rdesc, String rwork, int rnumber, String rkind) {
        this.rid = rid;
        this.rname = rname;
        this.rdesc = rdesc;
        this.rwork = rwork;
        this.rnumber = rnumber;
        this.rkind = rkind;
    }

    // get / set   对象.set/对象.get
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getRwork() {
        return rwork;
    }

    public void setRwork(String rwork) {
        this.rwork = rwork;
    }

    public int getRnumber() {
        return rnumber;
    }

    public void setRnumber(int rnumber) {
        this.rnumber = rnumber;
    }

    public String getRkind() {
        return rkind;
    }

    public void setRkind(String rkind) {
        this.rkind = rkind;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                ", rwork='" + rwork + '\'' +
                ", rnumber=" + rnumber +
                ", rkind='" + rkind + '\'' +
                '}';
    }
}

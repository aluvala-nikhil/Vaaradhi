package com.example.luvphoto;


public class workdetails {
    String wid;
    int nw;
    String worktype;
    String location;
    int allot;
    int rw;
    String id;


    public workdetails(String wid, int nw, String worktype, String location, String id) {
        this.wid = wid;
        this.nw = nw;
        this.worktype = worktype;
        this.location = location;
        this.allot = 0;
        this.rw = nw-allot;
        this.id = id;
    }

    public workdetails(String wid, int allot, String id, int nw, String loc, String type) {
        this.wid = wid;
        this.nw = nw;
        this.worktype = type;
        this.location = loc;
        this.allot = allot;
        this.rw = nw-allot;
        this.id = id;
    }
    public workdetails ()
    {

    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }


    public String getwid(){return wid;}

    public int getNw() {
        return nw;
    }

    public String getLocation(){
        return location;
    }

    public String getWorktype() {
        return worktype;
    }

    public int getAllot() {
        return allot;
    }

    public int getRw() {
        return rw;
    }
}

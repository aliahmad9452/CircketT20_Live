package com.example.circkett20live.Playerdetils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("odi")
    @Expose
    private Integer odi;
    @SerializedName("t20")
    @Expose
    private Integer t20;
    @SerializedName("test")
    @Expose
    private Integer test;
    @SerializedName("squads")
    @Expose
    private Integer squads;
    @SerializedName("matches")
    @Expose
    private Integer matches;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getOdi() {
        return odi;
    }

    public void setOdi(Integer odi) {
        this.odi = odi;
    }

    public Integer getT20() {
        return t20;
    }

    public void setT20(Integer t20) {
        this.t20 = t20;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getSquads() {
        return squads;
    }

    public void setSquads(Integer squads) {
        this.squads = squads;
    }

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

}

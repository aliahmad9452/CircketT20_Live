package com.example.circkett20live.Playerdetils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("hitsToday")
    @Expose
    private Integer hitsToday;
    @SerializedName("hitsUsed")
    @Expose
    private Integer hitsUsed;
    @SerializedName("hitsLimit")
    @Expose
    private Integer hitsLimit;
    @SerializedName("credits")
    @Expose
    private Integer credits;
    @SerializedName("server")
    @Expose
    private Integer server;
    @SerializedName("offsetRows")
    @Expose
    private Integer offsetRows;
    @SerializedName("totalRows")
    @Expose
    private Integer totalRows;
    @SerializedName("queryTime")
    @Expose
    private Double queryTime;
    @SerializedName("s")
    @Expose
    private Integer s;
    @SerializedName("cache")
    @Expose
    private Integer cache;

    public Integer getHitsToday() {
        return hitsToday;
    }

    public void setHitsToday(Integer hitsToday) {
        this.hitsToday = hitsToday;
    }

    public Integer getHitsUsed() {
        return hitsUsed;
    }

    public void setHitsUsed(Integer hitsUsed) {
        this.hitsUsed = hitsUsed;
    }

    public Integer getHitsLimit() {
        return hitsLimit;
    }

    public void setHitsLimit(Integer hitsLimit) {
        this.hitsLimit = hitsLimit;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    public Integer getOffsetRows() {
        return offsetRows;
    }

    public void setOffsetRows(Integer offsetRows) {
        this.offsetRows = offsetRows;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Double getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Double queryTime) {
        this.queryTime = queryTime;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

}

package com.example.hometesttiki.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Progress {

    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("qty_ordered")
    @Expose
    private Integer qtyOrdered;
    @SerializedName("qty_remain")
    @Expose
    private Integer qtyRemain;
    @SerializedName("percent")
    @Expose
    private Double percent;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(Integer qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public Integer getQtyRemain() {
        return qtyRemain;
    }

    public void setQtyRemain(Integer qtyRemain) {
        this.qtyRemain = qtyRemain;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
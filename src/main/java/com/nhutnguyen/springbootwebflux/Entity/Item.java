/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRICEITEM")

public class Item {
    private int PRICE_SEQ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ITEM_SEQ;
    private String NAT_CD;
    private float ASP;
    private int BOM_SEQ;

    public int getPRICE_SEQ() {
        return PRICE_SEQ;
    }

    public long getITEM_SEQ() {
        return ITEM_SEQ;
    }

    public String getNAT_CD() {
        return NAT_CD;
    }

    public float getASP() {
        return ASP;
    }

    public int getBOM_SEQ() {
        return BOM_SEQ;
    }

    public void setPRICE_SEQ(int PRICE_SEQ) {
        this.PRICE_SEQ = PRICE_SEQ;
    }

    public void setITEM_SEQ(long ITEM_SEQ) {
        this.ITEM_SEQ = ITEM_SEQ;
    }

    public void setNAT_CD(String NAT_CD) {
        this.NAT_CD = NAT_CD;
    }

    public void setASP(float ASP) {
        this.ASP = ASP;
    }

    public void setBOM_SEQ(int BOM_SEQ) {
        this.BOM_SEQ = BOM_SEQ;
    }

    @Override
    public String toString() {
        return "Item{" +
                "PRICE_SEQ=" + PRICE_SEQ +
                ", ITEM_SEQ=" + ITEM_SEQ +
                ", NAT_CD='" + NAT_CD + '\'' +
                ", ASP=" + ASP +
                ", BOM_SEQ=" + BOM_SEQ +
                '}';
    }
}

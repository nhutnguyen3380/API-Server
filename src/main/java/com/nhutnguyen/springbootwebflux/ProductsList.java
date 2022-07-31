/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux;

import javax.persistence.*;

@Entity
@Table(name = "TB_ITEM")
public class ProductsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_NO")
    String ITEM_NO;

//    @Column(name = "CD_NM")
//    String CD_NM;

    @Column(name = "POWER_CLS_CD")
    String POWER_CLS_CD;

    @Column(name = "ACTIVE_YN")
    String ACTIVE_YN;

    @Column(name = "ZMD0103")
    String ZMD0103;

    @Column(name = "ZMD0105")
    String ZMD0105;

    @Column(name = "ZMD0106")
    String ZMD0106;

    @Column(name = "DETAIL_NAME")
    String DETAIL_NAME;

    public String getITEM_NO() {
        return ITEM_NO;
    }

    public String getPOWER_CLS_CD() {
        return POWER_CLS_CD;
    }

    public String getACTIVE_YN() {
        return ACTIVE_YN;
    }

    public String getZMD0103() {
        return ZMD0103;
    }

    public String getZMD0105() {
        return ZMD0105;
    }

    public String getZMD0106() {
        return ZMD0106;
    }

    public String getDETAIL_NAME() {
        return DETAIL_NAME;
    }

    public void setITEM_NO(String ITEM_NO) {
        this.ITEM_NO = ITEM_NO;
    }

    public void setPOWER_CLS_CD(String POWER_CLS_CD) {
        this.POWER_CLS_CD = POWER_CLS_CD;
    }

    public void setACTIVE_YN(String ACTIVE_YN) {
        this.ACTIVE_YN = ACTIVE_YN;
    }

    public void setZMD0103(String ZMD0103) {
        this.ZMD0103 = ZMD0103;
    }

    public void setZMD0105(String ZMD0105) {
        this.ZMD0105 = ZMD0105;
    }

    public void setZMD0106(String ZMD0106) {
        this.ZMD0106 = ZMD0106;
    }

    public void setDETAIL_NAME(String DETAIL_NAME) {
        this.DETAIL_NAME = DETAIL_NAME;
    }

    @Override
    public String toString() {
        return "ProductsList{" +
                "ItemCode='" + ITEM_NO + '\'' +
                ", U_Wattage='" + POWER_CLS_CD + '\'' +
                ", Active='" + ACTIVE_YN + '\'' +
                ", Plant Description='" + ZMD0103 + '\'' +
                ", Grp1. Description='" + ZMD0105 + '\'' +
                ", Grp2. Description='" + ZMD0106 + '\'' +
                ", Grp3. Description='" + DETAIL_NAME + '\'' +
                '}';
    }
}

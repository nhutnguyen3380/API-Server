/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.qcells.springbootAPIserver.Entity;

import javax.persistence.*;

@Entity
@Table(name = "TB_CMMNCODE")

public class WhiteLabelList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_VAL3")
    String WH_Location;

    @Column(name = "CD_NM")
    String WH_3PL_Name;

    @Column(name = "CD_VAL3", insertable = false, updatable = false)
    String SAP_WH_Location_Group;

    @Column(name = "COMM_CD")
    String SAP_WH_Location_Code;

    @Column(name = "CD_NM", insertable = false, updatable = false)
    String SAP_3PL_WH_Name;

    @Column(name = "CD_VAL")
    String UseYN;

    public String getWH_Location() {
        return WH_Location;
    }

    public String getWH_3PL_Name() {
        return WH_3PL_Name;
    }

    public String getSAP_WH_Location_Group() {
        return SAP_WH_Location_Group;
    }

    public String getSAP_WH_Location_Code() {
        return SAP_WH_Location_Code;
    }

    public String getSAP_3PL_WH_Name() {
        return SAP_3PL_WH_Name;
    }

    public String getUseYN() {
        return UseYN;
    }

    public void setWH_Location(String WH_Location) {
        this.WH_Location = WH_Location;
    }

    public void setWH_3PL_Name(String WH_3PL_Name) {
        this.WH_3PL_Name = WH_3PL_Name;
    }

    public void setSAP_WH_Location_Group(String CD_VAL30) {
        this.SAP_WH_Location_Group = CD_VAL30;
    }

    public void setSAP_WH_Location_Code(String SAP_WH_Location_Code) {
        this.SAP_WH_Location_Code = SAP_WH_Location_Code;
    }

    public void setSAP_3PL_WH_Name(String SAP_3PL_WH_Name) {
        this.SAP_3PL_WH_Name = SAP_3PL_WH_Name;
    }

    public void setUseYN(String UseYN) {
        this.UseYN = UseYN;
    }

    @Override
    public String toString() {
        return "WhiteLabelList{" +
                "WH_Location='" + WH_Location + '\'' +
                ", WH_3PL_Name='" + WH_3PL_Name + '\'' +
                ", SAP_WH_Location_Group='" + SAP_WH_Location_Group + '\'' +
                ", SAP_WH_Location_Code='" + SAP_WH_Location_Code + '\'' +
                ", SAP_3PL_WH_Name='" + SAP_3PL_WH_Name + '\'' +
                ", UseYN='" + UseYN + '\'' +
                '}';
    }
}

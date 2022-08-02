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
@Table(name = "TB_CMMNCODE")

public class WhiteLabelList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CD_VAL3")
    String CD_VAL3;

    @Column(name = "CD_NM")
    String CD_NM;

    @Column(name = "CD_VAL3", insertable = false, updatable = false)
    String CD_VAL30;

    @Column(name = "COMM_CD")
    String COMM_CD;

    @Column(name = "CD_NM", insertable = false, updatable = false)
    String CD_NM0;

    @Column(name = "CD_VAL")
    String CD_VAL;

    public String getCD_VAL3() {
        return CD_VAL3;
    }

    public String getCD_NM() {
        return CD_NM;
    }

    public String getCD_VAL30() {
        return CD_VAL30;
    }

    public String getCOMM_CD() {
        return COMM_CD;
    }

    public String getCD_NM0() {
        return CD_NM0;
    }

    public String getCD_VAL() {
        return CD_VAL;
    }

    public void setCD_VAL3(String CD_VAL3) {
        this.CD_VAL3 = CD_VAL3;
    }

    public void setCD_NM(String CD_NM) {
        this.CD_NM = CD_NM;
    }

    public void setCD_VAL30(String CD_VAL30) {
        this.CD_VAL30 = CD_VAL30;
    }

    public void setCOMM_CD(String COMM_CD) {
        this.COMM_CD = COMM_CD;
    }

    public void setCD_NM0(String CD_NM0) {
        this.CD_NM0 = CD_NM0;
    }

    public void setCD_VAL(String CD_VAL) {
        this.CD_VAL = CD_VAL;
    }

    @Override
    public String toString() {
        return "WhiteLabelList{" +
                "CD_VAL3='" + CD_VAL3 + '\'' +
                ", CD_NM='" + CD_NM + '\'' +
                ", CD_VAL30='" + CD_VAL30 + '\'' +
                ", COMM_CD='" + COMM_CD + '\'' +
                ", CD_NM0='" + CD_NM0 + '\'' +
                ", CD_VAL='" + CD_VAL + '\'' +
                '}';
    }
}

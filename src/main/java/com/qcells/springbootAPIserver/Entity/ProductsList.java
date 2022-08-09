/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.qcells.springbootAPIserver.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ITEM")
public class ProductsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_NO")
    @NotNull
    String ItemCode;
//

    @Column(name = "CD_NM")
    @NotNull
    String Final_Product_Type;

    @Column(name = "POWER_CLS_CD")
    @NotNull
    String U_Wattage;

    @Column(name = "ACTIVE_YN")
    @NotNull
    String Active;

    @Column(name = "ZMD0103")
    @NotNull
    String Plant_Description;

    @Column(name = "ZMD0105")
    @NotNull
    String Grp1_Description;

    @Column(name = "ZMD0106")
    @NotNull
    String Grp2_Description;

    @Column(name = "DETAIL_NAME")
    @NotNull
    String Grp3_Description;

    public String getItemCode() {
        return ItemCode;
    }


    public String getFinal_Product_Type() {
        return Final_Product_Type;
    }

    public String getU_Wattage() {
        return U_Wattage;
    }

    public String getActive() {
        return Active;
    }

    public String getPlant_Description() {
        return Plant_Description;
    }

    public String getGrp1_Description() {
        return Grp1_Description;
    }

    public String getGrp2_Description() {
        return Grp2_Description;
    }

    public String getGrp3_Description() {
        return Grp3_Description;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public void setFinal_Product_Type(String final_Product_Type) {
        Final_Product_Type = final_Product_Type;
    }

    public void setU_Wattage(String U_Wattage) {
        this.U_Wattage = U_Wattage;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }

    public void setPlant_Description(String Plant_Description) {
        this.Plant_Description = Plant_Description;
    }

    public void setGrp1_Description(String Grp1_Description) {
        this.Grp1_Description = Grp1_Description;
    }

    public void setGrp2_Description(String Grp2_Description) {
        this.Grp2_Description = Grp2_Description;
    }

    public void setGrp3_Description(String Grp3_Description) {
        this.Grp3_Description = Grp3_Description;
    }

    @Override
    public String toString() {
        return "ProductsList{" +
                "ItemCode='" + ItemCode + '\'' +
                ", U_Wattage='" + U_Wattage + '\'' +
                ", Active='" + Active + '\'' +
                ", Plant Description='" + Plant_Description + '\'' +
                ", Grp1. Description='" + Grp1_Description + '\'' +
                ", Grp2. Description='" + Grp2_Description + '\'' +
                ", Grp3. Description='" + Grp3_Description + '\'' +
                '}';
    }
}

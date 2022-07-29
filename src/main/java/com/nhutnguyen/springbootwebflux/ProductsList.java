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

    @Column(name = "CD_NM")
    String CD_NM;

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

}

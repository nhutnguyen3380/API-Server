/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.repository;

import com.nhutnguyen.springbootwebflux.Entity.ProductsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductsList, String> {

    @Override
    List<ProductsList> findAll();

    @Query(value = "SELECT\n" +
            "\n" +
            "         TI1.ITEM_NO AS 'ITEM_NO'\n" +
            "\n" +
            "        , TC2.CD_NM                 AS 'CD_NM'\n" +
            "\n" +
            "        , TI1.POWER_CLS_CD            AS 'POWER_CLS_CD'\n" +
            "\n" +
            "        , CASE WHEN TI1.ACTIVE_YN = 'Y' THEN 'Active' ELSE 'Inactive' END AS 'ACTIVE_YN'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0103, '')        AS 'ZMD0103'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0105, '')        AS 'ZMD0105'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0106, '')        AS 'ZMD0106'\n" +
            "\n" +
            "        , ISNULL(TI1.DETAIL_NAME, '')    AS 'DETAIL_NAME'\n" +
            "\n" +
            "        FROM\n" +
            "\n" +
            "          hanwha_qcells.dbo.TB_ITEM(NOLOCK) TI1\n" +
            "\n" +
            "          /* WATT */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC1\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC1.REPR_CD                                  = 'US010'\n" +
            "\n" +
            "              AND TC1.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC1.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC1.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.POWER_CLS_CD\n" +
            "\n" +
            "          /* ITEM_TYPE */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC2\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC2.REPR_CD                                  = 'US011'\n" +
            "\n" +
            "              AND TC2.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC2.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC2.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.PDT_TYPE_CD\n" +
            "\n" +
            "          /* ITEM_GRP */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC3\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC3.REPR_CD                                  = 'US012'\n" +
            "\n" +
            "              AND TC3.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC3.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC3.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.ITEM_GRP_CD\n" +
            "\n" +
            "          /* DIV_CD */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC4\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC4.REPR_CD                                  = 'US043'\n" +
            "\n" +
            "              AND TC4.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC4.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC4.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.DIV_CD\n" +
            "\n" +
            "          /* TB_BOM */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_BOM (NOLOCK) TB\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TB.ITEM_SEQ = TI1.ITEM_SEQ\n" +
            "\n" +
            "        WHERE\n" +
            "\n" +
            "          TI1.NAT_CD                   = 'US'\n" +
            "\n" +
            "          AND TI1.ACTIVE_YN            = 'Y'\n" +
            "\n" +
            "          AND TI1.DEL_YN               = 'N'\n" +
            "\n" +
            "          AND TI1.SALES_ITEM_YN        = 'Y'\n" +
            "\n" +
            "          AND ISNULL(TB.BOM_TYPE, '') != 'P'\n" +
            "\n" +
            "          AND ISNULL(TB.DEL_YN, '')   != 'Y' AND ITEM_NO LIKE '%ItemCode%'", nativeQuery = true)

    List<ProductsList> findProductsListByItemCode(@Param("ItemCode") String ItemCode);


    @Query(value = "SELECT\n" +
            "\n" +
            "         TI1.ITEM_NO AS 'ITEM_NO'\n" +
            "\n" +
            "        , TC2.CD_NM                 AS 'CD_NM'\n" +
            "\n" +
            "        , TI1.POWER_CLS_CD            AS 'POWER_CLS_CD'\n" +
            "\n" +
            "        , CASE WHEN TI1.ACTIVE_YN = 'Y' THEN 'Active' ELSE 'Inactive' END AS 'ACTIVE_YN'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0103, '')        AS 'ZMD0103'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0105, '')        AS 'ZMD0105'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0106, '')        AS 'ZMD0106'\n" +
            "\n" +
            "        , ISNULL(TI1.DETAIL_NAME, '')    AS 'DETAIL_NAME'\n" +
            "\n" +
            "        FROM\n" +
            "\n" +
            "          hanwha_qcells.dbo.TB_ITEM(NOLOCK) TI1\n" +
            "\n" +
            "          /* WATT */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC1\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC1.REPR_CD                                  = 'US010'\n" +
            "\n" +
            "              AND TC1.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC1.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC1.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.POWER_CLS_CD\n" +
            "\n" +
            "          /* ITEM_TYPE */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC2\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC2.REPR_CD                                  = 'US011'\n" +
            "\n" +
            "              AND TC2.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC2.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC2.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.PDT_TYPE_CD\n" +
            "\n" +
            "          /* ITEM_GRP */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC3\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC3.REPR_CD                                  = 'US012'\n" +
            "\n" +
            "              AND TC3.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC3.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC3.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.ITEM_GRP_CD\n" +
            "\n" +
            "          /* DIV_CD */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC4\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC4.REPR_CD                                  = 'US043'\n" +
            "\n" +
            "              AND TC4.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC4.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC4.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.DIV_CD\n" +
            "\n" +
            "          /* TB_BOM */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_BOM (NOLOCK) TB\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TB.ITEM_SEQ = TI1.ITEM_SEQ\n" +
            "\n" +
            "        WHERE\n" +
            "\n" +
            "          TI1.NAT_CD                   = 'US'\n" +
            "\n" +
            "          AND TI1.ACTIVE_YN            = 'Y'\n" +
            "\n" +
            "          AND TI1.DEL_YN               = 'N'\n" +
            "\n" +
            "          AND TI1.SALES_ITEM_YN        = 'Y'\n" +
            "\n" +
            "          AND ISNULL(TB.BOM_TYPE, '') != 'P'\n" +
            "\n" +
            "          AND ISNULL(TB.DEL_YN, '')   != 'Y';", nativeQuery = true)
    List<ProductsList> findAllProductsList();

    @Query(value = "SELECT\n" +
            "\n" +
            "         TI1.ITEM_NO AS 'ITEM_NO'\n" +
            "\n" +
            "        , TC2.CD_NM                 AS 'CD_NM'\n" +
            "\n" +
            "        , TI1.POWER_CLS_CD            AS 'POWER_CLS_CD'\n" +
            "\n" +
            "        , CASE WHEN TI1.ACTIVE_YN = 'Y' THEN 'Active' ELSE 'Inactive' END AS 'ACTIVE_YN'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0103, '')        AS 'ZMD0103'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0105, '')        AS 'ZMD0105'\n" +
            "\n" +
            "        , ISNULL(TI1.ZMD0106, '')        AS 'ZMD0106'\n" +
            "\n" +
            "        , ISNULL(TI1.DETAIL_NAME, '')    AS 'DETAIL_NAME'\n" +
            "\n" +
            "        FROM\n" +
            "\n" +
            "          hanwha_qcells.dbo.TB_ITEM(NOLOCK) TI1\n" +
            "\n" +
            "          /* WATT */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC1\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC1.REPR_CD                                  = 'US010'\n" +
            "\n" +
            "              AND TC1.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC1.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC1.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.POWER_CLS_CD\n" +
            "\n" +
            "          /* ITEM_TYPE */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC2\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC2.REPR_CD                                  = 'US011'\n" +
            "\n" +
            "              AND TC2.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC2.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC2.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.PDT_TYPE_CD\n" +
            "\n" +
            "          /* ITEM_GRP */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC3\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC3.REPR_CD                                  = 'US012'\n" +
            "\n" +
            "              AND TC3.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC3.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC3.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.ITEM_GRP_CD\n" +
            "\n" +
            "          /* DIV_CD */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_CMMNCODE(NOLOCK) TC4\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TC4.REPR_CD                                  = 'US043'\n" +
            "\n" +
            "              AND TC4.NAT_CD                               = 'US'\n" +
            "\n" +
            "              AND TC4.USE_YN                               = 'Y'\n" +
            "\n" +
            "              AND TC4.COMM_CD COLLATE Korean_Wansung_CS_AS = TI1.DIV_CD\n" +
            "\n" +
            "          /* TB_BOM */\n" +
            "\n" +
            "          LEFT OUTER JOIN\n" +
            "\n" +
            "            hanwha_qcells.dbo.TB_BOM (NOLOCK) TB\n" +
            "\n" +
            "            ON\n" +
            "\n" +
            "              TB.ITEM_SEQ = TI1.ITEM_SEQ\n" +
            "\n" +
            "        WHERE\n" +
            "\n" +
            "          TI1.NAT_CD                   = 'US'\n" +
            "\n" +
            "          AND TI1.ACTIVE_YN            = 'Y'\n" +
            "\n" +
            "          AND TI1.DEL_YN               = 'N'\n" +
            "\n" +
            "          AND TI1.SALES_ITEM_YN        = 'Y'\n" +
            "\n" +
            "          AND ISNULL(TB.BOM_TYPE, '') != 'P'\n" +
            "\n" +
            "          AND ISNULL(TB.DEL_YN, '')   != 'Y'\n" +
            "\n" +
            "AND TI1.ITEM_NO IS NOT NULL\n" +
            "          AND TC2.CD_NM IS NOT NULL\n" +
            "          AND TI1.POWER_CLS_CD IS NOT NULL\n" +
            "          AND TI1.ACTIVE_YN IS NOT NULL\n" +
            "          AND TI1.ZMD0103 IS NOT NULL\n" +
            "          AND TI1.ZMD0105 IS NOT NULL\n" +
            "          AND TI1.ZMD0106 IS NOT NULL\n" +
            "          AND TI1.DETAIL_NAME IS NOT NULL;", nativeQuery = true)
    List<ProductsList> findProductsList();

}

/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.repository;

import com.nhutnguyen.springbootwebflux.Entity.WhiteLabelList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiteLabelRepository extends JpaRepository <WhiteLabelList, String>
{
    @Override
    List<WhiteLabelList> findAll();

    @Query(value = "SELECT\n" +
            "\n" +
            "    tc.CD_VAL3    AS 'CD_VAL3'\n" +
            "\n" +
            "    ,tc.CD_NM    AS 'CD_NM'\n" +
            "\n" +
            "    ,tc.CD_VAL3    AS 'CD_VAL3'\n" +
            "\n" +
            "    ,t2.COMM_CD AS 'COMM_CD'\n" +
            "\n" +
            "    ,tc.CD_NM    AS 'CD_NM'\n" +
            "\n" +
            "    ,CASE WHEN tc.CD_VAL = 'N' THEN 'Y' ELSE 'N' END AS 'CD_VAL'\n" +
            "\n" +
            "FROM hanwha_qcells.dbo.TB_CMMNCODE tc\n" +
            "\n" +
            "LEFT JOIN (\n" +
            "\n" +
            "    SELECT\n" +
            "\n" +
            "        COMM_CD\n" +
            "\n" +
            "        , CD_VAL3\n" +
            "\n" +
            "    FROM hanwha_qcells.dbo.TB_CMMNCODE\n" +
            "\n" +
            "    WHERE REPR_CD = 'US062'  and COMM_CD like 'A%') t2\n" +
            "\n" +
            "    ON tc.CD_VAL3 = t2.CD_VAL3 COLLATE Korean_Wansung_CS_AS\n" +
            "\n" +
            "WHERE REPR_CD = 'US062' AND  tc.CD_VAL3 IS NOT NULL\n" +
            "\n" +
            "AND LEFT(tc.CD_NM COLLATE Korean_Wansung_CS_AS , 2) = LEFT(tc.COMM_CD, 2)\n" +
            "\n" +
            "ORDER BY tc.SORT_SEQ ASC", nativeQuery = true)
    List<WhiteLabelList> findAllWhiteLabelList();
}

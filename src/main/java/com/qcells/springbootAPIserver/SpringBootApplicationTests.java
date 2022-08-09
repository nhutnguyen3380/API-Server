/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.qcells.springbootAPIserver;

import com.qcells.springbootAPIserver.Entity.ProductsList;
import com.qcells.springbootAPIserver.Entity.WhiteLabelList;
import com.qcells.springbootAPIserver.repository.ProductRepository;
import com.qcells.springbootAPIserver.repository.WhiteLabelRepository;
import com.qcells.springbootAPIserver.services.ProductService;
import com.qcells.springbootAPIserver.services.WhiteLabelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTests {

    @Autowired
    private WhiteLabelService whiteLabelService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WhiteLabelRepository whiteLabelRepository;



    @Test
    public void testFindAllProductsList()
    {
        List<ProductsList> foundProductsList = productService.getAllProductsList();
        assertEquals(1152,foundProductsList.size());
    }
    @Test
    public void testFindAllWhiteLabelList()
    {
        List<WhiteLabelList> foundWhiteLabelList = whiteLabelService.getAllWhiteLabelList();
        assertEquals(23,foundWhiteLabelList.size());
    }

}

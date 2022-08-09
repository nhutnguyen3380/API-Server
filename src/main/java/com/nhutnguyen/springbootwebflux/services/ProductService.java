/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.services;

import com.nhutnguyen.springbootwebflux.Entity.ProductsList;
import com.nhutnguyen.springbootwebflux.repository.ProductRepository;
import com.nhutnguyen.springbootwebflux.dao.ProductDao;
import com.nhutnguyen.springbootwebflux.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> loadAllProducts()
    {
        long start = System.currentTimeMillis();
        List<Product> products = dao.getProduct();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end-start));
        return products;
    }

    public Flux<Product> loadAllProductsStream()
    {
        long start = System.currentTimeMillis();
        Flux<Product> products = dao.getProductStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time: " + (end-start));
        return products;
    }

    public List<ProductsList> getProductsList()
    {
        return productRepository.findAll();
    }

//    public Flux<ProductsList> loadProductsListStream()
//    {
//
//    }

}
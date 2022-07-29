/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.dao;

import com.nhutnguyen.springbootwebflux.dto.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ProductDao {

    public List<Product> getProduct()
    {
        return IntStream.rangeClosed(1,50)
                .peek(i -> System.out.println("Processing count: " + i))
                .mapToObj(i->new Product(i, "product" + i))
                .collect(Collectors.toList());
    }

    public Flux<Product> getProductStream()
    {
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("Processing count: " + i))
                .map(i -> new Product(i, "product" + i));
    }
}

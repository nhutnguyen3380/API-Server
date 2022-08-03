/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootWebfluxApplication implements CommandLineRunner
	{
		@Autowired
		private ItemRepository itemRepo;
		@Autowired
		private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxApplication.class, args);
	}
	//request feature now
	@Override
	public void run(String... args) throws Exception {
//		List<Item> items = itemRepo.findAll();
//		items.forEach(System.out :: println);
//		Mono<String> monoString = Mono.just("This is a test").log();
//		monoString.subscribe(System.out::println);
//
//		Flux<String> fluxString = Flux.just("Dog", "Cat", "LUL").log();
//		fluxString.subscribe(System.out::println);

//		List<ProductsList> productsLists = fetchDataService.findAll();
//		productsLists.forEach(System.out::println);

	}
}

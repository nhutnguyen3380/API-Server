package com.nhutnguyen.springbootwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication

public class SpringbootWebfluxApplication implements CommandLineRunner {

	@Autowired
	private ItemRepository itemRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Item> items = itemRepo.findAll();
		items.forEach(System.out :: println);
	}
}

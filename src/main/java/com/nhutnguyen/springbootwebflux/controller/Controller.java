/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux.controller;

import com.nhutnguyen.springbootwebflux.EmptyInputException;
import com.nhutnguyen.springbootwebflux.Entity.Product;
import com.nhutnguyen.springbootwebflux.Entity.ProductsList;
import com.nhutnguyen.springbootwebflux.Entity.WhiteLabelList;
import com.nhutnguyen.springbootwebflux.NoDataFoundException;
import com.nhutnguyen.springbootwebflux.repository.ItemRepository;
import com.nhutnguyen.springbootwebflux.JwtUtil;
import com.nhutnguyen.springbootwebflux.repository.ProductRepository;
import com.nhutnguyen.springbootwebflux.repository.WhiteLabelRepository;
import com.nhutnguyen.springbootwebflux.models.AuthenticationRequest;
import com.nhutnguyen.springbootwebflux.models.AuthenticationResponse;
import com.nhutnguyen.springbootwebflux.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
public class Controller {
    //login feature
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private ProductService productService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WhiteLabelRepository whiteLabelRepository;

    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello World!";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(path="/products", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProducts()
    {
        return productService.loadAllProducts();
    }

    @RequestMapping(value = "/products/stream", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Flux<Product> getAllProductsStream()
    {
        return productService.loadAllProductsStream();
    }
    @GetMapping("/productslist")
    public List<ProductsList> getProductsList()
    {
        return productRepository.findAll();

    }
    @GetMapping("/whitelabel")
    public List<WhiteLabelList> getWhiteLabelList()
    {
        return whiteLabelRepository.findAll();
    }
    @GetMapping(value = "/getdata/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<ProductsList> getProductsListStream()
    {
        return productService.getProductsList();

    }
    @RequestMapping(path="/allProductsList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ProductsList> findAllProductsList()
    {
        return productRepository.findAllProductsList();
    }
    @RequestMapping(path="/allWhiteLabelList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<WhiteLabelList> findAllWhiteLabelList()
    {
        List<WhiteLabelList> wList = whiteLabelRepository.findAll();
        if(wList.isEmpty())
        {
            throw new NoDataFoundException();
        }
        else
        {
            return wList;
        }
    }

    @RequestMapping(path="/findProductsListByItemCode/{ITEM_NO}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ProductsList> findProductsListByItemCode(@PathVariable String ItemCode)
    {

        return productRepository.findProductsListByItemCode(ItemCode);
    }

}

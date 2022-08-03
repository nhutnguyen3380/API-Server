/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux;

import com.nhutnguyen.springbootwebflux.Entity.Product;
import com.nhutnguyen.springbootwebflux.Entity.ProductsList;
import com.nhutnguyen.springbootwebflux.Entity.WhiteLabelList;
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
import java.util.stream.Collectors;


@RestController
public class HelloResource {
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
    private FetchDataService fetchDataService;

    @Autowired
    private WhiteLabelFetchDataService whiteLabelFetchDataService;

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
    @GetMapping("/getdata")
    public List<ProductsList> getProductsList()
    {
        return fetchDataService.findAll();

    }
    @GetMapping("/whitelabel")
    public List<WhiteLabelList> getWhiteLabelList()
    {
        return whiteLabelFetchDataService.findAll();
    }
//    @GetMapping(value = "/getdata/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ProductsList> getProductsListStream()
//    {
//        return ""
//
//    }


}

/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.qcells.springbootAPIserver.controller;

import com.qcells.springbootAPIserver.Entity.ProductsList;
import com.qcells.springbootAPIserver.Entity.WhiteLabelList;
import com.qcells.springbootAPIserver.NoDataFoundException;
import com.qcells.springbootAPIserver.JwtUtil;
import com.qcells.springbootAPIserver.repository.ProductRepository;
import com.qcells.springbootAPIserver.repository.WhiteLabelRepository;
import com.qcells.springbootAPIserver.models.AuthenticationRequest;
import com.qcells.springbootAPIserver.models.AuthenticationResponse;
import com.qcells.springbootAPIserver.services.ProductService;
import com.qcells.springbootAPIserver.services.WhiteLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private ProductService productService;

    @Autowired
    private WhiteLabelService whiteLabelService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WhiteLabelRepository whiteLabelRepository;


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


    @GetMapping("/whitelabel")
    public List<WhiteLabelList> getWhiteLabelList()
    {
        return whiteLabelRepository.findAll();
    }

    @RequestMapping(path="/allProductsList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsList>> findAllProductsList()
    {
        return ResponseEntity.ok(productService.getAllProductsList());
    }
    @RequestMapping(path="/allWhiteLabelList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<WhiteLabelList>> findAllWhiteLabelList()
    {
        List<WhiteLabelList> wList = whiteLabelService.getAllWhiteLabelList();
        if(wList.isEmpty())
        {
            throw new NoDataFoundException();
        }
        else
        {
            return ResponseEntity.ok(wList);
        }
    }
    @RequestMapping(path="/productslist", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsList>> findProductsList()
    {
        return ResponseEntity.ok(productService.getProductsList());
    }

    @RequestMapping(path="/findProductsListByItemCode/{ITEM_NO}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ProductsList> findProductsListByItemCode(@PathVariable String ItemCode)
    {

        return productRepository.findProductsListByItemCode(ItemCode);
    }

}

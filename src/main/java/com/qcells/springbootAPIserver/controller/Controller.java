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
import org.apache.coyote.Response;
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

/*
    Main controller class with the URL paths
 */


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


    // Authenticate POST method to authorize user access to the API server
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

    // First QSP Query. GET request returns products list data from the QCELLS database
    @RequestMapping(path="/ProductsList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsList>> findAllProductsList()
    {
        return ResponseEntity.ok(productService.getAllProductsList());
    }
    // Second QSP query. GET request returns the white label list data from the QCELLS database
    @RequestMapping(path="/WhiteLabelList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
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


    // GET method for counting the number of objects
    @RequestMapping(path="/countWhiteLabelList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> countWhiteLabelList()
    {
        return ResponseEntity.ok(whiteLabelService.countWhiteLabelList());
    }
    // GET method for counting the number of objects
    @RequestMapping(path="/countProductsList", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> countProductsList()
    {
        return ResponseEntity.ok(productService.countProductsList());
    }


    // Unfiltered white label list, has NULL values
    @RequestMapping(path = "/allWhiteLabelList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public List<WhiteLabelList> getWhiteLabelList()
    {
        return whiteLabelRepository.findAll();
    }
    // Filtered product list with NO NULL values

    @RequestMapping(path="/allProductsList", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductsList>> findProductsList()
    {
        return ResponseEntity.ok(productService.getProductsList());
    }

    //Find products list by ITEM NO
    @RequestMapping(path="/findProductsListByItemCode/{ITEM_NO}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<ProductsList> findProductsListByItemCode(@PathVariable String ItemCode)
    {

        return productRepository.findProductsListByItemCode(ItemCode);
    }

}

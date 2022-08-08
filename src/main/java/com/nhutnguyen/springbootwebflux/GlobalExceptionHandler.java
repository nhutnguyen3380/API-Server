/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.nhutnguyen.springbootwebflux;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(
            NoDataFoundException ex, WebRequest request
    )
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "No data found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<Map<String, String>> handleException(
//            HttpRequestMethodNotSupportedException e) throws IOException {
//        Map<String, String> errorResponse = new HashMap<>();
//        String provided = e.getMethod();
//        List<String> supported = Arrays.asList(e.getSupportedMethods());
//
//        String error = provided + " is not one of the supported Http Methods (" +
//                String.join(", ", supported) + ")";
//        errorResponse.put("error", error);
//        errorResponse.put("message", e.getLocalizedMessage());
//        errorResponse.put("status", HttpStatus.METHOD_NOT_ALLOWED.toString());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
//    }
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<String> handleMediaTypeException(HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException)
    {
        return new ResponseEntity<String>("Acceptable data type:" + MediaType.APPLICATION_JSON_VALUE + " or " + MediaType.APPLICATION_XML_VALUE, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException)
    {
        return new ResponseEntity<String>("Method not supported", HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException accessDeniedException)
    {
        return new ResponseEntity<String>("Access denied", HttpStatus.UNAUTHORIZED);
    }

//    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    @ResponseBody
//    public String handleMediaTypeNotAcceptable(
//            final HttpMediaTypeNotAcceptableException exception,
//            final HttpServletRequest request) {
//        return "acceptable data type:" + MediaType.APPLICATION_JSON_VALUE + " or " + MediaType.APPLICATION_XML_VALUE;
//    }







}

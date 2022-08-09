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
    public ResponseEntity<String> handleNoDataFoundException(
            NoDataFoundException noDataFoundException, WebRequest request)
    {
        return new ResponseEntity<String>("Error: " + "\nMessage: " + noDataFoundException.getLocalizedMessage() + "\nStatus: Error", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException)
    {
        String error = httpRequestMethodNotSupportedException.getMethod() + " is not one of the supported HTTP methods";
        return new ResponseEntity<String>("Error: " + error + "\nMessage: " + httpRequestMethodNotSupportedException.getLocalizedMessage() + "\nStatus: " + HttpStatus.METHOD_NOT_ALLOWED.toString(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<String> handleMediaTypeException(HttpMediaTypeNotAcceptableException httpMediaTypeNotAcceptableException)
    {
        String error = "Unsupported data types";
        return new ResponseEntity<String>("Error: " + error + "\nMessage: " + httpMediaTypeNotAcceptableException.getLocalizedMessage() + "\nStatus: " + HttpStatus.NOT_ACCEPTABLE.toString(), HttpStatus.NOT_ACCEPTABLE);
    }



}

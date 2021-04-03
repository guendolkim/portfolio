package com.kh.portfolio.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

	@ExceptionHandler(RestAccessException.class)
	  public ResponseEntity<Map<String,Object>> haldler(
	  		HttpServletRequest request, RestAccessException ex) {
			Map<String,Object> map = new HashMap<>();
			map.put("rtcd", "01");
			map.put("rtmsg", ex.getErrMsgList());
			
			log.error("Request: " + request.getRequestURL() + " called " + ex);
	    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	  }

}

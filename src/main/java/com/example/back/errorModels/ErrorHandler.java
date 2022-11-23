package com.example.back.errorModels;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ErrorHandler {

   @ExceptionHandler(MethodArgumentTypeMismatchException.class)
   public ResponseEntity<ErrorInfo> methodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        System.out.println(e.getMessage());
        String value = (e.getValue()!=null)?e.getValue().toString().toString():"";
        String requiredType = (e.getRequiredType()!=null)?e.getRequiredType().toString():"";

        ErrorInfo errorInfo = new ErrorInfo(e.getErrorCode(),e.getName(),value,requiredType, e.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
   }

}

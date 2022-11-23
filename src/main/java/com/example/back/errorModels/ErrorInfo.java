package com.example.back.errorModels;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ErrorInfo {
    private String errorType;
    @JsonAlias("var")
    private String errorName;
    private String value;
    private String expected;
    @JsonAlias("message")
    private String msg;

   public ErrorInfo(String errorType, String errorName, String value, String expected, String msg){
    this.errorType = errorType;
    this.errorName = errorName;
    this.value = value;
    this.expected = expected;
    this.msg = msg;
   }

   public String getErrorType(){
    return errorType;
   }

   public String getErrorName(){
    return errorName;
   }
   public String getValue(){
    return value;
   }
   public String getExpected(){
    return expected;
   }
   public String getMsg(){
    return msg;
   }
}

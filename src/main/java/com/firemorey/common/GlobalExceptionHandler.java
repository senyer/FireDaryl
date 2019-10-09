package com.firemorey.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @SuppressWarnings("unchecked")
  public R handHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
    log.error("[统一异常处理]--[请求方式] {}  ", ex.toString());
    return new R(Msg.HTTP_REQUEST_ERROR, ex.getMessage());
  }

  @ExceptionHandler(FireException.class)
  @SuppressWarnings("unchecked")
  public R handEGBException(FireException ex) {
    log.error("[统一异常处理]--[自定义异常] {}  ", ex.toString());
    return new R(Msg.ERROR, ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @SuppressWarnings("unchecked")
  public R handUnkonwException(Exception ex) {
    log.error("[统一异常处理]--[未知异常]  {} ", ex.toString());
    return new R(Msg.ERROR, ex.getMessage());
  }
}

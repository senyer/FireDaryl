package com.firemorey.common;

public enum Msg {

  SUCCESS("OK", 200),
  AUTHORIZATION("Unauthorized", 401),
  AUTHENTICATION("Authentication failure", 402),
  HTTP_REQUEST_ERROR("Unsupported Request", 405),
  ERROR("Inner Error", 500),
  DUPLICATE_SUBMIT("请勿重复提交", -1),
  ;

  private String desc;
  private Integer statusCode;

  private Msg(String desc, Integer statusCode) {
    this.desc = desc;
    this.statusCode = statusCode;
  }

  private Msg(String desc) {
    this.desc = desc;
  }

  private Msg(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    return this.desc;
  }

}

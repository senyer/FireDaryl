package com.firemorey.common;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * web层通用数据处理
 *
 * @author Administrator
 */
public class BaseController {

  /**
   * 将前台传递过来的日期格式的字符串，自动转化为Date类型
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
  }

  /**
   * 返回成功
   */
  public R success() {
    return new R(Msg.SUCCESS);
  }

  /**
   * 返回成功+数据
   */
  public R success(Object object) {
    return new R(Msg.SUCCESS, object);
  }

  /**
   * 返回成功消息
   */
  public R success(String message) {
    return new R(Msg.SUCCESS, message);
  }

  /**
   * 返回失败消息
   */
  public R error() {
    return new R(Msg.ERROR);
  }

  /**
   * 返回枚举错误信息
   */
  public R error(Msg msg) {
    return new R(msg);
  }

  /**
   * 返回枚举错误信息
   */
  public R error(Msg msg, String message) {
    return new R(msg, message);
  }

}

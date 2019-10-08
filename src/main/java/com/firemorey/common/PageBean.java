package com.firemorey.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 统一的分页查询用的封装类
 */
@Data
public class PageBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private long total; // 总记录数
  private List list; // 结果集
  private long pageNum; // 第几页
  private long pageSize; // 每页记录数
  private long pages; // 总页数
  private long size; // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

  public PageBean(List list) {
    if (list instanceof Page) {
      Page page = (Page) list;
      this.pageNum = page.getCurrent();
      this.pageSize = page.getSize();
      this.total = page.getTotal();
      this.pages = page.getPages();
      this.list = page.getRecords();
      this.size = list.size();
    }
  }

  public PageBean(List sourceList, List targetList) {
    if (sourceList instanceof Page) {
      Page page = (Page) list;
      this.pageNum = page.getCurrent();
      this.pageSize = page.getSize();
      this.total = page.getTotal();
      this.pages = page.getPages();
      this.list = targetList;
      this.size = list.size();
    }
  }

  public PageBean(Collection collection) {
    if (collection instanceof Page) {
      Page page = (Page) list;
      this.pageNum = page.getCurrent();
      this.pageSize = page.getSize();
      this.total = page.getTotal();
      this.pages = page.getPages();
      this.list = page.getRecords();
      this.size = list.size();
    }
  }

}

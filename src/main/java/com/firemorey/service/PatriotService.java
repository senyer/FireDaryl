package com.firemorey.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.firemorey.domain.Patriot;
import com.firemorey.vo.PatrioDetailVO;
import com.firemorey.vo.PatrioVO;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gardener
 * @since 2019-10-08
 */
public interface PatriotService extends IService<Patriot> {

  /**
   * 异步处理用户入库信息
   * @param pic 电子签名图
   * @param username 用户名
   * @param userAgent 用户代理
   * @param ip 用户ip
   */
  void saveAsync(MultipartFile pic,String username,String userAgent,String ip);


  /**
   *
   * @param page 分页对象
   * @return 用户的图片+用户名
   */
  IPage<PatrioVO> selectPatrioVOPage(Page page);

  /**
   *
   * @param page 分页对象
   * @return 用户详情
   */
  IPage<PatrioDetailVO> selectPatrioDeatilVOPage(Page page);

}

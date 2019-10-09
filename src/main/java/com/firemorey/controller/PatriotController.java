package com.firemorey.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.firemorey.common.BaseController;
import com.firemorey.common.Msg;
import com.firemorey.common.PageUtil;
import com.firemorey.common.PageVo;
import com.firemorey.common.R;
import com.firemorey.service.PatriotService;
import com.firemorey.vo.PatrioDetailVO;
import com.firemorey.vo.PatrioVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gardener
 * @since 2019-10-08
 */
@RestController
@Slf4j
@CrossOrigin
public class PatriotController extends BaseController {

  //TODO senyer
  public static final AtomicInteger count = new AtomicInteger(0);

  //TODO senyer 后期转Redis
  private static final CopyOnWriteArrayList<String> ips = new CopyOnWriteArrayList<>();

  @Resource
  private PatriotService patriotService;

  @Resource
  private HttpServletRequest httpServletRequest;

  @PostMapping("/")
  @ApiOperation(value = "提交用户签名信息，用户名非必须。但是签名图片必须")
  @ApiImplicitParam(name = "username", defaultValue = "匿名", required = false)
  public R insert(String username, @RequestParam("file") MultipartFile pic){
    String ip = httpServletRequest.getRemoteAddr();
    /*
      判断ip是否存在。不存在则添加。存在则表明重复提交
     */
    if (ips.contains(ip)) {
      return error(Msg.DUPLICATE_SUBMIT);
    } else {
      ips.add(ip);
    }
    String userAgent = httpServletRequest.getHeader("User-Agent");
    patriotService.saveAsync(pic,username,userAgent,ip);

    /*
     * 统计签名数量
     */
    count.getAndIncrement();
    return success();
  }

  @GetMapping("/simple")
  @ApiOperation(value = "简单的分页查询用户列表,支持自定义排序")
  public R<IPage<PatrioVO>> selectPage(PageVo pageVo) {
    IPage<PatrioVO> patrioVO = patriotService.selectPatrioVOPage(PageUtil.initMpPage(pageVo));
    return new R<>(Msg.SUCCESS, patrioVO);
  }

  @GetMapping("/detail")
  @ApiOperation(value = "详细的分页查询用户列表,支持自定义排序")
  public R<IPage<PatrioDetailVO>> selectDetailPage(PageVo pageVo) {
    IPage<PatrioDetailVO> detailVO = patriotService.selectPatrioDeatilVOPage(PageUtil.initMpPage(pageVo));
    return new R<>(Msg.SUCCESS, detailVO);
  }

  @GetMapping("/count")
  @ApiOperation(value = "获取已签名人数")
  public R<Integer> count() {
    return new R<>(Msg.SUCCESS, count.get());
  }

}


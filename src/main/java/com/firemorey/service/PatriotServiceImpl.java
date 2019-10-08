package com.firemorey.service;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.firemorey.domain.Patriot;
import com.firemorey.mapper.PatriotMapper;
import com.firemorey.vo.PatrioDetailVO;
import com.firemorey.vo.PatrioVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gardener
 * @since 2019-10-08
 */
@Service
@Slf4j
public class PatriotServiceImpl extends ServiceImpl<PatriotMapper, Patriot> implements PatriotService {

  @Value("${firemorey.pic.url}")
  private String picUrl;
  @Value("${firemorey.pic.path}")
  private String path;

  @Resource
  private PatriotMapper patriotMapper;
  /*
   * 异步执行
   */
  @Override
  public void saveAsync(MultipartFile pic, String username, String userAgent, String ip) {
    try {
      String fileName;
      String originalFilename = pic.getOriginalFilename();
      String randomUUID = UUID.randomUUID().toString().replaceAll("-", "");
      String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
      fileName = randomUUID + "." + suffix;
      /*
       * 图片保存到本地
       */
      String targetPath = path + fileName;
      File targetFile = new File(targetPath);
      File fileParent = targetFile.getParentFile();
      if (!fileParent.exists()) {
        fileParent.mkdirs();
      }
      targetFile.createNewFile();
      pic.transferTo(targetFile);

      /*
       * 设置用户访问路径
       */
      String filePath = picUrl + "/img/" + fileName;

      UserAgent ua = UserAgentUtil.parse(userAgent);
      String terminalDevice;

      if (ua.isMobile()) {
        terminalDevice = "手机";
      } else {
        terminalDevice = "电脑";
      }

      /*
       * 信息入库
       */
      Patriot patriot = new Patriot();
      patriot.setIpInfo(ua.getBrowser().getName())
              .setSignedPicture(filePath)
              .setTerminalDevice(terminalDevice)
              .setTime(LocalDateTime.now())
              .setUserAgent(ua.getOs().getName())
              .setUserName(username)
              .setIp(ip);
      patriotMapper.insert(patriot);
    } catch (Exception e) {
      log.error("用户信息入库失败：{}",e.toString());
    }
  }

  @Override
  public IPage<PatrioVO> selectPatrioVOPage(Page page) {
    return patriotMapper.selectPatrioVOPage(page);
  }

  @Override
  public IPage<PatrioDetailVO> selectPatrioDeatilVOPage(Page page) {
    return patriotMapper.selectPatrioDeatilVOPage(page);
  }

}

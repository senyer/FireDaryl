package com.firemorey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.firemorey.domain.Patriot;
import com.firemorey.vo.PatrioDetailVO;
import com.firemorey.vo.PatrioVO;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gardener
 * @since 2019-10-08
 */
public interface PatriotMapper extends BaseMapper<Patriot> {

  @Select("SELECT signed_picture,user_name FROM patriot")
  IPage<PatrioVO> selectPatrioVOPage(Page page);

  @Select("SELECT id,signed_picture,terminal_device,user_agent,ip,ip_info,user_name,time FROM patriot")
  IPage<PatrioDetailVO> selectPatrioDeatilVOPage(Page page);
}

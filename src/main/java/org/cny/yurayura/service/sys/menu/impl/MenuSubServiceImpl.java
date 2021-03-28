package org.cny.yurayura.service.sys.menu.impl;

import org.cny.yurayura.entity.sys.menu.MenuSub;
import org.cny.yurayura.dao.sys.menu.MenuSubMapper;
import org.cny.yurayura.enumerate.MenuTypeEnum;
import org.cny.yurayura.service.sys.menu.IMenuSubService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统子菜单 service impl
 *
 * @author CNY
 * @since 2021-03-16
 */
@Service
public class MenuSubServiceImpl extends ServiceImpl<MenuSubMapper, MenuSub> implements IMenuSubService {

    @Autowired
    private MenuSubMapper menuSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult insert(MenuSub menuSub) {
        menuSub.setMenuType(MenuTypeEnum.SECONDLEVEL.getTypeId());
        menuSubMapper.insert(menuSub);
        return ApiResult.success("添加成功");
    }
}

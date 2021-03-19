package org.cny.yurayura.service.sys.menu.impl;

import org.cny.yurayura.entity.sys.menu.Menu;
import org.cny.yurayura.dao.sys.menu.MenuMapper;
import org.cny.yurayura.service.sys.menu.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统菜单 service impl
 *
 * @author CNY
 * @since 2021-03-16
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ApiResult getList() {
        return ApiResult.success("列表查询成功", menuMapper.getList());
    }
}
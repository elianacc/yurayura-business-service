package org.cny.yurayura.service.sys.menu.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.cny.yurayura.dao.sys.menu.MenuSubMapper;
import org.cny.yurayura.entity.sys.menu.Menu;
import org.cny.yurayura.dao.sys.menu.MenuMapper;
import org.cny.yurayura.entity.sys.menu.MenuSub;
import org.cny.yurayura.enumerate.MenuTypeEnum;
import org.cny.yurayura.service.sys.menu.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private MenuSubMapper menuSubMapper;

    @Override
    public ApiResult getList() {
        return ApiResult.success("列表查询成功", menuMapper.getList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult insert(Menu menu) {
        List<String> menuNameList = menuMapper.getMenuNameAndMenuSubName();
        if (menuNameList.contains(menu.getMenuName())) {
            return ApiResult.warn("菜单标识已存在，请更换");
        }
        menu.setMenuType(MenuTypeEnum.FIRSTLEVEL.getTypeId());
        menuMapper.insert(menu);
        return ApiResult.success("添加成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult deleteById(Integer id) {
        menuMapper.deleteById(id);
        QueryWrapper<MenuSub> queryWrapper = new QueryWrapper<>();
        menuSubMapper.delete(queryWrapper.eq("menu_pid", id));
        return ApiResult.success("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult update(Menu menu) {
        Menu oldMenu = menuMapper.selectById(menu.getId());
        List<String> menuNameList = menuMapper.getMenuNameAndMenuSubName();
        if (menuNameList.contains(menu.getMenuName()) && !menu.getMenuName().equals(oldMenu.getMenuName())) {
            return ApiResult.warn("菜单标识已存在，请更换");
        }
        menuMapper.updateById(menu);
        return ApiResult.success("修改成功");
    }
}

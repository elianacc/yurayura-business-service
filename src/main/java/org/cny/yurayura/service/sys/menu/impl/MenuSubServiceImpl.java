package org.cny.yurayura.service.sys.menu.impl;

import org.cny.yurayura.dao.sys.menu.MenuMapper;
import org.cny.yurayura.entity.sys.menu.MenuSub;
import org.cny.yurayura.dao.sys.menu.MenuSubMapper;
import org.cny.yurayura.enumerate.MenuTypeEnum;
import org.cny.yurayura.service.sys.menu.IMenuSubService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统子菜单 service impl
 *
 * @author CNY
 * @since 2021-03-16
 */
@Service
public class MenuSubServiceImpl extends ServiceImpl<MenuSubMapper, MenuSub> implements IMenuSubService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuSubMapper menuSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult insert(MenuSub menuSub) {
        List<String> menuNameList = menuMapper.getMenuNameAndMenuSubName();
        if (menuNameList.contains(menuSub.getMenuName())) {
            return ApiResult.warn("菜单标识已存在，请更换");
        }
        menuSub.setMenuType(MenuTypeEnum.SECONDLEVEL.getTypeId());
        menuSubMapper.insert(menuSub);
        return ApiResult.success("添加成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult deleteById(Integer id) {
        menuSubMapper.deleteById(id);
        return ApiResult.success("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ApiResult update(MenuSub menuSub) {
        MenuSub oldMenuSub = menuSubMapper.selectById(menuSub.getId());
        List<String> menuNameList = menuMapper.getMenuNameAndMenuSubName();
        if (menuNameList.contains(menuSub.getMenuName()) && !menuSub.getMenuName().equals(oldMenuSub.getMenuName())) {
            return ApiResult.warn("菜单标识已存在，请更换");
        }
        menuSubMapper.updateById(menuSub);
        return ApiResult.success("修改成功");
    }
}

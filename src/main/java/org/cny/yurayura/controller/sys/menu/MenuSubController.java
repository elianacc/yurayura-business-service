package org.cny.yurayura.controller.sys.menu;

import io.swagger.annotations.*;
import org.cny.yurayura.entity.sys.menu.MenuSub;
import org.cny.yurayura.system.annotation.PreventRepeatSubmit;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.cny.yurayura.service.sys.menu.IMenuSubService;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统子菜单 controller
 *
 * @author CNY
 * @since 2021-03-16
 */
@RestController
@RequestMapping("/api/sys/menuSub")
@Api(tags = "系统子菜单API")
public class MenuSubController {

    @Autowired
    private IMenuSubService iMenuSubService;

    /**
     * 查询系统子菜单（根据id）
     *
     * @param id
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getById")
    @ApiOperation("查询系统子菜单（根据id）")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1", dataType = "int")
    public ApiResult getById(Integer id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.warn("id不能为空");
        }
        return ApiResult.success("查询成功", iMenuSubService.getById(id));
    }

    /**
     * 添加系统子菜单
     *
     * @param menuSub
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PreventRepeatSubmit
    @PostMapping("/insert")
    @ApiOperation("添加系统子菜单")
    public ApiResult insert(@RequestBody MenuSub menuSub) {
        if (StringUtils.isEmpty(menuSub.getMenuTitle())) {
            return ApiResult.warn("标题不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuName())) {
            return ApiResult.warn("标识不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuIconClass())) {
            return ApiResult.warn("图标样式不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuSeq())) {
            return ApiResult.warn("序号不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuIndex())) {
            return ApiResult.warn("路径不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuPid())) {
            return ApiResult.warn("父菜单id不能为空");
        }
        return iMenuSubService.insert(menuSub);
    }

    /**
     * 删除系统子菜单（根据id）
     *
     * @param id
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/deleteById")
    @ApiOperation("删除系统子菜单（根据id）")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1", dataType = "int")
    public ApiResult deleteById(Integer id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.warn("id不能为空");
        }
        return iMenuSubService.deleteById(id);
    }

    /**
     * 修改系统子菜单
     *
     * @param menuSub
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PreventRepeatSubmit
    @PostMapping("/update")
    @ApiOperation("修改系统子菜单")
    public ApiResult update(@RequestBody MenuSub menuSub) {
        if (StringUtils.isEmpty(menuSub.getId()) || menuSub.getId() == 0) {
            return ApiResult.warn("id不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuTitle())) {
            return ApiResult.warn("标题不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuName())) {
            return ApiResult.warn("标识不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuIconClass())) {
            return ApiResult.warn("图标样式不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuSeq())) {
            return ApiResult.warn("序号不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuIndex())) {
            return ApiResult.warn("路径不能为空");
        } else if (StringUtils.isEmpty(menuSub.getMenuPid())) {
            return ApiResult.warn("父菜单id不能为空");
        }
        return iMenuSubService.update(menuSub);
    }
}


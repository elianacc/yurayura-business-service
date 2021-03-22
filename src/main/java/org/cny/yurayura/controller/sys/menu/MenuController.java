package org.cny.yurayura.controller.sys.menu;

import io.swagger.annotations.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.cny.yurayura.service.sys.menu.IMenuService;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 系统菜单 controller
 *
 * @author CNY
 * @since 2021-03-16
 */
@RestController
@RequestMapping("/api/sys/menu")
@Api(tags = "系统菜单API")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    /**
     * 查询系统菜单（根据id）
     *
     * @param id
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getById")
    @ApiOperation("查询系统菜单（根据id）")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1", dataType = "int")
    public ApiResult getById(Integer id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.warn("id不能为空");
        }
        return ApiResult.success("查询成功", iMenuService.getById(id));
    }

    /**
     * 查询系统菜单列表(侧边导航使用)
     *
     * @param
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getSysMenu")
    @ApiIgnore
    public ApiResult getSysMenu() {
        return iMenuService.getList();
    }

    /**
     * 查询系统菜单列表
     *
     * @param
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getList")
    @ApiOperation("查询系统菜单列表")
    public ApiResult getList() {
        return iMenuService.getList();
    }
}


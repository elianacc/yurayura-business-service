package org.cny.yurayura.controller.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.cny.yurayura.dto.UserSelectDto;
import org.cny.yurayura.entity.user.User;
import org.cny.yurayura.service.user.IUserService;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户 controller
 *
 * @author CNY
 * @since 2019-10-27
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户API")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 查询用户（根据id）
     *
     * @param id
     * @return org.cny.yurayura.vo.ApiResult
     */
    @GetMapping("/getById")
    @ApiOperation("查询用户（根据id）")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1", dataType = "int")
    public ApiResult getById(Integer id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.warn("id不能为空");
        }
        return ApiResult.success("查询成功", iUserService.getById(id));
    }

    /**
     * 分页查询用户
     *
	 * @param dto
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getPage")
    @ApiOperation("分页查询用户")
    public ApiResult getPage(@RequestBody UserSelectDto dto) {
        if (StringUtils.isEmpty(dto.getPageNum())) {
            return ApiResult.warn("页码不能为空");
        } else if (StringUtils.isEmpty(dto.getPageSize())) {
            dto.setPageSize(10); //页记录数默认10
        }
        return iUserService.getPage(dto);
    }

    /**
     * 修改状态（根据id）
     *
     * @param user
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/updateStatus")
    @ApiOperation("修改状态（根据id）")
    public ApiResult updateStatus(User user) {
        if (StringUtils.isEmpty(user.getId()) || user.getId() == 0) {
            return ApiResult.warn("id不能为空");
        } else if (StringUtils.isEmpty(user.getUserStatus())) {
            return ApiResult.warn("状态不能为空");
        }
        return iUserService.updateStatus(user);
    }

}


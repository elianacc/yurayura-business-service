package org.cny.yurayura.service.sys.menu;

import org.cny.yurayura.entity.sys.menu.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.cny.yurayura.vo.ApiResult;

/**
 * 系统菜单 service
 *
 * @author CNY
 * @since 2021-03-16
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询系统菜单列表
     *
     * @param
     * @return org.cny.yurayura.vo.ApiResult
     */
    public ApiResult getList();
}
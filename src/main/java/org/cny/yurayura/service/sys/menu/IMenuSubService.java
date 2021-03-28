package org.cny.yurayura.service.sys.menu;

import org.cny.yurayura.entity.sys.menu.MenuSub;
import com.baomidou.mybatisplus.extension.service.IService;
import org.cny.yurayura.vo.ApiResult;

/**
 * 系统子菜单 service
 *
 * @author CNY
 * @since 2021-03-16
 */
public interface IMenuSubService extends IService<MenuSub> {

    /**
     * 添加系统子菜单
     *
     * @param menuSub
     * @return org.cny.yurayura.vo.ApiResult
     */
    public ApiResult insert(MenuSub menuSub);

}

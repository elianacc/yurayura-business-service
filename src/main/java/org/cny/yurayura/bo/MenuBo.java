package org.cny.yurayura.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.cny.yurayura.entity.sys.menu.MenuSub;

import java.io.Serializable;
import java.util.List;

/**
 * 系统菜单 bo
 *
 * @author CNY
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuBo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 标题
     */
    private String menuTitle;

    /**
     * 标识
     */
    private String menuName;

    /**
     * 图标样式
     */
    private String menuIconClass;

    /**
     * 类型- 1：一级菜单，2：二级菜单
     */
    private Integer menuType;

    /**
     * 序号
     */
    private Integer menuSeq;

    /**
     * 子菜单
     */
    private List<MenuSub> menuSubList;

}

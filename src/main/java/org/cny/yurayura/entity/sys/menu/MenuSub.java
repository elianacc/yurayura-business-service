package org.cny.yurayura.entity.sys.menu;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统子菜单 entity
 *
 * @author CNY
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yurayura_sys_menu_sub")
@ApiModel(value = "MenuSub对象", description = "系统子菜单")
public class MenuSub implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String menuTitle;

    /**
     * 标识
     */
    @ApiModelProperty(value = "标识")
    private String menuName;

    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String menuIndex;

    /**
     * 图标样式
     */
    @ApiModelProperty(value = "图标样式")
    private String menuIconClass;

    /**
     * 父菜单id
     */
    @ApiModelProperty(value = "父菜单id")
    private Integer menuPid;

    /**
     * 类型- 1：一级菜单，2：二级菜单
     */
    @ApiModelProperty(value = "类型- 1：一级菜单，2：二级菜单")
    private Integer menuType;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer menuSeq;


}

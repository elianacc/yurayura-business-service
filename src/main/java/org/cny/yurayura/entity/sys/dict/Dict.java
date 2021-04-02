package org.cny.yurayura.entity.sys.dict;

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
 * 系统数据字典 entity
 *
 * @author CNY
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yurayura_sys_dict")
@ApiModel(value = "Dict对象", description = "系统数据字典")
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    private String dictCode;

    /**
     * 字典名
     */
    @ApiModelProperty(value = "字典名")
    private String dictName;

    /**
     * 字典值
     */
    @ApiModelProperty(value = "字典值")
    private String dictVal;

    /**
     * 启用状态- 0：禁用，1：启用
     */
    @ApiModelProperty(value = "启用状态- 0：禁用，1：启用")
    private Integer dictStatus;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer dictSeq;

}

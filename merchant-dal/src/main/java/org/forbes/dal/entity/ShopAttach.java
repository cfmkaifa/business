package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_shop_attach
 */
@Data
@ApiModel(description="商家附件")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_attach")
public class ShopAttach extends BaseEntity {


	private static final long serialVersionUID = -3561817498582590410L;

	/**
     * 数据ID
     * Table:     f_shop_attach
     * Column:    data_id
     * Nullable:  true
     */
	@ApiModelProperty(value = "数据ID",example = "0")
    private Long dataId;

    /**
     * 排序
     * Table:     f_shop_attach
     * Column:    orders_sort
     * Nullable:  true
     */
    @ApiModelProperty(value = "排序",example = "0")
    private Integer ordersSort;

    /**
     * 后缀
     * Table:     f_shop_attach
     * Column:    suffix
     * Nullable:  true
     */
    @ApiModelProperty(value = "后缀")
    private String suffix;

    /**
     * 中文名称
     * Table:     f_shop_attach
     * Column:    cn_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "中文名称")
    private String cnName;

    /**
     * Table:     f_shop_attach
     * Column:    en_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "英文名称")
    private String enName;

    /**
     * 文件地址
     * Table:     f_shop_attach
     * Column:    file_path
     * Nullable:  true
     */
    @ApiModelProperty(value = "文件地址")
    private String filePath;

    /**
     * 图片
     * Table:     f_shop_attach
     * Column:    type
     * Nullable:  true
     */
    @ApiModelProperty(value = "图片")
    private String type;

    /**
     * 0-商家身份证，1-法人身份证，2-营业执照
     * Table:     f_shop_attach
     * Column:    data_type
     * Nullable:  true
     */
    @ApiModelProperty(value = "0-商家身份证，1-法人身份证，2-营业执照")
    private String dataType;
}
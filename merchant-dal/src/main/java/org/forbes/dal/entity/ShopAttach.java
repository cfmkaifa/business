package org.forbes.dal.entity;

import lombok.Data;

/**
 * Table: f_shop_attach
 */
@Data
public class ShopAttach extends BaseEntity {
    /**
     * 数据ID
     * Table:     f_shop_attach
     * Column:    data_id
     * Nullable:  true
     */
    private Long dataId;

    /**
     * 排序
     * Table:     f_shop_attach
     * Column:    orders_sort
     * Nullable:  true
     */
    private Integer ordersSort;

    /**
     * 后缀
     * Table:     f_shop_attach
     * Column:    suffix
     * Nullable:  true
     */
    private String suffix;

    /**
     * 中文名称
     * Table:     f_shop_attach
     * Column:    cn_name
     * Nullable:  true
     */
    private String cnName;

    /**
     * Table:     f_shop_attach
     * Column:    en_name
     * Nullable:  true
     */
    private String enName;

    /**
     * 文件地址
     * Table:     f_shop_attach
     * Column:    file_path
     * Nullable:  true
     */
    private String filePath;

    /**
     * 0-大图，1-小图，3-中图
     * Table:     f_shop_attach
     * Column:    type
     * Nullable:  true
     */
    private String type;

    /**
     * 0-商家身份证，1-法人身份证，2-营业执照
     * Table:     f_shop_attach
     * Column:    data_type
     * Nullable:  true
     */
    private String dataType;
}
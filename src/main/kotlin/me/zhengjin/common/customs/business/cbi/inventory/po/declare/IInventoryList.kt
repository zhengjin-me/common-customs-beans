/*
 * MIT License
 *
 * Copyright (c) 2022 ZhengJin Fang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.zhengjin.common.customs.business.cbi.inventory.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import org.hibernate.annotations.Where
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.ConstraintMode
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.Index
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType

/**
 * 跨境进口清单表体
 */
@Entity
@Table(name = "cbi_inventory_list", indexes = [Index(columnList = "inventory_head_id")])
@JpaComment("跨境进口清单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["gnum", "itemRecordNo", "itemNo", "itemName", "gcode", "gname", "gmodel", "barCode", "country", "tradeCountry", "currency", "qty", "unit", "qty1", "unit1", "qty2", "unit2", "price", "totalPrice", "note"]
)
@XmlRootElement(name = "InventoryList", namespace = "http://www.chinaport.gov.cn/ceb")
data class IInventoryList(
    /**
     * 货物序号
     */
    @field:[
        JpaComment("货物序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int = 0,
    /**
     * 账册备案序号
     */
    @field:[
        JpaComment("账册备案序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemRecordNo: String? = null,
    /**
     * 企业商品货号
     */
    @field:[
        JpaComment("企业商品货号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemNo: String? = null,
    /**
     * 企业商品品名
     */
    @field:[
        JpaComment("企业商品品名")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemName: String? = null,
    /**
     * 商品编码 HsCode
     */
    @field:[
        JpaComment("商品编码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gcode: String? = null,
    /**
     * 商品名称
     */
    @field:[
        JpaComment("商品名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gname: String? = null,
    /**
     * 商品规格型号
     */
    @field:[
        JpaComment("商品规格型号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gmodel: String? = null,
    /**
     * 条码
     */
    @field:[
        JpaComment("条码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var barCode: String? = null,
    /**
     * 原产国（地区）
     */
    @field:[
        JpaComment("原产国")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var country: String? = null,
    /**
     * 贸易国
     */
    @field:[
        JpaComment("贸易国")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var tradeCountry: String? = null,
    /**
     * 币制
     */
    @field:[
        JpaComment("币制")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 数量
     */
    @field:[
        JpaComment("数量")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var qty: BigDecimal = BigDecimal.ZERO,
    /**
     * 计量单位
     */
    @field:[
        JpaComment("计量单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit: String? = null,
    /**
     * 法定数量
     */
    @field:[
        JpaComment("法定数量")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var qty1: BigDecimal? = null,
    /**
     * 法定计量单位
     */
    @field:[
        JpaComment("法定计量单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit1: String? = null,
    /**
     * 第二数量
     */
    @field:[
        JpaComment("第二数量")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT NULL")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", defaultValue = "0")
    ]
    var qty2: BigDecimal? = null,
    /**
     * 第二计量单位
     */
    @field:[
        JpaComment("第二计量单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var unit2: String? = null,
    /**
     * 单价
     */
    @field:[
        JpaComment("单价")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var price: BigDecimal = BigDecimal.ZERO,
    /**
     * 总价
     */
    @field:[
        JpaComment("总价")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var totalPrice: BigDecimal = BigDecimal.ZERO,
    /**
     * 备注
     */
    @field:[
        JpaComment("备注")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null

) : BaseEntity() {

    @JsonIgnore
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "inventory_head_id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    var inventoryHead: IInventoryHead? = null
}

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

package me.zhengjin.common.customs.business.cbi.order.po.declare

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import com.fasterxml.jackson.annotation.JsonIgnore
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
 * 跨境进口订单表体
 */
@Entity
@Table(name = "cbi_order_list", indexes = [Index(columnList = "order_head_id")])
@JpaComment("跨境进口订单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["gnum", "itemNo", "itemName", "gmodel", "itemDescribe", "barCode", "unit", "qty", "price", "totalPrice", "currency", "country", "note"]
)
@XmlRootElement(name = "OrderList", namespace = "http://www.chinaport.gov.cn/ceb")
data class IOrderList(
    /**
     * 商品序号
     */
    @field:[
        JpaComment("商品序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int? = null,
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
     * 企业商品名称
     */
    @field:[
        JpaComment("企业商品名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var itemName: String? = null,
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
     * 企业商品描述
     */
    @field:[
        JpaComment("企业商品描述")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemDescribe: String? = null,
    /**
     * 条形码
     */
    @field:[
        JpaComment("条形码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var barCode: String? = null,
    /**
     * 单位
     */
    @field:[
        JpaComment("单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit: String? = null,
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
     * 币制
     */
    @field:[
        JpaComment("币制")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 原产国
     */
    @field:[
        JpaComment("原产国")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var country: String? = null,
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
    @JoinColumn(name = "order_head_id", foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    var orderHead: IOrderHead? = null
}

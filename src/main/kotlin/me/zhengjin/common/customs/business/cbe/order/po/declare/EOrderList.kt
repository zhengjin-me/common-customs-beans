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

package me.zhengjin.common.customs.business.cbe.order.po.declare

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.ConstraintMode
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
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
 *跨境出口订单表体
 */
@Entity
@Table(name = "cbe_order_list")
@JpaComment("跨境出口订单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["gnum", "itemNo", "itemName", "itemDescribe", "barCode", "unit", "currency", "qty", "price", "totalPrice", "note"])
@XmlRootElement(name = "OrderList", namespace = "http://www.chinaport.gov.cn/ceb")
data class EOrderList(

    /**
     *从1开始的递增序号。（与清单的商品项关联对应)
     */
    @field:[
        JpaComment("从1开始的递增序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int? = null,
    /**
     * 企业自定义的商品货号
     */
    @field:[
        JpaComment("企业自定义的商品货号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var itemNo: String? = null,
    /**
     * 同一类商品的中文名称。任何一种具体商品可以并只能归入表中的一个条目。
     */
    @field:[
        JpaComment("同一类商品的中文名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var itemName: String? = null,
    /**
     * 电商平台上架的商品描述宣传信息
     */
    @field:[
        JpaComment("电商平台上架的商品描述宣传信息")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemDescribe: String? = null,
    /**
     * 商品条形码一般由前缀部分、制造厂商代码、商品代码和校验码组成
     */
    @field:[
        JpaComment("商品条形码一般由前缀部分")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var barCode: String? = null,
    /**
     * 海关标准的参数代码海关标准的参数代码《JGS-20海关业务代码集》
     * 计量单位代码
     */
    @field:[
        JpaComment("计量单位代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit: String? = null,
    /**
     * 海关标准的参数代码海关标准的参数代码《JGS-20海关业务代码集》
     * 货币代码
     */
    @field:[
        JpaComment("货币代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 数量
     */
    @field:[
        JpaComment("数量")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var qty: BigDecimal? = null,
    /**
     * 单价
     */
    @field:[
        JpaComment("单价")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var price: BigDecimal? = null,
    /**
     * 总价
     */
    @field:[
        JpaComment("总价")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var totalPrice: BigDecimal? = null,
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_head_id", foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    var orderHead: EOrderHead? = null
}

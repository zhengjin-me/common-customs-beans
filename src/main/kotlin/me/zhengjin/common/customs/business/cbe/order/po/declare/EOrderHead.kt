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

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.order.po.result.EOrderReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderBy
import javax.persistence.Table
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType

/**
 * 跨境出口订单表头
 */
@Entity
@Table(name = "cbe_order_head")
@JpaComment("跨境出口订单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["orderType", "orderNo", "ebpCode", "ebpName", "ebcCode", "ebcName", "goodsValue", "freight", "currency", "note"])
@XmlRootElement(name = "OrderHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class EOrderHead(
    /**
     * 电商平台的订单类型 I-进口商品订单；E-出口商品订单
     */
    @field:[
        JpaComment("电商平台的订单类型")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderType: String? = null,
    /**
     * 电商平台的交易订单编号，同一平台的订单编号唯一不重复
     */
    @field:[
        JpaComment("电商平台的交易订单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
    /**
     * 电商平台的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("电商平台的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * 电商平台的登记名称
     */
    @field:[
        JpaComment("电商平台的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpName: String? = null,
    /**
     * 电商企业的海关注册登记编号或统一社会信用代码，对应清单的收发货人
     */
    @field:[
        JpaComment("电商企业的海关注册登记编号或统一社会信用代码，对应清单的收发货人")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 电商企业的登记名称，对应清单的收发货人
     */
    @field:[
        JpaComment("电商企业的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
    /**
     * 商品实际成交价FOB(不含运杂费)，含非现金抵扣金额
     */
    @field:[
        JpaComment("商品实际成交价FOB(不含运杂费)，含非现金抵扣金额")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var goodsValue: BigDecimal? = null,
    /**
     * 运杂费，无则填写"0"
     */
    @field:[
        JpaComment("运杂费，无则填写0")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var freight: BigDecimal = BigDecimal.ZERO,
    /**
     * 海关标准的参数代码《JGS-20海关业务代码集》
     * 货币代码
     */
    @field:[
        JpaComment("货币代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 备注
     */
    @field:[
        JpaComment("备注")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null
) : DeclareContentBaseEntity() {

    /**
     * 跨境出口订单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EOrderList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderList: MutableList<EOrderList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            return field
        }

    /**
     * 跨境出口订单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EOrderReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderReturn: MutableList<EOrderReturn> = ArrayList()
}

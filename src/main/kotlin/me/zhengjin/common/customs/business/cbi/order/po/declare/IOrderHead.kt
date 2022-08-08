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

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbi.order.po.result.IOrderReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Index
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
 * 跨境进口订单表头
 */
@Entity
@Table(
    name = "cbi_order_head",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "orderNo"),
        Index(columnList = "ebpCode"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("跨境进口订单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["orderType", "orderNo", "ebpCode", "ebpName", "ebcCode", "ebcName", "goodsValue", "freight", "discount", "taxTotal", "acturalPaid", "currency", "buyerRegNo", "buyerName", "buyerTelephone", "buyerIdType", "buyerIdNumber", "payCode", "payName", "payTransactionId", "batchNumbers", "consignee", "consigneeTelephone", "consigneeAddress", "consigneeDistrict", "note"]
)
@XmlRootElement(name = "OrderHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IOrderHead(
    /**
     * 订单类型
     */
    @field:[
        JpaComment("订单类型")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderType: String? = null,
    /**
     * 订单编号
     */
    @field:[
        JpaComment("订单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
    /**
     * 电商平台代码
     */
    @field:[
        JpaComment("电商平台代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * 电商平台名称
     */
    @field:[
        JpaComment("电商平台名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpName: String? = null,
    /**
     * 电商企业代码
     */
    @field:[
        JpaComment("电商企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 电商企业名称
     */
    @field:[
        JpaComment("电商企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
    /**
     * 商品价格
     */
    @field:[
        JpaComment("商品价格")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var goodsValue: BigDecimal = BigDecimal.ZERO,
    /**
     * 运杂费
     */
    @field:[
        JpaComment("运杂费")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var freight: BigDecimal = BigDecimal.ZERO,
    /**
     * 非现金抵扣金额
     */
    @field:[
        JpaComment("非现金抵扣金额")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var discount: BigDecimal = BigDecimal.ZERO,
    /**
     * 代扣税款
     */
    @field:[
        JpaComment("代扣税款")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var taxTotal: BigDecimal = BigDecimal.ZERO,
    /**
     * 实际支付金额
     */
    @field:[
        JpaComment("实际支付金额")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var acturalPaid: BigDecimal = BigDecimal.ZERO,
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
     * 订购人注册号
     */
    @field:[
        JpaComment("订购人注册号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerRegNo: String? = null,
    /**
     * 订购人姓名
     */
    @field:[
        JpaComment("订购人姓名")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerName: String? = null,
    /**
     * 订购人电话
     */
    @field:[
        JpaComment("订购人电话")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerTelephone: String? = null,
    /**
     * 订购人证件类型
     */
    @field:[
        JpaComment("订购人证件类型")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdType: String? = null,
    /**
     * 订购人证件号码
     */
    @field:[
        JpaComment("订购人证件号码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdNumber: String? = null,
    /**
     * 支付企业代码
     */
    @field:[
        JpaComment("支付企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payCode: String? = null,
    /**
     * 支付企业名称
     */
    @field:[
        JpaComment("支付企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payName: String? = null,
    /**
     * 支付交易编号
     */
    @field:[
        JpaComment("支付交易编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payTransactionId: String? = null,
    /**
     * 商品批次号
     */
    @field:[
        JpaComment("商品批次号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var batchNumbers: String? = null,
    /**
     * 收货人姓名
     */
    @field:[
        JpaComment("收货人姓名")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consignee: String? = null,
    /**
     * 收货人电话
     */
    @field:[
        JpaComment("收货人电话")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeTelephone: String? = null,
    /**
     * 收货地址
     */
    @field:[
        JpaComment("收货地址")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeAddress: String? = null,
    /**
     * 收货地址行政区划代码
     */
    @field:[
        JpaComment("收货地址行政区划代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var consigneeDistrict: String? = null,
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
     * 跨境进口订单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IOrderList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderList: MutableList<IOrderList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            return field
        }

    /**
     * 跨境进口订单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IOrderReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderReturn: MutableList<IOrderReturn> = ArrayList()
}

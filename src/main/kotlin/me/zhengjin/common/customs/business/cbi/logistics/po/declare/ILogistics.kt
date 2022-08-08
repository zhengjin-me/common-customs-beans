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

package me.zhengjin.common.customs.business.cbi.logistics.po.declare

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbi.logistics.po.result.ILogisticsReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Where
import java.math.BigDecimal
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
 * 跨境进口运单
 */
@Entity
@Table(name = "cbi_logistics")
@JpaComment("跨境进口运单")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["logisticsCode", "logisticsName", "logisticsNo", "billNo", "orderNo", "freight", "insuredFee", "currency", "weight", "packNo", "goodsInfo", "consignee", "consigneeAddress", "consigneeTelephone", "note"]
)
@XmlRootElement(name = "LogisticsHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class ILogistics(
    /**
     * 物流企业代码
     */
    @field:[
        JpaComment("物流企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsCode: String? = null,
    /**
     * 物流企业名称
     */
    @field:[
        JpaComment("物流企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsName: String? = null,
    /**
     * 物流运单编号
     */
    @field:[
        JpaComment("物流运单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsNo: String? = null,
    /**
     * 提运单号
     */
    @field:[
        JpaComment("提运单号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var billNo: String? = null,
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
     * 运费
     */
    @field:[
        JpaComment("运费")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", defaultValue = "0")
    ]
    var freight: BigDecimal = BigDecimal.ZERO,
    /**
     * 保价费
     */
    @field:[
        JpaComment("保价费")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", defaultValue = "0")
    ]
    var insuredFee: BigDecimal = BigDecimal.ZERO,
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
     * 毛重
     */
    @field:[
        JpaComment("毛重")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var weight: BigDecimal = BigDecimal.ZERO,
    /**
     * 件数
     */
    @field:[
        JpaComment("件数")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var packNo: Int = 0,
    /**
     * 主要货物信息
     */
    @field:[
        JpaComment("主要货物信息")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var goodsInfo: String? = null,
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
     * 收货地址
     */
    @field:[
        JpaComment("收货地址")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeAddress: String? = null,
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
     * 跨境进口运单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "logistics",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ILogisticsReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var logisticsReturn: MutableList<ILogisticsReturn> = ArrayList()
}

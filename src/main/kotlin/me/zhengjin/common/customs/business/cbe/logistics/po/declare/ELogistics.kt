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

package me.zhengjin.common.customs.business.cbe.logistics.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.logistics.po.result.ELogisticsReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
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
 * 跨境出口运单
 */
@Entity
@Table(name = "cbe_logistics")
@JpaComment("跨境出口运单")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["logisticsCode", "logisticsName", "logisticsNo", "freight", "insuredFee", "currency", "grossWeight", "packNo", "goodsInfo", "ebcCode", "ebcName", "ebcTelephone", "note"]
)
@XmlRootElement(name = "Logistics", namespace = "http://www.chinaport.gov.cn/ceb")
data class ELogistics(

    /**
     * 物流企业的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("物流企业的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsCode: String? = null,
    /**
     * 物流企业的登记名称
     */
    @field:[
        JpaComment("物流企业的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsName: String? = null,
    /**
     * 物流企业运单的包裹面单号，同一物流企业的运单编号在6个月内不重复
     */
    @field:[
        JpaComment("物流企业运单的包裹面单号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsNo: String? = null,
    /**
     * 货物运输费用
     */
    @field:[
        JpaComment("货物运输费用")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var freight: BigDecimal? = null,
    /**
     * 货物保险费用
     */
    @field:[
        JpaComment("货物保险费用")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var insuredFee: BigDecimal? = null,
    /**
     * 海关标准的参数代码《JGS-20海关业务代码集》- 货币代码
     */
    @field:[
        JpaComment("海关标准的参数代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 单位为千克
     */
    @field:[
        JpaComment("单位为千克")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var grossWeight: BigDecimal? = null,
    /**
     * 单个运单下包裹数
     */
    @field:[
        JpaComment("单个运单下包裹数")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var packNo: Int? = null,
    /**
     * 物流企业可验视的商品信息
     */
    @field:[
        JpaComment("物流企业可验视的商品信息")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var goodsInfo: String? = null,
    /**
     * 电商企业的10位海关代码或者18 位信用代码
     */
    @field:[
        JpaComment("电商企业的10位海关代码或者18")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var ebcCode: String? = null,
    /**
     * 电商企业的海关备案名称（电子口岸校验名称)
     */
    @field:[
        JpaComment("电商企业的海关备案名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var ebcName: String? = null,
    /**
     * 电商企业电话
     */
    @field:[
        JpaComment("电商企业电话")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var ebcTelephone: String? = null,
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
     * 跨境出口运单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "logistics",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ELogisticsReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var logisticsReturn: MutableList<ELogisticsReturn> = ArrayList()
}

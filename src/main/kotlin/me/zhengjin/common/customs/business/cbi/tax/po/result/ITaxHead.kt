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

package me.zhengjin.common.customs.business.cbi.tax.po.result

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1
import me.zhengjin.common.customs.po.ExtendEntity
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.Date
import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Index
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

/**
 * 跨境进口电子税单表头
 */
@Entity
@Table(
    name = "cbi_tax_head_rd",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "taxNo"),
        Index(columnList = "invtNo"),
        Index(columnList = "entDutyNo"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("跨境进口电子税单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["guid", "returnTime", "invtNo", "taxNo", "customsTax", "valueAddedTax", "consumptionTax", "status", "entDutyNo", "note", "assureCode", "ebcCode", "logisticsCode", "agentCode", "customsCode", "orderNo", "logisticsNo"]
)
@XmlRootElement(name = "TaxHeadRd", namespace = "http://www.chinaport.gov.cn/ceb")
data class ITaxHead(
    /**
     * 系统唯一序号
     */
    @field:[
        JpaComment("系统唯一序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var guid: String? = null,
    /**
     * 回执时间
     */
    @field:[
        JpaComment("回执时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1::class)
    ]
    var returnTime: Date? = null,
    /**
     * 进境清单编号
     */
    @field:[
        JpaComment("进境清单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var invtNo: String? = null,
    /**
     * 电子税单编号
     */
    @field:[
        JpaComment("电子税单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var taxNo: String? = null,
    /**
     * 应征关税
     */
    @field:[
        JpaComment("应征关税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var customsTax: BigDecimal = BigDecimal.ZERO,
    /**
     * 应征增值税
     */
    @field:[
        JpaComment("应征增值税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var valueAddedTax: BigDecimal = BigDecimal.ZERO,
    /**
     * 应征消费税
     */
    @field:[
        JpaComment("应征消费税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var consumptionTax: BigDecimal = BigDecimal.ZERO,
    /**
     * 税单状态
     * 1-已生成
     * 2-已汇总
     * 3-作废
     */
    @field:[
        JpaComment("税单状态: 1-已生成 2-已汇总 3-作废")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var status: String? = null,
    /**
     * 缴款书编号
     */
    @field:[
        JpaComment("缴款书编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var entDutyNo: String? = null,
    /**
     * 备注
     */
    @field:[
        JpaComment("备注")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null,
    /**
     * 担保企业代码
     */
    @field:[
        JpaComment("担保企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var assureCode: String? = null,
    /**
     * 电商企业代码
     */
    @field:[
        JpaComment("电商企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var ebcCode: String? = null,
    /**
     * 物流企业代码
     */
    @field:[
        JpaComment("物流企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var logisticsCode: String? = null,
    /**
     * 申报单位代码
     */
    @field:[
        JpaComment("申报单位代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var agentCode: String? = null,
    /**
     * 申报口岸
     */
    @field:[
        JpaComment("申报口岸")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var customsCode: String? = null,
    /**
     * 订单编号
     */
    @field:[
        JpaComment("订单编号")
        Column(length = 60)
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var orderNo: String? = null,
    /**
     * 物流运单编号
     */
    @field:[
        JpaComment("物流运单编号")
        Column(length = 60)
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var logisticsNo: String? = null,
) : ExtendEntity() {

    /**
     * 跨境进口电子税单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "taxHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ITaxList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var taxList: MutableList<ITaxList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.taxHead)) it.taxHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.taxHead)) it.taxHead = this }
            return field
        }
}

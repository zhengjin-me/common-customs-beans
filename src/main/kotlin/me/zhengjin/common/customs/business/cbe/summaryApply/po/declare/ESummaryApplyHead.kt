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

package me.zhengjin.common.customs.business.cbe.summaryApply.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter2
import me.zhengjin.common.customs.business.cbe.summaryApply.po.result.ESummaryReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import java.util.Date
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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

/**
 * 跨境出口汇总申请单表头
 */
@Entity
@Table(name = "cbe_summary_apply_head")
@JpaComment("跨境出口汇总申请单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "copNo", "preNo", "sumNo", "agentCode", "agentName", "ebcCode", "ebcName", "declAgentCode", "declAgentName", "startTime", "endTime", "loctNo", "summaryFlag", "itemNameFlag", "msgCount", "msgSeqNo", "note"]
)
@XmlRootElement(name = "SummaryApplyHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class ESummaryApplyHead(

    /**
     * 申报地海关代码
     */
    @field:[
        JpaComment("申报地海关代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
    /**
     * 企业唯一编号
     */
    @field:[
        JpaComment("企业唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var copNo: String? = null,
    /**
     * 电子口岸编号
     */
    @field:[
        JpaComment("电子口岸编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
    /**
     * 汇总申请编号
     */
    @field:[
        JpaComment("汇总申请编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var sumNo: String? = null,
    /**
     * 申报单位代码
     */
    @field:[
        JpaComment("申报单位代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 申报单位名称
     */
    @field:[
        JpaComment("申报单位名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentName: String? = null,
    /**
     * 收发货人代码
     */
    @field:[
        JpaComment("收发货人代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 收发货人名称
     */
    @field:[
        JpaComment("收发货人名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
    /**
     * 报关单位代码
     */
    @field:[
        JpaComment("报关单位代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var declAgentCode: String? = null,
    /**
     * 报关单位名称
     */
    @field:[
        JpaComment("报关单位名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var declAgentName: String? = null,
    /**
     * 汇总开始时间
     */
    @field:[
        JpaComment("汇总开始时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
        XmlJavaTypeAdapter(value = DateAdapter2::class)
    ]
    var startTime: Date? = null,
    /**
     * 汇总结束时间
     */
    @field:[
        JpaComment("汇总结束时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
        XmlJavaTypeAdapter(value = DateAdapter2::class)
    ]
    var endTime: Date? = null,
    /**
     * 监管场所代码
     */
    @field:[
        JpaComment("监管场所代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var loctNo: String? = null,
    /**
     * 收发货人汇总标志
     */
    @field:[
        JpaComment("收发货人汇总标志")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var summaryFlag: String? = null,
    /**
     * 按商品名汇总标志
     */
    @field:[
        JpaComment("按商品名汇总标志")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var itemNameFlag: String? = null,
    /**
     * 报文总数
     */
    @field:[
        JpaComment("报文总数")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var msgCount: Int? = null,
    /**
     * 报文序号
     */
    @field:[
        JpaComment("报文序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var msgSeqNo: Int? = null,
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

    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "summaryApplyHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ESummaryApplyList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var summaryApplyList: MutableList<ESummaryApplyList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.summaryApplyHead)) it.summaryApplyHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.summaryApplyHead)) it.summaryApplyHead = this }
            return field
        }

    /**
     * 跨境出口汇总申请单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "summaryApplyHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ESummaryReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var summaryReturn: MutableList<ESummaryReturn> = ArrayList()
}

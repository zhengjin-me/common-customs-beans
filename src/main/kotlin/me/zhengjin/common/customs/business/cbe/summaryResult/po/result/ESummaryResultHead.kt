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

package me.zhengjin.common.customs.business.cbe.summaryResult.po.result

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1
import me.zhengjin.common.customs.po.ExtendEntity
import java.math.BigDecimal
import java.util.Date
import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
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
 * 跨境出口汇总结果单表头
 */
@Entity
@Table(name = "cbe_summary_result_head")
@JpaComment("跨境出口汇总结果单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["guid", "customsCode", "sumNo", "opDate", "declSeqNo", "decTmpNo", "decPreNo", "entryId", "decState", "agentCode", "agentName", "ebcCode", "ebcName", "declAgentCode", "declAgentName", "grossWeight", "netWeight", "msgCount", "msgSeqNo", "note"]
)
@XmlRootElement(name = "SummaryResultHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class ESummaryResultHead(

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
     * 申报地海关代码
     */
    @field:[
        JpaComment("申报地海关代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
    /**
     * 汇总申请编号
     */
    @field:[
        JpaComment("汇总申请编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var sumNo: String? = null,
    /**
     * 汇总处理时间
     */
    @field:[
        JpaComment("汇总处理时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1::class)
    ]
    var opDate: Date? = null,
    /**
     * 汇总统一编号
     */
    @field:[
        JpaComment("汇总统一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var declSeqNo: String? = null,
    /**
     * 电子口岸暂存编号
     */
    @field:[
        JpaComment("电子口岸暂存编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var decTmpNo: String? = null,
    /**
     * 电子口岸预录入编号
     */
    @field:[
        JpaComment("电子口岸预录入编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var decPreNo: String? = null,
    /**
     * 报关单编号
     */
    @field:[
        JpaComment("报关单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var entryId: String? = null,
    /**
     * 报关单状态
     */
    @field:[
        JpaComment("报关单状态")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var decState: String? = null,
    /**
     * 申报企业代码
     */
    @field:[
        JpaComment("申报企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 申报企业名称
     */
    @field:[
        JpaComment("申报企业名称")
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
     * 毛重（公斤）
     */
    @field:[
        JpaComment("毛重")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var grossWeight: BigDecimal? = null,
    /**
     * 净重（公斤）
     */
    @field:[
        JpaComment("净重")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var netWeight: BigDecimal? = null,
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
) : ExtendEntity() {

    /**
     * 跨境出口汇总结果单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "summaryResultHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ESummaryResultList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var summaryResultList: MutableList<ESummaryResultList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.summaryResultHead)) it.summaryResultHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.summaryResultHead)) it.summaryResultHead = this }
            return field
        }
}

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

package me.zhengjin.common.customs.business.cbe.wayBill.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.wayBill.po.result.EWayBillReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
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
 * 跨境出口清单总分单表头
 */
@Entity
@Table(name = "cbe_way_bill_head")
@JpaComment("跨境出口清单总分单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "copNo", "preNo", "agentCode", "agentName", "loctNo", "trafMode", "trafName", "voyageNo", "billNo", "domesticTrafNo", "grossWeight", "logisticsCode", "logisticsName", "msgCount", "msgSeqNo", "note"]
)
@XmlRootElement(name = "WayBillHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class EWayBillHead(

    /**
     * 办理通关手续的4位海关编号
     */
    @field:[
        JpaComment("办理通关手续的4位海关编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
    /**
     * 企业生成标识唯一编号
     */
    @field:[
        JpaComment("企业生成标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var copNo: String? = null,
    /**
     * 电子口岸标识唯一编号
     */
    @field:[
        JpaComment("电子口岸标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
    /**
     * 申报单位的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("申报单位的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 申报单位的登记名称
     */
    @field:[
        JpaComment("申报单位的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentName: String? = null,
    /**
     * 监管场所代码:同一申报地海关下有多个跨境电子商务的监管场所,需要填写区分
     */
    @field:[
        JpaComment("监管场所代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var loctNo: String? = null,
    /**
     * 运输方式:海关标准的参数代码《JGS-20 海关业务代码集》- 运输方式代码
     */
    @field:[
        JpaComment("运输方式")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * 运输工具名称
     */
    @field:[
        JpaComment("运输工具名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafName: String? = null,
    /**
     * 航班航次号
     */
    @field:[
        JpaComment("航班航次号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var voyageNo: String? = null,
    /**
     * 提运单号
     */
    @field:[
        JpaComment("提运单号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var billNo: String? = null,
    /**
     * 境内运输工具编号
     */
    @field:[
        JpaComment("境内运输工具编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var domesticTrafNo: String? = null,
    /**
     * 毛重（公斤)
     */
    @field:[
        JpaComment("公斤")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var grossWeight: BigDecimal? = null,
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

    /**
     * 跨境出口清单总分单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "wayBillHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EWayBillList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var wayBillList: MutableList<EWayBillList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.wayBillHead)) it.wayBillHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.wayBillHead)) it.wayBillHead = this }
            return field
        }

    /**
     * 跨境出口清单总分单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "wayBillHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EWayBillReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var wayBillReturn: MutableList<EWayBillReturn> = ArrayList()
}

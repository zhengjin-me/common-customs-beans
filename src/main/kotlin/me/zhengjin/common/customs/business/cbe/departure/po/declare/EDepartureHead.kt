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

package me.zhengjin.common.customs.business.cbe.departure.po.declare

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter2
import me.zhengjin.common.customs.business.cbe.departure.po.result.EDepartureReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
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
 * 跨境出口离境单表头
 */
@Entity
@Table(name = "cbe_departure_head")
@JpaComment("跨境出口离境单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "copNo", "preNo", "logisticsCode", "logisticsName", "trafMode", "trafName", "voyageNo", "billNo", "leaveTime", "msgCount", "msgSeqNo", "note"]
)
@XmlRootElement(name = "DepartureHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class EDepartureHead(

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
     * 企业唯一标识单证的编号
     */
    @field:[
        JpaComment("企业唯一标识单证的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var copNo: String? = null,
    /**
     * 电子口岸标识单证的编号
     */
    @field:[
        JpaComment("电子口岸标识单证的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
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
     * 运输方式
     * 填写海关标准的参数代码，参照《JGS-20 海关业务代码集》 - 运输方式代码。直购进口指跨境段物流运输方式
     */
    @field:[
        JpaComment("运输方式")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * 运输工具名称
     * 货物进出境的运输工具的名称或运输工具编号。填报内容应与运输部门向海关申报的载货清单所列相应内容一致；同报关单填制规范。邮路运输方可为空。
     */
    @field:[
        JpaComment("运输工具名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var trafName: String? = null,
    /**
     * 航班航次号
     */
    @field:[
        JpaComment("航班航次号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var voyageNo: String? = null,
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
     * 离境时间
     */
    @field:[
        JpaComment("离境时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = DateAdapter2::class)
    ]
    var leaveTime: Date? = null,
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
     * 跨境出口离境单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "departureHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EDepartureList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var departureList: MutableList<EDepartureList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.departureHead)) it.departureHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.departureHead)) it.departureHead = this }
            return field
        }

    /**
     * 跨境出口离境单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "departureHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EDepartureReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var departureReturn: MutableList<EDepartureReturn> = ArrayList()
}

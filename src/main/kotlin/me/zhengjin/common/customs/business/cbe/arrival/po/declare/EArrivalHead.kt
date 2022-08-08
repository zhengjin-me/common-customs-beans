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

package me.zhengjin.common.customs.business.cbe.arrival.po.declare

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.arrival.po.result.EArrivalReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
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
 * 跨境出口运抵单表头
 */
@Entity
@Table(name = "cbe_arrival_head")
@JpaComment("跨境出口运抵单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "copNo", "preNo", "operatorCode", "operatorName", "loctNo", "ieFlag", "trafMode", "billNo", "domesticTrafNo", "logisticsCode", "logisticsName", "msgCount", "msgSeqNo", "note"]
)
@XmlRootElement(name = "ArrivalHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class EArrivalHead(

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
     * 企业内部标识单证的编号
     */
    @field:[
        JpaComment("企业内部标识单证的编号")
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
     * 监管场所经营人的海关注册登记编号。邮路运输用邮政物流企业
     */
    @field:[
        JpaComment("监管场所经营人的海关注册登记编号。邮路运输用邮政物流企业")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var operatorCode: String? = null,
    /**
     * 监管场所经营人的海关注册登记名称。邮路运输用邮政物流企业
     */
    @field:[
        JpaComment("监管场所经营人的海关注册登记名称。邮路运输用邮政物流企业")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var operatorName: String? = null,
    /**
     * 监管场所代码
     * 同一申报地海关下有多个跨境电子商务的监管场所,需要填写区分
     */
    @field:[
        JpaComment("监管场所代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var loctNo: String? = null,
    /**
     * I进口/E出口
     */
    @field:[
        JpaComment("I进口/E出口")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ieFlag: String? = null,
    /**
     * 运输方式代码
     * 填写海关标准的参数代码，参照 《JGS-20 海关业务代码集》 - 运输方式代码。直购进口指跨境段物流运输方式。
     */
    @field:[
        JpaComment("运输方式代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * 提运单号
     * 货物提单或运单的海运提单、空运总 单或汽车载货清单。邮路运输方可为 空。
     */
    @field:[
        JpaComment("提运单号(货物提单或运单的海运提单、空运总 单或汽车载货清单。邮路运输方可为 空。)")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var billNo: String? = null,
    /**
     * 运往海关监管场所的运输工具编号， 例如车牌号。
     */
    @field:[
        JpaComment("运往海关监管场所的运输工具编号， 例如车牌号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var domesticTrafNo: String? = null,
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
     * 拆分后的报文总数。未拆分的填1，拆分的填实际数量。
     */
    @field:[
        JpaComment("拆分后的报文总数。未拆分的填1，拆分的填实际数量。")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var msgCount: Int? = null,
    /**
     * 当前报文序号
     * 以1开始的报文顺序 号，未拆分的填1，拆分的报文需要连续编号，不得跳号
     */
    @field:[
        JpaComment("当前报文序号")
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
) : DeclareContentBaseEntity(), Serializable {

    /**
     * 跨境出口运抵单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @OneToMany(
        mappedBy = "arrivalHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EArrivalList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var arrivalList: MutableList<EArrivalList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.arrivalHead)) it.arrivalHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.arrivalHead)) it.arrivalHead = this }
            return field
        }

    /**
     * 跨境出口运抵单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @OneToMany(
        mappedBy = "arrivalHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EArrivalReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var arrivalReturn: MutableList<EArrivalReturn> = ArrayList()
}

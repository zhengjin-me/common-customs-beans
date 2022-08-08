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

package me.zhengjin.common.customs.business.cbe.arrival.po.result

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.arrival.po.declare.EArrivalHead
import me.zhengjin.common.customs.po.ReturnContentBaseEntity
import javax.persistence.Column
import javax.persistence.ConstraintMode
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType

/**
 * 跨境出口运抵单回执
 */
@Entity
@Table(name = "cbe_arrival_return")
@JpaComment("跨境出口运抵单回执")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["operatorCode", "logisticsCode", "preNo", "copNo", "billNo", "msgSeqNo"])
@XmlRootElement(name = "ArrivalReturn", namespace = "http://www.chinaport.gov.cn/ceb")
data class EArrivalReturn(
    /**
     * 监管场所经营人的海关注册登记编号
     */
    @field:[
        JpaComment("监管场所经营人的海关注册登记编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var operatorCode: String? = null,
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
     * 企业唯一标识单证的编号
     */
    @field:[
        JpaComment("企业唯一标识单证的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var preNo: String? = null,
    /**
     * 电子口岸标识单证的编号
     */
    @field:[
        JpaComment("电子口岸标识单证的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var copNo: String? = null,
    /**
     * 提单或总运单的编号
     */
    @field:[
        JpaComment("提单或总运单的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var billNo: String? = null,
    /**
     * 当前报文序号
     * 以1开始的报文顺序号，未拆分的填1，拆分的报文需要连续编号，不得跳号
     */
    @field:[
        JpaComment("当前报文序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var msgSeqNo: Int? = null

) : ReturnContentBaseEntity() {
    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_head_id", foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    var arrivalHead: EArrivalHead? = null
}

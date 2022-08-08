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
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

/**
 * 跨境进口电子税单状态(缴款通知书)
 */
@Entity
@Table(name = "cbi_tax_head_status")
@JpaComment("跨境进口电子税单状态(缴款通知书)")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["guid", "returnTime", "invtNo", "taxNo", "status", "entDutyNo", "assureCode"])
@XmlRootElement(name = "TaxHeadStatus", namespace = "http://www.chinaport.gov.cn/ceb")
data class ITaxHeadStatus(
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
     * 税单状态
     */
    @field:[
        JpaComment("税单状态")
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
     * 担保企业代码
     */
    @field:[
        JpaComment("担保企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var assureCode: String? = null

) : ExtendEntity()

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

package me.zhengjin.common.customs.business.cbi.payment.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter2
import me.zhengjin.common.customs.business.cbi.payment.po.result.IPaymentReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.Date
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
 * ?????????????????????
 */
@Entity
@Table(name = "cbi_payment")
@JpaComment("?????????????????????")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["payCode", "payName", "payTransactionId", "orderNo", "ebpCode", "ebpName", "payerIdType", "payerIdNumber", "payerName", "telephone", "amountPaid", "currency", "payTime", "note"]
)
@XmlRootElement(name = "PaymentHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IPayment(
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payName: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payTransactionId: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpName: String? = null,
    /**
     * ?????????????????????
     */
    @field:[
        JpaComment("?????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payerIdType: String? = null,
    /**
     * ?????????????????????
     */
    @field:[
        JpaComment("?????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payerIdNumber: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var payerName: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var telephone: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var amountPaid: BigDecimal = BigDecimal.ZERO,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = DateAdapter2::class)
    ]
    var payTime: Date? = null,
    /**
     * ??????
     */
    @field:[
        JpaComment("??????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null

) : DeclareContentBaseEntity() {

    /**
     * ???????????????????????????
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "payment",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IPaymentReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var paymentReturn: MutableList<IPaymentReturn> = ArrayList()
}

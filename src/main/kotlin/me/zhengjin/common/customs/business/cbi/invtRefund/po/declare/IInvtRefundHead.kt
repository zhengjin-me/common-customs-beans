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

package me.zhengjin.common.customs.business.cbi.invtRefund.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbi.invtRefund.po.result.IInvtRefundReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
import java.util.Objects
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Index
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
 * ???????????????????????????
 */
@Entity
@Table(
    name = "cbi_invt_refund_head",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "orderNo"),
        Index(columnList = "ebpCode"),
        Index(columnList = "logisticsNo"),
        Index(columnList = "invtNo"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("???????????????????????????")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "orderNo", "ebpCode", "ebpName", "ebcCode", "ebcName", "logisticsNo", "logisticsCode", "logisticsName", "copNo", "preNo", "invtNo", "buyerIdType", "buyerIdNumber", "buyerName", "buyerTelephone", "agentCode", "agentName", "reason", "note"]
)
@XmlRootElement(name = "InvtRefundHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IInvtRefundHead(
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
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
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsNo: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsName: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var copNo: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var invtNo: String? = null,
    /**
     * ?????????????????????
     */
    @field:[
        JpaComment("?????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdType: String? = null,
    /**
     * ?????????????????????
     */
    @field:[
        JpaComment("?????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdNumber: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerName: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerTelephone: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentName: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var reason: String? = null,
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
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "invtRefundHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IInvtRefundList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var invtRefundList: MutableList<IInvtRefundList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.invtRefundHead)) it.invtRefundHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.invtRefundHead)) it.invtRefundHead = this }
            return field
        }

    /**
     * ???????????????????????????
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "invtRefundHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IInvtRefundReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var invtRefundReturn: MutableList<IInvtRefundReturn> = ArrayList()
}

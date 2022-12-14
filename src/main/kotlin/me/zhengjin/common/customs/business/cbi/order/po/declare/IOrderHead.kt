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

package me.zhengjin.common.customs.business.cbi.order.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbi.order.po.result.IOrderReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
import java.math.BigDecimal
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
 * ????????????????????????
 */
@Entity
@Table(
    name = "cbi_order_head",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "orderNo"),
        Index(columnList = "ebpCode"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("????????????????????????")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["orderType", "orderNo", "ebpCode", "ebpName", "ebcCode", "ebcName", "goodsValue", "freight", "discount", "taxTotal", "acturalPaid", "currency", "buyerRegNo", "buyerName", "buyerTelephone", "buyerIdType", "buyerIdNumber", "payCode", "payName", "payTransactionId", "batchNumbers", "consignee", "consigneeTelephone", "consigneeAddress", "consigneeDistrict", "note"]
)
@XmlRootElement(name = "OrderHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IOrderHead(
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderType: String? = null,
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
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var goodsValue: BigDecimal = BigDecimal.ZERO,
    /**
     * ?????????
     */
    @field:[
        JpaComment("?????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var freight: BigDecimal = BigDecimal.ZERO,
    /**
     * ?????????????????????
     */
    @field:[
        JpaComment("?????????????????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var discount: BigDecimal = BigDecimal.ZERO,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var taxTotal: BigDecimal = BigDecimal.ZERO,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var acturalPaid: BigDecimal = BigDecimal.ZERO,
    /**
     * ??????
     */
    @field:[
        JpaComment("??????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerRegNo: String? = null,
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
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payCode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payName: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var payTransactionId: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var batchNumbers: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consignee: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeTelephone: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeAddress: String? = null,
    /**
     * ??????????????????????????????
     */
    @field:[
        JpaComment("??????????????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var consigneeDistrict: String? = null,
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
     * ????????????????????????
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IOrderList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderList: MutableList<IOrderList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.orderHead)) it.orderHead = this }
            return field
        }

    /**
     * ????????????????????????
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "orderHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IOrderReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var orderReturn: MutableList<IOrderReturn> = ArrayList()
}

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

package me.zhengjin.common.customs.business.cbi.delivery.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbi.delivery.po.result.IDeliveryReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
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
 * ???????????????????????????
 */
@Entity
@Table(name = "cbi_delivery_head")
@JpaComment("???????????????????????????")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "copNo", "preNo", "rkdNo", "operatorCode", "operatorName", "ieFlag", "trafMode", "trafNo", "voyageNo", "billNo", "logisticsCode", "logisticsName", "unloadLocation", "note"]
)
@XmlRootElement(name = "DeliveryHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IDeliveryHead(
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
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
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
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var rkdNo: String? = null,
    /**
     * ???????????????????????????
     */
    @field:[
        JpaComment("???????????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var operatorCode: String? = null,
    /**
     * ???????????????????????????
     */
    @field:[
        JpaComment("???????????????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var operatorName: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ieFlag: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * ??????????????????
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafNo: String? = null,
    /**
     * ???????????????
     */
    @field:[
        JpaComment("???????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var voyageNo: String? = null,
    /**
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var billNo: String? = null,
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
     * ????????????
     */
    @field:[
        JpaComment("????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var unloadLocation: String? = null,
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
        mappedBy = "deliveryHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IDeliveryList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var deliveryList: MutableList<IDeliveryList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.deliveryHead)) it.deliveryHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.deliveryHead)) it.deliveryHead = this }
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
        mappedBy = "deliveryHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IDeliveryReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var deliveryReturn: MutableList<IDeliveryReturn> = ArrayList()
}

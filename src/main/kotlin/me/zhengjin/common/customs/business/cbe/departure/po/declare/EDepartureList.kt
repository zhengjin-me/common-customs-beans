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

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import com.fasterxml.jackson.annotation.JsonIgnore
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
 * 跨境出口离境单表体
 */
@Entity
@Table(name = "cbe_departure_list")
@JpaComment("跨境出口离境单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["gnum", "totalPackageNo", "logisticsNo", "note"])
@XmlRootElement(name = "DepartureList", namespace = "http://www.chinaport.gov.cn/ceb")
data class EDepartureList(

    /**
     * 序号
     */
    @field:[
        JpaComment("序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int? = null,
    /**
     * 总包号
     */
    @field:[
        JpaComment("总包号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var totalPackageNo: String? = null,
    /**
     * 物流运单编号
     */
    @field:[
        JpaComment("物流运单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsNo: String? = null,
    /**
     * 备注
     */
    @field:[
        JpaComment("备注")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null
) : BaseEntity() {

    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "departure_head_id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    var departureHead: EDepartureHead? = null
}

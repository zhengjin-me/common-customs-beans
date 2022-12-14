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

package me.zhengjin.common.customs.business.cbi.logisticsStatus.po.declare

import com.fasterxml.jackson.annotation.JsonIgnore
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter2
import me.zhengjin.common.customs.business.cbi.logisticsStatus.po.result.ILogisticsStatusReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import org.hibernate.annotations.Where
import java.util.Date
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.ConstraintMode
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ForeignKey
import javax.persistence.JoinColumn
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
 * ????????????????????????
 */
@Entity
@Table(name = "cbi_logistics_status")
@JpaComment("????????????????????????")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["logisticsCode", "logisticsName", "logisticsNo", "logisticsStatus", "logisticsTime", "note"]
)
@XmlRootElement(name = "LogisticsStatus", namespace = "http://www.chinaport.gov.cn/ceb")
data class ILogisticsStatus(
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
    var logisticsStatus: String? = null,
    /**
     * ??????????????????
     * yyyyMMddHHmmss
     */
    @field:[
        JpaComment("??????????????????")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = DateAdapter2::class)
    ]
    var logisticsTime: Date? = null,
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
     * ??????????????????????????????
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @JoinColumn(
        name = "ilogistics_status_id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    @OneToMany(
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = ILogisticsStatusReturn::class
    )
    var logisticsStatusReturn: MutableList<ILogisticsStatusReturn> = ArrayList()
}

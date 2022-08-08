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

package me.zhengjin.common.customs.business.cbe.inventory.po.result

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.business.cbe.inventory.po.declare.EInventoryHead
import me.zhengjin.common.customs.po.ReturnContentBaseEntity
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
 * 出口清单回执
 */
@Entity
@Table(name = "cbe_inventory_return")
@JpaComment("跨境出口清单回执")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["agentCode", "copNo", "preNo", "invtNo", "ebcCode", "ebpCode", "orderNo", "statisticsFlag"]
)
@XmlRootElement(name = "InventoryReturn", namespace = "http://www.chinaport.gov.cn/ceb")
data class EInventoryReturn(
    /**
     * 申报单位的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("申报单位的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 企业生成标识唯一编号
     */
    @field:[
        JpaComment("企业生成标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var copNo: String? = null,
    /**
     * 电子口岸标识唯一编号
     */
    @field:[
        JpaComment("电子口岸标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var preNo: String? = null,
    /**
     * 清单编号
     * 海关审结标识清单唯一编号（4位关区+4位 年+1位进出口标记+9位流水号）
     */
    @field:[
        JpaComment("清单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var invtNo: String? = null,
    /**
     * 收发货人代码
     * 电商（发货）企业的海关注册登记编号(10 位海关编码或18位统一社会信用代码)
     */
    @field:[
        JpaComment("收发货人代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 电商平台的海关登记编号
     */
    @field:[
        JpaComment("电商平台的海关登记编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * 交易平台的订单编号，同一交易平台的订 单编号应唯一。订单编号长度不能超过60 位。
     */
    @field:[
        JpaComment("交易平台的订单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
    /**
     * A-简化申报;B-汇总申报
     * 若采用A简化申报，则要求商品不涉许可证、不涉出口关税、不涉及出口退税。同时商品编码前4位为税则表填写
     */
    @field:[
        JpaComment("A-简化申报;B-汇总申报")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var statisticsFlag: String? = null
) : ReturnContentBaseEntity() {
    @JsonIgnore
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "inventory_head_id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    var inventoryHead: EInventoryHead? = null
}

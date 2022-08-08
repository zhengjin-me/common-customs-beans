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

package me.zhengjin.common.customs.business.cbe.inventory.po.declare

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
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
 * 出口清单表体
 */
@Entity
@Table(name = "cbe_inventory_list")
@JpaComment("跨境出口清单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["gnum", "itemNo", "itemRecordNo", "itemName", "gcode", "gname", "gmodel", "barCode", "country", "currency", "qty", "qty1", "qty2", "unit", "unit1", "unit2", "price", "totalPrice", "note"]
)
@XmlRootElement(name = "InventoryList", namespace = "http://www.chinaport.gov.cn/ceb")
data class EInventoryList(

    /**
     * 从1开始连续序号（与电子订单商品序号关联对应）
     */
    @field:[
        JpaComment("从1开始连续序号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int? = null,
    /**
     * 企业自定义的商品货号
     */
    @field:[
        JpaComment("企业自定义的商品货号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var itemNo: String? = null,
    /**
     * 保税出口模式必填
     */
    @field:[
        JpaComment("保税出口模式必填")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemRecordNo: String? = null,
    /**
     * 企业自定义的商品名称，汇总后用于退税品名
     */
    @field:[
        JpaComment("企业自定义的商品名称，汇总后用于退税品名")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var itemName: String? = null,
    /**
     * 对于符合简化申报的商品，前4位按税则归类申报（需要存在相应章节）
     */
    @field:[
        JpaComment("hs编码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gcode: String? = null,
    /**
     * 同一类商品的名称
     * 任何一种具体商品可以并只能归入表中的一个条目
     */
    @field:[
        JpaComment("商品名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gname: String? = null,
    /**
     * 满足海关归类、审价以及监管的要求为准。包括：品名、牌名、规格、 型号、成份、含量、等级等
     */
    @field:[
        JpaComment("规格型号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gmodel: String? = null,
    /**
     * 商品条形码一般由前缀部分、制造厂商代码、商品代码和校验码组成。没有条形码填“无”
     */
    @field:[
        JpaComment("商品条形码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var barCode: String? = null,
    /**
     * 海关标准的参数代码《JGS-20 海关业务代码集》 国家（地区）代码表填写代码
     */
    @field:[
        JpaComment("国家（地区）代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var country: String? = null,
    /**
     * 海关标准的参数代码《JGS-20 海关业务代码集》- 货币代码
     */
    @field:[
        JpaComment("货币代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String? = null,
    /**
     * 申报数量
     */
    @field:[
        JpaComment("申报数量")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var qty: BigDecimal? = null,
    /**
     * 法定数量
     */
    @field:[
        JpaComment("法定数量")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var qty1: BigDecimal? = null,
    /**
     * 第二数量
     */
    @field:[
        JpaComment("第二数量")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var qty2: BigDecimal? = null,
    /**
     * 申报计量单位:海关标准的参数代码 《JGS-20 海 关业务代码集》
     * 计量单位代码
     */
    @field:[
        JpaComment("计量单位代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit: String? = null,
    /**
     * 法定计量单位
     */
    @field:[
        JpaComment("法定计量单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var unit1: String? = null,
    /**
     * 第二计量单位
     */
    @field:[
        JpaComment("第二计量单位")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var unit2: String? = null,
    /**
     * 单价:成交单价FOB
     */
    @field:[
        JpaComment("单价")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var price: BigDecimal? = null,
    /**
     * 总价:总价=成交数量*单价
     */
    @field:[
        JpaComment("总价")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var totalPrice: BigDecimal? = null,
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
        name = "inventory_head_id",
        foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)
    )
    var inventoryHead: EInventoryHead? = null
}

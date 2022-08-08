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

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter3
import me.zhengjin.common.customs.business.cbe.inventory.po.result.EInventoryReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.Where
import java.math.BigDecimal
import java.util.Date
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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

/**
 * 跨境出口清单表头
 */
@Entity
@Table(
    name = "cbe_inventory_head",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "orderNo"),
        Index(columnList = "invtNo"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("跨境出口清单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["customsCode", "ebpCode", "ebpName", "orderNo", "logisticsCode", "logisticsName", "logisticsNo", "copNo", "preNo", "invtNo", "ieFlag", "portCode", "ieDate", "statisticsFlag", "agentCode", "agentName", "ebcCode", "ebcName", "ownerCode", "ownerName", "iacCode", "iacName", "emsNo", "tradeMode", "trafMode", "trafName", "voyageNo", "billNo", "totalPackageNo", "loctNo", "licenseNo", "country", "pod", "freight", "fCurrency", "fFlag", "insuredFee", "iCurrency", "iFlag", "wrapType", "packNo", "grossWeight", "netWeight", "note"]
)
@XmlRootElement(name = "InventoryHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class EInventoryHead(

    /**
     * 办理通关手续的4位海关代码 JGS/T18《海关关区代码》
     */
    @field:[
        JpaComment("办理通关手续的4位海关代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
    /**
     * 电商平台的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("电商平台的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * 电商平台的登记名称
     */
    @field:[
        JpaComment("电商平台的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpName: String? = null,
    /**
     * 交易平台的订单编号，同一交易平 台的订单编号应唯一
     */
    @field:[
        JpaComment("交易平台的订单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
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
     * 物流企业的登记名称
     */
    @field:[
        JpaComment("物流企业的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsName: String? = null,
    /**
     * 物流企业运单的包裹面单号，同一物流企业的运单编号在6个月内不重复
     */
    @field:[
        JpaComment("物流企业运单的包裹面单号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsNo: String? = null,
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
     * 电子口岸标识唯一编号（B+8位年 月日+9位流水号）
     */
    @field:[
        JpaComment("电子口岸标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
    /**
     * 海关审结标识唯一编号（4位关区 +4位年+1位进出口标记+9位流水号）
     */
    @field:[
        JpaComment("海关审结标识唯一编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var invtNo: String? = null,
    /**
     * I-进口,E-出口
     */
    @field:[
        JpaComment("I-进口,E-出口")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ieFlag: String? = null,
    /**
     * 商品实际出我国关境口岸海关的关区代码JGS/T18《海关关区代码》
     */
    @field:[
        JpaComment("商品实际出我国关境口岸海关的关区代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var portCode: String? = null,
    /**
     * 进/出口时间
     */
    @field:[
        JpaComment("出口时间")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = DateAdapter3::class)
    ]
    var ieDate: Date? = null,
    /**
     * A-简化申报;B-汇总申报
     * 若采用A简化申报，则要求商品不涉许可证、不涉出口关税、不涉及出口退税。同时商品编码前4位为税则表填写
     */
    @field:[
        JpaComment("A-简化申报;B-汇总申报")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var statisticsFlag: String? = null,
    /**
     * 申报单位的海关登记编号
     */
    @field:[
        JpaComment("申报单位的海关登记编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 申报单位的海关登记名称
     */
    @field:[
        JpaComment("申报单位的海关登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentName: String? = null,
    /**
     * 收发货人（电商企业）的海关注册登记编号或统一社会信用代码
     */
    @field:[
        JpaComment("收发货人（电商企业）的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 收发货人（电商企业）的登记名称
     */
    @field:[
        JpaComment("收发货人（电商企业）的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
    /**
     * 生产企业的海关注册登记编号或统一社会信用代码,未在海关登记的填NO
     */
    @field:[
        JpaComment("生产企业的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ownerCode: String? = null,
    /**
     * 生产企业的登记名称
     */
    @field:[
        JpaComment("生产企业的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ownerName: String? = null,
    /**
     * 特殊区域内仓储企业的海关注册登记编号或统一社会信用代码，特殊区域出口模式必填
     */
    @field:[
        JpaComment("特殊区域内仓储企业的海关注册登记编号或统一社会信用代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var iacCode: String? = null,
    /**
     * 特殊区域内仓储企业的登记名称， 特殊区域出口模式必填
     */
    @field:[
        JpaComment("特殊区域内仓储企业的登记名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var iacName: String? = null,
    /**
     * 特殊区域出口模式必须填写具体账号
     */
    @field:[
        JpaComment("特殊区域出口模式必须填写具体账号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var emsNo: String? = null,
    /**
     * 一般出口填9610，特殊区域出口填1210
     */
    @field:[
        JpaComment("一般出口填9610，特殊区域出口填1210")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var tradeMode: String? = null,
    /**
     * 海关标准的参数代码 《JGS-20 海 关业务代码集》- 运输方式代码
     */
    @field:[
        JpaComment("海关标准的参数代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * 货物进出境的运输工具的名称或运输工具编号。
     * 填报内容应与运输部门向海关申报的载货清单所列相应内容一致。
     * 按照关区要求，可以后置申报清单总分单，允许为空
     */
    @field:[
        JpaComment("货物进出境的运输工具的名称或运输工具编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var trafName: String? = null,
    /**
     * 货物进出境的运输工具的航次编号。
     * 按照关区要求，可以后置申报清单总分单，允许为空
     */
    @field:[
        JpaComment("货物进出境的运输工具的航次编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var voyageNo: String? = null,
    /**
     * 提单或总运单的编号
     * 按照关区要求，可以后置申报清单总分单，允许为空
     */
    @field:[
        JpaComment("提单或总运单的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var billNo: String? = null,
    /**
     * 对于提运单下含有多个大包的托盘编号（邮件为邮件总包号/邮袋号）
     * 按照关区要求，可以后置申报清单总分单，允许为空
     */
    @field:[
        JpaComment("对于提运单下含有多个大包的托盘编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var totalPackageNo: String? = null,
    /**
     * 同一申报地海关下有多个跨境电子商务的监管场所,需要填写区分
     */
    @field:[
        JpaComment("同一申报地海关下有多个跨境电子商务的监管场所")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var loctNo: String? = null,
    /**
     * 商务主管部门及其授权发证机关签发的进出口货物许可证的编号
     */
    @field:[
        JpaComment("商务主管部门及其授权发证机关签发的进出口货物许可证的编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var licenseNo: String? = null,
    /**
     * 出口货物的直接运抵的国家（地区），《JGS-20 海关业务代码集》 国家（地区）代码表填写代码
     */
    @field:[
        JpaComment("出口货物的直接运抵的国家")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var country: String? = null,
    /**
     * 出口运往境外的最终目的港的标识代码
     * 最终目的港不可预知时， 应尽可能按预知的目的港填
     */
    @field:[
        JpaComment("出口运往境外的最终目的港的标识代码")
        Column
        XmlElement(name = "POD", namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var pod: String? = null,
    /**
     * 物流企业实际收取的运输费用
     */
    @field:[
        JpaComment("物流企业实际收取的运输费用")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var freight: BigDecimal? = null,
    /**
     * 海关标准的参数代码《JGS-20 海关业务代码集》
     * 货币代码
     */
    @field:[
        JpaComment("货币代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var fCurrency: String? = null,
    /**
     * 1-率，2-单价，3-总价
     */
    @field:[
        JpaComment("1-率，2-单价，3-总价")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var fFlag: String? = null,
    /**
     * 物流企业实际收取的商品保价费用
     */
    @field:[
        JpaComment("物流企业实际收取的商品保价费用")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var insuredFee: BigDecimal? = null,
    /**
     * 海关标准的参数代码《JGS-20 海关业务代码集》
     * 货币代码
     */
    @field:[
        JpaComment("货币代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var iCurrency: String? = null,
    /**
     * 1-率，2-单价，3-总价
     */
    @field:[
        JpaComment("1-率，2-单价，3-总价")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var iFlag: String? = null,
    /**
     * 包装种类代码
     * 海关对进出口货物实际采用的外部包装方式的标识代码，采用1位数字表示，如：木箱、纸箱、桶装、 散装、托盘、包、油罐车等
     */
    @field:[
        JpaComment("包装种类代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var wrapType: String? = null,
    /**
     * 件数(包裹数量)
     */
    @field:[
        JpaComment("件数")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var packNo: Int? = null,
    /**
     * 总重量
     * 货物及其包装材料的重量之和，计量单位为千克
     */
    @field:[
        JpaComment("总重量")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var grossWeight: BigDecimal = BigDecimal.ZERO,
    /**
     * 净重
     * 货物的毛重减去外包装材料后的重量，即货物本身的实际重量，计量单位为千克
     */
    @field:[
        JpaComment("净重")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var netWeight: BigDecimal = BigDecimal.ZERO,
    /**
     * 备注
     */
    @field:[
        JpaComment("备注")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var note: String? = null,

) : DeclareContentBaseEntity() {

    // --------------申报状态--------------------
    /**
     * 清单总分单申报的处理状态: 0-待确认 1-待申报 2-已申报 3-取消 4-处理异常或失败
     */
    @XmlTransient
    @JsonProperty("waybillStatus")
    @JpaComment("清单总分单申报的处理状态: 0-待确认 1-待申报 2-已申报 3-取消 4-处理异常或失败")
    @Column(columnDefinition = "char(1) default 0")
    var waybillStatus: String = "0"
    /**
     * 汇总申请单申报的处理状态: 0-待申报 1-已申报
     */
    @XmlTransient
    @JsonProperty("summaryApplyStatus")
    @JpaComment("汇总申请单申报的处理状态: 0-待申报 1-已申报")
    @Column(columnDefinition = "char(1) default 0")
    var summaryApplyStatus: String = "0"

    /**
     * 跨境出口清单表头
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "inventoryHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EInventoryList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var inventoryList: MutableList<EInventoryList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.inventoryHead)) it.inventoryHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.inventoryHead)) it.inventoryHead = this }
            return field
        }

    /**
     * 跨境出口清单回执
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @JsonIgnore
    @OrderBy("RETURN_TIME DESC")
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "inventoryHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = EInventoryReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var inventoryReturn: MutableList<EInventoryReturn> = ArrayList()
}

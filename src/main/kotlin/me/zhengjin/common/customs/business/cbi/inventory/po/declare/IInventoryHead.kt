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

package me.zhengjin.common.customs.business.cbi.inventory.po.declare

import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter3
import me.zhengjin.common.customs.business.cbi.inventory.po.result.IInventoryReturn
import me.zhengjin.common.customs.po.DeclareContentBaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
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
 * 跨境进口清单表头
 */
@Entity
@Table(
    name = "cbi_inventory_head",
    indexes = [
        Index(columnList = "customerCode"),
        Index(columnList = "orderNo"),
        Index(columnList = "invtNo"),
        Index(columnList = "ebpCode"),
        Index(columnList = "buyerIdNumber"),
        Index(columnList = "is_delete")
    ]
)
@JpaComment("跨境进口清单表头")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["orderNo", "ebpCode", "ebpName", "ebcCode", "ebcName", "logisticsNo", "logisticsCode", "logisticsName", "copNo", "preNo", "assureCode", "emsNo", "invtNo", "ieFlag", "declTime", "customsCode", "portCode", "ieDate", "buyerIdType", "buyerIdNumber", "buyerName", "buyerTelephone", "consigneeAddress", "agentCode", "agentName", "areaCode", "areaName", "tradeMode", "trafMode", "trafNo", "voyageNo", "billNo", "loctNo", "licenseNo", "country", "freight", "insuredFee", "currency", "wrapType", "packNo", "grossWeight", "netWeight", "note"]
)
@XmlRootElement(name = "InventoryHead", namespace = "http://www.chinaport.gov.cn/ceb")
data class IInventoryHead(
    /**
     * 订单编号
     */
    @field:[
        JpaComment("订单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var orderNo: String? = null,
    /**
     * 电商平台代码
     */
    @field:[
        JpaComment("电商平台代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpCode: String? = null,
    /**
     * 电商平台名称
     */
    @field:[
        JpaComment("电商平台名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebpName: String? = null,
    /**
     * 电商企业代码
     */
    @field:[
        JpaComment("电商企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcCode: String? = null,
    /**
     * 电商企业名称
     */
    @field:[
        JpaComment("电商企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ebcName: String? = null,
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
     * 物流企业代码
     */
    @field:[
        JpaComment("物流企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsCode: String? = null,
    /**
     * 物流企业名称
     */
    @field:[
        JpaComment("物流企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var logisticsName: String? = null,
    /**
     * 企业内部编号
     */
    @field:[
        JpaComment("企业内部编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var copNo: String? = null,
    /**
     * 预录入编号
     */
    @field:[
        JpaComment("预录入编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var preNo: String? = null,
    /**
     * 担保企业编号
     */
    @field:[
        JpaComment("担保企业编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var assureCode: String? = null,
    /**
     * 账册编号
     */
    @field:[
        JpaComment("账册编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var emsNo: String? = null,
    /**
     * 清单编号
     */
    @field:[
        JpaComment("清单编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var invtNo: String? = null,
    /**
     * 进出口标记
     */
    @field:[
        JpaComment("进出口标记")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var ieFlag: String = "I",
    /**
     * 申报日期
     */
    @field:[
        JpaComment("申报日期")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
        XmlJavaTypeAdapter(value = DateAdapter3::class)
    ]
    var declTime: Date? = null,
    /**
     * 申报海关代码
     */
    @field:[
        JpaComment("申报海关代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var customsCode: String? = null,
    /**
     * 口岸海关代码
     */
    @field:[
        JpaComment("口岸海关代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var portCode: String? = null,
    /**
     * 进口日期
     */
    @field:[
        JpaComment("进口日期")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
        XmlJavaTypeAdapter(value = DateAdapter3::class)
    ]
    var ieDate: Date? = null,
    /**
     * 订购人证件类型
     */
    @field:[
        JpaComment("订购人证件类型")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdType: String = "1",
    /**
     * 订购人证件号码
     */
    @field:[
        JpaComment("订购人证件号码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerIdNumber: String? = null,
    /**
     * 订购人姓名
     */
    @field:[
        JpaComment("订购人姓名")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerName: String? = null,
    /**
     * 订购人电话
     */
    @field:[
        JpaComment("订购人电话")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var buyerTelephone: String? = null,
    /**
     * 收件地址
     */
    @field:[
        JpaComment("收件地址")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var consigneeAddress: String? = null,
    /**
     * 申报企业代码
     */
    @field:[
        JpaComment("申报企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentCode: String? = null,
    /**
     * 申报企业名称
     */
    @field:[
        JpaComment("申报企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var agentName: String? = null,
    /**
     * 区内企业代码
     */
    @field:[
        JpaComment("区内企业代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var areaCode: String? = null,
    /**
     * 区内企业名称
     */
    @field:[
        JpaComment("区内企业名称")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var areaName: String? = null,
    /**
     * 贸易方式
     */
    @field:[
        JpaComment("贸易方式")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var tradeMode: String? = null,
    /**
     * 运输方式
     */
    @field:[
        JpaComment("运输方式")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var trafMode: String? = null,
    /**
     * 运输工具编号
     */
    @field:[
        JpaComment("运输工具编号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var trafNo: String? = null,
    /**
     * 航班航次号
     */
    @field:[
        JpaComment("航班航次号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var voyageNo: String? = null,
    /**
     * 提运单号
     */
    @field:[
        JpaComment("提运单号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var billNo: String? = null,
    /**
     * 监管场所代码
     */
    @field:[
        JpaComment("监管场所代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var loctNo: String? = null,
    /**
     * 许可证件号
     */
    @field:[
        JpaComment("许可证件号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var licenseNo: String? = null,
    /**
     * 起运国（地区）
     */
    @field:[
        JpaComment("起运国（地区）")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var country: String? = null,
    /**
     * 运费
     */
    @field:[
        JpaComment("运费")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var freight: BigDecimal = BigDecimal.ZERO,
    /**
     * 保费
     */
    @field:[
        JpaComment("保费")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var insuredFee: BigDecimal = BigDecimal.ZERO,
    /**
     * 币制
     */
    @field:[
        JpaComment("币制")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var currency: String = "142",
    /**
     * 包装种类代码
     */
    @field:[
        JpaComment("包装种类代码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var wrapType: String = "2",
    /**
     * 件数
     */
    @field:[
        JpaComment("件数")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var packNo: Int = 0,
    /**
     * 毛重（公斤）
     */
    @field:[
        JpaComment("毛重（公斤）")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var grossWeight: BigDecimal = BigDecimal.ZERO,
    /**
     * 净重（公斤）
     */
    @field:[
        JpaComment("净重（公斤）")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
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
    var note: String? = null

) : DeclareContentBaseEntity() {

    /**
     * 跨境进口清单表体
     */
    @Suppress("DEPRECATION")
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @OneToMany(
        mappedBy = "inventoryHead",
        orphanRemoval = true,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        targetEntity = IInventoryList::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var inventoryList: MutableList<IInventoryList> = ArrayList()
        set(v) {
            v.forEach { if (Objects.isNull(it.inventoryHead)) it.inventoryHead = this }
            field = v
        }
        get() {
            field.forEach { if (Objects.isNull(it.inventoryHead)) it.inventoryHead = this }
            return field
        }

    /**
     * 跨境进口清单回执
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
        targetEntity = IInventoryReturn::class
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    var inventoryReturn: MutableList<IInventoryReturn> = ArrayList()
}

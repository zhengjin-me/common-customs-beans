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

package me.zhengjin.common.customs.business.cbi.tax.po.result

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.core.jpa.comment.annotation.JpaComment
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Where
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
 * 跨境进口电子税单表体
 */
@Entity
@Table(name = "cbi_tax_list_rd")
@JpaComment("跨境进口电子税单表体")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["gnum", "gcode", "taxPrice", "customsTax", "valueAddedTax", "consumptionTax"])
@XmlRootElement(name = "TaxListRd", namespace = "http://www.chinaport.gov.cn/ceb")
data class ITaxList(
    /**
     * 商品项号
     */
    @field:[
        JpaComment("商品项号")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb")
    ]
    var gnum: Int = 0,
    /**
     * 海关商品编码
     */
    @field:[
        JpaComment("海关商品编码")
        Column
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var gcode: String? = null,
    /**
     * 完税总价格
     */
    @field:[
        JpaComment("完税总价格")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var taxPrice: BigDecimal = BigDecimal.ZERO,
    /**
     * 应征关税
     */
    @field:[
        JpaComment("应征关税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var customsTax: BigDecimal = BigDecimal.ZERO,
    /**
     * 应征增值税
     */
    @field:[
        JpaComment("应征增值税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var valueAddedTax: BigDecimal = BigDecimal.ZERO,
    /**
     * 应征消费税
     */
    @field:[
        JpaComment("应征消费税")
        Column(columnDefinition = "decimal(19, 5) NULL DEFAULT 0")
        XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true, defaultValue = "0")
    ]
    var consumptionTax: BigDecimal = BigDecimal.ZERO
) : BaseEntity() {

    @JsonIgnore
    @XmlTransient
    @Where(clause = "is_delete = 0")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_head_id", foreignKey = ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    var taxHead: ITaxHead? = null
}

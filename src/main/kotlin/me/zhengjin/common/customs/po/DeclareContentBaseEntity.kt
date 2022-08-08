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

package me.zhengjin.common.customs.po

import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter2
import me.zhengjin.common.customs.message.CustomsResultStatus
import java.util.Date
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.Transient
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["guid", "appType", "appTime", "appStatus"])
abstract class DeclareContentBaseEntity : ExtendEntity() {
    /**
     * 企业系统生成36位唯一序号（英文字母大写)
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var guid: String = ""

    /**
     * 企业报送类型。1-新增 2-变更 3-删除
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var appType: String = "1"

    /**
     * 企业报送时间
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    @XmlJavaTypeAdapter(value = DateAdapter2::class)
    var appTime: Date? = null

    /**
     * 企业报送状态 1-暂存,2-申报 填写2时,Signature节点必须填写
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var appStatus: String = "2"

    /**
     * 最终回执状态
     */
    @Column
    @XmlTransient
    var returnStatus: String? = null

    /**
     * 回执状态描述
     */
    val returnStatusName: String
        @XmlTransient
        @Transient
        get() = CustomsResultStatus.transformStatusToDescription(returnStatus)

    /**
     * 最终回执信息
     */
    @Column
    @XmlTransient
    var returnInfo: String? = null

    /**
     * 最终回执时间
     */
    @Column
    @XmlTransient
    var returnTime: Date? = null
}

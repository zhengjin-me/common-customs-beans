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

import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1
import java.util.Date
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["guid", "returnStatus", "returnTime", "returnInfo"])
abstract class ReturnContentBaseEntity : ExtendEntity() {

    /**
     * 系统生成36位唯一序号（英文字母大写)
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var guid: String = ""

    /**
     * 操作结果（1电子口岸已暂存/2电子口岸申报中/3发送海关成功/4发送海关失败/100海关退单/120海关入库/300人工审核/399 海关审结/800放行/899结关等,若小于0 表示处理异常回执
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var returnStatus: String = ""

    /**
     * 回执时间
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    @XmlJavaTypeAdapter(value = me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter1::class)
    var returnTime: Date? = null

    /**
     * 回执信息
     */
    @Column
    @XmlElement(namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var returnInfo: String = ""
}

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

package me.zhengjin.common.customs.client.dxp

import me.zhengjin.common.customs.message.CEBMessageType
import java.io.Serializable
import java.nio.charset.Charset
import java.util.Base64
import java.util.Date
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlTransient
import javax.xml.bind.annotation.XmlType

/**
 * 终端节点消息实体
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["transInfo", "data", "addInfo"])
@XmlRootElement(name = "DxpMsg", namespace = "http://www.chinaport.gov.cn/dxp")
class ClientEndPointMessage() : Serializable {
    /**
     * 版本
     * an..3
     * 版本信息，当前版本为1.0。
     */
    @field:[
        XmlAttribute(name = "ver", required = true)
    ]
    val ver = "1.0"

    /**
     * 终端信息节点
     * 定义终端节点封装的相关信息
     * 必填:是
     *
     * 存有企业DXPID信息
     * 海关GUID读取msgId
     * 申报读取senderId
     * 回执读取receiverIds
     */
    @field:[
        XmlElement(name = "TransInfo", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var transInfo: TransInfo? = null

    /**
     * 待传输数据
     * 放置待传输的数据，即业务报文。Data定义类型为base64编码
     * 必填:是
     */
    @field:[
        XmlElement(name = "Data", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var data: String = ""
        /**
         * 待传输数据
         * setData 后，会自动转化成Base64编码的字符串
         */
        set(v) {
            val dataByte = Base64.getEncoder().encode(v.toByteArray(Charset.defaultCharset()))
            field = String(dataByte, Charsets.UTF_8)
        }

    /**
     * 附加信息
     * 终端节点封装数据的附加信息
     * 必填:否
     */
    @field:[
        XmlElement(name = "AddInfo", namespace = "http://www.chinaport.gov.cn/dxp", required = false)
    ]
    var addInfo: AddInfo = AddInfo()

    constructor(msgId: String, senderId: String, receiverIds: MutableList<String>, createTime: Date, msgType: CEBMessageType, data: String) : this() {
        this.transInfo = TransInfo(msgId, senderId, receiverIds, createTime, msgType)
        this.addInfo.fileName = "${msgType}_$msgId.xml"
        this.data = data
    }

    constructor(transInfo: TransInfo, data: String) : this() {
        this.transInfo = transInfo
        this.data = data
    }

    constructor(transInfo: TransInfo, data: String, addInfo: AddInfo) : this() {
        this.transInfo = transInfo
        this.addInfo = addInfo
        this.data = data
    }

    @XmlTransient
    fun getDataContent() = String(Base64.getDecoder().decode(this.data.toByteArray()))
}

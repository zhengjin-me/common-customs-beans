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

import me.zhengjin.common.customs.base.xmlDateAdapter.DateAdapter4
import me.zhengjin.common.customs.message.CEBMessageType
import java.util.Date
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["msgId", "senderId", "receiverIds", "createTime", "msgType"])
@XmlRootElement(name = "TransInfo", namespace = "http://www.chinaport.gov.cn/dxp")
class TransInfo(
    /**
     * 发送方内部报文ID
     * 发送方定义的传输报文内部唯一编号
     * an..255
     * 必填：是
     */
    @field:[
        XmlElement(name = "CopMsgId", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var msgId: String = "",

    /**
     * 发送方id(DXPID)
     * 发送方唯一id号，由数据交换平台统一分配
     * 数据格式:an..16
     * 必填：是
     */
    @field:[
        XmlElement(name = "SenderId", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var senderId: String = "",

    /**
     * 接收方id
     * 接收方id，节点可出现1到5次
     * 数据格式:C..18
     * 必填：是
     */
    @field:[
        XmlElement(name = "ReceiverId", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
        XmlElementWrapper(name = "ReceiverIds", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var receiverIds: MutableList<String> = ArrayList(),

    /**
     * 原始报文创建时间
     * 原始报文的创建时间，格式为： yyyy-mm-ddThh:mm:ss
     * 数据格式:DataTime
     * 必填：是
     */
    @field:[
        XmlElement(name = "CreatTime", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
        XmlJavaTypeAdapter(value = DateAdapter4::class)
    ]
    var createTime: Date? = null,

    /**
     * 报文类型
     * 报文类型，传输双方协定填写。
     * an..30
     * 必填：是
     */
    @field:[
        XmlElement(name = "MsgType", namespace = "http://www.chinaport.gov.cn/dxp", required = true)
    ]
    var msgType: CEBMessageType? = null
)

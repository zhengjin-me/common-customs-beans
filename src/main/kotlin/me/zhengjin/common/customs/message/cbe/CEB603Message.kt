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

package me.zhengjin.common.customs.message.cbe

import me.zhengjin.common.customs.business.cbe.inventory.po.declare.EInventory
import me.zhengjin.common.customs.message.CEBMessage
import me.zhengjin.common.customs.message.CEBMessageType
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlType

/**
 * 【跨境出口】清单申报
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["inventory", "baseTransfer", "baseSubscribe", "extendMessage"])
@XmlRootElement(name = "CEB603Message", namespace = "http://www.chinaport.gov.cn/ceb")
data class CEB603Message(

    /**
     * 出口清单业务节点
     * 必填: 是
     */
    @field:[
        XmlElement(name = "Inventory", namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    ]
    var inventory: MutableList<EInventory> = ArrayList()

) : CEBMessage() {

    override fun getMsgType(): CEBMessageType {
        return CEBMessageType.CEB603Message
    }
}
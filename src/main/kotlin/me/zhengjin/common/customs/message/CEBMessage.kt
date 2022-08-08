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

package me.zhengjin.common.customs.message

import me.zhengjin.common.customs.client.dxp.TransInfo
import me.zhengjin.common.customs.message.extend.BaseSubscribe
import me.zhengjin.common.customs.message.extend.BaseTransfer
import me.zhengjin.common.customs.message.extend.ExtendMessage
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlTransient

/**
 * @author fangzhengjin
 * date 2018-9-20 10:05
 * @version V1.0
 * title: CEBMessage
 * package com.oborcloud.ceb.po
 * description:
 */
// 由子类控制xml序列化的元素顺序
@XmlTransient
// @XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(name = "", propOrder = ["baseTransfer", "baseSubscribe", "extendMessage"])
abstract class CEBMessage : Serializable {
    /**
     * 报文编号
     * 报文的36位系统唯一序号（英文字母大写）。
     * an36
     * 必填:是
     */
    @XmlAttribute(required = true, name = "guid")
    var guid: String? = null

    @XmlAttribute(required = true, name = "version")
    var version = "1.0"

    /**
     * 企业报送状态 1-暂存,2-申报
     * 仅供加签时使用
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @XmlTransient
    var appStatus: String = "2"

    /**
     * 基础报文传输实体节点
     * 放置报文传输企业信息。
     * 必填:是
     */
    @XmlElement(name = "BaseTransfer", namespace = "http://www.chinaport.gov.cn/ceb", required = true)
    var baseTransfer: BaseTransfer? = null

    /**
     * 基础回执订阅实体节点
     * 用于第三方提供数据的订阅下发
     * 必填:否
     */
    @XmlElement(name = "BaseSubscribe", namespace = "http://www.chinaport.gov.cn/ceb")
    var baseSubscribe: List<BaseSubscribe> = ArrayList()

    @XmlElement(name = "ExtendMessage", namespace = "http://www.chinaport.gov.cn/ceb")
    var extendMessage: ExtendMessage? = null

    /**
     * 存有企业DXPID信息
     * 海关GUID读取msgId
     * 申报读取senderId
     * 回执读取receiverIds
     * 【仅用于存储日志使用】
     */
    @XmlTransient
    var transInfo: TransInfo? = null

    /**
     * 原始报文ID
     * 原始报文存储于MongoDB中
     */
    @XmlTransient
    var originalMessageId: String? = null

    /**
     * 终端节点报文内容
     */
    @XmlTransient
    var clientEndPointMessageData: String? = null

    /**
     * 业务节点报文内容
     */
    @XmlTransient
    var cebMessageData: String? = null

    @XmlTransient
    abstract fun getMsgType(): CEBMessageType

    open fun isSupport(cebMessageType: CEBMessageType) = getMsgType() == cebMessageType

    open fun isSupport(clazz: Class<out CEBMessage>) = getMsgType().clazz == clazz
}

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

import me.zhengjin.common.core.entity.BaseEntity
import me.zhengjin.common.customs.business.cbe.summaryResult.po.result.ESummaryResultHead
import me.zhengjin.common.customs.business.cbi.tax.po.result.ITaxHead
import me.zhengjin.common.customs.business.cbi.tax.po.result.ITaxHeadStatus
import me.zhengjin.common.customs.message.CEBMessage
import me.zhengjin.common.customs.message.MessageReturn
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlTransient

@MappedSuperclass
@XmlAccessorType(XmlAccessType.NONE)
abstract class ExtendEntity : BaseEntity() {

    /**
     * 原始报文ID
     * 原始报文存储于MongoDB中
     */
    @XmlTransient

    @Column
    var originalMessageId: String? = null

    /**
     * 海关GUID
     */
    @XmlTransient

    @Column
    var customsGuid: String? = null

    /**
     * 企业DXPID
     */
    @XmlTransient
    @Column
    var dxpId: String? = null

    /**
     * 系统客户代码 (存到note字段里)
     */
    @XmlTransient
    @Column
    var customerCode: String? = null

    /**
     * 异常邮件忽略
     */
    @XmlTransient
    @JsonIgnore
    @Column
    var errorIgnoreFlag: String = "0"

    fun processExtendInfo(cebMessage: CEBMessage) {
        when (this) {
            is DeclareContentBaseEntity -> {
                this.customsGuid = cebMessage.transInfo?.msgId
                this.dxpId = cebMessage.transInfo?.senderId
                this.originalMessageId = cebMessage.originalMessageId
            }
            is ReturnContentBaseEntity,
            is ESummaryResultHead,
            is MessageReturn,
            is ITaxHead,
            is ITaxHeadStatus -> {
                this.customsGuid = cebMessage.transInfo?.msgId
                this.dxpId = cebMessage.transInfo?.receiverIds?.get(0)
                this.originalMessageId = cebMessage.originalMessageId
            }
        }
    }
}

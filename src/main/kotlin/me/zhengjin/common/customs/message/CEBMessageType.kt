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

import javax.xml.bind.annotation.XmlEnum
import javax.xml.bind.annotation.XmlEnumValue

@XmlEnum
enum class CEBMessageType(
    val clazz: Class<out CEBMessage>,
    val description: String
) {
    /**
     * 跨境进口报文类型
     */
    @field:XmlEnumValue("CEB311Message")
    CEB311Message(me.zhengjin.common.customs.message.cbi.CEB311Message::class.java, "跨境进口订单申报"),

    @field:XmlEnumValue("CEB312Message")
    CEB312Message(me.zhengjin.common.customs.message.cbi.CEB312Message::class.java, "跨境进口订单回执"),

    @field:XmlEnumValue("CEB411Message")
    CEB411Message(me.zhengjin.common.customs.message.cbi.CEB411Message::class.java, "跨境进口支付单申报"),

    @field:XmlEnumValue("CEB412Message")
    CEB412Message(me.zhengjin.common.customs.message.cbi.CEB412Message::class.java, "跨境进口支付单回执"),

    @field:XmlEnumValue("CEB511Message")
    CEB511Message(me.zhengjin.common.customs.message.cbi.CEB511Message::class.java, "跨境进口运单申报"),

    @field:XmlEnumValue("CEB512Message")
    CEB512Message(me.zhengjin.common.customs.message.cbi.CEB512Message::class.java, "跨境进口运单回执"),

    @field:XmlEnumValue("CEB513Message")
    CEB513Message(me.zhengjin.common.customs.message.cbi.CEB513Message::class.java, "跨境进口运单状态申报"),

    @field:XmlEnumValue("CEB514Message")
    CEB514Message(me.zhengjin.common.customs.message.cbi.CEB514Message::class.java, "跨境进口运单状态回执"),

    @field:XmlEnumValue("CEB621Message")
    CEB621Message(me.zhengjin.common.customs.message.cbi.CEB621Message::class.java, "跨境进口清单申报"),

    @field:XmlEnumValue("CEB622Message")
    CEB622Message(me.zhengjin.common.customs.message.cbi.CEB622Message::class.java, "跨境进口清单回执"),

    @field:XmlEnumValue("CEB623Message")
    CEB623Message(me.zhengjin.common.customs.message.cbi.CEB623Message::class.java, "跨境进口撤销申请单申报"),

    @field:XmlEnumValue("CEB624Message")
    CEB624Message(me.zhengjin.common.customs.message.cbi.CEB624Message::class.java, "跨境进口撤销申请单回执"),

    @field:XmlEnumValue("CEB625Message")
    CEB625Message(me.zhengjin.common.customs.message.cbi.CEB625Message::class.java, "跨境进口退货申请单申报"),

    @field:XmlEnumValue("CEB626Message")
    CEB626Message(me.zhengjin.common.customs.message.cbi.CEB626Message::class.java, "跨境进口退货申请单回执"),

    @field:XmlEnumValue("CEB711Message")
    CEB711Message(me.zhengjin.common.customs.message.cbi.CEB711Message::class.java, "跨境进口入库单申报"),

    @field:XmlEnumValue("CEB712Message")
    CEB712Message(me.zhengjin.common.customs.message.cbi.CEB712Message::class.java, "跨境进口入库单回执"),

    @field:XmlEnumValue("CEB816Message")
    CEB816Message(me.zhengjin.common.customs.message.cbi.CEB816Message::class.java, "跨境进口电子税单回执"),

    @field:XmlEnumValue("CEB818Message")
    CEB818Message(me.zhengjin.common.customs.message.cbi.CEB818Message::class.java, "跨境进口电子税单状态回执"),

    @field:XmlEnumValue("CEB900Message")
    CEB900Message(me.zhengjin.common.customs.message.CEB900Message::class.java, "报文格式校验错误回执"),

    /**
     * 跨境出口报文类型
     */
    @field:XmlEnumValue("CEB303Message")
    CEB303Message(me.zhengjin.common.customs.message.cbe.CEB303Message::class.java, "跨境出口订单申报"),

    @field:XmlEnumValue("CEB304Message")
    CEB304Message(me.zhengjin.common.customs.message.cbe.CEB304Message::class.java, "跨境出口订单回执"),

    @field:XmlEnumValue("CEB403Message")
    CEB403Message(me.zhengjin.common.customs.message.cbe.CEB403Message::class.java, "跨境出口收款单申报"),

    @field:XmlEnumValue("CEB404Message")
    CEB404Message(me.zhengjin.common.customs.message.cbe.CEB404Message::class.java, "跨境出口收款单回执"),

    @field:XmlEnumValue("CEB505Message")
    CEB505Message(me.zhengjin.common.customs.message.cbe.CEB505Message::class.java, "跨境出口运单申报"),

    @field:XmlEnumValue("CEB506Message")
    CEB506Message(me.zhengjin.common.customs.message.cbe.CEB506Message::class.java, "跨境出口运单回执"),

    @field:XmlEnumValue("CEB507Message")
    CEB507Message(me.zhengjin.common.customs.message.cbe.CEB507Message::class.java, "跨境出口物流运抵申报"),

    @field:XmlEnumValue("CEB508Message")
    CEB508Message(me.zhengjin.common.customs.message.cbe.CEB508Message::class.java, "跨境出口物流运抵回执"),

    @field:XmlEnumValue("CEB509Message")
    CEB509Message(me.zhengjin.common.customs.message.cbe.CEB509Message::class.java, "跨境出口物流离境单申报"),

    @field:XmlEnumValue("CEB510Message")
    CEB510Message(me.zhengjin.common.customs.message.cbe.CEB510Message::class.java, "跨境出口物流离境单回执"),

    @field:XmlEnumValue("CEB603Message")
    CEB603Message(me.zhengjin.common.customs.message.cbe.CEB603Message::class.java, "跨境出口清单申报"),

    @field:XmlEnumValue("CEB604Message")
    CEB604Message(me.zhengjin.common.customs.message.cbe.CEB604Message::class.java, "跨境出口清单回执"),

    @field:XmlEnumValue("CEB605Message")
    CEB605Message(me.zhengjin.common.customs.message.cbe.CEB605Message::class.java, "跨境出口撤销申请单申报"),

    @field:XmlEnumValue("CEB606Message")
    CEB606Message(me.zhengjin.common.customs.message.cbe.CEB606Message::class.java, "跨境出口撤销申请单回执报文"),

    @field:XmlEnumValue("CEB607Message")
    CEB607Message(me.zhengjin.common.customs.message.cbe.CEB607Message::class.java, "跨境出口清单总分单申报"),

    @field:XmlEnumValue("CEB608Message")
    CEB608Message(me.zhengjin.common.customs.message.cbe.CEB608Message::class.java, "跨境出口清单总分单回执"),

    @field:XmlEnumValue("CEB701Message")
    CEB701Message(me.zhengjin.common.customs.message.cbe.CEB701Message::class.java, "跨境出口汇总申请单申报"),

    @field:XmlEnumValue("CEB702Message")
    CEB702Message(me.zhengjin.common.customs.message.cbe.CEB702Message::class.java, "跨境出口汇总申请单回执"),

    @field:XmlEnumValue("CEB792Message")
    CEB792Message(me.zhengjin.common.customs.message.cbe.CEB792Message::class.java, "跨境出口汇总结果单回执");

    fun generator(): CEBMessage = this.clazz.newInstance()

    companion object {
        @JvmStatic
        fun names(): List<String> {
            return values().map { it.name }
        }

        @JvmStatic
        fun valueOfNoCaseInsensitive(cbeType: String): CEBMessageType? {
            return values().singleOrNull { it.name.equals(cbeType, true) || it.name.equals("${cbeType}Message", true) }
        }
    }
}

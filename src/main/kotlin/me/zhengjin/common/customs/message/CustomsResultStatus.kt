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

/**
 * 海关回执状态枚举
 */
enum class CustomsResultStatus(
    val status: String,
    val description: String
) {
    /**
     * 1 电子口岸已暂存
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB608Message] 出口清单总分单回执
     * [CEB702Message] 出口汇总申请单回执
     *
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    ELECTRONIC_PORT_TEMPORARILY_STORED("1", "电子口岸已暂存"),

    /**
     * 2 电子口岸申报中
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB608Message] 出口清单总分单回执
     * [CEB702Message] 出口汇总申请单回执
     *
     * [CEB312Message] 进口订单回执
     * [CEB412Message] 进口支付单回执
     * [CEB512Message] 进口运单回执
     * [CEB514Message] 进口运单状态回执
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    ELECTRONIC_PORT_DECLARATION("2", "电子口岸申报中"),

    /**
     * 3 发送海关成功
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB608Message] 出口清单总分单回执
     * [CEB702Message] 出口汇总申请单回执
     *
     * [CEB312Message] 进口订单回执
     * [CEB412Message] 进口支付单回执
     * [CEB512Message] 进口运单回执
     * [CEB514Message] 进口运单状态回执
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    SEND_CUSTOMS_SUCCESS("3", "发送海关成功"),

    /**
     * 4 发送海关失败
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB608Message] 出口清单总分单回执
     * [CEB702Message] 出口汇总申请单回执
     *
     * [CEB312Message] 进口订单回执
     * [CEB412Message] 进口支付单回执
     * [CEB512Message] 进口运单回执
     * [CEB514Message] 进口运单状态回执
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    SEND_CUSTOMS_FAILED("4", "发送海关失败"),

    /**
     * 100 海关退单
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB608Message] 出口清单总分单回执
     * [CEB702Message] 出口汇总申请单回执
     *
     * [CEB312Message] 进口订单回执
     * [CEB412Message] 进口支付单回执
     * [CEB512Message] 进口运单回执
     * [CEB514Message] 进口运单状态回执
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    CUSTOMS_RETURN("100", "海关退单"),

    /**
     * 120 海关入库
     * [CEB304Message] 出口订单回执
     * [CEB404Message] 出口收款单回执
     * [CEB506Message] 出口运单回执
     * [CEB508Message] 出口运抵单回执
     * [CEB510Message] 出口离境单回执
     * [CEB604Message] 出口清单回执
     * [CEB608Message] 出口清单总分单回执
     *
     * [CEB312Message] 进口订单回执
     * [CEB412Message] 进口支付单回执
     * [CEB512Message] 进口运单回执
     * [CEB514Message] 进口运单状态回执
     * [CEB622Message] 进口清单回执
     * [CEB624Message] 进口撤消单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    CUSTOMS_STORAGE("120", "海关入库"),

    /**
     * 300 人工审核
     * [CEB604Message] 出口清单回执
     * [CEB622Message] 进口清单回执
     */
    CUSTOMS_MANUAL_REVIEW("300", "人工审核"),

    /**
     * 500 查验
     */
    CUSTOMS_INSPECTION("500", "查验"),

    /**
     * 399 海关审结
     * [CEB604Message] 出口清单回执
     * [CEB606Message] 出口撤消单回执
     * [CEB702Message] 出口汇总申请单回执
     * [CEB622Message] 进口清单回执
     * [CEB626Message] 进口退货申请单回执
     * [CEB712Message] 进口入库明细单回执
     */
    CUSTOMS_TRIAL_ENDS("399", "海关审结"),

    /**
     * 800 放行
     * [CEB604Message] 出口清单回执
     * [CEB622Message] 进口清单回执
     */
    CUSTOMS_CLEARANCE("800", "放行"),

    /**
     * 899 结关
     * [CEB604Message] 出口清单回执
     * [CEB622Message] 进口清单回执
     */
    CUSTOMS_CLOSE("899", "结关"),

    /**
     * 501 扣留移送通关
     * [CEB622Message] 进口清单回执
     */
    DETAINED_TRANSFER_CLEARANCE("501", "扣留移送通关"),

    /**
     * 502 扣留移送缉私
     * [CEB622Message] 进口清单回执
     */
    DETAINED_TRANSFER("502", "扣留移送缉私"),

    /**
     * 503 扣留移送法规
     * [CEB622Message] 进口清单回执
     */
    DETENTION_TRANSFER_REGULATIONS("503", "扣留移送法规"),

    /**
     * 599 其他扣留
     * [CEB622Message] 进口清单回执
     */
    OTHER_DETENTION("599", "其他扣留"),

    /**
     * 700 退运
     * [CEB622Message] 进口清单回执
     */
    RETURNED("700", "退运");

    fun generatorMockDescription(): String {
        return "[Code:$status;Desc:MOCK,$description]"
    }

    companion object {
        @JvmStatic
        fun transformStatusToDescription(status: String?): String {
            val list = values().filter { it.status == status }
            if (list.isNotEmpty()) {
                return list[0].description
            }
            return "--"
        }
    }
}

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

package me.zhengjin.common.customs.utils

import me.zhengjin.common.customs.message.CustomsResultStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.UUID

object CustomsResultMockUtils {

    @JvmStatic
    private val dtf1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")!!

    @JvmStatic
    private val dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")!!

    @JvmStatic
    private fun xmlWrapper(type: String, content: String, uuid: String, receiverId: String, senderId: String): String {
        val time = dtf2.format(LocalDateTime.now())

        return """
                |<?xml version="1.0" encoding="UTF-8" ?>
                |<DxpMsg xmlns="http://www.chinaport.gov.cn/dxp" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ver="1.0">
                |    <TransInfo>
                |        <CopMsgId>${uuid.uppercase()}</CopMsgId>
                |        <SenderId>$senderId</SenderId>
                |        <ReceiverIds>
                |            <ReceiverId>$receiverId</ReceiverId>
                |        </ReceiverIds>
                |        <CreatTime>$time</CreatTime>
                |        <MsgType>$type</MsgType>
                |    </TransInfo>
                |    <Data>${Base64.getEncoder().encodeToString(content.toByteArray())}</Data>
                |    <AddInfo>
                |        <FileName>$type${uuid.uppercase()}</FileName>
                |        <IcCard>1</IcCard>
                |        <BizKey>
                |            <Key name="DealFlag">1</Key>
                |            <Key name="RetType">1</Key>
                |        </BizKey>
                |    </AddInfo>
                |</DxpMsg>
        """.trimMargin()
    }

    /**
     * ??????????????????????????????
     * @param ebpCode ??????????????????
     * @param ebcCode ??????????????????
     * @param orderNo ?????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????????????????
     */
    @JvmStatic
    fun generatorCEB312Message(
        ebpCode: String,
        ebcCode: String,
        orderNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                |<CEB312Message xmlns="http://www.chinaport.gov.cn/ceb" version="1.0" guid="${uuid.uppercase()}">
                |    <OrderReturn>
                |        <guid>$uuid</guid>
                |        <ebpCode>$ebpCode</ebpCode>
                |        <ebcCode>$ebcCode</ebcCode>
                |        <orderNo>$orderNo</orderNo>
                |        <returnStatus>2</returnStatus>
                |        <returnTime>$time</returnTime>
                |        <returnInfo>??????????????????[MOCK,??????:$orderNo] </returnInfo>
                |    </OrderReturn>
                |</CEB312Message>
        """.trimMargin()
        return xmlWrapper("CEB312Message", content, uuid, receiverId, "DXPEDCCEB0000002")
    }

    /**
     * ??????????????????????????????
     * @param logisticsCode ??????????????????
     * @param logisticsNo ?????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????????????????
     */
    @JvmStatic
    fun generatorCEB512Message(
        logisticsCode: String,
        logisticsNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                |<CEB512Message xmlns="http://www.chinaport.gov.cn/ceb" version="1.0" guid="${uuid.uppercase()}">
                |    <LogisticsReturn>
                |        <guid>$uuid</guid>
                |        <logisticsCode>$logisticsCode</logisticsCode>
                |        <logisticsNo>$logisticsNo</logisticsNo>
                |        <returnStatus>2</returnStatus>
                |        <returnTime>$time</returnTime>
                |        <returnInfo>??????????????????[MOCK,??????$logisticsNo] </returnInfo>
                |    </LogisticsReturn>
                |</CEB512Message>
        """.trimMargin()
        return xmlWrapper("CEB512Message", content, uuid, receiverId, "DXPEDCCEB0000002")
    }

    /**
     * ??????????????????????????????
     * @param resultType ????????????
     * @param customsCode ???????????? 4258 ????????????
     * @param ebpCode ??????????????????
     * @param ebcCode ??????????????????
     * @param agentCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ???????????????
     * @param invtNo ?????????
     * @param orderNo ?????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB622Message(
        resultType: CustomsResultStatus,
        customsCode: String,
        ebpCode: String,
        ebcCode: String,
        agentCode: String,
        copNo: String,
        preNo: String,
        invtNo: String = "",
        orderNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        var returnInfo = ""
        var returnStatus = ""
        when (resultType) {
            CustomsResultStatus.ELECTRONIC_PORT_DECLARATION -> {
                returnStatus = CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status
                returnInfo = "????????????????????????[MOCK,?????????????????????$ebcCode ???????????????$orderNo]"
            }
            CustomsResultStatus.CUSTOMS_INSPECTION -> {
                returnStatus = CustomsResultStatus.CUSTOMS_INSPECTION.status
                returnInfo = CustomsResultStatus.CUSTOMS_INSPECTION.generatorMockDescription()
            }
            CustomsResultStatus.CUSTOMS_MANUAL_REVIEW -> {
                returnStatus = CustomsResultStatus.CUSTOMS_MANUAL_REVIEW.status
                returnInfo = CustomsResultStatus.CUSTOMS_MANUAL_REVIEW.generatorMockDescription()
            }
            CustomsResultStatus.CUSTOMS_CLEARANCE -> {
                returnStatus = CustomsResultStatus.CUSTOMS_CLEARANCE.status
                returnInfo = CustomsResultStatus.CUSTOMS_CLEARANCE.generatorMockDescription()
            }
            else -> {
            }
        }
        val content = """
                |<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                |<CEB622Message xmlns="http://www.chinaport.gov.cn/ceb" version="1.0" guid="${uuid.uppercase()}">
                |    <InventoryReturn>
                |        <guid>$uuid</guid>
                |        <customsCode>$customsCode</customsCode>
                |        <ebpCode>$ebpCode</ebpCode>
                |        <ebcCode>$ebcCode</ebcCode>
                |        <agentCode>$agentCode</agentCode>
                |        <copNo>$copNo</copNo>
                |        <preNo>$preNo</preNo>
                |        <invtNo>$invtNo</invtNo>
                |        <returnStatus>$returnStatus</returnStatus>
                |        <returnTime>$time</returnTime>
                |        <returnInfo>$returnInfo</returnInfo>
                |    </InventoryReturn>
                |</CEB622Message>
        """.trimMargin()
        return xmlWrapper("CEB622Message", content, uuid, receiverId, "DXPEDCCEB0000002")
    }

    /**
     * ??????????????????????????????
     * @param ebpCode ??????????????????
     * @param ebcCode ??????????????????
     * @param orderNo ?????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????????????????
     */
    @JvmStatic
    fun generatorCEB304Message(
        ebpCode: String,
        ebcCode: String,
        orderNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB304Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:OrderReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:ebpCode>$ebpCode</ceb:ebpCode>
                |		<ceb:ebcCode>$ebcCode</ceb:ebcCode>
                |		<ceb:orderNo>$orderNo</ceb:orderNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:OrderReturn>
                |</ceb:CEB304Message>
        """.trimMargin()
        return xmlWrapper("CEB304Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ?????????????????????????????????
     * @param ebcCode ??????????????????
     * @param orderNo ?????????
     * @param payNo ??????????????????
     * @param receiverId ?????????DXPID
     * @return ?????????????????????????????????
     */
    @JvmStatic
    fun generatorCEB404Message(
        payNo: String,
        ebcCode: String,
        orderNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB404Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:ReceiptsReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:ebcCode>$ebcCode</ceb:ebcCode>
                |		<ceb:orderNo>$orderNo</ceb:orderNo>
                |		<ceb:payNo>$payNo</ceb:payNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:ReceiptsReturn>
                |</ceb:CEB404Message>
        """.trimMargin()
        return xmlWrapper("CEB404Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ??????????????????????????????
     * @param logisticsCode ??????????????????
     * @param logisticsNo ??????????????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????????????????
     */
    @JvmStatic
    fun generatorCEB506Message(
        logisticsCode: String,
        logisticsNo: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB506Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:LogisticsReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:logisticsCode>$logisticsCode</ceb:logisticsCode>
                |		<ceb:logisticsNo>$logisticsNo</ceb:logisticsNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:LogisticsReturn>
                |</ceb:CEB506Message>
        """.trimMargin()
        return xmlWrapper("CEB506Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ????????????????????????????????????
     * @param operatorCode ???????????????????????????
     * @param logisticsCode ??????????????????
     * @param preNo ??????????????????
     * @param copNo ??????????????????
     * @param billNo ????????????
     * @param msgSeqNo ???????????? ?????????????????? 1
     * @param receiverId ?????????DXPID
     * @return ????????????????????????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB508Message(
        operatorCode: String,
        logisticsCode: String,
        preNo: String,
        copNo: String,
        billNo: String,
        msgSeqNo: String = "1",
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB508Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:ArrivalReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:operatorCode>$operatorCode</ceb:operatorCode>
                |		<ceb:logisticsCode>$logisticsCode</ceb:logisticsCode>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:billNo>$billNo</ceb:billNo>
                |		<ceb:msgSeqNo>$msgSeqNo</ceb:msgSeqNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:ArrivalReturn>
                |</ceb:CEB508Message>
        """.trimMargin()
        return xmlWrapper("CEB508Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ???????????????????????????????????????
     * @param logisticsCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ??????????????????
     * @param msgSeqNo ???????????? ?????????????????? 1
     * @param receiverId ?????????DXPID
     * @return ???????????????????????????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB510Message(
        logisticsCode: String,
        copNo: String,
        preNo: String,
        msgSeqNo: String = "1",
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB510Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:DepartureReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:logisticsCode>$logisticsCode</ceb:logisticsCode>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:msgSeqNo>$msgSeqNo</ceb:msgSeqNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:DepartureReturn>
                |</ceb:CEB510Message>
        """.trimMargin()
        return xmlWrapper("CEB510Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ??????????????????????????????
     * @param resultType ????????????
     * @param agentCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ??????????????????
     * @param invtNo ????????????
     * @param ebcCode ??????????????????
     * @param ebpCode ??????????????????
     * @param orderNo ????????????
     * @param statisticsFlag ?????????????????? A-????????????;B-????????????
     * @param receiverId ?????????DXPID
     * @return ??????????????????????????????
     */
    @JvmStatic
    fun generatorCEB604Message(
        resultType: CustomsResultStatus,
        agentCode: String,
        copNo: String,
        preNo: String,
        invtNo: String,
        ebcCode: String,
        ebpCode: String,
        orderNo: String,
        statisticsFlag: String,
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB604Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:InventoryReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:agentCode>$agentCode</ceb:agentCode>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:invtNo>$invtNo</ceb:invtNo>
                |		<ceb:ebcCode>$ebcCode</ceb:ebcCode>
                |		<ceb:ebpCode>$ebpCode</ceb:ebpCode>
                |		<ceb:orderNo>$orderNo</ceb:orderNo>
                |		<ceb:statisticsFlag>$statisticsFlag</ceb:statisticsFlag>
                |		<ceb:returnStatus>${resultType.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${resultType.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:InventoryReturn>
                |</ceb:CEB604Message>
        """.trimMargin()
        return xmlWrapper("CEB604Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ?????????????????????????????????
     * @param agentCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ??????????????????
     * @param invtNo ????????????
     * @param msgSeqNo ???????????? ?????????????????? 1
     * @param receiverId ?????????DXPID
     * @return ?????????????????????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB606Message(
        agentCode: String,
        copNo: String,
        preNo: String,
        invtNo: String,
        msgSeqNo: String = "1",
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB606Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:InvtCancelReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:agentCode>$agentCode</ceb:agentCode>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:invtNo>$invtNo</ceb:invtNo>
                |		<ceb:msgSeqNo>$msgSeqNo</ceb:msgSeqNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:InvtCancelReturn>
                |</ceb:CEB606Message>
        """.trimMargin()
        return xmlWrapper("CEB606Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ???????????????????????????????????????
     * @param agentCode ??????????????????
     * @param logisticsCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ??????????????????
     * @param billNo ????????????
     * @param msgSeqNo ???????????? ?????????????????? 1
     * @param receiverId ?????????DXPID
     * @return ???????????????????????????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB608Message(
        agentCode: String,
        logisticsCode: String,
        copNo: String,
        preNo: String,
        billNo: String,
        msgSeqNo: String = "1",
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB608Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:WayBillReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:agentCode>$agentCode</ceb:agentCode>
                |		<ceb:logisticsCode>$logisticsCode</ceb:logisticsCode>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:billNo>$billNo</ceb:billNo>
                |		<ceb:msgSeqNo>$msgSeqNo</ceb:msgSeqNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:WayBillReturn>
                |</ceb:CEB608Message>
        """.trimMargin()
        return xmlWrapper("CEB608Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    /**
     * ???????????????????????????????????????
     * @param agentCode ??????????????????
     * @param ebcCode ??????????????????
     * @param copNo ??????????????????
     * @param preNo ??????????????????
     * @param sumNo ??????????????????
     * @param msgSeqNo ???????????? ?????????????????? 1
     * @param receiverId ?????????DXPID
     * @return ???????????????????????????????????????
     */
    @JvmOverloads
    @JvmStatic
    fun generatorCEB702Message(
        agentCode: String,
        ebcCode: String,
        copNo: String,
        preNo: String,
        sumNo: String,
        msgSeqNo: String = "1",
        receiverId: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        val time = dtf1.format(LocalDateTime.now())
        val content = """
                |<?xml version="1.0" encoding="UTF-8"?>
                |<ceb:CEB702Message guid="$uuid" version="1.0"  xmlns:ceb="http://www.chinaport.gov.cn/ceb" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                |	<ceb:SummaryReturn>
                |		<ceb:guid>$uuid</ceb:guid>
                |		<ceb:agentCode>$agentCode</ceb:agentCode>
                |		<ceb:ebcCode>$ebcCode</ceb:ebcCode>
                |		<ceb:copNo>$copNo</ceb:copNo>
                |		<ceb:preNo>$preNo</ceb:preNo>
                |		<ceb:sumNo>$sumNo</ceb:sumNo>
                |		<ceb:msgSeqNo>$msgSeqNo</ceb:msgSeqNo>
                |		<ceb:returnStatus>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.status}</ceb:returnStatus>
                |		<ceb:returnTime>$time</ceb:returnTime>
                |		<ceb:returnInfo>${CustomsResultStatus.ELECTRONIC_PORT_DECLARATION.generatorMockDescription()}</ceb:returnInfo>
                |	</ceb:SummaryReturn>
                |</ceb:CEB702Message>
        """.trimMargin()
        return xmlWrapper("CEB702Message", content, uuid, receiverId, "DXPEDCCEB0000003")
    }

    @JvmStatic
    fun generatorCEB816Message(
        receiverId: String,
        content: String
    ): String {
        val uuid = UUID.randomUUID().toString()
        return xmlWrapper("CEB816Message", content, uuid, receiverId, "DXPEDCCEB0000002")
    }
}

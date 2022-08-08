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

package me.zhengjin.common.customs.base.xmlDateAdapter

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import javax.xml.bind.annotation.adapters.XmlAdapter

class DateAdapter3 : XmlAdapter<String, Date>() {
    companion object {
        @JvmStatic
        private val dtf = DateTimeFormatter.ofPattern("yyyyMMdd")!!
    }

    override fun marshal(v: Date?): String {
        if (v == null) return ""
        val localDateTime = LocalDateTime.ofInstant(v.toInstant(), ZoneId.systemDefault())
        return dtf.format(localDateTime)
    }

    override fun unmarshal(v: String?): Date {
        if (v.isNullOrBlank()) return Date()
        val localDate = dtf.parse(v, LocalDate::from)
        val localDateTime = localDate.atStartOfDay()
        val zonedDateTime = localDateTime.atZone(ZoneId.systemDefault())
        return Date.from(zonedDateTime.toInstant())
    }
}

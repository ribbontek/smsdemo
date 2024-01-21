package com.ribbontek.smsdemo

import com.amazonaws.services.sns.model.InvalidParameterException
import com.ribbontek.smsdemo.service.SmsMessage
import com.ribbontek.smsdemo.service.SmsService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SmsDemoApplicationTests {

    @Value("\${com.ribbontek.sms.test.number}")
    private lateinit var testNumber: String

    @Autowired
    private lateinit var smsService: SmsService

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun `publish a message to a verified sms - successful`() {
        val result = smsService.sendMessage(SmsMessage(testNumber, "TEST >> Welcome to SMS"))
        log.info("Received result - $result")
    }

    @Test
    fun `publish a message to a verified sms - error`() {
        val result = assertThrows<InvalidParameterException> {
            smsService.sendMessage(SmsMessage("abcd", "TEST >> Welcome to SMS"))
        }
        log.info("Received result - $result")
        assertTrue(result.message?.startsWith("Invalid parameter: PhoneNumber Reason: abcd is not valid to publish to") ?: false)
    }
}

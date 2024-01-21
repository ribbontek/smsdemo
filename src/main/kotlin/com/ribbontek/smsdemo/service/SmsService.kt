package com.ribbontek.smsdemo.service

import com.amazonaws.services.sns.AmazonSNSClient
import com.amazonaws.services.sns.model.PublishRequest
import com.amazonaws.services.sns.model.PublishResult
import org.springframework.stereotype.Service

data class SmsMessage(
    val phoneNumber: String,
    val message: String
)

interface SmsService {
    fun sendMessage(smsMessage: SmsMessage): PublishResult
}

@Service
class SmsServiceImpl(
    private val amazonSNSClient: AmazonSNSClient
) : SmsService {

    override fun sendMessage(smsMessage: SmsMessage): PublishResult {
        return amazonSNSClient.publish(
            PublishRequest().apply {
                message = smsMessage.message
                phoneNumber = smsMessage.phoneNumber
            }
        )
    }
}

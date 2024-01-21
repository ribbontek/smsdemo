package com.ribbontek.smsdemo.config

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.sns.AmazonSNSClient
import com.amazonaws.services.sns.AmazonSNSClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SmsConfig(
    @Value("\${com.ribbontek.sms.region}") private val smsRegion: String
) {

    @Bean
    fun amazonSnsClient(): AmazonSNSClient = AmazonSNSClientBuilder
        .standard()
        .withCredentials(DefaultAWSCredentialsProviderChain())
        .withRegion(smsRegion)
        .build() as AmazonSNSClient
}

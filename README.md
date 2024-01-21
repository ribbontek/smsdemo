# SMS Demo

A simple demo app that utilises SpringBoot 3.2, Kotlin 1.9, Java 21, SQS, & SNS

To configure the project: 
- Add your test number into AWS as a sandboxed destination phone number
- Add the test number into application.properties (E.164 format)
  - com.ribbontek.sms.test.number

Build & run the application

```
./gradlew clean build -i
```
# MQTT Android Service Tutorial
A tutorial for using the MQTT Android Service, as seen on https://wildanmsyah.wordpress.com/2017/05/11/mqtt-android-client-tutorial/

### Requirements:
- Android Studio
- [Paho MQTT Android Service](https://github.com/eclipse/paho.mqtt.android)
- [CloudMQTT Broker](https://www.cloudmqtt.com/)

### Functionality:
  -Retrieves from cloudMQTT broker messages uploaded by Server
  
  -Allows user to decide whether to send verification message or not. Could opt for automatic sending and manual testing
### How to modify MqttHelper.java:
  Make change to CloudMQTT server by changing serverUri variable on line 20, clientId, username and password to suitable cloudmqtt broker corresponding names.
  Able to distinguish between topics by changing variable subscriptionTopic on line 23

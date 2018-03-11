import json
import paho.mqtt.client as mqtt
import random
import time
import threading
import sys

mqttc = mqtt.Client("client1", clean_session=False)
mqttc.username_pw_set("jxjanbvd", "uuUlFpgEVUte")
mqttc.connect("m23.cloudmqtt.com", 10035, 60)


def pub():
    mqttc.publish("sms/henry","Message you want to edit")
    threading.Timer(1, pub).start()

pub()

#!/bin/bash
#
#

javac UDPClient.java UDPServer.java
java UDPClient localhost "Ping message de test"
# rm ./*.class

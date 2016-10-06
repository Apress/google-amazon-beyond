@echo off
set CL=../../../common/lib/
set AXP=.;%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar

java -cp %AXP% FactorialClient 10 http://localhost:8080/axis/Factorial.jws

set AXP=
set CL=
pause

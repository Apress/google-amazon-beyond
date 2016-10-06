@echo off
set CL=../../../common/lib/
set AXP=.;%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar

java -cp %AXP% UpdateCountClient -utjm -wtjm -hlocalhost -p65432 DELETE_AmaAuth 123456789X

set AXP=
set CL=
pause

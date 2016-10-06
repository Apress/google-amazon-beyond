set CL=../../../common/lib/
set AXP=%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar
set WSDLURI=googleSearch.wsdl
java -cp %AXP% org.apache.axis.wsdl.WSDL2Java %WSDLURI%
set WSDLURI=
set AXP=
set CL=
pause

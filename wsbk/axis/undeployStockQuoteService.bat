set CL=../../../common/lib/
set AXP=%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar
java -cp %AXP% org.apache.axis.client.AdminClient com/example/stockquote_wsdl/undeploy.wsdd
set AXP=
set CL=
pause

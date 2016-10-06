set CL=../../../common/lib/
set AXP=%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar
set WSDLURI=w3stockquote.wsdl
java -cp %AXP% org.apache.axis.wsdl.WSDL2Java  --server-side --skeletonDeploy true %WSDLURI%
set WSDLURI=
set AXP=
set CL=
pause

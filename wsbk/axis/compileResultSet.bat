set CL=../../../common/lib/
set AXP=.;%CL%axis.jar;%CL%commons-logging-api.jar
set AXP=%AXP%;%CL%commons-discovery.jar;%CL%wsdl4j.jar;
set AXP=%AXP%;%CL%jaxrpc.jar;%CL%saaj.jar

javac -classpath %AXP% ResultSetClient.java com/n_topus/DBS_RS/*.java

set AXP=
set CL=
pause

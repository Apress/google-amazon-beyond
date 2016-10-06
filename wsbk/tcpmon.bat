@echo off
set CL=../../common/lib/

java -cp %CL%axis.jar org.apache.axis.utils.tcpmon

set CL=
pause

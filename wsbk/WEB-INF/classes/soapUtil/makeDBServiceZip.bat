rem this is C:\Program Files\Apache Group\Tomcat 4.1\webapps\wsbk\WEB-INF\classes\soapUtil\makeDBServiceZip.bat
cd ..\..\..
jar -cf DBService.zip WEB-INF/classes/DBServiceConfig.xml WEB-INF/classes/soapUtil/DBService.* WEB-INF/classes/soapUtil/makeDBServ*.*
jar -uf DBService.zip DBService/BookClubReviewer.html utils/xmlhttp.js utils/getDOMdata.js utils/key.js
jar -uf DBService.zip DBService/usingRequestURLs.html
move DBService.zip DBService/DBService.zip
pause

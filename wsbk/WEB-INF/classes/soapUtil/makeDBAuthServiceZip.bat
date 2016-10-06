rem this is C:\Program Files\Apache Group\Tomcat 4.1\webapps\wsbk\WEB-INF\classes\soapUtil\makeDBAuthServiceZip.bat
cd ..\..\..
jar -cf DBAuthService.zip WEB-INF/classes/DBAuthServiceConfig*.xml WEB-INF/classes/xslt/*.* WEB-INF/classes/soapUtil/DBAuth*.* WEB-INF/classes/soapUtil/DBQ*.* WEB-INF/classes/soapUtil/makeDBAuth*.* WEB-INF/classes/soapUtil/doDBAuth*.*
jar -uf DBAuthService.zip DBService/BookClubAuthReviewer.html DBService/BookClubREST.html DBService/usingAuthRequestURLs.html utils/xmlhttp.js utils/getDOMdata.js utils/key.js
rem jar -uf DBAuthService.zip DBService/usingRequestURLs.html
move DBAuthService.zip DBService/DBAuthService.zip
pause

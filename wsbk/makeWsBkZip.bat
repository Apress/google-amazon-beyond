cd ..
jar -cf wsbk.zip  wsbk/*.htm* wsbk/*.txt wsbk/*.jsp wsbk/makeWsBkZip.bat wsbk/tcpmon.bat
jar -uf wsbk.zip  wsbk/amazon/*.html wsbk/amazon/*.txt
jar -uf wsbk.zip  wsbk/base64/*.htm*
jar -uf wsbk.zip  wsbk/DBService/*.htm* wsbk/DBService/*.txt wsbk/DBService/*.xml
jar -uf wsbk.zip  wsbk/googleShare_1/*.htm* wsbk/googleShare_1/*.txt wsbk/googleShare_1/*.js
jar -uf wsbk.zip  wsbk/ntopuRSS
jar -uf wsbk.zip  wsbk/rss
jar -uf wsbk.zip  wsbk/utils
jar -uf wsbk.zip  wsbk/weather
jar -uf wsbk.zip  wsbk/webdav
jar -uf wsbk.zip  wsbk/WEB-INF/web.xml wsbk/WEB-INF/classes/*.xml wsbk/WEB-INF/classes/xslt wsbk/WEB-INF/classes/soapUtil 
jar -uf wsbk.zip  wsbk/xmlhttp
jar -uf wsbk.zip  wsbk/xslt
jar -uf wsbk.zip  wsbk/oxdav
jar -uf wsbk.zip  wsbk/axis
jar -uf wsbk.zip  /mysql/data/wsbkdb
jar -uf wsbk.zip  axis/Factorial.jws axis/WEB-INF/classes/com
jar -uf wsbk.zip  oxdav/h*.html oxdav/o*.htm oxdav/i*.html oxdav/*.jsp
jar -uf wsbk.zip  oxdav/res/*.htm*
jar -uf wsbk.zip  oxdav/openXML/CODE/*.xsl
jar -uf wsbk.zip  oxdav/TIDY
jar -uf wsbk.zip  oxdav/WEB-INF/web.xml oxdav/WEB-INF/classes
move wsbk.zip wsbk
pause


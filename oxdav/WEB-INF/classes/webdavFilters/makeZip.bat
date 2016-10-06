if exist oxdav.zip del oxdav.zip
del *.$$$
cd ..\..\..\..

jar -cf oxdav.zip oxdav/rdbCreateTables.jsp oxdav/showTables.jsp oxdav/error.jsp
jar -uf oxdav.zip oxdav/index.htm oxdav/openXMLctl.jsp oxdav/openXMLhelp.htm
jar -uf oxdav.zip oxdav/TIDY/tidy.cfg oxdav/openXML/CODE/*.xsl
jar -uf oxdav.zip oxdav/WEB-INF/classes/webdavFilters/*.* oxdav/WEB-INF/web.xml
jar -uf oxdav.zip oxdav/openXML/MyerhoffUnitStructured.htm
jar -uf oxdav.zip oxdav/res/openXML/MyerhoffUnitStructured.htm
jar -uf oxdav.zip oxdav/openXML/NordstromUnit.htm oxdav/res/openXML/NordstromUnit.htm
move oxdav.zip oxdav\WEB-INF\classes\webdavFilters
pause

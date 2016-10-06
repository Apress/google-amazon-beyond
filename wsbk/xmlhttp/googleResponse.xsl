<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
  xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"
  xmlns:xsd="http://www.w3.org/1999/XMLSchema"
  xmlns:ns1="urn:GoogleSearch"
  xmlns:ns2="http://schemas.xmlsoap.org/soap/encoding/"
  xmlns:ns3="http://schemas.xmlsoap.org/soap/encoding/"
  exclude-result-prefixes="SOAP-ENV xsi xsd ns1 ns2 ns3"
                version="1.0">
<xsl:output method="html"/>
<xsl:template match="/">
 <html> <head> <title> Google Response </title>
    <style>
     span.selected {background:lightgreen;}
    </style>
  </head>
  <body style="color:blue">
<table border="1" style="color:red">
<tr><td>xmlns:SOAP-ENV</td><td>http://schemas.xmlsoap.org/soap/envelope/</td></tr>
<tr><td>xmlns:xsi</td><td>http://www.w3.org/1999/XMLSchema-instance</td></tr>
<tr><td>xmlns:xsd</td><td>http://www.w3.org/1999/XMLSchema</td></tr>
<tr><td>xmlns:ns1</td><td>urn:GoogleSearch</td></tr>
<tr><td>xmlns:ns2</td><td>http://schemas.xmlsoap.org/soap/encoding/</td></tr>
<tr><td>xmlns:ns3</td><td>http://schemas.xmlsoap.org/soap/encoding/</td></tr>
</table>

   <xsl:apply-templates/>
  </body>
 </html>
</xsl:template>

<xsl:template match="*">
  <div style="margin-left:10px">
    <xsl:value-of select="concat('&lt;',name())"/>
    <xsl:apply-templates select="@*"/>
    <xsl:text>&gt;</xsl:text>
    <xsl:apply-templates/>
    <xsl:value-of select="concat('&lt;/',name(),'&gt;')"/>
  </div>
</xsl:template>
<xsl:template match="@*">
  <xsl:text> </xsl:text>
  <span style="color:black">
     <xsl:value-of select="concat(name(),'=',.)"/>
  </span>
</xsl:template>


</xsl:stylesheet>


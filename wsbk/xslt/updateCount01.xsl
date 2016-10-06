<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="/">
  <html><head><title>updateCount01 Output</title></head><body>
 <div>
    <h2>
       <xsl:text>Original Title: </xsl:text>
      <xsl:value-of select="html/head/title"/>
    </h2>
    <h3>
      <xsl:text>Rows affected: </xsl:text>
      <xsl:value-of select="html/body/span"/>
    </h3>
  </div>
  </body></html>
</xsl:template>


</xsl:stylesheet>


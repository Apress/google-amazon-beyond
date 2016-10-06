<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="span">
  <div>
    <h3>
      <xsl:text>Rows affected: </xsl:text>
      <xsl:value-of select="."/>
    </h3>
  </div>
</xsl:template>    
 
</xsl:stylesheet>


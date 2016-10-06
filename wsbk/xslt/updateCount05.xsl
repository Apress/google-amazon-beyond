<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="/">
  <html><head><title>updateCount05 Output</title></head><body>
  <div>
    <xsl:apply-templates select="html/head/title"/>
    <xsl:apply-templates select="html/body/span"/>
  </div>
  </body></html>
</xsl:template>
<xsl:template match="title">
   <h3>
      <xsl:text>Original Title: </xsl:text>
      <xsl:value-of select="."/>
    </h3>
</xsl:template>
<xsl:template match="span">
    <h3>
      <xsl:text>Rows affected: </xsl:text>
      <xsl:value-of select="."/>
    </h3>
</xsl:template>
</xsl:stylesheet>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="/">
  <html><head><title>updateCount06 Output</title></head><body>
    <table border="1">
      <tr><td>Top Level</td></tr>
      <tr><td><xsl:value-of select="."/></td></tr>
      <tr><td><xsl:apply-templates select="node()"/></td></tr>
    </table>
  </body></html>
</xsl:template>

<xsl:template match="*">
  <table border="1">
    <tr><td>Tag: <xsl:value-of select="name(.)"/></td></tr>
    <tr><td><xsl:apply-templates select="@*"/></td></tr>
    <tr><td><xsl:value-of select="."/></td></tr>
    <tr><td><xsl:apply-templates select="node()"/></td></tr>
  </table>
</xsl:template>    

<xsl:template match="text()">
  <b><xsl:value-of select="."/></b>
</xsl:template>

<xsl:template match="@*">
  <em><xsl:value-of select="concat(name(.),'=',.,' ')"/></em>
</xsl:template>    

</xsl:stylesheet>


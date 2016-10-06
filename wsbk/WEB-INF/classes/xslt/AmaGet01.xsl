<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />
      

<xsl:template match="/">
  <html><head><title>XSL-Lite</title></head>
    <body>
      <xsl:apply-templates select="ProductInfo/Details" />
    </body>
  </html>
</xsl:template>

<xsl:template match="Details">
  <div>
    <xsl:variable name="url" select="@url"/>
    <xsl:variable name="productName" select="ProductName"/>
    <xsl:apply-templates select="Authors/Author"/>
    <xsl:text> wrote </xsl:text>
    <a href="{$url}">
      <xsl:value-of select="$productName"/>
    </a>
  </div>
</xsl:template>

<xsl:template match="Author">
  <xsl:if test="position() &gt; 1"> and </xsl:if>
  <span style="background:lightgreen"><xsl:value-of select="."/></span>
</xsl:template>

</xsl:stylesheet>


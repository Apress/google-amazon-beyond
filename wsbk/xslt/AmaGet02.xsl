<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />
      
<xsl:template match="/">
  <html><head><title>AmaGet02.xsl</title></head>
    <body>
      <table border="1">
        <tr><th>Authors</th><th>Title</th><th>Price</th></tr>
        <xsl:apply-templates select="ProductInfo/Details" />
      </table>
    </body>
  </html>
</xsl:template>

<xsl:template match="Details">
  <xsl:variable name="url" select="@url"/>
  <xsl:variable name="productName" select="ProductName"/>
  <tr>
    <td>
      <xsl:apply-templates select="Authors/Author"/>
    </td>
    <td>
      <a href="{$url}">
        <xsl:value-of select="$productName"/>
      </a>
    </td>
    <td><xsl:value-of select="OurPrice"/></td>
  </tr>
</xsl:template>

<xsl:template match="Author">
  <xsl:if test="position() &gt; 1">, </xsl:if>
  <span style="background:yellow"><xsl:value-of select="."/></span>
</xsl:template>

</xsl:stylesheet>


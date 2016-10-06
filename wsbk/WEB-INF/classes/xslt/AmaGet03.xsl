<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="/">
  <html><head><title>AmaGet03.xsl</title></head>
    <body>
      <table border="1">
        <tr><th>Authors</th><th>Title</th><th>Price</th></tr>
        <xsl:for-each select="ProductInfo/Details" >
          <xsl:sort select="substring-after(OurPrice,'$')" data-type="number"/>
          <tr>
            <td><xsl:apply-templates select="Authors/Author"/></td>
            <td><a href="{@url}"><xsl:value-of select="ProductName"/></a></td>
            <td><xsl:value-of select="OurPrice"/></td>
           </tr>
        </xsl:for-each>
      </table>
    </body>
  </html>
</xsl:template>

<xsl:template match="Author">
  <xsl:if test="position() &gt; 1">, </xsl:if>
  <span style="background:orange"><xsl:value-of select="."/></span>
</xsl:template>

</xsl:stylesheet>


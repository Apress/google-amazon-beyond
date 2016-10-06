<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />
      
<!--
 columns in AmaBks are 
   (Asin,ProductName,ReleaseDate,Manufacturer,OurPrice,URL) 
This stylesheet takes one such table as its input, and generates
a paragraph for each row after the first (header) row.
-->

<!-- top-level match -->

<xsl:template match="/">
  <html><head><title>amaBks.xsl</title></head>
    <body>
      <xsl:apply-templates select="*" />
    </body>
  </html>
</xsl:template>
<xsl:template match="table">
  <div>
    <xsl:apply-templates select="tr[position() &gt; 1]" />
  </div>
</xsl:template>

<xsl:template match="tr">
  <xsl:variable name="asin" select="td[1]"/>
  <xsl:variable name="prodName" select="td[2]"/>
  <xsl:variable name="releaseDate" select="td[3]"/>
  <xsl:variable name="manufacturer" select="td[4]"/>
  <xsl:variable name="ourPrice" select="td[5]"/>
  <xsl:variable name="url" select="td[6]"/>
  <p>
    <a href="{$url}"><xsl:value-of select="$prodName"/></a>
    <xsl:text> costs </xsl:text>
    <xsl:value-of select="$ourPrice"/>
  </p>
</xsl:template>    


</xsl:stylesheet>


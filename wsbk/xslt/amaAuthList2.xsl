<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<!--
  This stylesheet turns a table (asin, author) into a list of paragraphs
  The input looks like
  <table>
    <tr><th>ASIN</th><th>    AUTHOR</th></tr>
    <tr><td>1234</td><td>John Smith</td></tr>
    <tr><td>4321</td><td>  Jane Doe</td></tr>
    ...
  </table>
-->

<!-- top-level match -->

<xsl:template match="/">
  <html><head><title>amaAuthList.xsl</title></head>
    <body>
      <xsl:apply-templates select="table" />
    </body>
  </html>
</xsl:template>

<xsl:template match="table">
  <div>
    <xsl:apply-templates select="tr[position() &gt; 1]"/>
  </div>
</xsl:template>    


<xsl:template match="tr">
  <xsl:variable name="asin" select="td[1]"/>
  <xsl:variable name="author" select="td[2]"/>
  <xsl:variable name="baseRef"
      select="'http://localhost:65431/AmaBks/'" />
  <xsl:variable name="doc" select="document(concat($baseRef,$asin))"/>
<!-- columns in AmaBks are 
   (Asin,ProductName,ReleaseDate,Manufacturer,OurPrice,URL) -->
<!-- we could refer to the title as $doc//td[2], but better specific: -->
  <xsl:variable name="row" select="$doc/html/body/table/tr"/>
  <xsl:variable name="title" select="$row/td[2]"/>
  <xsl:variable name="url" select="$row/td[6]"/>
  <p>
    <xsl:value-of select="$author"/>
    <xsl:text> wrote </xsl:text>
    <a href="{$url}">
      <xsl:value-of select="$title"/>
    </a>
  </p>
</xsl:template>    


</xsl:stylesheet>


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:key name="asinRow"
               match="tr"
               use="td[1]" />
<xsl:key name="asinList"
               match="tr/td[1]"
               use="'names'" />
      

<!--
  This stylesheet turns a table (asin, author) into a list of paragraphs,
  one for each ASIN.
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
  <html><head><title>amaAuthList3.xsl</title></head>
    <body>
      <xsl:apply-templates select="key('asinList','names')" />
    </body>
  </html>
</xsl:template>

<xsl:template match="td">

<!-- this template is applied to td[1] cells, i.e. containing the ASIN -->
  <xsl:variable name="asin" select="."/>
  <xsl:variable name="rowsLikeMe" select="key('asinRow',string($asin))" />
  <xsl:if test="generate-id($asin)=generate-id($rowsLikeMe/td[1])">
    <p> 
      <xsl:variable name="authors" select="$rowsLikeMe/td[2]"/>
      <xsl:variable name="baseRef"
        select="'http://localhost:65431/AmaBks/'" />
      <xsl:variable name="doc" select="document(concat($baseRef,$asin))"/>
<!-- columns in AmaBks are 
   (Asin,ProductName,ReleaseDate,Manufacturer,OurPrice,URL) -->
<!-- we could refer to the title as $doc//td[2], but better specific: -->
      <xsl:variable name="row" select="$doc/html/body/table/tr"/>
      <xsl:variable name="title" select="$row/td[2]"/>
      <xsl:variable name="url" select="$row/td[6]"/>
      <xsl:for-each select="$authors">
        <xsl:if test="position() &gt; 1">
          <xsl:text> and </xsl:text>
        </xsl:if>
        <xsl:value-of select="."/>
      </xsl:for-each>
      <xsl:text> wrote </xsl:text>
      <a href="{$url}"><xsl:value-of select="$title"/></a>

    </p>
  </xsl:if>
</xsl:template>    


<xsl:template match="trx">
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


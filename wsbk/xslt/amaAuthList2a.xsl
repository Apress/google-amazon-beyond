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
   <xsl:apply-templates />
</xsl:template>

<!-- default match -->

<xsl:template match="*">
  <xsl:apply-templates/>
</xsl:template>

<!--
  match <table>...</table>
  produce <div><p>A wrote X</p><p>B wrote Y</p>...</div>

 -->

<xsl:template match="table">
  <div>
    <xsl:apply-templates/>
  </div>
</xsl:template>    
<xsl:template match="tr">
  <xsl:variable name="cells" value="td">
  <p>
    <xsl:value-of select="cells[2]"/>
    <xsl:text> wrote </xsl:text>
    <xsl:apply-templates select="cells[1]" mode="makeURL"/>
  </p>
</xsl:template>    
<!-- turn <td>123</td> into
     <a href="http://www.amazon.com/../123">123</a>
 -->
<xsl:template match="td" mode="makeURL"/>
  <xsl:variable name="baseRef" value="http:www.amazon.com/.."/>
  <xsl:variable name="theHRef" value="concat($baseRef,.)"/>
  <xsl:element name="a">
     <xsl:attribute name="href" value="$theHRef"/>
     <xsl:value-of select="."/>
  </xsl:element>
</xsl:template>
 
</xsl:stylesheet>


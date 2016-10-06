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
  <xsl:variable name="baseRef2"
      select="'http://www.amazon.com/exec/obidos/ASIN/'" />
  <xsl:variable name="baseRef"
      select="'http://localhost:65432/AmaBks/'" />
  <p>
    <xsl:value-of select="td[2]"/>
    <xsl:text> wrote </xsl:text>
    <a href="{concat($baseRef,td[1])}">
      <xsl:value-of select="td[1]"/>
    </a>
  </p>
</xsl:template>    


</xsl:stylesheet>


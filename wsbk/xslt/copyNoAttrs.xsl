<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />
<xsl:strip-space elements="*"/> 
<xsl:template match="/">
   <xsl:apply-templates />
</xsl:template>

<xsl:template match="*">
  <xsl:copy>
    <xsl:apply-templates/>
  </xsl:copy>
</xsl:template>

<xsl:template match="table">
  <xsl:copy>
    <xsl:attribute name="border">1</xsl:attribute>
    <xsl:apply-templates/>
  </xsl:copy>
</xsl:template>

<xsl:template match="p | span">
  <xsl:if test="string(.)">
  <xsl:copy>
    <xsl:apply-templates/>
  </xsl:copy>
   </xsl:if>
</xsl:template>
    

<xsl:template match="text()">
 <xsl:value-of select="."/>
</xsl:template>
 
</xsl:stylesheet>


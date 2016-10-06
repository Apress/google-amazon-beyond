<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                 version="1.0">

<!-- first we say that the first h1 anywhere is "root"  -->
<xsl:key name="root" match="h1" use="'root'" />

<!-- now we assert that each h2  is a child of the h1, etc. -->
<xsl:key name="children"
   match="h2" use="generate-id(preceding::h1[1])" />
<xsl:key name="children"
   match="h3" use="generate-id(preceding::h2[1])" />
<xsl:key name="children"
   match="h4" use="generate-id(preceding::h3[1])" />
<xsl:key name="children"
   match="h5" use="generate-id(preceding::h4[1])" />
<xsl:key name="children"
   match="h6" use="generate-id(preceding::h5[1])" />

<xsl:template match="/">
 <html><xsl:copy-of select="/html/head"/><body>
   <xsl:if test="1 &lt; count(key('root','root'))">
      <!-- Output warning -->
      <h1 style='color:red'>
        Warning: This document contains more than one h1 element.
      </h1>
      <div style='color:red'>
        <pre>
          <xsl:copy-of select="key('root','root')"/>
        </pre>
      </div>
   </xsl:if>
   <xsl:apply-templates mode="section"
                        select="key('root','root')[1]"/>
 </body></html>
</xsl:template>

<xsl:template match="node()" mode="collectText">
  <xsl:if test="not(string-length(name(.))=2) or
                not(starts-with(name(.),'h'))">
     <xsl:copy-of select="."/>
     <xsl:apply-templates mode="collectText"
                          select="following-sibling::node()[1]"/>
  </xsl:if>
</xsl:template>

<xsl:template match="*" mode="section">
  <xsl:param name="parentPath" select="''"/>
  <xsl:variable name="path">
    <xsl:choose>
      <xsl:when test="$parentPath">
        <xsl:value-of select="$parentPath"/>_<xsl:number/>
      </xsl:when>
      <xsl:otherwise><xsl:text>s</xsl:text></xsl:otherwise>
    </xsl:choose>
  </xsl:variable>
  <div class="{concat('div_',name(.))}" style="margin:10" id="{concat('div',$path)}">
     <xsl:copy>
       <a name="{$path}" href="{concat('#',$path)}">_</a>
       <xsl:copy-of select="node()"/>
     </xsl:copy>
     <span class="textCollection">
       <xsl:apply-templates mode="collectText" select="following-sibling::node()[1]"/>
     </span>
     <xsl:apply-templates mode="section" select="key('children',generate-id(.))">
       <xsl:with-param name="parentPath" select="$path"/>
     </xsl:apply-templates>
  </div>
</xsl:template>

</xsl:stylesheet>


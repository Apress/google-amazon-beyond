<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />


<!--
  This stylesheet displays a single Product Review, e.g.
   http://localhost:65432/indivProdRev/0393011836:tjm
  by pulling in data from http://localhost:65431/AmaBks, 
  from http://localhost:654321/AmaAuth,
  and from Amazon's web site.

ProdRevs: (AsinUserID,Asin,UserID,dtime,Rating,Keywords,Review)
AmaBks:   (Asin,ProductName,ReleaseDate,Manufacturer,OurPrice,Url)
AmaAuth:  (Asin,Author)
Amazon: heavy, contains /ProductInfo/Details/SalesRank
using
-->

<!-- top-level match -->
<xsl:template match="/">
  <html><head><title>indivProdRev.xsl</title></head>
    <body>
      <xsl:apply-templates select="*" />
    </body>
  </html>
</xsl:template>
<xsl:template match="table">
  <xsl:apply-templates select="tr[2]"/>
</xsl:template>

<xsl:template match="tr">
  <xsl:variable name="asin" select="td[2]"/>
  <xsl:variable name="userID" select="td[3]"/>
  <xsl:variable name="dTime" select="td[4]"/>
  <xsl:variable name="rating" select="td[5]"/>
  <xsl:variable name="keywords" select="td[6]"/>
  <xsl:variable name="review" select="td[7]"/>

  <xsl:variable name="baseRef"
    select="'http://localhost:65431/'" />
  <xsl:variable name="audoc"
    select="document(concat($baseRef,'AmaAuth/',$asin))"/>
  <xsl:variable name="authorTable" select="$audoc/html/body/table" />

  <xsl:variable name="bkdoc"
    select="document(concat($baseRef,'AmaBks/',$asin))"/>
  <xsl:variable name="bkRow"
    select="$bkdoc/html/body/table/tr[2]"/>
  <xsl:variable name="prodName" select="$bkRow/td[2]"/>
  <xsl:variable name="releaseDate" select="$bkRow/td[3]"/>
  <xsl:variable name="manufacturer" select="$bkRow/td[4]"/>
  <xsl:variable name="ourPrice" select="$bkRow/td[5]"/>
  <xsl:variable name="url" select="$bkRow/td[6]"/>

  <xsl:variable name="devT" select="'D2Y0P98RA19J1K'"/>
  <xsl:variable name="amaBase"
    select="'http://xml.amazon.com/onca/xml2?t=webservices-20'"/>
  <xsl:variable name="amaURL"
    select="concat($amaBase,'&amp;dev-t=',$devT,
                 '&amp;AsinSearch=',$asin,
                  '&amp;type=heavy&amp;f=xml')"/>
  <xsl:variable name="amaDoc" select="document($amaURL)"/>
  <xsl:variable name="salesRank"
    select="$amaDoc/ProductInfo/Details/SalesRank"/>

  <div>
    <p>
    <a href="{$url}"><xsl:value-of select="$prodName"/></a>
      <xsl:text>, by </xsl:text>
      <xsl:for-each select="$authorTable/tr[position() &gt; 1]/td[2]">
        <xsl:sort select="substring-after(.,' ')"/>
        <xsl:if test="position()&gt; 1"> and </xsl:if>
        <xsl:value-of select="."/>
      </xsl:for-each>
      <xsl:text> costs </xsl:text>
      <xsl:value-of select="$ourPrice"/>
    </p>
    <p>
      Its salesrank is
      <xsl:value-of select="$salesRank"/>.
    </p><p>
      <xsl:value-of select="$userID"/> reviewed it on 
      <xsl:value-of select="$dTime"/>, giving it a rating of 
      <xsl:value-of select="$rating"/>; the review is
      <br/>
      <xsl:value-of select="$review"/>
     </p>
  </div>
</xsl:template>    

</xsl:stylesheet>


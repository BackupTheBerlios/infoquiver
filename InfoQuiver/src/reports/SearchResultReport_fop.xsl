<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo" 
    xmlns:date="http://exslt.org/dates-and-times" extension-element-prefixes="date">
    <xsl:include href="src/reports/inc_variables.xsl"/>
    <xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <!-- defines the layout master -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="iq_first" page-height="29.7cm" page-width="21cm" 
                    margin="0mm 20mm 5mm 20mm">
                    <fo:region-body margin="20mm 00mm 20mm 00mm"/>
                    <fo:region-after extent="10mm" display-align="before"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="iq_first" force-page-count="no-force" initial-page-number="1">
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block text-align="center" font-size="9pt"> - <fo:page-number/> - </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body">
                    <fo:table table-layout="fixed">
                        <fo:table-column column-width="140mm"/>
                        <fo:table-column column-width="30mm"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-size="14pt" font-family="serif" font-weight="bold" 
                                        line-height="15pt">InfoQuiver - Search Report</fo:block>
                                    <fo:block font-size="10pt" font-family="serif" line-height="12pt" color="black">
                                        <xsl:value-of select="/root/created"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block padding-bottom="20pt" text-align="right">
                                        <fo:basic-link external-destination="url({$homeurl})">
                                            <fo:external-graphic src="file:images/iquiver.gif"/>
                                        </fo:basic-link>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:table table-layout="fixed">
                        <fo:table-column column-width="8mm"/>
                        <fo:table-column column-width="132mm"/>
                        <fo:table-column column-width="30mm"/>
                        <fo:table-body>
                            <xsl:for-each select="/root/queryresult">
                                <xsl:variable name="resultpos" select="position()"/>
                                <fo:table-row>
                                    <fo:table-cell number-columns-spanned="3">
                                        <fo:table table-layout="fixed">
                                            <fo:table-column column-width="120mm"/>
                                            <fo:table-column column-width="50mm"/>
                                            <fo:table-body>
                                                <fo:table-row>
                                                    <fo:table-cell padding-top="10pt" border-bottom-style="solid" 
                                                        border-bottom-color="black" border-bottom-width="0.1pt">
                                                        <fo:block font-size="12pt" font-family="serif" 
                                                            line-height="12pt">
                                                            <xsl:value-of select="SearchQuery/SearchQueryCriteria"/>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell padding-top="10pt" border-bottom-style="solid" 
                                                        border-bottom-color="black" border-bottom-width="0.1pt">
                                                        <fo:block font-size="12pt" font-family="serif" 
                                                            line-height="12pt" color="black" text-align="right"> 
                                                            <xsl:value-of 
                                                            select="count(/root/queryresult[$resultpos]/Document)"/><xsl:value-of 
                                                            select="$spacer"/>results<xsl:value-of select="$spacer"/> 
                                                            </fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                                <fo:table-row>
                                                    <fo:table-cell padding-bottom="8pt"/>
                                                </fo:table-row>
                                            </fo:table-body>
                                        </fo:table>
                                    </fo:table-cell>
                                </fo:table-row>
                                <xsl:for-each select="/root/queryresult[$resultpos]/Document">
                                    <xsl:variable name="fileURL">
                                        <xsl:value-of select="InfoUrl"/>
                                    </xsl:variable>
                                    <fo:table-row>
                                        <fo:table-cell padding-right="5pt">
                                            <fo:block font-size="10pt" font-family="serif" line-height="12pt" 
                                                color="black" text-align="right" font-weight="bold">
                                                <xsl:value-of select="position()"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block font-size="10pt" font-family="serif" line-height="12pt" 
                                                color="#225B79" font-weight="bold">
                                                <fo:basic-link external-destination="url({$fileURL})">
                                                    <xsl:choose>
                                                        <xsl:when test="string-length(Name) &gt; 0">
                                                            <xsl:value-of select="Name"/>
                                                        </xsl:when>
                                                        <xsl:otherwise>
                                                            <xsl:choose>
                                                                <xsl:when test="string-length(FileName) &gt; 0">
                                                                    <xsl:value-of select="FileName"/>
                                                                </xsl:when>
                                                                <xsl:otherwise> no title</xsl:otherwise>
                                                            </xsl:choose>
                                                        </xsl:otherwise>
                                                    </xsl:choose>
                                                </fo:basic-link>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block font-size="10pt" font-family="serif" line-height="12pt" 
                                                color="black" text-align="right"> <xsl:value-of select="Score"/>% 
                                                </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell/>
                                        <fo:table-cell number-columns-spanned="2">
                                            <fo:block font-size="10pt" font-family="serif" line-height="12pt" 
                                                color="black">
                                                <xsl:choose>
                                                    <xsl:when test="string-length(Description) &gt; 0">
                                                        <xsl:value-of select="Description"/>
                                                    </xsl:when>
                                                    <xsl:otherwise>
                                                        <xsl:when test="string-length(Title) &gt; 0">
                                                            <xsl:value-of select="Title"/>
                                                        </xsl:when>
                                                    </xsl:otherwise>
                                                </xsl:choose>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <fo:table-row>
                                        <fo:table-cell number-columns-spanned="3" padding-top="5pt" padding-bottom="5pt">
                                            <fo:block font-size="10pt" font-family="serif" line-height="12pt" 
                                                color="#225B79" text-align="right">
                                                <fo:basic-link external-destination="url({$fileURL})">
                                                    <xsl:value-of select="$fileURL"/>
                                                </fo:basic-link>
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:include href="src/reports/inc_variables.xsl"/>
    <xsl:include href="src/reports/inc_styles.xsl"/>
    <xsl:output method="html" encoding="ISO-8859-1" />
    <xsl:template match="/">
        <html>
            <xsl:call-template name="head"/>
            <body>
                <xsl:call-template name="content"/>
            </body>
        </html>
    </xsl:template>
    <xsl:template name="head">
        <head>
            <title>InfoQuiver :: search report</title>
            <xsl:call-template name="styles"/>
        </head>
    </xsl:template>
    <xsl:template name="content">
        <div align="center">
            <table cellspacing="0" cellpadding="0" width="700" border="0" class="maintable">
                <tr>
                    <td valign="top" align="left" width="90%">
                        <span class="headline">InfoQuiver - Search Report</span><br/>
                        <xsl:value-of select="/root/created"/>
                    </td>
                    <td width="10%" valign="top" align="right">
                        <a href="{$homeurl}">
                            <img src="iquiver.gif" alt="{$homeurl}" border="0"/>
                        </a>
                    </td>                    
                </tr>
                <tr>
                    <td colspan="2"><xsl:value-of select="$spacer"/></td>
                </tr>
                <tr>
                    <td colspan="2" width="90%">
                        <xsl:for-each select="/root/queryresult">
                            <xsl:variable name="resultpos" select="position()"/>
                            <table cellspacing="0" cellpadding="0" border="0" width="100%">
                                <tr>
                                    <td class="headerbox" width="100%">
                                        <table cellspacing="0" cellpadding="0" border="0">
                                            <tr>
                                                <td valign="middle" align="left" width="2%">
                                                    <img src="frame_icon.gif" border="0" alt="0"/>
                                                </td>
                                                <td valign="middle" align="left" width="73%">
                                                    <span class="tableheader">
                                                        <xsl:value-of select="SearchQuery/SearchQueryCriteria"/>
                                                    </span>
                                                </td>
                                                <td valign="middle" align="right" width="25%">
                                                    <span class="tableheader"> <xsl:value-of 
                                                        select="count(/root/queryresult[$resultpos]/Document)"/> 
                                                        results </span>
                                                    <xsl:value-of select="$spacer"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <xsl:for-each select="/root/queryresult[$resultpos]/Document">
                                    <xsl:variable name="fileURL">
                                        <xsl:value-of select="InfoUrl"/>
                                    </xsl:variable>
                                    <tr>
                                        <td width="100%" class="contentbox">
                                            <table class="content" width="100%">
                                                <tr>
                                                    <td width="2%">
                                                        <span class="headline">
                                                            <xsl:value-of select="position()"/>
                                                        </span>
                                                    </td>
                                                    <td width="83%">
                                                        <b>
                                                            <a href="{$fileURL}" target="_blank">
                                                                <xsl:choose>
                                                                    <xsl:when test="string-length(Name) &gt; 0">
                                                                        <xsl:value-of select="Name"/>
                                                                    </xsl:when>
                                                                    <xsl:otherwise>
                                                                        <xsl:choose>
                                                                            <xsl:when 
                                                                                test="string-length(FileName) &gt; 0">
                                                                                <xsl:value-of select="FileName"/>
                                                                            </xsl:when>
                                                                            <xsl:otherwise> no title </xsl:otherwise>
                                                                        </xsl:choose>
                                                                    </xsl:otherwise>
                                                                </xsl:choose>
                                                            </a>
                                                        </b>
                                                    </td>
                                                    <td align="right" width="15%"><xsl:value-of select="Score"/>%</td>
                                                </tr>
                                                <tr>
                                                    <td width="2%">
                                                        <xsl:value-of select="$spacer"/>
                                                    </td>
                                                    <td colspan="2" align="left" width="98%">
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
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td colspan="2" align="right">
                                                        <a href="{$fileURL}" target="_blank">
                                                            <xsl:value-of select="$fileURL"/>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </table>
                        </xsl:for-each>
                    </td>
                </tr>
            </table>
        </div>
    </xsl:template>
</xsl:stylesheet>
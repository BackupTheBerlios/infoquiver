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
            <title>InfoQuiver :: Search result report</title>
            <xsl:call-template name="styles"/>
        </head>
    </xsl:template>
    <xsl:template name="content">
        <table>
            <tr>
                <td>
                    <a href="{$homeurl}">
                        <img src="iquiver.gif" alt="{$homeurl}" border="0"/>
                    </a>
                </td>
                <td valign="middle">InfoQuiver - Search Results</td>
            </tr>
        </table>
        <div class="box">
            <xsl:for-each select="/root/queryresult">
                <xsl:variable name="resultpos" select="position()"/>
                <table>
                    <tr>
                        <td>
                            <h1>
                                <xsl:value-of select="SearchQuery/SearchQueryCriteria"/>
                            </h1>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table>
                                <xsl:for-each select="/root/queryresult[$resultpos]/Document">
                                    <xsl:variable name="fileURL">
                                        <xsl:value-of select="InfoUrl"/>
                                    </xsl:variable>
                                    <tr>
                                        <td>
                                            <h2>
                                                <xsl:value-of select="position()"/>
                                            </h2>
                                        </td>
                                        <td>
                                            <a href="{$fileURL}" target="_blank">
                                                <xsl:choose>
                                                    <xsl:when test="string-length(Name) &gt; 0">
                                                        <xsl:value-of select="Name"/>
                                                    </xsl:when>
                                                    <xsl:otherwise>
                                                        <xsl:when test="string-length(FileName) &gt; 0">
                                                            <xsl:value-of select="FileName"/>
                                                        </xsl:when>
                                                    </xsl:otherwise>
                                                </xsl:choose>
                                            </a>
                                        </td>
                                        <td align="right"><xsl:value-of select="Score"/>%</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td colspan="2">
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
                                        <td></td>
                                        <td align="right">
                                            <a href="{$fileURL}" target="_blank">
                                                <xsl:value-of select="$fileURL"/>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <xsl:value-of select="$spacer"/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </table>
                        </td>
                    </tr>
                </table>
            </xsl:for-each>
        </div>
    </xsl:template>
</xsl:stylesheet>
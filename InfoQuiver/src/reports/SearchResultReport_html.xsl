<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">    
<xsl:include href="reports/inc_variables.xsl"/>
    
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
            <link rel="stylesheet" type="text/css" href="{$path}/styles.css" />
        </head>
    </xsl:template>
    
    <xsl:template name="content">
        <xsl:for-each select="/root/queryresult">
            <xsl:variable name="resultpos" select="position()"/>
            <table>
                <tr>
                    <td><xsl:value-of select="SearchQuery/SearchQueryCriteria"/></td>
                </tr>
                <tr>
                    <td>
                        <table>
                            <xsl:for-each select="/root/queryresult[$resultpos]/document">
                             <tr>
                                <td><xsl:value-of select="position()"/></td>
                                <td></td>
                                <td align="right"><xsl:value-of select="score"/></td>
                            </tr>
                            </xsl:for-each>
                        </table>
                    </td>
                </tr>
            </table>
        </xsl:for-each>
    </xsl:template>
    
</xsl:stylesheet>
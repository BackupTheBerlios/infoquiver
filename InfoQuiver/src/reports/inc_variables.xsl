<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:variable name="copyright">&#169;</xsl:variable>
	<xsl:variable name="br">&#xA;</xsl:variable>
	<xsl:variable name="spacer">&#xa0;</xsl:variable>
	<xsl:variable name="euro">&#8364;</xsl:variable>
	<xsl:variable name="leftBracket">(</xsl:variable>
	<xsl:variable name="rightBracket">)</xsl:variable>
	<xsl:variable name="colon">:</xsl:variable>
	<xsl:variable name="backslash">-</xsl:variable>
	<xsl:variable name="dash">/</xsl:variable>
	<xsl:variable name="comma">,</xsl:variable>	
    <xsl:variable name="dot">.</xsl:variable>
    <xsl:variable name="paraLine">|</xsl:variable>
    <xsl:variable name="percentage">%</xsl:variable>
    <xsl:variable name="star">*</xsl:variable>
    <xsl:variable name="apos">&apos;</xsl:variable>
	
	<xsl:variable name="img.images">images/</xsl:variable>
	<xsl:variable name="img.spacer"><xsl-value-of select="$img.images"/>/spacer.gif</xsl:variable>
	<xsl:variable name="img.logo"><xsl-value-of select="$img.images"/>/iquiver.gif</xsl:variable>
    
</xsl:stylesheet>

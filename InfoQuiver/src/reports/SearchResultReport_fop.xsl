<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo" 
    xmlns:date="http://exslt.org/dates-and-times" extension-element-prefixes="date">
    <xsl:include href="reports/inc_variables.xsl"/>
    
    <xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
    
    <xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<!-- defines the layout master -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="iq_first" page-height="29.7cm" page-width="21cm" margin-top="0.5cm" 
					margin-bottom="2cm" margin-left="1cm" margin-right="2cm">
					<fo:region-body margin-top="1cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="iq_first">
				<fo:flow flow-name="xsl-region-body">
                    <fo:block>hallo</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>        
    </xsl:template>
</xsl:stylesheet>
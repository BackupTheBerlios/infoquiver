<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template name="styles">
        <style type="text/css"> <![CDATA[
            body            { background-color               : #E7E7E7;
                              color                          : #000000;
                              padding-top                    : 20px;
                              padding-bottom                 : 20px;                  
                            }
            
            td, p, li     { font-size              : 11px;
                            font-family            : Verdana,Arial;
                            color                  : #000000; } 
            .headline   	 {font-family: Verdana, Arial, sans-serif; font-size:11; color:#000000; font-weight: bold}
            .tableheader    { font-size: 11px; font-family: Verdana,Arial; color: #FFFFFF; font-weight: bold}
            .footer         { font-size: 11px; font-family: Verdana,Arial; color: #FFFFFF;}
            .maintable           { margin:             0px;
                                   padding:            0px; }                                   
            .headerbox           { font-family:        Verdana,Arial;
                                   font-size:          11px;
                                   border-left:        1px solid #333333;
                                   border-right:       1px solid #333333;
                                   border-top:         1px solid #333333;
                                   border-bottom:      1px solid #333333;
                                   background-color:   #3394c7;
                                   color:              #FFFFFF;
                                   height:             16px; }
            .contentbox            {font-family:        Verdana,Arial;
                                   font-size:          11px;
                                   border-left:        1px solid #333333;
                                   border-right:       1px solid #333333;                                   
                                   background-color:   #DAE7F3;
                                   padding:            8px;
                                   color:              #000000;}
            .content            {font-family:        Verdana,Arial;
                                   font-size:          11px;
                                   background-color:   #DAE7F3;
                                   padding:            8px;
                                   color:              #000000;}                                   
            A:link           {font-family: Verdana, Arial, sans-serif; font-size:11; text-decoration: none; color: #225B79}
            A:visited        {font-family: Verdana, Arial, sans-serif; font-size:11; text-decoration: none; color: #225B79}
            A:hover          {font-family: Verdana, Arial, sans-serif; font-size:11; text-decoration: none; color: #AE6B00}
            A:active         {font-family: Verdana, Arial, sans-serif; font-size:11; text-decoration: none; color: #AE6B00}            
        ]]> </style>
    </xsl:template>
</xsl:stylesheet>
<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">    
    <xsl:template name="styles">
        <style type="text/css">
        <![CDATA[
            BODY
            {
                BORDER-RIGHT: 0px;
                BORDER-TOP: 0px;
                FONT-SIZE: 11px;
                MARGIN: 0px;
                BORDER-LEFT: 0px;
                COLOR: #000000;
                BORDER-BOTTOM: 0px;
                FONT-FAMILY: Verdana, Arial, Geneva, Helvetica, sans-serif;
                BACKGROUND-COLOR: #efefef
            }
            .error
            {
                FONT-SIZE: 11px;
                COLOR: red;
                FONT-FAMILY: verdana, arial, helvetica, sans-serif;
                TEXT-DECORATION: none
            }
            .error_important
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: red;
                FONT-FAMILY: verdana, arial, helvetica, sans-serif
            }
            SELECT.singleline
            {
                BORDER-RIGHT: #ffffff 1px solid;
                BORDER-TOP: #ffffff 1px solid;
                FONT-SIZE: 11px;
                BORDER-LEFT: #ffffff 1px solid;
                COLOR: #000000;
                BORDER-BOTTOM: #ffffff 1px solid;
                HEIGHT: 20px
            }
            TD
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            H1
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            H2
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            H3
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            H4
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            UL
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            OL
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            LI
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            ADDRESS
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            BLOCKQUOTE
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txtTitle
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 18px;
                COLOR: #255aa6;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txtSubTitle
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 14px;
                COLOR: #255aa6;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt11
            {
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt11bold
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt11blue
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #255aa6;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt11white
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #ffffff;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .copyright
            {
                FONT-WEIGHT: normal;
                FONT-SIZE: 11px;
                COLOR: #999999;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt12
            {
                FONT-SIZE: 12px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            .txt12bold
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 12px;
                COLOR: #000000;
                FONT-FAMILY: Arial, Geneva, Nimbus, Helvetica, sans-serif
            }
            A
            {
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Helvetica, sans-serif;
                TEXT-DECORATION: underline
            }
            A
            {
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif;
                TEXT-DECORATION: underline
            }
            A:active
            {
                COLOR: #255aa6
            }
            A:visited
            {
                COLOR: #000000
            }
            A:hover
            {
                COLOR: #255aa6
            }
            A.path
            {
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif;
                TEXT-DECORATION: underline
            }
            A.path:active
            {
                COLOR: #255aa6;
                TEXT-DECORATION: underline
            }
            A.path:visited
            {
                COLOR: #000000;
                TEXT-DECORATION: underline
            }
            A.path:hover
            {
                COLOR: #255aa6;
                TEXT-DECORATION: underline
            }
            A.box
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #ffffff;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif;
                TEXT-DECORATION: none
            }
            A.box:active
            {
                COLOR: #f8d500;
                TEXT-DECORATION: none
            }
            A.box:visited
            {
                COLOR: #ffffff;
                TEXT-DECORATION: none
            }
            A.box:hover
            {
                COLOR: #f8d500;
                TEXT-DECORATION: none
            }
            A.bold
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #000000;
                FONT-FAMILY: Verdana, Arial, Geneva, Nimbus, Helvetica, sans-serif;
                TEXT-DECORATION: none
            }
            A.bold:active
            {
                COLOR: #255aa6;
                TEXT-DECORATION: none
            }
            A.bold:visited
            {
                COLOR: #000000;
                TEXT-DECORATION: none
            }
            A.bold:hover
            {
                COLOR: #255aa6;
                TEXT-DECORATION: none
            }
            A.txt11blue
            {
                FONT-WEIGHT: bold;
                FONT-SIZE: 11px;
                COLOR: #255aa6;
                FONT-FAMILY: Verdana, Arial, Geneva, Helvetica, sans-serif;
                TEXT-DECORATION: none
            }
            A.txt11blue:active
            {
                COLOR: #000000;
                TEXT-DECORATION: none
            }
            A.txt11blue:visited
            {
                COLOR: #255aa6;
                TEXT-DECORATION: none
            }
            A.txt11blue:hover
            {
                COLOR: #000000;
                TEXT-DECORATION: none
            }
            TABLE.blue
            {
                BACKGROUND-COLOR: #336699
            }
            TR.blue
            {
                BACKGROUND-COLOR: #336699
            }
            TD.blue
            {
                BACKGROUND-COLOR: #336699
            }
            TABLE.background
            {
                BACKGROUND-COLOR: #efefef
            }
            TR.background
            {
                BACKGROUND-COLOR: #efefef
            }
            TD.background
            {
                BACKGROUND-COLOR: #efefef
            }
            TABLE.bright
            {
                BACKGROUND-COLOR: #efefef
            }
            TR.bright
            {
                BACKGROUND-COLOR: #efefef
            }
            TD.bright
            {
                BACKGROUND-COLOR: #efefef
            }
            TABLE.dark
            {
                BACKGROUND-COLOR: #d5dbe3
            }
            TR.dark
            {
                BACKGROUND-COLOR: #d5dbe3
            }
            TD.dark
            {
                BACKGROUND-COLOR: #d5dbe3
            }
            TABLE.yellow
            {
                BACKGROUND-COLOR: #f5cf22
            }
            TR.yellow
            {
                BACKGROUND-COLOR: #f5cf22
            }
            TD.yellow
            {
                BACKGROUND-COLOR: #f5cf22
            }
            .input
            {
                FONT-SIZE: 11px;
                FONT-FAMILY: Arial, Geneva , Helvetica, sans-serif
            }
            .inputdark
            {
                BORDER-RIGHT: #ffffff 1px solid;
                BORDER-TOP: #ffffff 1px solid;
                FONT-SIZE: 11px;
                BORDER-LEFT: #ffffff 1px solid;
                COLOR: #000000;
                BORDER-BOTTOM: #ffffff 1px solid;
                FONT-FAMILY: Verdana, Arial, Geneva , Helvetica, sans-serif;
                HEIGHT: 18px;
                BACKGROUND-COLOR: #d5dbe3;
                TEXT-ALIGN: right
            }
            .inputbright
            {
                BORDER-RIGHT: #ffffff 1px solid;
                BORDER-TOP: #ffffff 1px solid;
                FONT-SIZE: 11px;
                BORDER-LEFT: #ffffff 1px solid;
                COLOR: #000000;
                BORDER-BOTTOM: #ffffff 1px solid;
                FONT-FAMILY: Verdana, Arial, Geneva , Helvetica, sans-serif;
                HEIGHT: 18px;
                BACKGROUND-COLOR: #efefef;
                TEXT-ALIGN: right
            }
            .inputbright1
            {
                BORDER-RIGHT: #ffffff 1px;
                BORDER-TOP: #ffffff 1px;
                FONT-SIZE: 11px;
                BORDER-LEFT: #ffffff 1px;
                COLOR: #000000;
                BORDER-BOTTOM: #ffffff 1px;
                FONT-FAMILY: Verdana, Arial, Geneva , Helvetica, sans-serif;
                HEIGHT: 18px;
                BACKGROUND-COLOR: #fef8da;
                TEXT-ALIGN: right
            }
            .formfield
            {
                PADDING-LEFT: 2px;
                FONT-SIZE: 11px;
                FONT-FAMILY: Verdana, Arial, Geneva , Helvetica, sans-serif;
                HEIGHT: 18px;
                BACKGROUND-COLOR: #ffffff
            }
            .clCMAbs
            {
                LEFT: 0px;
                VISIBILITY: hidden;
                POSITION: absolute;
                TOP: 0px
            }
            .clBar
            {
                VISIBILITY: hidden;
                WIDTH: 10px;
                POSITION: absolute;
                HEIGHT: 10px;
                BACKGROUND-COLOR: navy;
                layer-background-color: Navy
            }
            .clLevel0
            {
                PADDING-RIGHT: 2px;
                PADDING-LEFT: 3px;
                FONT-WEIGHT: normal;
                FONT-SIZE: 11px;
                PADDING-BOTTOM: 2px;
                PADDING-TOP: 2px;
                FONT-FAMILY: Verdana, Arial, Nimbus, Helvetica, sans-serif;
                POSITION: absolute;
                COLOR: white;
                BACKGROUND-COLOR: #255aa6;
                layer-background-color: #255AA6    
            }
            .clLevel0over
            {
                PADDING-RIGHT: 2px;
                PADDING-LEFT: 3px;
                FONT-WEIGHT: normal;
                FONT-SIZE: 11px;
                PADDING-BOTTOM: 2px;
                PADDING-TOP: 2px;
                FONT-FAMILY: Verdana, Arial, Nimbus, Helvetica, sans-serif;
                POSITION: absolute;
                CURSOR: hand;
                COLOR: #ffffff;
                BACKGROUND-COLOR: #255aa6;
                layer-background-color: #255AA6
            }
            .clLevel0border
            {
                VISIBILITY: hidden;
                POSITION: absolute;
                BACKGROUND-COLOR: #255aa6;
                layer-background-color: #255AA6
            }
            .clLevel1
            {
                PADDING-RIGHT: 2px;
                PADDING-LEFT: 3px;
                FONT-WEIGHT: normal;
                FONT-SIZE: 11px;
                PADDING-BOTTOM: 2px;
                PADDING-TOP: 2px;
                FONT-FAMILY: Verdana, Arial, Nimbus, Helvetica, sans-serif;
                POSITION: absolute;
                COLOR: #000000;
                BACKGROUND-COLOR: #c2cedf;
                layer-background-color: #C2CEDF
            }
            .clLevel1over
            {
                PADDING-RIGHT: 2px;
                PADDING-LEFT: 3px;
                FONT-WEIGHT: normal;
                FONT-SIZE: 11px;
                PADDING-BOTTOM: 2px;
                PADDING-TOP: 2px;
                FONT-FAMILY: Verdana, Arial, Nimbus, Helvetica, sans-serif;
                POSITION: absolute;
                CURSOR: hand;
                COLOR: #000000;
                BACKGROUND-COLOR: #99aeca;
                layer-background-color: #99AECA
            }
            .clLevel1border
            {
                VISIBILITY: hidden;
                POSITION: absolute;
                BACKGROUND-COLOR: #ffffff;
                layer-background-color: #FFFFFF
            }
            .stroke
            {
                COLOR: black;
                FONT-FAMILY: Arial;
                TEXT-DECORATION: line-through
            }        
        ]]>
        </style>
    </xsl:template>    
</xsl:stylesheet>
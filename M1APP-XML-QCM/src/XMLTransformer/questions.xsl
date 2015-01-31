<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : questions.xsl
    Created on : 31 janvier 2015, 01:11
    Author     : new
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/questions">
        <html>
            <head>
                <title>Questions en XSL</title>
            </head>
            <body link="#6666FF" vlink="#6666FF" text="#FFFFFF" bgcolor="#000000" alink="#6666FF">
                <p align="center">
                    <font size="5" face="Arial, Helvetica, sans-serif">
                        <b>QCM</b>
                    </font>
                </p>
                <hr width="50%" size="6"></hr>
    
                <form method="POST" action="./correct.php">
                    <xsl:apply-templates select="question"/>

                    <p>
                        <input type="submit" name="submit" value="Resultats"/>
                        <input type="reset" value="Effacer"/>
                    </p>
                </form>
                
                
            </body>
        </html>
    </xsl:template>

    <xsl:template match="question">
        
            <p>
                <b>
                    <font size="2" face="Arial, Helvetica, sans-serif">QUESTION N°<xsl:value-of select="@id"/></font>
                </b>
            </p>
            <p>
                <font size="2" face="Arial, Helvetica, sans-serif">
                    <xsl:value-of select="libelle"/>
                </font>
            </p>
            <ol>
                <xsl:apply-templates select="reponse"/>
            </ol>
            
    </xsl:template>
    
    <xsl:template match="reponse">
        
                <li>
                    <xsl:element name="input">
                        <xsl:attribute name="type">checkbox</xsl:attribute>
                        <xsl:attribute name="name">reponses[]</xsl:attribute>
                        <xsl:attribute name="value"> <xsl:value-of select="@id"/></xsl:attribute>
                    </xsl:element>
                    <font size="2" face="Arial, Helvetica, sans-serif"> <xsl:value-of select="."/> </font>
                </li>
            
    </xsl:template>
    
</xsl:stylesheet>

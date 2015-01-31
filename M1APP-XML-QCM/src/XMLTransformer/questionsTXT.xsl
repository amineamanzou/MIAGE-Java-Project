<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : questionsTXT.xsl
    Created on : 31 janvier 2015, 01:11
    Author     : new
    Description:
        Purpose of transformation follows.
-->
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
    
    <xsl:output method="text"/>
    <xsl:variable name="newLine" select="translate('&#xa;','','')"/> 
 
    <!-- Questions transformation -->
    <xsl:template match="questions">
        <xsl:value-of select="$newLine" />
        <xsl:apply-templates select="question" />
    </xsl:template>
 
    <!-- Question transformation  -->
    <xsl:template match="question">
        <!-- Recuperation des informations du fichier XML -->
        <xsl:variable name="identifiant" select="@id" />
        <xsl:variable name="libelle" select="./libelle" />
        <!-- Generation du contenu -->
        <xsl:text>Question N°</xsl:text>
        <xsl:value-of select="$identifiant" />
        <xsl:text> : </xsl:text>
        <xsl:value-of select="$libelle" />
        <xsl:value-of select="$newLine" />
        <xsl:apply-templates select="reponse" />
        <xsl:value-of select="$newLine" />
    </xsl:template>
    
    <!-- Reponse transformation  -->
    <xsl:template match="reponse">
        <!-- Recuperation des informations du fichier XML -->
        <xsl:variable name="id" select="@id" />
        <!-- Generation du contenu -->
        <xsl:value-of select="$id" />
        <xsl:text> ) </xsl:text>
        <xsl:value-of select="."/>
        <xsl:value-of select="$newLine" />
    </xsl:template>
    
</xsl:stylesheet>
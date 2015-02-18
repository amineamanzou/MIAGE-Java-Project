/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carine
 */
@Entity
@Table(name = "COTATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotations.findAll", query = "SELECT c FROM Cotations c"),
    @NamedQuery(name = "Cotations.findBySymbole", query = "SELECT c FROM Cotations c WHERE c.symbole = :symbole"),
    @NamedQuery(name = "Cotations.findByCours", query = "SELECT c FROM Cotations c WHERE c.cours = :cours")})

public class Cotations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SYMBOLE")
    private String symbole;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COURS")
    private BigDecimal cours;

    public Cotations() {
    }

    public Cotations(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public BigDecimal getCours() {
        return cours;
    }

    public void setCours(BigDecimal cours) {
        this.cours = cours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (symbole != null ? symbole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotations)) {
            return false;
        }
        Cotations other = (Cotations) object;
        if ((this.symbole == null && other.symbole != null) || (this.symbole != null && !this.symbole.equals(other.symbole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.model.Cotations[ symbole=" + symbole + " ]";
    }
    
}

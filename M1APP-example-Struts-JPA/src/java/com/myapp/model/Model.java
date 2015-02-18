/*
 * ModeleImp.java
 *
 * Created on 27 mars 2007, 21:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.model;


/**
 *
 * @author carine
 */


public interface Model {

  public Double getCotation(String symbole ) throws ModelException ;
  public void createCotation (String symbole, Double cours ) throws ModelException ;
  public void updateCotation (String symbole, Double cours ) throws ModelException ;
  public void deleteCotation (String symbole) throws ModelException ;
}

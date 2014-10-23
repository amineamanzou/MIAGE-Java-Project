/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import java.util.Locale;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class LanguageSelectAction extends DispatchAction{
 
	public ActionForward english(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
 
		request.getSession().setAttribute(
				Globals.LOCALE_KEY, Locale.ENGLISH);
                
		return mapping.findForward("success");
	}
 
	public ActionForward france(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
 
		request.getSession().setAttribute(
				Globals.LOCALE_KEY, Locale.FRANCE);
 
		return mapping.findForward("success");
	}
 
}
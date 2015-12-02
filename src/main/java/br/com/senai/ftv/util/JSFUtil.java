package br.com.senai.ftv.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class JSFUtil {

	private static final String BUNDLE_NAME = "resources.messageJSF";

	public static String getMessage(String message, Locale locale) {
		ResourceBundle resourceBundle = null;

		if (locale != null)
			resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		else
			resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

		if (resourceBundle != null) {
			message = resourceBundle.getString(message);
		}
		return message;
	}

	public static String getMsgJSF(String messageId) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String msg = "";
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
		try {
			msg = bundle.getString(messageId);
		} catch (Exception e) {
		}
		return msg;
	}

}

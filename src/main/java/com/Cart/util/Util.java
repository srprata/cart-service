package com.Cart.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {
	
	public static String currencyBrasil(Float value) {
	    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	    return nf.format(value);
	}

}

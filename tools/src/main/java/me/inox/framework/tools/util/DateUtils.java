package me.inox.framework.tools.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	public static final String DATE_FORMAT_yyyyMMdd = "yyyyMMdd";
	public static final String DATE_FORMAT_yyMMdd ="yyMMdd";
	public static final String DATE_FORMAT_yyyyMMddHHmm ="yyyyMMddHHmm";
	public static final String DATE_FORMAT_MMddHHmm ="MMddHHmm";
	public static final String DATE_FORMAT_ddHHmm ="ddHHmm";
	public static final String DATE_FORMAT_yyyyMM ="yyyyMM";
	public static final String DATE_FORMAT_HHmmss ="HHmmss";
	public static final String DATE_FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final Pattern pattern = Pattern.compile("[0-9]*");
    private static ThreadLocal yyyyMMddFormat = new ThreadLocal(){
    		protected synchronized Object initialValue() {
    			return new java.text.SimpleDateFormat(DATE_FORMAT_yyyyMMdd);
    		}
    };
    
    private static ThreadLocal yyMMddFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_yyMMdd);
		}
    };
    
    private static ThreadLocal yyyyMMddHHmmFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_yyyyMMddHHmm);
		}
    };
    
    private static ThreadLocal MMddHHmmFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_MMddHHmm);
		}
    };
    
    private static ThreadLocal ddHHmmFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_ddHHmm);
		}
    };
    
    private static ThreadLocal yyyyMMFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_yyyyMM);
		}
    };   
    
    private static ThreadLocal HHmmssFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_HHmmss);
		}
    }; 
    
    private static ThreadLocal yyyyMMddHHmmssFormat = new ThreadLocal(){
		protected synchronized Object initialValue() {
			return new java.text.SimpleDateFormat(DATE_FORMAT_yyyyMMddHHmmss);
		}
    }; 
    
    public static SimpleDateFormat getFormat(String format){   
    	if(DATE_FORMAT_yyyyMMdd.equals(format)){
    		return (SimpleDateFormat)yyyyMMddFormat.get();  
    	}else if (DATE_FORMAT_yyMMdd.equals(format)){
    		return (SimpleDateFormat)yyMMddFormat.get();
    	}else if (DATE_FORMAT_yyyyMMddHHmm.equals(format)){
    		return (SimpleDateFormat)yyyyMMddHHmmFormat.get();
    	}else if (DATE_FORMAT_MMddHHmm.equals(format)){
    		return (SimpleDateFormat)MMddHHmmFormat.get();
    	}else if (DATE_FORMAT_ddHHmm.equals(format)){
    		return (SimpleDateFormat)ddHHmmFormat.get();
    	}else if (DATE_FORMAT_yyyyMM.equals(format)){
    		return (SimpleDateFormat)yyyyMMFormat.get();
    	}else if (DATE_FORMAT_HHmmss.equals(format)){
    		return (SimpleDateFormat) HHmmssFormat.get();
    	}else if (DATE_FORMAT_yyyyMMddHHmmss.equals(format)){
    		return (SimpleDateFormat) yyyyMMddHHmmssFormat.get();
    	}else{
    		return null;
    	}
    }
     public static boolean isAllNum(String date){
    	 if(date == null || "".equals(date)) {
    		 return false;
    	 }
    	 Matcher match = pattern.matcher(date);
    	 return match.matches();
     }
}

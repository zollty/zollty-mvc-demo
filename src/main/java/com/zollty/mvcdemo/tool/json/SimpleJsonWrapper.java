/*
 * @(#)SimpleJsonWrapper.java
 */
package com.zollty.mvcdemo.tool.json;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zollty 
 * @since 2013-12-10
 */
public class SimpleJsonWrapper {

	private Map<String, String> map;
	
	public static SimpleJsonWrapper getInstance(){
		return new SimpleJsonWrapper();
	}
	
	public SimpleJsonWrapper(){
		map = new HashMap<String, String>();
	}
	
	public void addItem(String key, Object value){
		if(key==null){
		    throw new NullPointerException("key is null");
		}
		if(value!=null){
			if( CharSequence.class.isInstance( value ) ){
			    map.put(key, SimpleJsonUtils.escapeValueOrName( value.toString() ));
			}
			else{
			    map.put(key, value.toString());    
			}
		}else{
			map.put(key, "");
		}
	}
	
	@Override
	public String toString(){
		return SimpleJsonUtils.simpleMapToJson(map);
	}
	
}

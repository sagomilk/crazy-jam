package com.sagomilk;

/*
 * BeanNameUtil.java
 *
 * @author: sagomilk
 * 2017年6月26日 下午9:32:58
 */
public class BeanNameUtil {
	public static String generateGetterName(String name, String type) {
		return null;
	}

	// 首字母大写
	public static String upperCaseFirstLetter(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	public static String getSetterName(String value, String type) {
		return "    public void get"+ upperCaseFirstLetter(value) + "(" + type + " " + value + ") {" +  Common.RT + 
				"        this." + value + " = " + value + ";" + Common.RT + 
				"    }"+ Common.RT;
	}

	public static String getGetterName(String value, String type) {
		return "    public "+ type + " set"+ upperCaseFirstLetter(value) + "(" + type + " " + value + ") {" +  Common.RT + 
				"        return this." + value + ";" + Common.RT + 
				"    }"+ Common.RT ;
	}
	
	public static String getField(String columnName , String columnType) {
		String fieldString = "";
		if ("VARCHAR".equals(columnType)) {
			fieldString += "    private String "+ columnName +";" + Common.RT ;
		} else if ("INT".equals(columnType)) {
			fieldString += "    private Integer "+ columnName +";" + Common.RT ;
		} else if ("DATETIME".equals(columnType)) {
//			dateImportString = "import java.util.Date;" + Common.RT ;
			fieldString += "    private Date "+ columnName +";" + Common.RT ;
		}
		
		return fieldString;
	}
	
	public static void main(String[] args) {
		System.out.println(getField("name", "VARCHAR"));
		System.out.println(getSetterName("name", "String"));
		System.out.println(getGetterName("name", "String"));
	}
}

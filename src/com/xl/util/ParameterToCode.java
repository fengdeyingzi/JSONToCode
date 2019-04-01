package com.xl.util;

public class ParameterToCode {
	
	

	//检测是否为中文
		public static boolean checkCh(String text)
		{
			if(text.getBytes().length==text.length())//这句就是来判断 String是否含有中文字符。
			{
			 return false;
			}
			else
			{
				return true;
			}
		}
	
	public static String toCode(String name,String text) {
		StringBuffer buffer= new StringBuffer();
		System.out.println(text);
		String function_name= "addPostParmeter";
		if(text.indexOf("GET")>=0){
			function_name= "addGetParmeter";
		}
		String item_name=name;
		if(item_name.length()==0){
			item_name= "connect";
		}
		char c=0;
		String info=null;
		String items[]= text.split("\n");
		String item=null;
		String temp=null;
		for(int i=1;i<items.length;i++){
			item= items[i];
			System.out.println(item);
			if(item.indexOf("string")>=0){
				temp= items[i-1];
				if(i+2<items.length)
				info= items[i+2];
				else{
					info= "";
				}
				if(!checkCh(temp)){
					buffer.append(""+item_name+"."+function_name+"(\""+temp+"\","+temp+"); //"+info+"\n");
					
				}
			}
			
		}
		
		return buffer.toString();
	}

}

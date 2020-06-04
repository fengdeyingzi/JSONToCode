package com.xl.util;

public class MarkDownToCode {
	
	//转换成微信小程序
	/*
	 * URl:
	 * 请求参数：
	 * ***\*返回参数：\****
	 * ##
	 */
	public static String toCode(String markdown){
		StringBuffer buffer = new StringBuffer();
		int start = 0;
		int line = 1;
		String title = "";
		String url = "";
		String json = "";
		int type = 0;
		for(int i=0;i<markdown.length();i++){
			char c = markdown.charAt(i);
			if(c == '\n'){
				start = i+1;
				line++;
				switch (type) {
				case 0:
					if(searchTextLine(markdown, i, "URl:")){
						url = getLineTitle(markdown,i);
					}
					if(searchTextLine(markdown, i, "##")){
						title = getLineTitle(markdown, i);
					}
					if(searchTextLine(markdown, i, "请求参数：")){
						type=1;
					}
					break;
				case 1:
					
					break;
				default:
					break;
				}
				
				
			}
		}
		
		return buffer.toString();
	}
	
	
	//判断当前行是否存在指定文字
	public static boolean searchTextLine(String text,int index, String searchText){
		String lineText = getLine(text, index);
		return lineText.indexOf(searchText)>=0;
	}
	
	//获取当前行的文字
	public static String getLine(String text,int index){
		int start = index;
		int end = 0;
		for(int i=index;i>=0;i++){
			char c = text.charAt(i);
			if(c=='\n'){
				start = i+1;
				break;
			}
		}
		
		for(int i=index;i<text.length();i++){
			char c = text.charAt(i);
			if(c=='\n' || (text.length()-1==i)){
				end = i;
				break;
			}
		}
		return text.substring(start,end);
	}
	//从当前位置开始读取json代码
	public static String getJSONCode(String text, int index){
		int start = index;
		int end = 0;
		int leve = 0;
		for(int i=index;i>=0;i++){
			char c = text.charAt(i);
			if(c=='\n' || c=='{'){
				start = i+1;
				leve = 1;
				break;
			}
		}
		for(int i=start;i<text.length();i++){
			char c = text.charAt(i);
			if(c=='{'){
				leve++;
			}
			if(c=='}'){
				leve--;
			}
			if(leve==0){
				end = i;
				break;
			}
			if(c=='#'){
				end = 1;break;
			}
		}
		return text.substring(start,end);
	}
	
	//提取当前行的文字 并去除*
	public static String getLineTitle(String text,int index){
		String temp = getLine(text,index);
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<temp.length();i++){
			char c = temp.charAt(i);
			if(c != '*'){
				buffer.append(c);
			}
			
		}
		return buffer.toString();
	}
	

}

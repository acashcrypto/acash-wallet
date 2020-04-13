package com.vaklinov.zcashtest;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Date;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.WriterConfig;
import com.vaklinov.zcashui.Util;

public class Test1 
{

	public static void main(String[] args) 
		throws IOException
	{
	}
	
	
	
	
	private static String hexify(String plain)
		throws IOException
	{
		StringBuilder hexBuf = new StringBuilder();
		int i = 0;
		for (byte c : plain.getBytes("UTF-8"))
		{
			hexBuf.append("(byte)0x");
			String hexChar = Integer.toHexString((int)c);
			if (hexChar.length() < 2)
			{
				hexChar = "0" + hexChar;
			}
			hexBuf.append(hexChar);
			hexBuf.append(",");
			
			if ((i > 0) & (++i % 10 == 0))
			{
				hexBuf.append("\n");
			}
		}
		
		return hexBuf.toString();
	}

}

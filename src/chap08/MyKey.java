/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap08
 *	@File			:		MyKey.java
 *	@Date			:		2014. 2. 15.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap08;

public class MyKey {

	String str;

	public MyKey(String s) {
		str = s;
	}

	public boolean equals(MyKey x) {
		return str.equals(x.str);
	}

	public int hashCode() {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += (int) str.charAt(i);
		}
		return sum;
	}

	public String toString() {
		return str;
	}
}

/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap05
 *	@File			:		CellDouble.java
 *	@Date			:		2014. 2. 15.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap05;

public class CellDouble {

	CellDouble prev;
	CellDouble next;
	Object data;

	public CellDouble(Object aData) {
		data = aData;
	}
}
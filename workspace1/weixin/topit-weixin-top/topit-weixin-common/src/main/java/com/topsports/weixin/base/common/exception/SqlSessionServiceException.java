// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SqlSessionServiceException.java

package com.topsports.weixin.base.common.exception;


// Referenced classes of package com.yougou.logistics.base.common.exception:
//			ServiceException

public class SqlSessionServiceException extends ServiceException
{

	private static final long serialVersionUID = 0x60a001ea357469b2L;

	public SqlSessionServiceException(String message, Exception cause)
	{
		super(message, cause);
	}

	public SqlSessionServiceException(String message)
	{
		super(message);
	}
}

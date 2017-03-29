// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   DaoException.java

package com.topsports.weixin.base.common.exception;


public class DaoException extends Exception
{

	private static final long serialVersionUID = 0x4f21f5ed4d6a561L;
	private int errorCode;

	public DaoException()
	{
	}

	public DaoException(String msg)
	{
		super(msg);
	}

	public DaoException(Throwable cause)
	{
		super(cause);
	}

	public DaoException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public DaoException(int code, String msg)
	{
		super(msg);
		errorCode = code;
	}

	public DaoException(int code, String msg, Throwable cause)
	{
		super((new StringBuilder()).append(code).append(":").append(msg).toString(), cause);
		errorCode = code;
	}

	public int getErrorCode()
	{
		return errorCode;
	}
}

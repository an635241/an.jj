// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ServiceException.java

package com.topsports.weixin.base.common.exception;


public class ServiceException extends Exception
{

	private static final long serialVersionUID = 0x8c4f2e488f44244cL;
	private int errorCode;

	public ServiceException()
	{
	}

	public ServiceException(String msg)
	{
		super(msg);
	}

	public ServiceException(Throwable cause)
	{
		super(cause);
	}

	public ServiceException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public ServiceException(int code, String msg)
	{
		super(msg);
		errorCode = code;
	}

	public ServiceException(int code, String msg, Throwable cause)
	{
		super((new StringBuilder()).append(code).append(":").append(msg).toString(), cause);
		errorCode = code;
	}

	public int getErrorCode()
	{
		return errorCode;
	}
}

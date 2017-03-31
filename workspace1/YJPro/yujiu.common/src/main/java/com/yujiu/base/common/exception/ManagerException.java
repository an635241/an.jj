// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ManagerException.java

package com.yujiu.base.common.exception;


public class ManagerException extends Exception
{

	private static final long serialVersionUID = 0x4f21f5ed4d6a561L;
	private int errorCode;

	public ManagerException()
	{
	}

	public ManagerException(String msg)
	{
		super(msg);
	}

	public ManagerException(Throwable cause)
	{
		super(cause);
	}

	public ManagerException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public ManagerException(int code, String msg)
	{
		super(msg);
		errorCode = code;
	}

	public ManagerException(int code, String msg, Throwable cause)
	{
		super(msg, cause);
		errorCode = code;
	}

	public int getErrorCode()
	{
		return errorCode;
	}
}

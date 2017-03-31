// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RpcException.java

package com.yujiu.base.common.exception;


public class RpcException extends Exception
{

	private static final long serialVersionUID = 0x4f21f5ed4d6a561L;
	private int errorCode;
	private String projectName;

	public RpcException(String projectName, String msg)
	{
		super(msg);
		this.projectName = projectName;
	}

	public RpcException(String projectName, Throwable cause)
	{
		super(cause);
		this.projectName = projectName;
	}

	public RpcException(String projectName, String msg, Throwable cause)
	{
		super(msg, cause);
		this.projectName = projectName;
	}

	public RpcException(String projectName, int errorCode, String msg)
	{
		super(msg);
		this.errorCode = errorCode;
		this.projectName = projectName;
	}

	public RpcException(int errorCode, String msg, String projectName, Throwable cause)
	{
		super(msg, cause);
		this.errorCode = errorCode;
		this.projectName = projectName;
	}

	public int getErrorCode()
	{
		return errorCode;
	}

	public String getProjectName()
	{
		return projectName;
	}
}

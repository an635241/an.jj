// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   FatalSequenceException.java

package com.yujiu.base.common.exception;


public class FatalSequenceException extends Exception
{

	private static final long serialVersionUID = 1L;

	public FatalSequenceException(String message)
	{
		super(message);
	}

	public FatalSequenceException(String message, Throwable cause)
	{
		super(message, cause);
	}
}

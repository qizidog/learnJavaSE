// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Emp.java

package learnDynamicJava;


public class Emp
{

	private int empno;
	private String ename;

	public int getEmpno()
	{
		return empno;
	}

	public void setEmpno(int i)
	{
		empno = i;
	}

	public Emp(int i, String s)
	{
		empno = i;
		ename = s;
	}
	
	public Emp() {
        // TODO Auto-generated constructor stub
    }
	
	public void sayHello(int a) {
	    System.out.println("hello"+a);
    }
}

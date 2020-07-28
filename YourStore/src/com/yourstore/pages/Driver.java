package com.yourstore.pages;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;


public class Driver 
{
	public static void main(String[]args) 
	{
		List<String> list=new ArrayList<String>();
		list.add("testng.xml");
		TestNG run=new TestNG();
		run.setTestSuites(list);
		run.run();
	}
}

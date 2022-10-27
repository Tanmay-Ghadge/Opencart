package com.Opencart.Utility;

import org.apache.logging.log4j.*;


public class Log
{
	//initialise log4j logs
	public static Logger log=LogManager.getLogger(Log.class.getName());

	public static void startTestCase(String testcaseName)
	{
		log.info("--------------------"+testcaseName+" Test start-----------------------");
	}

	public static void endTestCase(String testcaseName)
	{
		log.info("--------------------"+testcaseName+" Test End-----------------------");
	}

	
	//methods to call
	public static void info(String message)
	{
		log.info(message);
	}

	public static void fatal(String message)
	{
		log.fatal(message);	
	}

	public static void warn(String message)
	{
		log.warn(message);
	}

	public static void debug(String message)
	{
		log.debug(message);
	}

	public static void error(String message)
	{
		log.error(message);
	}





}



import org.apache.logging.log4j.LogManager;


public class Log1
{
	public static void main(String[] args) 
	{
		org.apache.logging.log4j.Logger log=LogManager.getLogger("log1");
		System.out.println("this is logger demo");
		
		log.info("for info only");
		log.fatal("for fatal only");
		log.warn("for warn only");
		log.debug("for debug only");
		log.error("for error only");

	}
}

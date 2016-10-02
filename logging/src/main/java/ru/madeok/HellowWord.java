package ru.madeok;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;

public class HellowWord {
	
	@Autowired
	private Environment env;
	
	
	
	public static void main(String[] args) throws IOException{	
		//new HellowWord().loggingWithErr();
		//new HellowWord().loggingWithJUL();
		new HellowWord().loggingWithLog4j();
	}
	
	//System.err.println
	public void loggingWithErr() throws IOException{
		// Определяем файл в который будем писать лог
		System.setErr(new PrintStream(new File("src/main/resources/log.txt").getAbsolutePath()));
		// Выводим сообщения
		System.err.println("time: " + new Date().getSeconds());
		// Выводим сообщение об ошибке
		try {
		     throw new Exception("Сообщение об ошибке");
		} catch (Exception e) {
		     e.printStackTrace();
		}
	}
	
	//Java.util.logging
	public void loggingWithJUL() throws SecurityException, IOException{
		LogManager.getLogManager().readConfiguration(HellowWord.class.getResourceAsStream("logging.properties"));
		Logger log = Logger.getLogger(HellowWord.class.getName());
		log.log(Level.INFO, "messFromJUL");

	}
	
	public void loggingWithLog4j(){
		/*Logger log = LogManager.getLogger("HellowWord");
		String mess = "messFromLog4J";
		log.fatal("messFromLog4J");*/
		
		org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(HellowWord.class);
		logger.info("uraaaaaaaaaaaaaaaaaaa");
	}
}

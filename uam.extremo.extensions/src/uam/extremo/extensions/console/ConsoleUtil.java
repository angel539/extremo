/**
 * <copyright> 
 *
 * Copyright (c) 2004, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $$Id: ConsoleUtil.java,v 1.3 2007/11/14 18:13:57 cdamus Exp $$
 */
package uam.extremo.extensions.console;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;


/**
 * A Util Class: provides convenient API to write to the Eclipse Console View  
 * 
 * The client of println(String name, String msg) methods does not need to do any 
 * housekeeping work to use this method. All pre-work for example registering the console 
 * with the Eclipse console manager if neccessary, creating the message stream, setting 
 * the default color are handled ny the method if neccesary.
 * 
 * However once they are done printing all there messages and have no more requirement
 * for the console and know that the console is not shared by others they can call 
 * unregisterConsole(String name) to dispose of the console
 * 
 * @author Saurabh Bagrodia (bagrodia) 
 */
public class ConsoleUtil {
	
	/** cache for console name to actual console object mapping*/
	private static Map<String, MessageConsole> nameToConsole =
		new HashMap<String, MessageConsole>();
	
	/** cache for 'console name' to 'stream for that console' mapping */
	private static Map<String, MessageConsoleStream> nameToStream =
		new HashMap<String, MessageConsoleStream>();

	/**
	 * Registers the console with the Eclipse Console Manager.
	 * 
	 * @param name - the name for the console
	 * @param image - the image associated with the console
	 * @return the message console 
	 */
	public synchronized static MessageConsole registerConsole(String name){		
		if(nameToConsole.get(name) == null){	
			MessageConsole console = new MessageConsole(name, null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{console});
			nameToConsole.put(name, console);
		}
		
		return nameToConsole.get(name);
	}
	
	
	/**
	 *  Unregisters the console with the Eclipse Console Manager
	 * 
	 * 	@param name - the name name for the console	   
	 */
	public synchronized static void unregisterConsole(String name){		
		if(nameToConsole.containsKey( name)){		
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(
				new IConsole[]{nameToConsole.get(name)});
			nameToConsole.remove( name);
		}		
	}
	
	
	
	/**
	 * returns the default (cached) MessageConsoleStream for the specified console name
	 * 
	 * @param name - the specified console name
	 * @return the default MessageConsoleStream 
	 */
	private synchronized static MessageConsoleStream getDefaultStream(String name){
		if(nameToStream.get(name)== null){
			MessageConsole console = registerConsole(name);			
			MessageConsoleStream defaultStream = console.newMessageStream();
			
			nameToStream.put(name, defaultStream);
			
		}
		
		return nameToStream.get(name);
	}

	/** 
	 * Convinient static method to print an string on the specified console.
	 * The color of the message printed is by black. 
	 *  
	 * The client of this method does not need to do any housekeeping work to use 
	 * this method. All pre-work for example registering the console with the Eclipse 
	 * console manager if neccessary, creating the message stream, setting the color
	 * are handled by the method if neccesary.   
	 * 
	 * @param name - specifies the console
	 * @param msg  - the message
	 */
	public static void println(String name, String msg){
		MessageConsoleStream defaultStream = getDefaultStream(name);		
		defaultStream.println(msg);			
	}

	/**
	 * Shows the Eclipse console view and brings on top the specified console.
	 * 
	 * Also creates and registers the console with the Eclipse console manager 
	 * if necessary.
	 * 
	 * @param name - specifies the console
	 */
	public static void showConsole(String name){
		MessageConsole console = registerConsole(name);
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);
	}	
}

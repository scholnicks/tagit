/* Copyright 2005 Steven Scholnick
   
   This library is free software; you can redistribute it and/or modify
   it under the terms of version 2.1 of the GNU Lesser General Public 
   License as published by the Free Software Foundation.
   
   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   GNU Lesser General Public License for more details.
   
   You should have received a copy of the GNU Lesser General Public
   License along with this library; if not, write to the 
   Free Software Foundation, Inc., 59 Temple Place, Suite 330, 
   Boston, MA 02111-1307  USA
*/
package net.scholnick.tagit.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * MockHttpSession simulates an HTTP session.  All methods dealing with data are available; all others are stubbed out.
 * It can be used in conjunction with <code>MockHttpServletRequest</code>.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class MockHttpSession implements HttpSession
{
	private final Map dataMap;
	private final Map valueMap;
	
	public MockHttpSession()
	{
		dataMap  = new HashMap();
		valueMap = new HashMap();
	}
	
	public void setAttribute(String key, Object value)
	{
		dataMap.put(key,value);
	}

	public void removeAttribute(String key)
	{
		dataMap.remove(key);
	}

	public Object getAttribute(String key)
	{
		return dataMap.get(key);
	}

	public Enumeration getAttributeNames()
	{
		return Collections.enumeration( dataMap.keySet() );
	}

	public String toString()
	{
		return dataMap.toString();
	}
	
	public Object getValue(String key)
	{
		return valueMap.get(key);
	}

	public String[] getValueNames()
	{
		return (String []) new ArrayList( valueMap.keySet() ).toArray(new String[0]);
	}

	public void putValue(String key, Object value)
	{
		valueMap.put( key, value );
	}

	public void removeValue(String key)
	{
		valueMap.remove( key );
	}

	// Stubbed out and not used

	public void invalidate()
	{
	}

	/** Not used */
	public long getCreationTime()
	{
		return 0;
	}

	/** Not used */
	public String getId()
	{
		return null;
	}

	/** Not used */
	public long getLastAccessedTime()
	{
		return 0;
	}

	/** Not used */
	public ServletContext getServletContext()
	{
		return null;
	}

	/** Not used */
	public void setMaxInactiveInterval(int arg0)
	{
	}

	/** Not used */
	public int getMaxInactiveInterval()
	{
		return 0;
	}

	/** @deprecated */
	public javax.servlet.http.HttpSessionContext getSessionContext()
	{
		return null;
	}

	/** Not used */
	public boolean isNew()
	{
		return false;
	}

}

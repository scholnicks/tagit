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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * MockHttpServletRequest is simulation of a HttpServletRequest.  All methods that hold data are available; others are stubbed
 * out.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class MockHttpServletRequest implements HttpServletRequest
{
	private HttpSession 	session;
	private Map			attributeMap;
	private Map			parameterMap;
	
	public HttpSession getSession(boolean b)
	{
		if( session == null )
			session = new MockHttpSession();
		
		return session;
	}

	public HttpSession getSession()
	{
		return getSession(true);
	}

	private Map getAttributeMap()
	{
		if( attributeMap == null )
			attributeMap = new HashMap();
		
		return attributeMap;
	}
	
	public Object getAttribute(String key)
	{
		return getAttributeMap().get(key);
	}

	public Enumeration getAttributeNames()
	{
		return Collections.enumeration( getAttributeMap().keySet() );
	}

	public void setAttribute(String key, Object value)
	{
		getAttributeMap().put(key,value);
	}

	public void removeAttribute(String key)
	{
		getAttributeMap().remove(key);
	}

	public String getParameter(String key)
	{
		return (String) getParameterMap().get(key);
	}

	public void setParameter(String key, String value)
	{
		getParameterMap().put( key, value );
	}

	public Enumeration getParameterNames()
	{
		return Collections.enumeration( getParameterMap().keySet() );
	}

	public Map getParameterMap()
	{
		if( parameterMap == null )
			parameterMap = new HashMap();
		
		return parameterMap;
	}
	
	// Stubbed out and not used
	
	/** Not available */
	public String[] getParameterValues(String arg0)
	{
		return null;
	}

	/** Not available */
	public String getAuthType()
	{
		return null;
	}

	/** Not available */
	public Cookie[] getCookies()
	{
		return null;
	}

	/** Not available */
	public long getDateHeader(String arg0)
	{
		return 0;
	}

	/** Not available */
	public String getHeader(String arg0)
	{
		return null;
	}

	/** Not available */
	public Enumeration getHeaders(String arg0)
	{
		return null;
	}

	/** Not available */
	public Enumeration getHeaderNames()
	{
		return null;
	}

	/** Not available */
	public int getIntHeader(String arg0)
	{
		return 0;
	}

	/** Not available */
	public String getMethod()
	{
		return "POST";
	}

	/** Not available */
	public String getPathInfo()
	{
		return null;
	}

	/** Not available */
	public String getPathTranslated()
	{
		return null;
	}

	/** Not available */
	public String getContextPath()
	{
		return null;
	}

	/** Not available */
	public String getQueryString()
	{
		return null;
	}

	/** Not available */
	public String getRemoteUser()
	{
		return null;
	}

	/** Not available */
	public boolean isUserInRole(String arg0)
	{
		return false;
	}

	/** Not available */
	public Principal getUserPrincipal()
	{
		return null;
	}

	/** Not available */
	public String getRequestedSessionId()
	{
		return null;
	}

	/** Not available */
	public String getRequestURI()
	{
		return null;
	}

	/** Not available */
	public StringBuffer getRequestURL()
	{
		return new StringBuffer("http://127.0.0.1:8080");
	}

	/** Not available */
	public String getServletPath()
	{
		return "/";
	}

	/** Not available */
	public boolean isRequestedSessionIdValid()
	{
		return false;
	}

	/** Not available */
	public boolean isRequestedSessionIdFromCookie()
	{
		return false;
	}

	/** Not available */
	public boolean isRequestedSessionIdFromURL()
	{
		return false;
	}

	/** Not available */
	public boolean isRequestedSessionIdFromUrl()
	{
		return false;
	}

	/** Not available */
	public String getCharacterEncoding()
	{
		return null;
	}

	/** Not available */
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException
	{
	}

	/** Not available */
	public int getContentLength()
	{
		return 0;
	}

	/** Not available */
	public String getContentType()
	{
		return null;
	}

	/** Not available */
	public ServletInputStream getInputStream() throws IOException
	{
		return null;
	}

	/** Not available */
	public String getProtocol()
	{
		return "http";
	}

	/** Not available */
	public String getScheme()
	{
		return null;
	}

	/** Not available */
	public String getServerName()
	{
		return "localhost";
	}

	/** Not available */
	public int getServerPort()
	{
		return 8080;
	}

	/** Not available */
	public BufferedReader getReader() throws IOException
	{
		return null;
	}

	/** Not available */
	public String getRemoteAddr()
	{
		return "127.0.0.1";
	}

	/** Not available */
	public String getRemoteHost()
	{
		return "localhost";
	}

	/** Not available */
	public Locale getLocale()
	{
		return Locale.getDefault();
	}

	/** Not available */
	public Enumeration getLocales()
	{
		return Collections.enumeration( Arrays.asList( Locale.getAvailableLocales() ) );
	}

	/** Not available */
	public boolean isSecure()
	{
		return false;
	}

	/** Not available */
	public RequestDispatcher getRequestDispatcher(String path)
	{
		return null;
	}

	/** Not available */
	public String getRealPath(String arg0)
	{
		return null;
	}
}

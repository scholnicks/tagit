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

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 * MockPageContext simulates the page context for a JSP page.  All methods dealing with data are available; all others are stubbed out.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class MockPageContext extends PageContext
{
	private final Map			attributeMap;
	private JspWriter 			writer;
	private HttpServletRequest 	request;
	
	public MockPageContext()
	{
		attributeMap = new HashMap();
	}
	
	public void release()
	{
		attributeMap.clear();
	}

	public void removeAttribute(String key)
	{
		attributeMap.remove(key);
	}

	public void setAttribute(String key, Object value)
	{
		attributeMap.put(key,value);
	}

	public Object getAttribute(String key)
	{
		return attributeMap.get(key);
	}

	public JspWriter getOut()
	{
		if( writer == null )
			writer = new MockJspWriter();
		
		return writer;
	}

	public HttpSession getSession()
	{
		return ((HttpServletRequest)getRequest()).getSession();
	}

	public ServletRequest getRequest()
	{
		if( request == null )
			request = new MockHttpServletRequest();
		
		return request;
	}

	// Stubbed Out Methods //
	
	/** Not Used */
	public void initialize(Servlet s, ServletRequest req, ServletResponse res, String arg3, boolean arg4, int arg5, boolean arg6) throws IOException, IllegalStateException,IllegalArgumentException
	{
	}

	/** Not Used */
	public Object getPage()
	{
		return null;
	}

	/** Not Used */
	public void setAttribute(String key, Object value, int ignored)
	{
	}

	/** Not Used */
	public Object getAttribute(String key, int ignored)
	{
		return null;
	}

	/** Not Used */
	public Object findAttribute(String arg0)
	{
		return null;
	}

	/** Not Used */
	public void removeAttribute(String arg0, int arg1)
	{
	}

	/** Not Used */
	public int getAttributesScope(String arg0)
	{
		return 0;
	}
	
	/** Not Used */
	public Enumeration getAttributeNamesInScope(int arg0)
	{
		return null;
	}

	/** Not Used */
	public ServletResponse getResponse()
	{
		return null;
	}

	/** Not Used */
	public Exception getException()
	{
		return null;
	}

	/** Not Used */
	public ServletConfig getServletConfig()
	{
		return null;
	}

	/** Not Used */
	public ServletContext getServletContext()
	{
		return null;
	}

	/** Not Used */
	public void forward(String path) throws ServletException, IOException
	{
	}

	/** Not Used */
	public void include(String path) throws ServletException, IOException
	{
	}

	/** Not Used */
	public void handlePageException(Exception arg0) throws ServletException,IOException
	{
	}

	/** Not Used */
	public void handlePageException(Throwable arg0) throws ServletException,IOException
	{
	}
}

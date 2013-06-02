/*
 * Released to public domain.
 */
package net.scholnick.net.test.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * UnOrderedListCollectionTag is a custom tag that generates an unordered list for a collection.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class UnOrderedListCollectionTag extends TagSupport
{
	private String name;
	
	public int doStartTag() throws JspException
	{
		try
		{
			Collection data = (Collection) pageContext.getRequest().getAttribute( getName() );
			
			if( data == null )
				data = (Collection) ((HttpServletRequest) pageContext.getRequest()).getSession().getAttribute( getName() );
			
			StringBuffer buf = new StringBuffer(512);
			
			buf.append("<ul>");
			for( Iterator iter = data.iterator(); iter.hasNext(); )
			{
				buf.append( "<li>" ).append( iter.next() ).append( "</li>" );
			}
			buf.append("</ul>");
			
		
			pageContext.getOut().print( buf );
		}
		catch( IOException e )
		{
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}	
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private static final long serialVersionUID = 1L;
}

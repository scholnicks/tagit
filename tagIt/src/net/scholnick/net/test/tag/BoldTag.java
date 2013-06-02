/*
 * Released to public domain.
 */
package net.scholnick.net.test.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * BoldTagTestCase is a custom tag that will bold the data.  
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class BoldTag extends TagSupport
{
	private String name;
	
	public int doStartTag() throws JspException
	{
		try
		{
			Object data = pageContext.getRequest().getAttribute( getName() );
			
			if( data == null )
				data = ((HttpServletRequest) pageContext.getRequest()).getSession().getAttribute( getName() );
			
			pageContext.getOut().print( "<b>" + data + "</b>" );
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

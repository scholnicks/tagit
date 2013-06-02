/*
 * Released to public domain.
 */
package net.scholnick.unittests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import junit.framework.TestCase;
import net.scholnick.net.test.tag.BoldTag;
import net.scholnick.tagit.mock.MockPageContext;

/**
 * BoldTagTestCase demonstrates the usage of the tagit library
 * to run out of the container unit tests against custom tag classes.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public class BoldTagTestCase extends TestCase
{
	public void testTag() throws JspException
	{
		PageContext context = new MockPageContext();
		context.getRequest().setAttribute( "data", "tagit" );

		BoldTag tag = new BoldTag();
		tag.setName( "data" );
		tag.setPageContext( context );
		tag.doStartTag();
		
		assertEquals( "<b>tagit</b>", context.getOut().toString() );
	}

	public void testDataFromSession() throws JspException
	{
		PageContext context = new MockPageContext();
		HttpSession session = ((HttpServletRequest) context.getRequest()).getSession();
		
		session.setAttribute( "data", "tagit" );

		BoldTag tag = new BoldTag();
		tag.setName( "data" );
		tag.setPageContext( context );
		tag.doStartTag();
		
		assertEquals( "<b>tagit</b>", context.getOut().toString() );
	}
}

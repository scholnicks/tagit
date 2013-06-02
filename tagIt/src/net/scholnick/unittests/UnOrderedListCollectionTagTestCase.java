/*
 * Released to public domain.
 */
package net.scholnick.unittests;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import junit.framework.TestCase;
import net.scholnick.net.test.tag.UnOrderedListCollectionTag;
import net.scholnick.tagit.mock.MockPageContext;

/**
 * UnOrderedListCollectionTagTestCase demonstrates the usage of the tagit library
 * to run out of the container unit tests against custom tag classes.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public class UnOrderedListCollectionTagTestCase extends TestCase
{
	public void testTag() throws JspException
	{
		// Create the mock page context
		PageContext context = new MockPageContext();
		List data = Arrays.asList( new String[] { "one", "two" });
		
		// Save the data in the request
		context.getRequest().setAttribute( "data", data );

		// create the tag
		UnOrderedListCollectionTag tag = new UnOrderedListCollectionTag();
		
		// call the set methods that would be called automatically
		tag.setName( "data" );
		tag.setPageContext( context );
		
		// run the tag by calling doStartTag
		tag.doStartTag();
		
		// now check the page context's Out writer against the expected HTML data
		assertEquals( "<ul><li>one</li><li>two</li></ul>", context.getOut().toString() );
	}

	public void testDataFromSession() throws JspException
	{
		// Create the mock page context
		PageContext context = new MockPageContext();
		HttpSession session = ((HttpServletRequest) context.getRequest()).getSession();
		
		// Save the data in the session
		List data = Arrays.asList( new String[] { "one", "two" });
		session.setAttribute( "data", data );

		// create the tag
		UnOrderedListCollectionTag tag = new UnOrderedListCollectionTag();

		// call the set methods that would be called automatically
		tag.setName( "data" );
		tag.setPageContext( context );
		
		// run the tag by calling doStartTag
		tag.doStartTag();
		
		// now check the page context's Out writer against the expected HTML data
		assertEquals( "<ul><li>one</li><li>two</li></ul>", context.getOut().toString() );
	}
}

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
import java.io.StringWriter;

import javax.servlet.jsp.JspWriter;

/**
 * MockJspWriter simulates a JspWriter; all methods are available. The data is written to a String,
 * that can be accessed by the standard <code>toString()</code> method.  All methods are thread-safe.
 * 
 * @author Steven Scholnick <steve@scholnick.net>
 */
public final class MockJspWriter extends JspWriter
{
	private final StringWriter worker;
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	/** Returns all data written to this writer */
	public String toString()
	{
		synchronized( worker )
		{
			return worker.toString();
		}
	}
	
	public MockJspWriter()
	{
		this(0,false);
	}
	
	protected MockJspWriter(int i, boolean b)
	{
		super(i, b);
		worker = new StringWriter();
	}

	public void newLine() throws IOException
	{
		worker.write(NEW_LINE);
	}

	public void print(boolean b) throws IOException
	{
		worker.write( String.valueOf(b) );
	}

	public void print(char c) throws IOException
	{
		worker.write( String.valueOf(c) );
	}

	public void print(int i) throws IOException
	{
		worker.write( i );
	}

	public void print(long l) throws IOException
	{
		worker.write( String.valueOf(l) );
	}

	public void print(float f) throws IOException
	{
		worker.write( String.valueOf(f) );
	}

	public void print(double d) throws IOException
	{
		worker.write( String.valueOf(d) );
	}

	public void print(char[] c) throws IOException
	{
		worker.write( String.valueOf(c) );
	}

	public void print(String s) throws IOException
	{
		worker.write( s );
	}

	public void print(Object o) throws IOException
	{
		worker.write( o.toString() );
	}

	public void println() throws IOException
	{
		worker.write( NEW_LINE );
	}

	public void println(boolean b) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(b) );
			worker.write( NEW_LINE );
		}
	}

	public void println(char c) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(c) );
			worker.write( NEW_LINE );
		}
	}

	public void println(int i) throws IOException
	{
		synchronized( worker )
		{
			worker.write( i );
			worker.write( NEW_LINE );
		}
	}

	public void println(long l) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(l) );
			worker.write( NEW_LINE );
		}
	}

	public void println(float f) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(f) );
			worker.write( NEW_LINE );
		}
	}

	public void println(double d) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(d) );
			worker.write( NEW_LINE );
		}
	}

	public void println(char[] c) throws IOException
	{
		synchronized( worker )
		{
			worker.write( String.valueOf(c) );
			worker.write( NEW_LINE );
		}
	}

	public void println(String s) throws IOException
	{
		synchronized( worker )
		{
			worker.write( s );
			worker.write( NEW_LINE );
		}
	}

	public void println(Object o) throws IOException
	{
		synchronized( worker )
		{
			worker.write( o.toString() );
			worker.write( NEW_LINE );
		}
	}

	public void clear() throws IOException
	{
		worker.getBuffer().setLength(0);
	}

	public void clearBuffer() throws IOException
	{
		worker.getBuffer().setLength(0);
	}

	public void flush() throws IOException
	{
		worker.flush();
	}

	public void close() throws IOException
	{
		worker.close();
	}

	public int getRemaining()
	{
		return 0;
	}

	public void write(char[] c, int start, int end) throws IOException
	{
		worker.write( c, start, end );
	}
}

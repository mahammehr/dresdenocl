/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package org.dresdenocl.essentialocl.standardlibrary;

/**
 * 
 * 
 * @author Matthias Braeuer
 * @version 1.0 30.03.2007
 */
public interface OclSequence<T extends OclAny> extends OclSortedCollection<T> {

	/**
	 * 
	 * @param lower
	 * @param upper
	 * @return the sub-set of <code>this</code> starting at number
	 *         <code>lower</code>, up to and including element number
	 *         <code>upper</code>.
	 */
	OclSequence<T> subSequence(OclInteger lower, OclInteger upper);

	/**
	 * 
	 * @param o
	 * 
	 * @return The sequence of elements, consisting of all elements of
	 *         <code>this</code>, followed by <code>o</code>.
	 */
	OclSequence<T> append(T o);

	/**
	 * 
	 * @param o
	 * 
	 * @return The sequence consisting of <code>o</code>, followed by all
	 *         elements in <code>this</code>.
	 */
	OclSequence<T> prepend(T o);

	/**
	 * 
	 * @param index
	 * @param o
	 * 
	 * @return The sequence consisting of <code>this</code> with
	 *         <code>o</code> inserted at position <code>index</code>.
	 */
	OclSequence<T> insertAt(OclInteger index, T o);

	/**
	 * 
	 * @param o
	 * 
	 * @return The sequence containing all elements of <code>this</code> plus
	 *         <code>o</code> added as the last element.
	 */
	OclSequence<T> including(T o);

	/**
	 * 
	 * @param o
	 * 
	 * @return The sequence containing all elements of <code>this</code> apart
	 *         from all occurrences of <code>o</code>. The order of the
	 *         remaining elements is not changed.
	 */
	OclSequence<T> excluding(T o);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dresdenocl.essentialocl.standardlibrary.OclCollection#flatten()
	 */
	<T2 extends OclAny> OclSequence<T2> flatten();
	
	/**
	 * 
	 * @param s
	 * 
	 * @return the union of <code>this</code> and <code>s</code>.
	 */
	OclSequence<T> union(OclSequence<T> s);
}

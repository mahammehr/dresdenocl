/*
Copyright (C) 2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Model Bus Plug-in of Dresden OCL2 for Eclipse.

Dresden OCL2 for Eclipse is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL2 for Eclipse is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL2 for Eclipse. If not, see <http://www.gnu.org/licenses/>.
 */
package org.dresdenocl.modelinstancetype.exception;

import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.pivotmodel.Type;

/**
 * <p>
 * A {@link AsTypeCastException} is thrown, if the operation
 * {@link IModelInstanceElement#asType(org.dresdenocl.pivotmodel.Type)}
 * is invoked with a {@link Type} to that the {@link IModelInstanceElement}
 * cannot be casted.
 * </p>
 * 
 * @author Claas Wilke
 */
public class AsTypeCastException extends Exception {

	/**
	 * <p>
	 * The id required for serialization.
	 * </p>
	 */
	private static final long serialVersionUID = 3880555924270702528L;

	/**
	 * <p>
	 * Creates a new {@link AsTypeCastException}.
	 * </p>
	 * 
	 * @param msg
	 *          The message of the created {@link Exception}.
	 */
	public AsTypeCastException(String msg) {

		super(msg);
	}

	/**
	 * <p>
	 * Creates a new {@link AsTypeCastException}.
	 * </p>
	 * 
	 * @param msg
	 *          The message of the created {@link Exception}.
	 * @param e
	 *          A given {@link Exception} that is the cause of this
	 *          {@link Exception}.
	 */
	public AsTypeCastException(String msg, Exception e) {

		super(msg, e);
	}
}
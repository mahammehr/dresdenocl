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
package org.dresdenocl.modelinstancetype.types.base;

import org.apache.log4j.Logger;
import org.eclipse.osgi.util.NLS;

import org.dresdenocl.essentialocl.EssentialOclPlugin;
import org.dresdenocl.modelinstancetype.ModelInstanceTypePlugin;
import org.dresdenocl.modelinstancetype.exception.AsTypeCastException;
import org.dresdenocl.modelinstancetype.internal.ModelInstanceMessages;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.modelinstancetype.types.IModelInstanceInteger;
import org.dresdenocl.pivotmodel.PrimitiveType;
import org.dresdenocl.pivotmodel.PrimitiveTypeKind;
import org.dresdenocl.pivotmodel.Type;

/**
 * <p>
 * Represents an adaptation for {@link Integer}s of a {@link JavaModelInstance}.
 * </p>
 * 
 * <p>
 * This type is located in the ModelBus plug-in because the standard library and
 * the Java model instance type plug-in both require such an implementation but
 * are not allowed to know each other.
 * </p>
 * 
 * @author Claas Wilke
 */
public class JavaModelInstanceInteger extends AbstractModelInstanceInteger
		implements IModelInstanceInteger {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER =
			ModelInstanceTypePlugin.getLogger(JavaModelInstanceInteger.class);

	/** The adapted {@link Long} of this {@link JavaModelInstanceInteger}. */
	private Long myLong;

	/**
	 * <p>
	 * Creates a new {@link JavaModelInstanceInteger}.
	 * </p>
	 * 
	 * @param aLong
	 *          The {@link Long} that shall be adapted by this
	 *          {@link JavaModelInstanceInteger}.
	 */
	protected JavaModelInstanceInteger(Long aLong) {

		/* Eventually debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceInteger("; //$NON-NLS-1$
			msg += "aLong = " + aLong; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.myLong = aLong;

		/* Initialize the type. */
		this.myType =
				EssentialOclPlugin.getOclLibraryProvider().getOclLibrary()
						.getOclInteger();

		/* Eventually debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "JavaModelInstanceInteger(Long) - exit"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceElement
	 * #asType(org.dresdenocl.pivotmodel.Type)
	 */
	public IModelInstanceElement asType(Type type) throws AsTypeCastException {

		if (type == null) {
			throw new IllegalArgumentException("Parameter 'type' must not be null.");
		}
		// no else.

		IModelInstanceElement result;

		/* By default the result is null. */
		result = null;

		/* Integers can only be casted to primitive types. */
		if (type instanceof PrimitiveType) {
			PrimitiveType primitiveType;
			primitiveType = (PrimitiveType) type;

			/* Check the given PrimitiveTypeKind. */
			if (primitiveType.getKind().equals(PrimitiveTypeKind.INTEGER)) {

				/* Create a new integer to avoid side effects. */
				result = new JavaModelInstanceInteger(this.myLong);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.REAL)) {

				/* Each integer is also a real. */
				result = new JavaModelInstanceReal(this.myLong);
			}

			else if (primitiveType.getKind().equals(PrimitiveTypeKind.STRING)) {

				if (this.myLong == null) {
					result = new JavaModelInstanceString(null);
				}

				else {
					result = new JavaModelInstanceString(this.myLong.toString());
				}
			}
			// no else.
		}
		// no else.

		/* Probably throw an AsTypeCastException. */
		if (result == null) {
			String msg;

			msg = ModelInstanceMessages.IModelInstanceElement_CannotCast;
			msg = NLS.bind(msg, this.getName(), type.getName());

			throw new AsTypeCastException(msg);
		}
		// no else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceElement
	 * #deepCopy()
	 */
	public IModelInstanceElement copyForAtPre() {

		return new JavaModelInstanceInteger(this.myLong);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.dresdenocl.modelbus.modelinstance.IModelInstanceInteger#getInteger
	 * ()
	 */
	public Long getLong() {

		return this.myLong;
	}

	/*
	 * (non-Javadoc)
	 * @see org.dresdenocl.modelinstancetype.types.IModelInstanceReal#getDouble()
	 */
	public Double getDouble() {

		return this.myLong.doubleValue();

	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {	
		return this.getLong().toString();
	}
}
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IOclElementMapping<ReferenceType> extends org.dresdenocl.language.ocl.resource.ocl.IOclReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.analysis;

import java.util.List;

import org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolveHelper;
import org.dresdenocl.language.ocl.resource.ocl.OclReferenceResolveHelperProvider;
import org.dresdenocl.pivotmodel.Namespace;

public class TypePathNameNestedCSNamespaceReferenceResolver
		implements
		org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.TypePathNameNestedCS, org.dresdenocl.pivotmodel.Namespace> {

	private org.dresdenocl.language.ocl.resource.ocl.analysis.OclDefaultResolverDelegate<org.dresdenocl.language.ocl.TypePathNameNestedCS, org.dresdenocl.pivotmodel.Namespace> delegate = new org.dresdenocl.language.ocl.resource.ocl.analysis.OclDefaultResolverDelegate<org.dresdenocl.language.ocl.TypePathNameNestedCS, org.dresdenocl.pivotmodel.Namespace>();

	public void resolve(
			java.lang.String identifier,
			org.dresdenocl.language.ocl.TypePathNameNestedCS container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolveResult<org.dresdenocl.pivotmodel.Namespace> result) {

		IOclReferenceResolveHelper rrHelper = OclReferenceResolveHelperProvider
				.getOclReferenceResolveHelper();
		if (rrHelper != null) {
			List<Namespace> namespaces = rrHelper.resolveNamespace(identifier,
					resolveFuzzy, container);
			for (Namespace namespace : namespaces) {
				if (!resolveFuzzy)
					result.addMapping(identifier, namespace);
				else
					result.addMapping(namespace.getName(), namespace);
			}
		}
	}

	public java.lang.String deResolve(
			org.dresdenocl.pivotmodel.Namespace element,
			org.dresdenocl.language.ocl.TypePathNameNestedCS container,
			org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does not
		// depend on any option
	}

}

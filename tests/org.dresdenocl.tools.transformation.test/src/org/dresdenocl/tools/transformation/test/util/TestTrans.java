package org.dresdenocl.tools.transformation.test.util;

import org.eclipse.emf.ecore.EObject;

import org.dresdenocl.tools.codegen.IOcl2CodeSettings;
import org.dresdenocl.tools.transformation.ITransformation;
import org.dresdenocl.tools.transformation.M2XTransformation;
import org.dresdenocl.tools.transformation.exception.InvalidModelException;
import org.dresdenocl.tools.transformation.exception.TransformationException;

public class TestTrans extends
		M2XTransformation<EObject, IOcl2CodeSettings, String> implements
		ITransformation<EObject, IOcl2CodeSettings, String> {

	public TestTrans(String modelIn, String modelOut) {

		super(modelIn, modelOut);
	}

	public void invoke() throws TransformationException, InvalidModelException {

		// Do nothing.

	}

}

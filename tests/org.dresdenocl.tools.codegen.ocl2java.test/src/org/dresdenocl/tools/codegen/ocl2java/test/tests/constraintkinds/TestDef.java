/*
Copyright (C) 2008-2010 by Claas Wilke (claaswilke@gmx.net)

This file is part of the OCL 2 Java Code Generator of Dresden OCL2 for Eclipse.

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

package org.dresdenocl.tools.codegen.ocl2java.test.tests.constraintkinds;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.pivotmodel.Constraint;
import org.dresdenocl.pivotmodel.ConstraintKind;
import org.dresdenocl.tools.codegen.ocl2java.test.tests.AbstractDiffTest;

/**
 * <p>
 * Contains some test cases to test the code generation {@link Constraint}s of
 * the {@link ConstraintKind#DEFINITION}.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestDef extends AbstractDiffTest {

	/**
	 * <p>
	 * Initializes the test cases.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {

		AbstractDiffTest.setUp();
	}

	/**
	 * <p>
	 * Tears down the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	@AfterClass
	public static void tearDown() throws IllegalArgumentException,
			ModelAccessException {

		AbstractDiffTest.tearDown();
	}

	/**
	 * <p>
	 * Tests the instrumentation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDef01() throws Exception {

		this.compareInstrumentationCodeGeneration("constraintkindtest/def", "def01");
	}

	/**
	 * <p>
	 * Tests the instrumentation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDef02() throws Exception {

		this.compareInstrumentationCodeGeneration("constraintkindtest/def", "def02");
	}

	/**
	 * <p>
	 * Tests the instrumentation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDef03() throws Exception {

		this.compareInstrumentationCodeGeneration("constraintkindtest/def", "def03");
	}

	/**
	 * <p>
	 * Tests the instrumentation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStaticDef01() throws Exception {

		this.compareInstrumentationCodeGeneration("constraintkindtest/def", "staticDef01");
	}

	/**
	 * <p>
	 * Tests the instrumentation of the constraint.
	 * </p>
	 * 
	 * @throws Exception
	 */
	@Test
	public void testStaticDef02() throws Exception {

		this.compareInstrumentationCodeGeneration("constraintkindtest/def", "staticDef02");
	}
}
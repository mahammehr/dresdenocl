/*
Copyright (C) 2011 by Claas Wilke (claas.wilke@tu-dresden.de)

This file is part of the PAIN Case Study of Dresden OCL.

Dresden OCL is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL. If not, see <http://www.gnu.org/licenses/>.
 */
package tudresden.ocl20.pivot.interpreter.test.constraintkinds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tudresden.ocl20.pivot.interpreter.IInterpretationResult;
import tudresden.ocl20.pivot.interpreter.test.standardlibrary.AbstractInterpreterTest;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.parser.ParseException;

/**
 * <p>
 * Contains some test cases to test derive constraints.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestDerive extends AbstractInterpreterTest {

	/** The name of the constraint directory for this test suite. */
	private static final String CONSTRAINT_DIRECTORY = "constraintkind/derive";

	/**
	 * <p>
	 * Deriveializes the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	@BeforeClass
	public static void setUp() throws IllegalArgumentException,
			ModelAccessException {

		AbstractInterpreterTest.setUp();
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

		AbstractInterpreterTest.tearDown();
	}

	/**
	 * A non-static derive should be interpreted for every model element.
	 */
	@Test
	public void testDerive01() throws IllegalArgumentException,
			ModelAccessException, ParseException {

		List<IInterpretationResult> results;
		results = super.interpretConstraintsForInstance(MODEL2_NAME,
				CONSTRAINT_DIRECTORY + "/derive01", INSTANCE4_NAME,
				Arrays.asList(new String[] { "Class2" }));

		assertNotNull(results);
		assertEquals(2, results.size());

		this.assertIsEqual(new Integer(42), results.get(0));
		this.assertIsEqual(new Integer(42), results.get(0));
	}

	/**
	 * A static derive should be interpreted exactly once.
	 */
	@Test
	public void testDerive02_01() throws IllegalArgumentException,
			ModelAccessException, ParseException {

		List<IInterpretationResult> results;
		results = super.interpretConstraintsForInstance(MODEL2_NAME,
				CONSTRAINT_DIRECTORY + "/derive02", INSTANCE4_NAME,
				Arrays.asList(new String[] { "Class2" }));

		assertNotNull(results);
		assertEquals(1, results.size());

		this.assertIsEqual(new Integer(42), results.get(0));
	}

	/**
	 * A static body should be interpreted exactly once (even if not
	 * ModelInstanceElement for this type exists).
	 */
	@Test
	public void testDerive02_02() throws IllegalArgumentException,
			ModelAccessException, ParseException {

		List<IInterpretationResult> results;
		results = super.interpretConstraintsForInstance(MODEL2_NAME,
				CONSTRAINT_DIRECTORY + "/derive02", INSTANCE5_NAME,
				Arrays.asList(new String[] { "Class2" }));

		assertNotNull(results);
		assertEquals(1, results.size());

		this.assertIsEqual(new Integer(42), results.get(0));
	}
}
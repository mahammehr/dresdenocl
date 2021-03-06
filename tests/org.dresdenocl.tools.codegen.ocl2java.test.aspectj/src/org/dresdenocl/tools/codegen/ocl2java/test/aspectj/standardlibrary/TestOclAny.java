/*
Copyright (C) 2010 by Claas Wilke (claaswilke@gmx.net)

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

package org.dresdenocl.tools.codegen.ocl2java.test.aspectj.standardlibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import testpackage.Class1;
import testpackage.Class2;

/**
 * <p>
 * Tests generated code for boolean operations of the OCL Standard Library.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestOclAny {

	/**
	 * <p>
	 * Tests the generated code for the method
	 * <code>OclAny.allInstances()</code> .
	 * </p>
	 */
	@Test
	public void testAllInstances01() {

		Class1 class1;
		class1 = new Class1();

		assertNotNull(class1.testOclAnyAllInstances());
		assertTrue(class1.testOclAnyAllInstances().size() > 0);
		assertTrue(class1.testOclAnyAllInstances().contains(class1));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation <code>@pre</code>
	 * .
	 * </p>
	 */
	@Test
	public void testAtPre01() {

		Class1 class1;
		class1 = new Class1();

		class1.postOperation02();
	}

	/**
	 * <p>
	 * Tests the generated code for the method <code>OclAny.=(OclAny)</code> .
	 * </p>
	 */
	@Test
	public void testEquals01() {

		Class1 class1;
		class1 = new Class1();

		Class1 class2;
		class2 = new Class1();

		assertTrue(class1.testOclAnyEquals01(class1, class1));
		assertFalse(class1.testOclAnyEquals01(class1, class2));
	}

	/**
	 * <p>
	 * Tests the generated code for the method <code>OclAny.<>(OclAny)</code> .
	 * </p>
	 */
	@Test
	public void testNotEquals01() {

		Class1 class1;
		class1 = new Class1();

		Class1 class2;
		class2 = new Class1();

		assertFalse(class1.testOclAnyNotEquals01(class1, class1));
		assertTrue(class1.testOclAnyNotEquals01(class1, class2));
	}

	/**
	 * <p>
	 * Tests the generated code for the method
	 * <code>OclAny.oclAsType(Type)</code> .
	 * </p>
	 */
	@Test
	public void testOclAsType01() {

		Class1 class1;
		class1 = new Class1();

		class1.testOclAsType01(class1);
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsKindOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsKindOf01_1() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertTrue(class1.testOclIsKindOf01(class1, Class1.class));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsKindOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsKindOf01_2() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertFalse(class1.testOclIsKindOf01(class1, Class2.class));

	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsKindOf01_3() {
	
		Class2 class2;
		class2 = new Class2();
	
		assertTrue(class2.testOclIsKindOf01(class2, Class1.class));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsKindOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsKindOf01_4() {
	
		Class2 class2;
		class2 = new Class2();
	
		assertTrue(class2.testOclIsKindOf01(class2, Class2.class));

	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsTypeOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsTypeOf01_1() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertTrue(class1.testOclIsTypeOf01(class1, Class1.class));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsTypeOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsTypeOf01_2() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertFalse(class1.testOclIsTypeOf01(class1, Class2.class));

	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsTypeOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsTypeOf01_3() {
	
		Class2 class2;
		class2 = new Class2();
	
		assertFalse(class2.testOclIsTypeOf01(class2, Class1.class));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsTypeOf(OclType)</code> .
	 * </p>
	 */
	@Test
	public void testOclIsTypeOf01_4() {
	
		Class2 class2;
		class2 = new Class2();
	
		assertTrue(class2.testOclIsTypeOf01(class2, Class2.class));
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsNew()</code> .
	 * </p>
	 */
	@Test
	public void testOclIsNew01() {

		Class1 class1;
		class1 = new Class1();

		class1.postOperation03();
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsInvalid()</code> .
	 * </p>
	 */
	@Test
	public void testOclIsInvalid01() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertFalse(class1.testOclIsInvalid01());
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsInvalid()</code> .
	 * </p>
	 */
	@Test
	public void testOclIsInvalid02() {
	
		Class1 class1;
		class1 = new Class1();
	
		assertTrue(class1.testOclIsInvalid02());
	}

	/**
	 * <p>
	 * Tests the generated code for the special OCL operation
	 * <code>OclAny.oclIsUndefined()</code> .
	 * </p>
	 */
	@Test
	public void testOclIsUndefined01() {

		Class1 class1;
		class1 = new Class1();

		assertFalse(class1.testOclIsUndefined01(class1));
		assertTrue(class1.testOclIsUndefined01(null));
	}

	/**
	 * <p>
	 * Tests the generated code for the method <code>OclAny.oclType()</code> .
	 * </p>
	 */
	@Test
	public void testOclType01() {

		Class1 class1;
		class1 = new Class1();

		assertNotNull(class1.testOclAnyOclType(class1));
		assertEquals(class1.getClass(), class1.testOclAnyOclType(class1));
	}
}
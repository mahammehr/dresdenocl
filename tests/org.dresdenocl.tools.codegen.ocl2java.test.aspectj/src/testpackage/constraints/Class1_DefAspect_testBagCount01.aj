package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testBagCount01 {

    /**
     * <p>Defines the method testBagCount01(java.util.List<Object> source, Object arg01) defined by the constraint
     * <code>context Class1
     *       def: testBagCount01(source: Bag(OclAny), arg01: OclAny): Integer = source ->count(arg01)</code></p>
     */
    public Integer testpackage.Class1.testBagCount01(java.util.List<Object> source, Object arg01) {
        return org.dresdenocl.tools.codegen.ocl2java.types.util.OclBags.count(source, arg01);
    }
}
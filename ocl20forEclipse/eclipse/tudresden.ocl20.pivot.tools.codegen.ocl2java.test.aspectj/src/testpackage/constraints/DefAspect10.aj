package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect10 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testCollectNestedIteratorExp01()}.</p>
     */
    protected pointcut testCollectNestedIteratorExp01Caller(testpackage.Class1 aClass):
    	call(* testpackage.Class1.testCollectNestedIteratorExp01())
    	&& target(aClass);
    
    /**
     * <p>Defines the method testCollectNestedIteratorExp01() defined by the constraint
     * <code>context Class1
     *       def: testCollectNestedIteratorExp01() : Bag(Boolean) =
    Set{1, 2, 3}->collectNested(i: Integer | i <> 2)</code></p>
     */
    java.util.List<Boolean> around(testpackage.Class1 aClass): testCollectNestedIteratorExp01Caller(aClass) {
        java.util.HashSet<Integer> collection1;
        collection1 = new java.util.HashSet<Integer>();
        
        collection1.add(new Integer(1));
        collection1.add(new Integer(2));
        collection1.add(new Integer(3));
        java.util.ArrayList<Boolean> result1;
        result1 = new java.util.ArrayList<Boolean>();
        
        /* Iterator CollectNested: Iterate through all elements and collect them. */
        for (Integer i : collection1) {
            result1.add(!((Object) i).equals(new Integer(2)));
        }
    
        return result1;
    }
}
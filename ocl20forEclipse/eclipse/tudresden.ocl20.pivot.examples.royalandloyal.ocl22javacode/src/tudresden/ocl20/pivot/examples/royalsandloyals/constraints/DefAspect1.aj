package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect1 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedLoyaltyAccount;
    
    /**
     * <p>Pointcut for all requests on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount#turnover}.</p>
     */
    protected pointcut turnoverGetter(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass) :
    	get(* turnover) && this(aClass);
    
    /**
     * <p>Initializes the attribute turnover defined by the constraint
     * <code>context LoyaltyAccount
     *       def: turnover = transactions[].amount[].sum()</code></p>
     */
    before(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass): turnoverGetter(aClass) {
        tudresden.ocl20.pivot.ocl2java.types.OclBag<Float> result1;
        result1 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<Float>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement1 : aClass.transactions) {
            result1.add(anElement1.amount);
        }

        Float result2;
        result2 = new Float(0);
        
        /* Compute the result of a sum operation. */
        for (Float anElement2 : result1) {
            result2 += anElement2;
        }
    
        aClass.turnover = result2;
    }
}
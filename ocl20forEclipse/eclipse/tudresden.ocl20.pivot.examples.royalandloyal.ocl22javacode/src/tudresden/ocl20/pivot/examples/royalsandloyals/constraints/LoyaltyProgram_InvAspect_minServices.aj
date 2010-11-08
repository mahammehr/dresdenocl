package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect LoyaltyProgram_InvAspect_minServices {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class LoyaltyProgram defined by the constraint
     * <code>context LoyaltyProgram
     *       inv minServices: partners->forAll(deliveredServices->size() >= 1)</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
        Boolean result1;
        result1 = true;
        
        /* Iterator ForAll: Iterate and check, if all elements fulfill the condition. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner $implicitVariable0$ : aClass.partners) {
            if (!(tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.size($implicitVariable0$.deliveredServices) >= new Integer(1))) {
                result1 = false;
                break;
            }
            // no else
        }
    
        if (!result1) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
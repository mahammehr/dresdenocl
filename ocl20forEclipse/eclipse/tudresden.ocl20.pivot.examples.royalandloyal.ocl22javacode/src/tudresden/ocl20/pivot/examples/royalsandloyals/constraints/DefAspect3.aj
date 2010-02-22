package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect3 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.Membership extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedMembership;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Membership#getCurrentLevelName()}.</p>
     */
    protected pointcut getCurrentLevelNameCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.Membership.getCurrentLevelName())
    	&& target(aClass);
    
    /**
     * <p>Defines the method getCurrentLevelName() defined by the constraint
     * <code>context Membership
     *       def: getCurrentLevelName = currentLevel[].name[]</code></p>
     */
    String around(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass): getCurrentLevelNameCaller(aClass) {
        return aClass.currentLevel.name;
    }
}
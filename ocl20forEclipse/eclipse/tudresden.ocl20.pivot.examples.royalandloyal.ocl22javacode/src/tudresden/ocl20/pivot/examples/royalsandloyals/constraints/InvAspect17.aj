package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InvAspect17 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.Membership extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedMembership;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Membership#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.Membership.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class Membership defined by the constraint
     * <code>context Membership
     *       inv: currentLevel[].name[].=( 'Silver').implies( card[].color[].=( Color::silver[])).and( currentLevel[].name[].=( 'Gold').implies( card[].color[].=( Color::gold[])))</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Membership. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Membership")) {
        if (!((!aClass.currentLevel.name.equals("Silver") || aClass.card.color.equals(tudresden.ocl20.pivot.examples.royalsandloyals.Color.silver)) && (!aClass.currentLevel.name.equals("Gold") || aClass.card.color.equals(tudresden.ocl20.pivot.examples.royalsandloyals.Color.gold)))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
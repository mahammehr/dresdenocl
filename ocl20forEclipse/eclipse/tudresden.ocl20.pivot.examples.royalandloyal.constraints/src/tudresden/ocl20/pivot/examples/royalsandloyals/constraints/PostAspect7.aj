package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect PostAspect7 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Service#upgradePointsEarned(Integer amount)}.</p>
     */
    protected pointcut upgradePointsEarnedCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass, Integer amount):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.Service.upgradePointsEarned(Integer))
    	&& target(aClass) && args(amount);
    
    /**
     * <p>Checks a postcondition for the upgradePointsEarned(, Integer amount) defined by the constraint
     * <code>context Service::upgradePointsEarned(amount: Integer) : 
     *       post: calcPoints().=( calcPoints@pre().+( amount[]))</code></p>
     */
    void around(tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass, Integer amount): upgradePointsEarnedCaller(aClass, amount) {
        /* Disable this constraint for subclasses of Service. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Service")) {
    
        Integer atPreValue1;
        
        if ((Object) aClass.calcPoints() == null) {
            atPreValue1 = null;
        } else {
            atPreValue1 = new Integer(aClass.calcPoints());
        }
    
        proceed(aClass, amount);
    
        if (!((Object) aClass.calcPoints()).equals((atPreValue1 + amount))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
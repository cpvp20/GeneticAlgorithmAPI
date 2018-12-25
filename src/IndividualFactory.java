public abstract class IndividualFactory<G, P> {
	
	/** 
	 * Returns a randomly created individual each time it is called
	 * @return random individual
	 */
	public abstract Individual<G, P> create();	
	
}

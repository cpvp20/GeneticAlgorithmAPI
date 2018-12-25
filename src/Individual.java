public abstract class Individual<G, P> {
	
	protected Genotype<G>  genotype;
	protected Phenotype<P> phenotype;
	
	protected double fitness = 0;
	
	/**
	 * Constructor which sets the individual's Genotype and Phenotype 
	 * @param genotype to be set
	 * @param phenotype to be set
	 */
	public Individual(Genotype<G> genotype, Phenotype<P> phenotype) {
		this.genotype  = genotype;
		this.phenotype = phenotype;
		updatePhenotype();
	}
	
	/**
	 * Updates the Phenotype of the individual
	 */
	public abstract void updatePhenotype();

	/**	 
	 * Returns a clone (exact copy) of the individual
	 * @return clone of individual
	 */
	public abstract Individual<G, P> clone();
	
	/** 
	 * Returns the Phenotype of the individual
	 * @return Phenotype of the individual
	 */
	public abstract Phenotype<P> getPhenotype();
	
	/**
	 * Sets the specified fitness value of the individual
	 * @param fitness value which measures an individual's strength
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	/**
	 * Returns the fitness value of the individual
	 * @return fitness of individual
	 */
	public double getFitness() {
		return this.fitness;
	}	
	
}

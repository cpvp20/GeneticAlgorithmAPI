public class CSIndividual extends Individual<Character, Character> {

	/**
	 * Constructor which calls the constructor of the Individual class
	 * @param gen the Genotype
	 * @param phen the Phenotype
	 */
	public CSIndividual(Genotype<Character> gen, Phenotype<Character> phen) {
		super(gen, phen);
	}

	@Override
	/**
	 * Updates the Phenotype of the individual to set its array equal to its Genotype's gene array
	 */
	public void updatePhenotype() {
		for (int i = 0; i < 27; i++)
			this.phenotype.setValue(i, this.genotype.getGene(i));
	}
	
	@Override
	/**	
	 * Returns a clone of the individual calling the clone methods of Genotype and Phenotype and setting the corresponding fitness value
	 * @return clone of the CSIndividual  
	 */
	public Individual<Character, Character> clone() {
		Individual<Character, Character> clone = new CSIndividual(super.genotype.clone(), super.phenotype.clone());
		clone.fitness = this.fitness;
		return clone;
	}
	
	@Override
	/** 
	 * Returns the Phenotype of the individual
	 * @return the Phenotype of the individual
	 */
	public Phenotype<Character> getPhenotype() {
		return this.phenotype;
	}

	/**
	 * Returns the information regarding the individual as a String using the toString methods of Genotype and Phenotype
	 * @return the information regarding the individual as a String
	 */
	public String toString() {
		return super.genotype.toString() + "\n" + super.phenotype.toString() + "\n" + "Fitness: " + super.getFitness();
	}

}
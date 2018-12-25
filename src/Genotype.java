public abstract class Genotype<T> {
	
	/**
	 * Sets the specified element at the specified position in the Genotype's chromosome
	 * @param index the index of the array (chromosome) which contains the gene you want to set
	 * @param value the value of the gene you want to set
	 */
	public abstract void setGene(int index, T value);
	
	/**
	 * Returns the element at the specified position in the Genotype's chromosome
	 * @param index the index of the array (chromosome) which contains the gene you want to get
	 * @return the gene in the specified index
	 */
	public abstract T getGene(int index);
	
	/**
	 * Returns the length of the Genotype's chromosome
	 * @return the length of the Genotype's chromosome
	 */
	public abstract int length();
	
	/**
	 * Shuffles the chromosome of the genotype
	 */
	public abstract void randomize();
		
	/**
	 * Returns a clone (exact copy) of the Genotype
	 * @return clone of the genotype
	 */
	public abstract Genotype<T> clone();
	
}

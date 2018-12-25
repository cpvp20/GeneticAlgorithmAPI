public abstract class Phenotype<T> {
	
	/**
	 * Sets the specified element at the specified position in the Phenotype's array 
	 * @param index the index of the array which contains the value you want to set
	 * @param value the value of the value you want to set
	 */
	public abstract void setValue(int index, T value);
	
	/**
	 * Returns the element at the specified position in the Phenotype's array
	 * @param index the index of the array which contains the value you want to get
	 * @return the value in the specified index
	 */
	public abstract T getValue(int index);
	
	/**
	 * Returns the length of the Phenotype's array 
	 * @return the length of the Phenotype
	 */
	public abstract int length();
	
	/**	 
	 * Returns a clone (exact copy) of the Phenotype
	 * @return clone of the Phenotype
	 */
	public abstract Phenotype<T> clone();
	
}

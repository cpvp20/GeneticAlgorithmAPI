import java.util.Arrays;

public class CharArrayPhenotype extends Phenotype<Character> {

	private Character [] geneArray = null;

	/**
	 * Constructor which creates a new array of 27 Characters and assigns it to the Phenotype's gene array attribute
	 */
	public CharArrayPhenotype() {
		this.geneArray = new Character[27];
	}

	@Override
	/** 
	 * Sets the specified Character at the specified position in the Phenotype's gene array 
	 * @param index the index of the array of Characters which contains the Character you want to set
	 * @param value the value of the Character you want to set
	 */
	public void setValue(int index, Character value) {
		this.geneArray[index]= value;		
	}

	@Override
	/**
	 * Returns the Character at the specified position in the Phenotype's gene array
	 * @param index the index of the array of Characters which contains the Character you want to get
	 * @return the Character in the specified index
	 */
	public Character getValue(int index) {
		return geneArray[index];
	}

	@Override
	/**
	 * Returns the length of the Phenotype's gene array (27)
	 * @return the length of the Phenotype's gene array
	 */
	public int length() {
		return geneArray.length;
	}

	@Override
	/**
	 * Returns a clone (exact copy) of the CharArrayPhenotype
	 * @return clone of the CharArrayPhenotype
	 */
	public CharArrayPhenotype clone() {
		CharArrayPhenotype clone = new CharArrayPhenotype();
		for (int i = 0; i < this.length(); i++)
			clone.geneArray[i] = this.geneArray[i];
		return clone;
	}

	/**
	 * Returns the gene array of the Phenotype as a String using the toString method of the Arrays class
	 * @return the gene array of the Phenotype as a String
	 */
	public String toString() {
		return "Phenotype:\n" + Arrays.toString(geneArray);
	}

}

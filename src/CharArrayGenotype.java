import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharArrayGenotype extends Genotype<Character>{

	private Character [] geneArray = null;

	/**
	 * Constructor which creates a new array of 27 Characters and assigns it to the Genotype's gene array attribute
	 */
	public CharArrayGenotype() {
		this.geneArray = new Character[27];
	}

	@Override
	/** 
	 * Sets the specified Character at the specified position in the Genotype's gene array (chromosome)
	 * @param index the index of the array of Characters which contains the Character you want to set
	 * @param value the value of the Character you want to set
	 */
	public void setGene(int index, Character value) {
		this.geneArray[index]= value;		
	}

	@Override
	/**
	 * Returns the Character at the specified position in the Genotype's gene array (chromosome)
	 * @param index the index of the array of Characters which contains the Character you want to get
	 * @return the Character in the specified index
	 */
	public Character getGene(int index) {
		return geneArray[index];
	}

	@Override
	/**
	 * Returns the length of the Genotype's gene array (27)
	 * @return the length of the Genotype's gene array 
	 */
	public int length() {
		return geneArray.length;
	}

	@Override
	/**
	 * Shuffles the array of Characters using the shuffle method of the Collections class 
	 */
	public void randomize() {
		Character[] InitialCharArray = {'a','b','c', 'd', 'e', 'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
		List<Character> TemporalList = Arrays.asList(InitialCharArray);
		Collections.shuffle(TemporalList);
		Character[] shuffledArray = (Character[]) TemporalList.toArray();	
		for (int i = 0; i < this.length(); i++)
			geneArray[i] = shuffledArray[i];		
	}

	@Override
	/**
	 * Returns a clone (exact copy) of the CharArrayGenotype
	 * @return clone of the CharArrayGenotype
	 */
	public CharArrayGenotype clone() {
		CharArrayGenotype clone = new CharArrayGenotype();
		for (int i = 0; i < this.length(); i++)
			clone.geneArray[i] = this.geneArray[i];
		return clone;
	}
	
	/**
	 * Returns the gene array of the Genotype as a String using the toString method of the Arrays class
	 * @return the gene array of the Genotype as a String
	 */
	public String toString() {
		return "Genotype:\n" + Arrays.toString(geneArray);
	}
}

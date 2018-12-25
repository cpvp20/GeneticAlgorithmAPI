public class CSMutator extends Mutator<Character> {

	private static CSMutator instance = null;

	/**
	 * Empty Constructor (singleton)
	 */
	private CSMutator() {		
	}

	@Override
	/**
	 * Mutates the given genotype by selecting two random genes (positions within the chromosome array) and then swapping them
	 * @param genotype that will go through mutation
	 */
	public void mutate(Genotype<Character> genotype) {
		int index1 = (int) ((Math.random()*genotype.length() -1));	
		int index2 = (int) ((Math.random()*genotype.length() -1));	
		Character temp = genotype.getGene(index1);
		genotype.setGene(index1, genotype.getGene(index2));
		genotype.setGene(index2, temp);
	}

	/** 
	 * Returns the only instance of this mutator function (singleton)
	 * @return instance of mutator function
	 */
	public static CSMutator getInstance() {
		if(instance == null) instance = new CSMutator();
		return instance;
	}
}

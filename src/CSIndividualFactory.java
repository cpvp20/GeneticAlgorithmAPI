
public class CSIndividualFactory extends IndividualFactory<Character, Character> {

	@Override
	/** 
	 * Returns a randomly created CSIndividual in which the Genotype and Phenotype are identical 
	 * @return a randomly created CSIndividual in which the Genotype and Phenotype are identical
	 */
	public Individual<Character, Character> create() {
		Phenotype<Character>   phenotype  = new CharArrayPhenotype();
		Genotype<Character>   genotype   = new CharArrayGenotype();
		genotype.randomize();
		CSIndividual individual = new CSIndividual(genotype, phenotype);
		individual.updatePhenotype();
		return individual;
	}
}

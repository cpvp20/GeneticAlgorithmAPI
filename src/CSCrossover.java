import java.util.HashSet;
import java.util.Set;

public class CSCrossover extends Crossover<Character> {

	private static CSCrossover instance = null;

	/**
	 * Empty constructor (singleton)
	 */
	private CSCrossover() {
	}	

	@Override
	/**
	 * Combines the genetic information of two parents to generate 2 new offsprings 
	 * For each pair of parents, a crossover point is chosen at random
	 * Offsprings replace the parents 
	 * @param genotype1
	 * @param genotype2
	 */
	public void cross(Genotype<Character> genotype1, Genotype<Character> genotype2) {

		int crossOverPoint = (int) ((Math.random()*genotype1.length() -1));	

		CharArrayGenotype child1 = new CharArrayGenotype();
		CharArrayGenotype child2 = new CharArrayGenotype();

		//Set used to check there are no repeated letters in the genotype's gene array
		Set<Character> child1Set = new HashSet<>();
		Set<Character> child2Set = new HashSet<>();

		//Up to crossover point, copy genes from parent to offspring
		for(int i = 0; i <= crossOverPoint; i ++) {
			child1.setGene(i, genotype1.getGene(i));
			child1Set.add(genotype1.getGene(i));
			child2.setGene(i, genotype2.getGene(i));
			child2Set.add(genotype2.getGene(i));
		}
		//Next, copy remaining genes from parent to offspring 
		int nextPosChild1 = ++ crossOverPoint;
		int nextPosChild2 = crossOverPoint;
		for(int i = 0; i < genotype1.length(); i ++) {
			if(child1Set.add(genotype2.getGene(i)))
				child1.setGene(nextPosChild1 ++, genotype2.getGene(i));
			if(child2Set.add(genotype1.getGene(i)))
				child2.setGene(nextPosChild2 ++, genotype1.getGene(i));
		}
		//Offsprings replace parents
		genotype1 = child1.clone();
		genotype2 = child2.clone();
	}

	/** 
	 * Returns the only instance of this crossover function (singleton)
	 * @return instance of crossover function 
	 */
	public static CSCrossover getInstance() {
		if(instance == null) instance = new CSCrossover();
		return instance;
	}
}
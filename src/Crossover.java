public abstract class Crossover <T> {
	/**
	 * Genetic operator which combines the genetic information of two parents to generate 2 new offsprings
	 * Offsprings replace the parents 
	 * @param genotype1 first parent
	 * @param genotype2 second parent
	 */
	public abstract void cross(Genotype<T> genotype1, Genotype<T> genotype2);
	
}

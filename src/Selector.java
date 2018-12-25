import java.util.List;

public interface Selector<G, P> {
	
	/**
	 * Function which receives a population (a list of individuals) and subjects it to a certain selection process based on the individuals' fitness values
	 * Returns the new population after it has gone through the selection process
	 * @param population the population which is subjected to the selection process
	 * @param bestIndividualIndex the fittest individual of the entire population
	 * @return the new, theoretically improved, population after it has gone through the selection process
	 */
	List<Individual<G, P>> select(List<Individual<G, P>> population, int bestIndividualIndex);	

}

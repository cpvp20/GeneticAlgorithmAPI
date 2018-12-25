import java.util.List;
import java.util.ArrayList;

public class CSSelector<G,P> implements Selector<G,P>{

	/**
	 * Receives a population which is subjected to a tournament selection process
	 * The best individual of the population automatically passes if population size is odd
	 * Returns the new population after it has gone through the selection process
	 * @param oldPopulation the old population which is subjected to a tournament selection process
	 * @param bestIndividualIndex the best individual of the population (automatically passes if population size is odd)
	 * @return the new population (a list of individuals) after it has gone through the tournament selection process
	 */
	public List<Individual<G, P>> select(List<Individual<G, P>> oldPopulation, int bestIndividualIndex){

		final int N = oldPopulation.size();	//saves the size of the current population

		List<Individual<G, P>> newPopulation = new ArrayList<Individual<G, P>>(N);	//creates another array of individuals which will contain the new generation

		if(N % 2 != 0) newPopulation.add(oldPopulation.get(bestIndividualIndex));	//if population size is odd, add the fittest individual to the new population

		Individual<G,P> individual1;	//stores the 2 current participants/oponents of the selection process
		Individual<G,P> individual2;

		int rounds = N % 2 == 0 ? N/2 : (N-1)/2; //the number of competition rounds in this process

		for(int i = 0; i < rounds; i++) {

			int indexOfCompetitor = (int) (Math.random() * oldPopulation.size());	//randomly picks the first competitor and removes it from the old population
			individual1 = oldPopulation.remove(indexOfCompetitor);
			indexOfCompetitor = (int) (Math.random() * oldPopulation.size());	//randomly picks the second competitor and removes it from the old population
			individual2 = oldPopulation.remove(indexOfCompetitor);
			//competitors face each other to be added to the new population
			if(individual1.getFitness() > individual2.getFitness()) 
				newPopulation.add(individual1);
			else if(individual1.getFitness() < individual2.getFitness()) 
				newPopulation.add(individual2);
			else {
				newPopulation.add(individual1);	//both competitors are added if it is a tie to keep the algorythm
				newPopulation.add(individual2);	//from becoming redundant and doing the same thing every cycle
			}
		}

		//repopulate new population with copies of its members to grow to become original size
		while(newPopulation.size() < N){
			int randomIndividual = (int) ((Math.random() * newPopulation.size()));
			newPopulation.add(newPopulation.get(randomIndividual).clone());
		}
		return newPopulation;
	}//method select

}//class
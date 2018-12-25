public interface ObjectiveFunction<G,P> {
	/**
	 * Function that determines how fit an individual is (how close a solution is to achieving the set aims)
	 * @param phenotype the individual's Phenotype to be evaluated
	 * @param encryptedMssg text provided by the user which the GA is aiming to decrypt
	 * @return fitness value of the individual
	 */
	double calcFitness(Phenotype <P> phenotype, String encryptedMssg);

}

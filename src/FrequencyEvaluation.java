import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyEvaluation implements ObjectiveFunction<Character, Character> {

	/**
	 * Empty constructor (singleton)
	 */		
	private FrequencyEvaluation() {
	}

	private static FrequencyEvaluation instance = null;
	public static Map<String, Integer> nGramsInFitnessData = new HashMap<>();//Stores an Ngram as key with its frequnecy in a text as its value

	static {
		loadFitnessData();
	}

	/**
	 * Loads and formats the fitness data once (static) to be used by the algorithm
	 */
	private static void loadFitnessData() {
		try {
			String fileData = new String(Files.readAllBytes(Paths.get("res\\fitness_data.txt"))).trim()
					.replaceAll("//r", "").replaceAll("//n", "").toLowerCase(); //Stores the fitness data text file and formats it
			//Goes through the whole text and stores 3-character-long ngrams in the Hash Map
			for (int i = 0, j = 3; i < fileData.length() - 2; i++, j++) {	 
				String nGram = fileData.substring(i, j);
				if (nGram.matches("[a-z ]{3}")) {	//nGram matches the following pattern (letters or spaces only)
					if (nGramsInFitnessData.containsKey(nGram)) {
						int oldValue = nGramsInFitnessData.get(nGram);
						nGramsInFitnessData.replace(nGram, ++oldValue);
					} else {
						nGramsInFitnessData.put(nGram, 1);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);	//File not found
		}
	}

	@Override
	/**
	 * Function that determines how fit an individual is
	 * Uses the Phenotype as the key to decrypt the encrypted text and compares this to the fitness Data
	 * Comparing the frequency of all nGrams (3 adjacent letters) in both
	 * @param phenotype to be evaluated
	 * @param encryptedMssg text provided by the user which the GA is aiming to decrypt
	 * @return fitness value of the individual
	 */
	public double calcFitness(Phenotype <Character> phenotype, String encryptedMssg) {
		String possibleDecryptedMsg = decryptMsg(phenotype, encryptedMssg);
		Set<String> lookedNGrams = new HashSet<>();
		double fitness = 0;

		for (int i = 0, j = 3; i < possibleDecryptedMsg.length() - 2; i++, j++) {
			String nGram = possibleDecryptedMsg.substring(i, j);
			// First verify that the current nGram is even on the HashMap, that it follows the appropiate pattern
			// and that it is a new nGram we have not treated
			if (nGramsInFitnessData.containsKey(nGram) && nGram.matches("[a-z ]{3}") && lookedNGrams.add(nGram)) 
				//To then use it to calculate the fitness value, which we get by 
				//multiplying the frequency of the nGram in the decrypted text by the frequency of the nGram in the fitness Data
				fitness += calcFreq(possibleDecryptedMsg, nGram) * Math.log(nGramsInFitnessData.get(nGram));
		}
		return fitness;
	}

	/**
	 * Calculates the frequency of an nGram (3 adjacent letters) in a specified text (String)
	 * @param msg specified text 
	 * @param nGram specified nGram (3 adjacent letters)
	 * @return nGram's frequency in message
	 */
	public int calcFreq(String msg, String nGram) {
		int frequency = 0;
		for (int i = 0, j = 3; i < msg.length() - 2; i++, j++) {
			String nGramToCompare = msg.substring(i, j);
			if (nGram.equals(nGramToCompare)) frequency++;
		}
		return frequency;
	}

	/**
	 * Calculate the possible solution the Phenotype provides by using it as the key to decrypt the specified message
	 * @param phenotype key to be used
	 * @param encryptedMsg specified message
	 * @return a plain text which is the possible solution the specified Phenotype provides
	 */
	public String decryptMsg(Phenotype <Character> phenotype, String encryptedMsg) {
		String decryptedMsg = "";

		for (int i = 0, index; i < encryptedMsg.length(); i++) {
			if (encryptedMsg.charAt(i) == ' ' || encryptedMsg.charAt(i) >= 'a' && encryptedMsg.charAt(i) <= 'z') {
				for(index = 0; index < 27; index++){
					if(encryptedMsg.charAt(i) == phenotype.getValue(index)) break;
				}
				if(index == 26) decryptedMsg += ' ';	//Uses the index and the value stored in index to decrypt
				else decryptedMsg += (char)(index + 97);
			} else {
				decryptedMsg += encryptedMsg.charAt(i);	//not used, simply copied
			}
		}
		return decryptedMsg;
	}

	/** 
	 * Returns the only instance of the FrequencyEvaluation function (singleton)
	 * @return instance of FrequencyEvaluation function 
	 */
	public static FrequencyEvaluation getInstance() {
		if(instance == null) instance = new FrequencyEvaluation();
		return instance;
	}
}

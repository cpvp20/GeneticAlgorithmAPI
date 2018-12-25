public class MissingStageException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	/**
	 * Sets the specified message to be displayed along with the exception
	 * @param message to be displayed within exception
	 */
	public MissingStageException(String message) {
		this.message = message;
	}

	/**
	 * Returns a String containing information regarding the exception
	 * @return String information about the exception
	 */
	public String toString() {
		return String.format("%s\n%s", super.toString(), this.message);
	}	
	
}


public enum NewsMetric {
	LENGTH, COUNT;
	
	/**
	 * The overridden <code>toString</code> method gives the length or count 
	 * 
	 */
	@Override
	public String toString() {
		switch (this) {
		case LENGTH:
			return "Length";
		case COUNT:
			return "Count";
		default:
			throw new IllegalArgumentException();
		}
	}
}

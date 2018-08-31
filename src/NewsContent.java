
public enum NewsContent {
	SOURCE, TOPIC, SUBJECT;
	
	/**
	 * The overridden <code>toString</code> method gives the news content.
	 */
	@Override
	public String toString() {
		switch (this) {
		case SOURCE:
			return "Source";
		case TOPIC:
			return "Topic";
		case SUBJECT:
			return "Subject";
		default:
			throw new IllegalArgumentException();
		}
	}
}

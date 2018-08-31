import java.util.LinkedList;
import java.util.List;

public enum NewsMedia {
	
	NEWSPAPER, ONLINE, TV;
	
	public static final List<NewsMedia> VALUES_LIST = new LinkedList<NewsMedia>();
	
	/**
	 * The overridden <code>toString</code> method gives the news content.
	 */
	@Override
	public String toString() {
		switch (this) {
		case NEWSPAPER:
			return "Newspaper";
		case ONLINE:
			return "Online";
		case TV:
			return "TV";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public List<NewsMedia> valuesAsList(){
		VALUES_LIST.add(NEWSPAPER);
		VALUES_LIST.add(ONLINE);
		VALUES_LIST.add(TV);
		return VALUES_LIST;
	}
	
}

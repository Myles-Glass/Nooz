import java.io.Serializable;

import javax.swing.DefaultListModel;

public class NewsStoryListModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<NewsStory> newsStories;

	public NewsStoryListModel(){
		
	}
	
	public NewsStoryListModel(NewsStoryListModel newsStoryListModel){
		
	}
	
	public boolean isEmpty(){
		return newsStories.isEmpty();
	}
	
	public int size(){
		return newsStories.size();
	}
	
	/**
	 * An accessor method to test whether the list already contains a news
	 * maker.
	 * <P>
	 * Simply makes use of the <code>contains</code> method of
	 * <code>ArrayList</code>.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to check for in the list.
	 * @return The boolean value true if the news maker is in the list, false
	 *         otherwise.
	 */
	public boolean contains(NewsStory newsStory) {
		return this.newsStories.contains(newsStory);
	}

	public NewsStory get(int index){
		return newsStories.getElementAt(index);
	}
	
	public DefaultListModel<NewsStory> getNewsStories(){
		return newsStories;
	}
	
	/**
	 * The mutator for adding news makers to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * can ensure that we don't add multiple <code>NewsMaker</code> objects with
	 * the same name to our list (thereby keeping the names unique).
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to add.
	 * @throws IllegalArgumentException
	 *             If the news maker to add is already in the list.
	 */
	public void add(NewsStory newsStory) {
		if (!this.newsStories.contains(newsStory)) {
			this.newsStories.addElement(newsStory);
			
		} else {
			throw new IllegalArgumentException("NewsStory with topic " + newsStory.getTopic() + " already in list.");
		}
	}

	public void remove(NewsStory newsStory){
		newsStories.removeElement(newsStory);
	}
	
	public void removeListOfNewsStories(DefaultListModel<NewsStory> newsStories){
		newsStories.removeAllElements();
	}
	
	public void setNewsStories(NewsStoryListModel newsStoryListModel){
		this.newsStories = newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoriesFromArray(NewsStory[] newsStoryArray){
		removeListOfNewsStories(newsStories);
		for (int i = 0; i < newsStoryArray.length; i++ ) {
			this.newsStories.addElement(newsStoryArray[i]);
		}
	}
	
}

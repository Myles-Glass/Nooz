import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class NewsMakerModel implements Comparable<NewsMakerModel>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ActionListener> actionListenerList;
	
	private String name;
	
	private NewsStoryListModel newsStoryListModel;
	
	public NewsMakerModel(){
		
	}
	
	public NewsMakerModel(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public NewsStoryListModel getNewsStoryListModel(){
		return this.newsStoryListModel;
	}
	
	public void addNewsStory(NewsStory newsStory){
		this.newsStoryListModel.add(newsStory);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
		this.newsStoryListModel = newsStoryListModel;
	}
	
	public void removeNewsStory(NewsStory newsStory){
		newsStoryListModel.remove(newsStory);
	}
	
	/**
	 * An overridden <code>equals</code> method.
	 * <P>
	 * A <code>NewsMaker</code> should be equal to another object if that object
	 * is also a <code>NewsMaker</code> object and they have the same name.
	 * (Since <code>equals</code> is a method in the <code>Object</code> class
	 * that we are overriding, the parameter needs to be an
	 * <code>Object</code>.)
	 * </P>
	 * 
	 * @param o
	 *            The Object to which to compare this.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof NewsMakerModel) {
			NewsMakerModel newsMakerModel = (NewsMakerModel) o;
			return this.name.equals(newsMakerModel.getName());
		}
		return false;
	}

	/**
	 * The required <code>compareTo</code> method for implementing
	 * <code>Comparable</code>. Looks at name only.
	 * 
	 * @param newsMaker
	 *            The other news maker to which to compare this.
	 */
	@Override
	public int compareTo(NewsMakerModel newsMakerModel) {
		return this.name.compareTo(newsMakerModel.name);
	}

	public String toString(){
		return "DO ITTT";
	}
	
	public void addActionListener(ActionListener actionListener){
		actionListenerList.add(actionListener);
	}
	
	public void removeActionListener(ActionListener actionListener){
		actionListenerList.remove(actionListener);
	}
	
	private void processEvent(ActionEvent actionEvent){
		
	}
	
}

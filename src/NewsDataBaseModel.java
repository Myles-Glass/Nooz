import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultListModel;

public class NewsDataBaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ActionListener> actionListenerList;
	private Map<String, String> newsSourceMap = new TreeMap<String, String>();
	private Map<String, String> newsTopicMap = new TreeMap<String, String>();
	private Map<String, String> newsSubjectMap = new TreeMap<String, String>();
	NewsMakerModel none; 
	private NewsMakerListModel newsMakerListModel;
	private NewsStoryListModel newsStoryListModel;
	
	public NewsDataBaseModel(){
		
	}
	
	public NewsDataBaseModel(NewsMakerListModel newsMakerListModel, NewsStoryListModel newsStoryListModel){
		this.newsMakerListModel = newsMakerListModel;
		this.newsStoryListModel = newsStoryListModel;
	}

	public Map<String, String> getNewsSourceMap(){
		return newsSourceMap;
	}
	
	public String[] getNewsSources(){
		String[] newsSourceArray = newsSourceMap.values().toArray(new String[0]);
		return newsSourceArray;
	}
	
	public void setNewsSourceMap(Map<String, String> newsSourceMap){
		this.newsSourceMap = newsSourceMap;
	}
	
	public Map<String, String> getNewsTopicMap(){
		return newsTopicMap;
	}
	
	public String[] getNewsTopics(){
		String[] newsTopicArray = newsTopicMap.values().toArray(new String[0]);
		return newsTopicArray;
	}
	
	public void setNewsTopicMap(Map<String, String> newsTopicMap){
		this.newsTopicMap = newsTopicMap;
	}
	
	public Map<String, String> getNewsSubjectMap(){
		return newsSubjectMap;
	}
	
	public String[] getNewsSubjects(){
		String[] newsSubjectArray = newsSubjectMap.values().toArray(new String[0]);
		return newsSubjectArray;
	}
	
	public void setNewsSubjectMap(Map<String, String> newsSubjectMap){
		this.newsSubjectMap = newsSubjectMap;
	}
	
	public boolean newsMakerListIsEmpty(){
		return newsMakerListModel.isEmpty();
	}
	
	public boolean containsNewsMakerModel(NewsMakerModel newsMakerModel){
		return newsMakerListModel.contains(newsMakerModel);
	}
	
	public NewsMakerListModel getNewsMakerListModel(){
		return newsMakerListModel;
	}
	
	public String[] getNewsMakerNames(){
		return newsMakerListModel.getNewsMakerNames();
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		return newsMakerListModel.getNewsMakers();
	}
	
	public void setNewsMakerListModel(NewsMakerListModel newsMakerListModel){
		newsMakerListModel.setNewsMakersFromNewsMakerList(newsMakerListModel);
	}
	
	public void addNewsMakerModel(NewsMakerModel newsMakerModel){
		newsMakerListModel.add(newsMakerModel);
	}
	
	public void replaceNewsMakerModel(NewsMakerModel newsMakerModel){
		newsMakerListModel.replace(newsMakerModel);
	}
	
	public void removeNewsMakers(DefaultListModel<NewsMakerModel> newsMakers){
		newsMakerListModel.removeListOfNewsMakers(newsMakers);
	}
	
	public void removeAllNewsMakers(){
		newsMakerListModel.removeAllNewsMakers();
	}
	
	public void sortNewsMakerListModel(){
		newsMakerListModel.sort();
	}
	
	public boolean newsStoryListIsEmpty(){
		return newsStoryListModel.isEmpty();
	}
	
	public boolean containsNewsStory(NewsStory newsStory){
		return newsStoryListModel.contains(newsStory);
	}
	
	public NewsStoryListModel getNewsStoryListModel(){
		return newsStoryListModel;
	}
	
	public DefaultListModel<NewsStory> getNewsStories(){
		return newsStoryListModel.getNewsStories();
	}
	
	public void setNewsStoryListModel(NewsStoryListModel newsStoryListModel){
		newsStoryListModel.setNewsStories(newsStoryListModel);
	}
	
	public void setNewsStoryListModelFromArray(NewsStory[] newsStoryArray){
		newsStoryListModel.setNewsStoriesFromArray(newsStoryArray);
	}
	
	public void addNewsStory(NewsStory newsStory){
		newsStoryListModel.add(newsStory);
	}
	
	public void removeNewsStories(DefaultListModel<NewsStory> newsStories){
		newsStoryListModel.removeListOfNewsStories(newsStories);
	}
	
	public void removeAllNewsStories(){
		newsStoryListModel = null;
	}
	
	public void addActionListener(ActionListener l){
		actionListenerList.add(l);
	}
	
	public void removeActionListener(ActionListener l){
		actionListenerList.remove(l);
	}
	
	private void processEvent(ActionEvent e){
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;

public class NewsController {
	
	private NewsDataBaseModel newsDataBaseModel;
	private SelectionView selectionView;
	//private EditNewsMakerView editNewsMakerView;
	private JDialog viewDialog;
	//private AddEditNewsStoryView addEditNewsStoryView;
	private NewsStory editedNewsStory;
	//private MediaTypeSelectionView mediaTypeSelectionView;
	private List<NewsMedia> selectedMediaTypes;
	
	public NewsController(){
		
	}
	
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
	}
	public void setSelectionView(SelectionView selectionView){
		this.selectionView = selectionView;
	}
	private void loadNewsData(){
		System.out.println ("LOADER CLICKED");
	}
	private void saveNewsData();
	private void importNoozStories();
	private void exportNewsStories();
	private void addNewsMaker();
	private void editNewsMakers();
	private void deleteNewsMakers();
	private void deleteNewsMakerList();
	private void addNewsStory();
	private void editNewsStories();
	private void sortNewsStories();
	private void deleteNewsStories();
	private void deleteAllNewsStories();
	private void displayPieCharts();
	private void displayTextViews();
	
	/**
	 * Listener as inner class.
	 */
	private class FileMenuListener implements ActionListener {
		private SelectionView selectionView;
		//ActionListener actionListener = new ActionListener()
		
		/**
		 * Overridden actionPerformed method (called when listener is notified
		 * of a user gesture by a view).
		 * 
		 * @param actionEvent
		 *            The action that took place.
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			loadNewsData();//SelectionView.registerFileMenuListener(actionEvent);

		}
			
	}
}

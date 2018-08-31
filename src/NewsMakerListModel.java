
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;

public class NewsMakerListModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<NewsMakerModel> newsMakerDefaultListModel;
	
	public NewsMakerListModel(){
		
	}
	
	public NewsMakerListModel(NewsMakerListModel newsMakerListModel){
		
	}
	
	public boolean isEmpty(){
		return newsMakerDefaultListModel.isEmpty();
	}

	public int size(){
		return newsMakerDefaultListModel.size();
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
	public boolean contains(NewsMakerModel newsMakerModel) {
		return this.newsMakerDefaultListModel.contains(newsMakerModel);
	}

	/**
	 * An accessor method to get a news maker from the list.
	 * <P>
	 * Note that <code>NewsMaker</code> objects are mutable, so this really
	 * should return a copy of the news maker instead. However, we haven't
	 * studied that yet, so returning the news maker itself is acceptable for
	 * now.
	 * </P>
	 * 
	 * @param newsMaker
	 *            The news maker to get from the list.
	 * @return The news maker found, if any. Otherwise, null.
	 */
	public NewsMakerModel get(NewsMakerModel newsMakerModel) {
		int index = newsMakerDefaultListModel.indexOf(newsMakerModel);
		if (index >= 0) {
			// TODO Have it return a copy instead (Eventually)
			return this.newsMakerDefaultListModel.get(index);
		} else {
			return null;
		}
	}
	
	/**
	 * This method should be able to use a binary search to find the news maker
	 * but relies on the list being sorted first. It therefore checks the
	 * <code>sorted</code> flag and prints an error to the standard error if it
	 * was called with an unsorted list. It will conduct a linear search if a
	 * binary search is not possible.
	 * 
	 * @param newsMakerName
	 *            The exact name for which to search.
	 * @return The news maker found or null if none found.
	 */
	public NewsMakerModel getExactMatch(String newsMakerName) {		
		
		for (int i = 0; i < newsMakerDefaultListModel.size(); i++ ) {
			if (newsMakerDefaultListModel.getElementAt(i).getName().equals(newsMakerName)) {
				return newsMakerDefaultListModel.getElementAt(i);
			}
		}
		return null;
	}
	
	/**
	 * This method searches for partial matches in the list, and returns the
	 * first news maker that contains the search string specified.
	 * 
	 * @param newsMakerName
	 *            The string on which to search.
	 * @return The news maker found or null if none found.
	 */
	public NewsMakerModel getPartialMatch(String newsMakerName) {
		for (int i = 0; i < newsMakerDefaultListModel.size(); i++ ) {
			if (newsMakerDefaultListModel.getElementAt(i).getName().contains(newsMakerName)) {
				return newsMakerDefaultListModel.getElementAt(i);
			}
		}
		return null;
	}
	
	public DefaultListModel<NewsMakerModel> getNewsMakers(){
		return newsMakerDefaultListModel;
	}
	
	public NewsMakerModel get(int index){
		return newsMakerDefaultListModel.getElementAt(index);
	}

	public String[] getNewsMakerNames(){
		ArrayList<String> tempArray = new ArrayList<String>();
		
		for (int i = 0; i < newsMakerDefaultListModel.size(); i++ ) {
			tempArray.add(newsMakerDefaultListModel.getElementAt(i).getName());
		}
		
		String[] names = new String[tempArray.size()];
		names = tempArray.toArray(names);
		return names;
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
	public void add(NewsMakerModel newsMakerModel) {
		if (!this.newsMakerDefaultListModel.contains(newsMakerModel)) {
			this.newsMakerDefaultListModel.addElement(newsMakerModel);
			
		} else {
			throw new IllegalArgumentException("NewsMaker " + newsMakerModel.getName() + " already in list.");
		}
	}
	
	public void replace(NewsMakerModel newsMakerModel){
		this.remove(newsMakerModel);
		this.add(newsMakerModel);
	}
	
	public void remove(NewsMakerModel newsMakerModel){
		newsMakerDefaultListModel.removeElement(newsMakerModel);
	}
	
	public void removeListOfNewsMakers(DefaultListModel<NewsMakerModel> newsMakerDefaultListModel){
		newsMakerDefaultListModel.removeAllElements();
	}
	
	public void removeAllNewsMakers(){
		newsMakerDefaultListModel.removeAllElements();
	}
	
	public void setNewsMakersFromNewsMakerList(NewsMakerListModel newsMakerListModel){
		this.newsMakerDefaultListModel = newsMakerListModel.getNewsMakers();
	}
	
	/**
	 * This method sorts the list using a stable sort. It also sets the
	 * <code>sorted</code> flag to <code>true</code>.
	 */
	public void sort() {
	    ArrayList<NewsMakerModel> tempList = new ArrayList<>();
	    for (int i = 0; i < newsMakerDefaultListModel.size(); i++) {
	        tempList.add(newsMakerDefaultListModel.get(i));
	    }
	    Collections.sort(tempList);
	    newsMakerDefaultListModel.removeAllElements();
	    for (NewsMakerModel newsMakerModel : tempList) {
	    	newsMakerDefaultListModel.addElement(newsMakerModel);
	    }
	}
}

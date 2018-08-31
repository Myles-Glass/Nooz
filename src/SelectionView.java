import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;


public class SelectionView extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NewsDataBaseModel newsDataBaseModel;
	private JMenuBar jmb;
	private JMenu jmFile;
	private JMenuItem jmiLoad;
	private JMenuItem jmiSave;
	private JMenuItem jmiImport;
	private JMenuItem jmiExport;
	private JMenu jmNewsMaker;
	private JMenuItem jmiAddNewsMaker;
	private JMenuItem jmiEditNewsMaker;
	private JMenuItem jmiDeleteNewsMaker;
	private JMenuItem jmiDeleteNewsMakerList;
	private JMenu jmNewsStory;
	private JMenuItem jmiAddNewsStory;
	private JMenuItem jmiEditNewsStory;
	private JMenuItem jmiSortNewsStories;
	private JMenuItem jmiDeleteNewsStory;
	private JMenuItem jmiDeleteAllNewsStories;
	private JMenu jmDisplay;
	private JMenuItem jmiPieChart;
	private JMenuItem jmiText;
	private JList<NewsMakerModel> jlNewsMakerList;
	private JScrollPane jspNewsMakerList;
	private JPanel jpNewsMakerList;
	private JList<NewsStory> jlNewsStoryList;
	private JScrollPane jspNewsStoryList;
	private JPanel jpNewsStoryList;
	private JSplitPane splitPane;
	
	public SelectionView(){

		//Menu Bar
		jmb = new JMenuBar();
		
		jmFile = new JMenu("File");
		jmb.add(jmFile);
		jmiLoad = new JMenuItem("Load");
		jmFile.add(jmiLoad);
		jmiSave = new JMenuItem("Save");
		jmFile.add(jmiSave);
		jmiImport = new JMenuItem("Import");
		jmFile.add(jmiImport);
		jmiExport = new JMenuItem("Export");
		jmFile.add(jmiExport);
		
		jmNewsMaker = new JMenu("Newsmakers");
		jmb.add(jmNewsMaker);
		jmiAddNewsMaker = new JMenuItem("Add Newsmaker");
		jmNewsMaker.add(jmiAddNewsMaker);
		jmiEditNewsMaker = new JMenuItem("Edit Newsmaker");
		jmNewsMaker.add(jmiEditNewsMaker);
		jmiDeleteNewsMaker = new JMenuItem("Delete Newsmaker");
		jmNewsMaker.add(jmiDeleteNewsMaker);
		jmiDeleteNewsMakerList = new JMenuItem("Delete Newsmaker List");
		jmNewsMaker.add(jmiDeleteNewsMakerList);
		
		jmNewsStory = new JMenu("News Stories");
		jmb.add(jmNewsStory);
		jmiAddNewsStory = new JMenuItem("Add News Story");
		jmNewsStory.add(jmiAddNewsStory);
		jmiEditNewsStory = new JMenuItem("Edit News Story");
		jmNewsStory.add(jmiEditNewsStory);
		jmiSortNewsStories = new JMenuItem("Sort News Stories");
		jmNewsStory.add(jmiSortNewsStories);
		jmiDeleteNewsStory = new JMenuItem("Delete News Story");
		jmNewsStory.add(jmiDeleteNewsStory);
		jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
		jmNewsStory.add(jmiDeleteAllNewsStories);
		
		jmDisplay = new JMenu("Display");
		jmb.add(jmDisplay);
		jmiPieChart = new JMenuItem("Pie Chart");
		jmDisplay.add(jmiPieChart);
		jmiText = new JMenuItem("Text");
		jmDisplay.add(jmiText);
		
		
		//Maker List
		jspNewsMakerList = new JScrollPane(jlNewsMakerList);
		TitledBorder makerBorder = new TitledBorder("Newsmakers");
		makerBorder.setTitleJustification(TitledBorder.LEFT);
		makerBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
	    jspNewsMakerList.setBorder(makerBorder);
		
		//Story List
		jspNewsStoryList = new JScrollPane(jlNewsStoryList);
		TitledBorder storyBorder = new TitledBorder("News Stories");
		storyBorder.setTitleJustification(TitledBorder.LEFT);
		storyBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
		jspNewsStoryList.setBorder(storyBorder);
        
		//Main window
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jspNewsMakerList, jspNewsStoryList);
		setTitle("Nooz");
		add(splitPane, BorderLayout.CENTER);
		add(jmb, BorderLayout.NORTH);
		setMinimumSize(new Dimension(700, 320));
		splitPane.setDividerLocation(260);
			
		//jlNewsMakerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void registerFileMenuListener(ActionListener fileMenuListener){
		jmFile.addActionListener(fileMenuListener);
	}
	public void registerNewsMakerMenuListener(ActionListener newsMakerMenuListener);
	public void registerNewsStoryMenuListener(ActionListener newsStoryMenuListener);
	public void registerDisplayMenuListener(ActionListener displayMenuListener);
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
	}
	public void actionPerformed(ActionEvent actionEvent);
	public int[] getSelectedNewsMakers();
	public int[] getSelectedNewsStories();
}

import java.io.IOException;

public class NoozDriver {
	private static NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	private static SelectionView selectionView = new SelectionView();
	private static NewsController newsController = new NewsController();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// There should be no program arguments supplied
		if (args.length != 0) {
			// If the calling process specifies the wrong number of program
			// arguments, give an error message and exit with non-zero exit code
			System.err.println("Usage error. Program arguments are not used by this program.");
			System.exit(1);
		}
		
		newsDataBaseModel = new NewsDataBaseModel();
		selectionView.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setNewsDataBaseModel(newsDataBaseModel);
		newsController.setSelectionView(selectionView);
	}
}

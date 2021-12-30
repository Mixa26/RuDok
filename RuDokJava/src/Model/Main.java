package Model;

import View.MainView;

public class Main {

    public static void main(String[] args) {
        MainView mainFrame = MainView.getInstance();
        mainFrame.setVisible(true);
        mainFrame.openInitialPopUp();
    }
}

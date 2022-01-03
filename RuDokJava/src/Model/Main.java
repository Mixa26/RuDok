package Model;

import View.MainView;

public class Main {

    public static void main(String[] args) {
        MainView mainView = MainView.getInstance();
        mainView.setVisible(true);
        mainView.openInitialPopUp();
    }
}

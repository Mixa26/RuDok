package Model;

import View.MainView;

public class Main {

    public static void main(String[] args) {
        MainView mainFrame = MainView.getIntance();
        mainFrame.setVisible(true);
    }
}

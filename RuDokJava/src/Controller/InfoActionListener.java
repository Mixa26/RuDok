package Controller;

import View.InfoFrame;
import View.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoActionListener implements ActionListener {
    public InfoActionListener()
    {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new InfoFrame(MainFrame.getIntance(),"Info", true);
    }
}

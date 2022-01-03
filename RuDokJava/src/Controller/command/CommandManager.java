package Controller.command;

import View.MainView;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<AbstractCommand>();

    private int currentCommand = 0;

    public CommandManager() {
        MainView.getInstance().getActionManager().getRedoAction().setEnabled(false);
        MainView.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    public void addComand(AbstractCommand command)
    {
        while (currentCommand < commands.size())
        {
            commands.remove(currentCommand);
        }
        commands.add(command);
        doCommand();
    }

    public void doCommand()
    {
        if (currentCommand < commands.size())
        {
            commands.get(currentCommand++).doCommmand();
            MainView.getInstance().getActionManager().getUndoAction().setEnabled(true);
            // ovde setuj da redo enabled u action manager
        }

        if (currentCommand==commands.size())
        {
            MainView.getInstance().getActionManager().getRedoAction().setEnabled(false);
            // ovde setuj da redo disabled u action manager
        }
    }

    public void undoCommand()
    {
        if (currentCommand > 0)
        {
            MainView.getInstance().getActionManager().getRedoAction().setEnabled(true);
            //set enable redo u action mangeru
            commands.get(--currentCommand).undoCommand();
        }
        if (currentCommand==0)
        {
            MainView.getInstance().getActionManager().getUndoAction().setEnabled(false);
            //set disable redo u action manageru
        }
    }
}

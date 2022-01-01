package Model.slotHandler;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.TextEditorView;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TextSlotHandler extends SlotHandler implements Serializable {
    List<charStyle> charStyle = new ArrayList<>();

    public TextSlotHandler(Slot slot) {
        super.slot = slot;
    }

    @Override
    public void setContent(String content) {
        charStyle.clear();
        slot.signalizeChange();
        slot.setContent(content);
    }

    @Override
    public String getContent() {
        JTextPane jTextPane = ((PresentationView)(MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent())).getTextEditorView().getjTextPane();

        boolean bold;
        boolean italic;
        boolean underline;

        String text =slot.getContent();
        if (text != null)
        {
            for (int i = 0; i < text.length(); i++)
            {
                AttributeSet set = jTextPane.getStyledDocument().getCharacterElement(i).getAttributes();
                bold = StyleConstants.isBold(set);
                italic = StyleConstants.isItalic(set);
                underline = StyleConstants.isUnderline(set);
                charStyle.add(new charStyle(bold, italic, underline));
            }
        }
        return slot.getContent();
    }

    public List<Model.slotHandler.charStyle> getCharStyle() {
        return charStyle;
    }
}

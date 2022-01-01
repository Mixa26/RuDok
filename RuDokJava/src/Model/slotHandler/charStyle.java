package Model.slotHandler;

import java.io.Serializable;

public class charStyle implements Serializable {
    private boolean bold;
    private boolean italic;
    private boolean underline;

    public charStyle(boolean bold, boolean italic, boolean underline) {
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
    }

    public boolean isBold() {
        return bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public boolean isUnderline() {
        return underline;
    }
}

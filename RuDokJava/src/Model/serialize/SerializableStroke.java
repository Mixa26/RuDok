package Model.serialize;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableStroke implements Stroke,Serializable {

    Stroke stroke;

    public SerializableStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        if (stroke instanceof BasicStroke)
        {
            BasicStroke basicStroke = (BasicStroke) stroke;
            out.writeFloat(basicStroke.getLineWidth());
            out.writeInt(basicStroke.getEndCap());
            out.writeInt(basicStroke.getLineJoin());
            out.writeFloat(basicStroke.getMiterLimit());
            out.writeObject(basicStroke.getDashArray());
            out.writeFloat(basicStroke.getDashPhase());
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        stroke = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(), in.readFloat(), (float[])in.readObject(), in.readFloat());
    }

    @Override
    public Shape createStrokedShape(Shape p) {
        return stroke.createStrokedShape(p);
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Stroke getStroke() {
        return stroke;
    }
}

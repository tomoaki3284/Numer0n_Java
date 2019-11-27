import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Rule extends JPanel{
    private JTextArea ta;

    public Rule(){
        super();
        setBounds(0,0,400,400);

        EmptyBorder empty = new EmptyBorder(80,10,10,10);
        setBorder(empty);

        ta = new JTextArea(">>> Rules:");
        ta.append("\n"   + "EAT : Same number and same location");
        ta.append("\n"   + "BITE: Same number but different location");
        ta.append("\n\n" + ">>> Example:");
        ta.append("\n"   + "Number -> 951,"
                + "\n"   + "Guess  -> 158"
                + "\n"   + "5 -> same number same location"
                + "\n"   + "1 -> same number different location"
                + "\n"   + "EAT - BITE : 1 - 1"
                + "\n\n" + ">>> Tip:"
                + "\n"   + "Use Card Eliminator to eliminate unused card");

        ta.setEditable(false);

        setLayout(new GridLayout(1,1));

        add(ta);
    }

    public JPanel getRule(){
        return this;
    }
}

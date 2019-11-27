import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class CardEliminator extends JPanel{

    private ArrayList<Card> cards = new ArrayList<>();

    public CardEliminator(){
        super();
        setBounds(0,0,400,100);
        setLayout(new GridLayout(2,5));

        //create all the cards
        for(int i = 0; i < 10; i++){
            cards.add(new Card(i));
        }

        for(int i = 0; i < 10; i++){
            generateButtons(i);
        }

//        JLabel label = new JLabel("Card Eliminator");
//        add(label);
    }

    public void generateButtons(int i){
        Card card = cards.get(i);
        JButton b = new JButton(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                card.switchElimination();
                Object source = e.getSource();

                if (source instanceof JButton){
                    JButton b = (JButton)source;
                    if(card.getEliminated()){
                        b.setIcon(new ImageIcon(card.getImage_Eliminator_Eliminated()));
                    }
                    else{
                        b.setIcon(new ImageIcon(card.getImage_Eliminator_Uneliminated()));
                    }
                }

                repaint();
            }
        });
        b.setPreferredSize(new Dimension(30, 50));
        b.setIcon(new ImageIcon(card.getImage_Eliminator_Uneliminated()));
        add(b);
    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NumbersPanel extends JPanel {
    public static NumbersPanel panel = null;
    private JButton sendBtn, flipCardBtn, clearBtn;
    private ArrayList<String> guessNumbers = new ArrayList<String>();
    private String message = "";

    public NumbersPanel(){
        super();
        setBounds(0,0,400,400);
        setLayout(new GridLayout(5,3));

        EmptyBorder emptyB = new EmptyBorder(80,10,10,10);
        setBorder(emptyB);

        //create buttons 0-9
        JButton nums_btn;
        String thisNumber;
        for(int i = 0; i < 10; i++){
            thisNumber = Integer.toString(i);
            nums_btn = createButton(thisNumber);
            add(nums_btn);
        }

        sendBtn = new JButton(new AbstractAction("Call"){
            @Override
            public void actionPerformed(ActionEvent e) {
                //call numberManager method to send the record to RecordTable
                if(guessNumbers.size() == 3){
                    NumberManager numberManager = NumberManager.getNumberManager();
                    numberManager.ComputeEAT_BITEandSendRecord(guessNumbers);
                    guessNumbers.clear();
                    message = "Send";
                    Numeron_Prototype03.switchPlayerTurn();
                    repaint();
                    resetMessage();
                }
                else if(guessNumbers.size() < 3){
                    message = "Please select three digit";
                    guessNumbers.clear();
                    repaint();
                    resetMessage();
                }
            }
        });

        flipCardBtn = new JButton(new AbstractAction("Flip"){
            @Override
            public void actionPerformed(ActionEvent e) {
                Board board = Board.getBoard();
                board.FlipPlayer1Numbers();
            }

        });

        clearBtn = new JButton(new AbstractAction("Clear"){
            @Override
            public void actionPerformed(ActionEvent e) {
                guessNumbers.clear();
                message = "";
                repaint();
            }

        });

        add(sendBtn);
        add(flipCardBtn);
        add(clearBtn);
        setVisible(true);
    }

    public void resetMessage(){
        message = "";
    }

    public static NumbersPanel getNumbersPanel(){
        if(panel == null){
            panel = new NumbersPanel();
        }
        return panel;
    }

    private JButton createButton(final String thisNumber){
        JButton btn = new JButton(new AbstractAction(thisNumber){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(guessNumbers.size() < 3){
                    guessNumbers.add(thisNumber);
                    message += thisNumber;
                    repaint();
                }
            }

        });
        return btn;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.drawString(message, 60, 60);

        g.dispose();
    }
}

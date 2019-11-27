import java.awt.*;
import javax.swing.*;

public class Numeron_Prototype03 extends JFrame{
    //added this for two player
    private static boolean isPlayer1Turn = true;

    JPanel board = Board.getBoard();
    JPanel rtPanel = RecordTable.getRecordTable();
    JPanel rtPanel2 = RecordTable.getRecordTable2();
    JPanel cardEliminator1 = new CardEliminator();
    JPanel cardEliminator2 = new CardEliminator();
    JPanel numPanel = NumbersPanel.getNumbersPanel();
    JPanel rulePanel = new Rule();
//    String music = "";

    public Numeron_Prototype03(){
        super();
        setBounds(300,0,1200,800);
        setResizable(true);

        JPanel bigPanel = new JPanel();
        bigPanel.setBounds(0,0,1200,800);
        bigPanel.setLayout(new GridLayout(1,3));

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(800,0,400,800);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.add(rtPanel);
        rightPanel.add(cardEliminator1);
        rightPanel.add(numPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setBounds(400,0,400,800);
        centerPanel.setLayout(new GridLayout(1,1));
        centerPanel.add(board);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0,0,400,800);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(rtPanel2);
        leftPanel.add(cardEliminator2);
        leftPanel.add(rulePanel);

//        centerPanel.add(numPanel);//second reference to numPanel

        bigPanel.add(leftPanel);
        bigPanel.add(centerPanel);
        bigPanel.add(rightPanel);

        Dimension d = board.getSize();
        System.out.println(d);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(bigPanel);
        setVisible(true);
    }

    public static void switchPlayerTurn(){
        isPlayer1Turn = !isPlayer1Turn;
    }

    public static boolean getIsPlayer1Turn(){
        return isPlayer1Turn;
    }

    public static void main(String[] args) {
        StartUp_GUI gui = new StartUp_GUI();
    }
}

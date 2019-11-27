import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RecordTable extends JPanel{
    private static RecordTable recordTable = null;
    private static RecordTable recordTable2 = null;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private int trial;

    private RecordTable(){
        super();
        setBounds(0,0,400,200);

        EmptyBorder emptyB = new EmptyBorder(50,50,50,50);
        setBorder(emptyB);

        model = new DefaultTableModel();
        table = new JTable(model);
        scroll = new JScrollPane(table){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 150);
            }
        };
        trial = 1;

        table.setPreferredSize(new Dimension(350,300));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        table.setFillsViewportHeight(true);

        model.addColumn("Trial");
        model.addColumn("Guesses");
        model.addColumn("EAT - BITE");

        table.getColumnModel().getColumn(0).setPreferredWidth(5);

        add(scroll);
    }

    public static JPanel getRecordTable(){
        if(recordTable == null){
            recordTable = new RecordTable();
        }
        return recordTable;
    }

    public static JPanel getRecordTable2(){
        if(recordTable2 == null){
            recordTable2 = new RecordTable();
        }
        return recordTable2;
    }

    public void addRecord(String guess, int eat, int bite){
        String eat_bite = eat + " - " + bite;
        if(guess != null && eat_bite != null){
            model.addRow(new Object[]{trial, guess, eat_bite});
            trial++;
        }
        if(eat == 3){
            Board board = Board.getBoard();
            model.addRow(new Object[]{"WIN", "WIN", "WIN"});
            board.revealPlayer2Numbers();
            board.FlipPlayer1Numbers();
        }
    }
}

import java.util.*;

public class NumberManager {
    public static NumberManager numberManager = null;
    private ArrayList<String> player1_numbers = new ArrayList<String>();
    private ArrayList<String> player2_numbers = new ArrayList<String>();

    public NumberManager(){
        initializePlayerNumbers(player1_numbers);
        initializePlayerNumbers(player2_numbers);
    }

    public static NumberManager getNumberManager(){
        if(numberManager == null){
            numberManager = new NumberManager();
        }
        return numberManager;
    }

    public ArrayList<String> getPlayer2_numbers(){
        return player2_numbers;
    }

    public ArrayList<String> getPlayer1_numbers(){
        return player1_numbers;
    }

    private void initializePlayerNumbers(ArrayList<String> player_numbers){
        int random = (int)(Math.random() * 10);
        boolean isDupulicateNumberExist = true;

        while(isDupulicateNumberExist){
            player_numbers.clear();
            for(int i = 0; i < 3; i++){
                String StrNum = Integer.toString(random);
                player_numbers.add(StrNum);
                random = (int)(Math.random() * 10);
            }
            isDupulicateNumberExist = isDupulicateNumberExist(player_numbers);
        }
    }

    private boolean isDupulicateNumberExist(ArrayList<String> StrNums){
        int num1 = Integer.parseInt(StrNums.get(0));
        int num2 = Integer.parseInt(StrNums.get(1));
        int num3 = Integer.parseInt(StrNums.get(2));

        if(num1 == num2 || num1 == num3 || num2 == num3){
            return true;
        }
        else{
            return false;
        }
    }

    public void ComputeEAT_BITEandSendRecord(ArrayList<String> guess){
        ArrayList<String> opponent_numbers;
        String guess1digit = guess.get(0);
        String guess2digit = guess.get(1);
        String guess3digit = guess.get(2);
        String guessNumbers = guess1digit + guess2digit + guess3digit;

        String right1digit, right2digit, right3digit;
        //added this for two player

        if(Numeron_Prototype03.getIsPlayer1Turn()){
            right1digit = player2_numbers.get(0);
            right2digit = player2_numbers.get(1);
            right3digit = player2_numbers.get(2);
            opponent_numbers = player2_numbers;
        }
        else{
            right1digit = player1_numbers.get(0);
            right2digit = player1_numbers.get(1);
            right3digit = player1_numbers.get(2);
            opponent_numbers = player1_numbers;
        }

        int eat = 0;
        int bite = 0;

        if(guess1digit.equals(right1digit)){
            eat++;
        }
        if(guess2digit.equals(right2digit)){
            eat++;
        }
        if(guess3digit.equals(right3digit)){
            eat++;
        }

        //check bite
        for(int i = 0; i < opponent_numbers.size(); i++){
            if(i == 0){
                continue;
            }
            else if(guess1digit.equals(opponent_numbers.get(i))){
                bite++;
                break;
            }
        }
        for(int i = 0; i < opponent_numbers.size(); i++){
            if(i == 1){
                continue;
            }
            else if(guess2digit.equals(opponent_numbers.get(i))){
                bite++;
                break;
            }
        }
        for(int i = 0; i < opponent_numbers.size(); i++){
            if(i == 2){
                continue;
            }
            else if(guess3digit.equals(opponent_numbers.get(i))){
                bite++;
                break;
            }
        }

        if(Numeron_Prototype03.getIsPlayer1Turn()){
            RecordTable recordTable = (RecordTable)RecordTable.getRecordTable();
            recordTable.addRecord(guessNumbers, eat, bite);
        }
        else{
            RecordTable recordTable2 = (RecordTable)RecordTable.getRecordTable2();
            recordTable2.addRecord(guessNumbers, eat, bite);
        }
    }
}

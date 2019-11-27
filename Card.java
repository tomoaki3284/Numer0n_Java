import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Card {
    public static final String SharedImgPath = "/Users/tomoaki3284/Pictures/Numeron_Pictures/";
    private String imgPath;
    private String imgPath_eliminated;
    private Image img;
    private Image img_eliminator_eliminated;
    private Image img_eliminator_uneliminated;
    private Integer number;
    private boolean eliminated = false;

    public Card(int a){
        number = a;

        switch(a){
            case 1:
                imgPath = SharedImgPath + "1.jpg";
                imgPath_eliminated = SharedImgPath +  "1_Eliminated.jpg";
                break;

            case 2:
                imgPath = SharedImgPath + "2.png";
                imgPath_eliminated = SharedImgPath +  "2_Eliminated.png";;
                break;

            case 3:
                imgPath = SharedImgPath + "3.jpg";
                imgPath_eliminated = SharedImgPath +  "3_Eliminated.jpg";;
                break;

            case 4:
                imgPath = SharedImgPath + "4";
                imgPath_eliminated = SharedImgPath +  "4_Eliminated.jpg";;
                break;

            case 5:
                imgPath = SharedImgPath + "5.jpg";
                imgPath_eliminated = SharedImgPath +  "5_Eliminated.jpg";;
                break;

            case 6:
                imgPath = SharedImgPath + "6.jpg";
                imgPath_eliminated = SharedImgPath +  "6_Eliminated.jpg";;
                break;

            case 7:
                imgPath = SharedImgPath + "7.jpg";
                imgPath_eliminated = SharedImgPath +  "7_Eliminated.jpg";;
                break;

            case 8:
                imgPath = SharedImgPath + "8.jpg";
                imgPath_eliminated = SharedImgPath +  "8_Eliminated.jpg";;
                break;

            case 9:
                imgPath = SharedImgPath + "9.jpg";
                imgPath_eliminated = SharedImgPath +  "9_Eliminated.jpg";
                break;

            case 0:
                imgPath = SharedImgPath + "0.jpg";
                imgPath_eliminated = SharedImgPath +  "0_Eliminated.jpg";
                break;

            case -1:
                imgPath = SharedImgPath + "Card_Backside_Blue01.png";
                imgPath_eliminated = SharedImgPath + "Card_Backside_Blue01.png";
                break;

            case -2:
                imgPath = SharedImgPath + "Card_Backside_Red01.png";
                imgPath_eliminated = SharedImgPath + "Card_Backside_Red01.png";
                break;
        }
        try{
            img = ImageIO.read(new File(imgPath));

            this.img_eliminator_uneliminated = ImageIO.read(new File(imgPath));
            this.img_eliminator_uneliminated = this.img_eliminator_uneliminated.getScaledInstance(35, 50, Image.SCALE_DEFAULT);

            img_eliminator_eliminated = ImageIO.read(new File(imgPath_eliminated));
            img_eliminator_eliminated = img_eliminator_eliminated.getScaledInstance(35, 50, Image.SCALE_DEFAULT);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Integer getNumber(){
        return number;
    }

    public Image getImage(){
        return img;
    }

    public Image getImage_Eliminator_Eliminated(){
        return img_eliminator_eliminated;
    }

    public Image getImage_Eliminator_Uneliminated(){
        return img_eliminator_uneliminated;
    }

    public void switchElimination(){
        eliminated = !eliminated;
    }

    public boolean getEliminated(){
        return eliminated;
    }
}

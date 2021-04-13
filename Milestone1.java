import java.util.Random;
import java.util.Scanner;

public class Milestone1 {
    static int BlazikenAttackStat = 240;
    static int BlazikenDefenseStat = 140;
    static int BlazikenHealthStat = 160;
    static int ZapdosAttackStat = 180;
    static int ZapdosDefenseStat = 170;
    static int ZapdosHealthStat = 180;

    static String[] ZapdosAttacks = {"ThunderBolt" , "Charge Beam"};
    static String[] BlazikenAttacks = {"Flare Blitz" , "Blaze Kick"};


    public static void combatLoop(){
        Scanner inp = new Scanner (System.in);
        Random r = new Random();

        int randomNum = r.nextInt(ZapdosAttacks.length);
        int BlazikenAttack;
        int ZapdosAttack;


        System.out.println("Choose an attack: \n0: FlareBlitz \n1: Blaze Kick");
        int move = inp.nextInt();

        //Blaziken's turn
        if (move == 0) {
            System.out.println("Blaziken used " + BlazikenAttacks[0] + "!");
            BlazikenAttack = BlazikenAttackStat - ZapdosDefenseStat;
            ZapdosHealthStat = ZapdosHealthStat - BlazikenAttack;

            if (ZapdosHealthStat > 0) {
                System.out.println("Zapdos has " + ZapdosHealthStat + "HP left.\n");
            }
            if (ZapdosHealthStat <= 0) {
                System.out.println("Zapdos has 0HP left\n");
            }

            //Zapdos's turn
            if (ZapdosHealthStat > 0) {
                System.out.println("Zapdos used " + ZapdosAttacks[randomNum] + "!");
                ZapdosAttack = ZapdosAttackStat - BlazikenDefenseStat;
                BlazikenHealthStat = BlazikenHealthStat - ZapdosAttack;

                if (BlazikenHealthStat > 0) {
                    System.out.println("Blaziken has " + BlazikenHealthStat + "HP left.\n");
                }
                if (BlazikenHealthStat <= 0) {
                    System.out.println("Blaziken has 0HP left.\n");
                }
            }
        //Blaziken's turn
        } else if (move == 1) {
            System.out.println("Blaziken used " + BlazikenAttacks[1] + "!");
            BlazikenAttack = BlazikenAttackStat - ZapdosDefenseStat;
            ZapdosHealthStat = ZapdosHealthStat - BlazikenAttack;

            if (ZapdosHealthStat > 0) {
                System.out.println("Zapdos has " + ZapdosHealthStat + "HP left.\n");
            }
                if (ZapdosHealthStat <= 0) {
                    System.out.println("Zapdos has 0HP left.\n");
                }

                //Zapdos's turn
                if (ZapdosHealthStat > 0) {
                    System.out.println("Zapdos used " + ZapdosAttacks[randomNum]);
                    ZapdosAttack = ZapdosAttackStat - BlazikenDefenseStat;
                    BlazikenHealthStat = BlazikenHealthStat - ZapdosAttack;
                    System.out.println("Blaziken has " + BlazikenHealthStat + "HP left.\n");
                    if (BlazikenHealthStat <= 0){
                        System.out.println("Blaziken has 0HP left.\n");
                }
            }

        }
    }

    public static boolean gameOver() {
        if (ZapdosHealthStat <=  0) {
            System.out.println("Blaziken Won!");
            return true;
        } else if (BlazikenHealthStat <= 0) {
            System.out.println("Zapdos won :(");
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("You encountered a wild Zapdos, Your only option is to attack!!!");
        do {
            combatLoop();
        } while (!gameOver()) ;
    }
}
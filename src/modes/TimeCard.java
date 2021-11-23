package src.modes;

import java.util.Scanner;

public class TimeCard {
    private int checkIn; //entrada
    private int checkOut; //saida
    private int exeededTime; //Tempo a mais

    Scanner scan = new Scanner(System.in);
    
    public TimeCard(){ //método construtor
       this.exeededTime = 0;
       this.checkIn = 0;
       this.checkOut = 0;
    }

    public void setCheckIn(int checkIn){
        
        this.checkIn = checkIn;
    }
    public int getCheckIn() {
        return this.checkIn;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }
    public int getCheckOut() {
        return this.checkOut;
    }
    public void setExeededTime(int exeededTime) {
        this.exeededTime = exeededTime;
    }

    public int getExeededTime() {
        return this.exeededTime;
    }



}

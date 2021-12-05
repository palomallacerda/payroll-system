package src.modes;

import java.time.LocalDate;
import java.util.Scanner;

public class TimeCard {
    private int checkIn; //entrada
    private int checkOut; //saida
    private int workedhours;
    private int exeededTime; //Tempo a mais
    private String today;
    
    Scanner scan = new Scanner(System.in);
    
    public TimeCard(){ //método construtor
       this.exeededTime = 0;
       this.checkIn = 0;
       this.checkOut = 0;
    }

    public void setWorkedhours(int in, int out) {
        this.workedhours = out-in;
        setCheckIn(in);
        setCheckOut(out);
    }
    public int getWorkedhours() {
        return workedhours;
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
    public void setExeededTime() {
        this.exeededTime = this.workedhours-8;
    }

    public int getExeededTime() {
        return this.exeededTime;
    }

    public void setToday() {
        this.today = LocalDate.now().toString();
    }
    public String getToday() {
        return this.today;
    }
    public void printTimecard(){
        System.out.println("[Date] "+ this.getToday());
        System.out.println("[Cheack in] "+ this.getCheckIn());
        System.out.println("[Cheack Out] "+ this.getCheckOut());
        System.out.println("[ExeededTime] "+ this.getExeededTime());
        System.out.println("[Worked hours] "+ this.getWorkedhours());
    }


}

package src.ultis;
import java.util.Scanner;


public class UpdateEmployee {
    public void Update(){
        Scanner scan = new Scanner(System.in);
        int key;
        
        while(true){
          System.out.println("What option would you like to update:");
          System.out.println("[1] - Name");
          System.out.println("[2] - Address");
          System.out.println("[3] - Employee type");
          System.out.println("[4] - Paymente way");
          System.out.println("[5] - Belong to Syndicate");
          
          key = scan.nextInt();                    
          switch(key){
              case 1:
                  System.out.println("Change Name");
                  break;
              case 2:
                  System.out.println("Change Adress");
                  break;
              case 3:
                  System.out.println("Change Employee type");
                  break;
              case 4: 
                  System.out.println("Change paymente way");
                  break;
              case 5:
                  System.out.println("Change Syndicate status");
                  break;
              default:
                  System.out.println("Invalid input");
                  break;
            }

        }  
    }
}

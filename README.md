# Payroll-system

<!-- ### <p align="center" > 🚧  Project still in progress 🚀 🚧 -->

<p align ="justify"> The goal of the project is to build a payroll system. The system consists in the management of the employees's payments in a company. In addition, the system must manage the data of these employees, such as timecards. Employees must receive their their salary at the correct time, using the method they prefer, obeying various rates and taxes deducted from the salary.</p>


| Function |             Title               |     Progress      | Extra function |
|:--------:|:-------------------------------:|:---:              | :-------------:|
|     0    |  List all                       | ✅                | Yes            |
|     1    |  Add an employee                | ✅                | No             | 
|     2    |  Remove an employee             | ✅                | No             |
|     3    |  Post a timecard                | ✅                | No             |
|     4    |  Post sales result              | ✅                | No             |
|     5    |  Post a servece tax             | ✅                | No             |
|     6    |  Update employee details        | ✅                | No             |
|     7    |  Run today's payroll            | ✅                | No             |
|     8    |  Undo/Redo                      | ✅                | No             |
|     9    |  Scheduel payment               | ✅                | No             |
|    10    |  Create a new Scheduel payment  | ✅                | No             |
|    11    |  Leave                          | ✅                | Yes            |

## Code Smells founded

- *Bloaters*
    - Founded in PaymentScheduel Long Method
        - Line 87 untill 151   (Created a new method 'scheduelRuning' to fix it) and by so extracting the method
#### Before 
``` java
public void changePaymentSchedules(LinkedList<String> schedueles, LinkedList<Employees> employee){
        
        while(true){
            System.out.println("\n--------- Here is all the Avalible Scheduel options -----------");
            listAvalibleSchedules(schedueles);
            System.out.println("\n\nRemember by default all:\n----------------------\n\nHourly [weekly 1 friday]\nComissioned [monthly $]\nSalaried [weekly 2 friday]");
            System.out.println("----------------------");
            System.out.println("\nWould you like to:");
            System.out.println("[1] - Change a scheduel");
            System.out.println("[2] - Keep as default (Exit)");
            
            option = scan.nextInt();
           
            switch(option){
                case 1:
                    System.out.println("\nEnter the employee ID");
                    int id = scan.nextInt();
                    auxEmp = find.find(employee, id);
                    if(auxEmp.getName() == null){
                        System.out.println("Not a valid Id - Try again");
                        changePaymentSchedules(schedueles, employee);
                    }   
                    else{
                        System.out.println(auxEmp.getName()+"Is now a "+auxEmp.getPaymentScheduel());
                        System.out.println("\nWhat new scheduel would you like to put:");
                        listAvalibleSchedules(schedueles);
                        int index = scan.nextInt();
                        for(int i = 0; i < schedueles.size(); i++){
                            if(index == i){
                                changeScheduel = schedueles.get(i);
                            }
                        }

                        if(changeScheduel == null){
                            System.out.println("Option invalid");
                        }
                        else{
                            if(auxEmp.getPaymentScheduel().equals(changeScheduel)){
                                System.out.println("\n---- There is nothing to change----");
                                System.out.println(" ----You already has this scheduel ----");
                            }
                            else{
                                auxEmp.setPaymentScheduel(changeScheduel);
                                System.out.println("Sucessfully changed to "+changeScheduel);
                                System.out.println("\nClick [Enter] to continue");
                                scan.nextLine();
                                scan.nextLine();
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("######### Okay, say bye! #######");
                    return;
                default:
                    System.out.println("Invalid option\nTry Again!");
                    changePaymentSchedules(schedueles, employee);
                    break;
            }
        
        }
        
    }
``` 
#### Now
``` java
public void changePaymentSchedules(LinkedList<String> schedueles, LinkedList<Employees> employee)
{ 
    while(true){
        System.out.println("\n--------- Here is all the Avalible Scheduel options -----------");
        listAvalibleSchedules(schedueles);
        System.out.println("\n\nRemember by default all:\n----------------------\n\nHourly [weekly 1 friday]\nComissioned [monthly $]\nSalaried [weekly 2 friday]");
        System.out.println("----------------------");
        System.out.println("\nWould you like to:");
        System.out.println("[1] - Change a scheduel");
        System.out.println("[2] - Keep as default (Exit)");
        
        option = scan.nextInt();
        
        switch(option){
            case 1:
                System.out.println("\nEnter the employee ID");
                int id = scan.nextInt();
                auxEmp = find.find(employee, id);
                if(auxEmp.getName() == null){
                    System.out.println("Not a valid Id - Try again");
                    changePaymentSchedules(schedueles, employee);
                }   
                else{
                    scheduelRuning(schedueles);
                }
                break;
            case 2:
                System.out.println("######### Okay, say bye! #######");
                return;
            default:
                System.out.println("Invalid option\nTry Again!");
                changePaymentSchedules(schedueles, employee);
                break;
        }
    
    }
}
private void scheduelRuning(LinkedList<String> schedueles){
    System.out.println(auxEmp.getName()+"Is now a "+auxEmp.getPaymentScheduel());
    System.out.println("\nWhat new scheduel would you like to put:");
    listAvalibleSchedules(schedueles);
    int index = scan.nextInt();
    for(int i = 0; i < schedueles.size(); i++){
        if(index == i){
            changeScheduel = schedueles.get(i);
        }
    }
    if(changeScheduel == null){
        System.out.println("Option invalid");
    }
    else{
        if(auxEmp.getPaymentScheduel().equals(changeScheduel)){
            System.out.println("\n---- There is nothing to change ----");
            System.out.println(" ---- You already has this scheduel ----");
        }
        else{
            auxEmp.setPaymentScheduel(changeScheduel);
            System.out.println("Sucessfully changed to "+changeScheduel);
            System.out.println("\nClick [Enter] to continue");
            scan.nextLine();
            scan.nextLine();
        }
    }
}   
```
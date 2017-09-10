 /**
 * @student xxxxx
 * @author fekiee
 * @email xxxxxxxx@xxxxx.com
 *****************************************************************************************************************************************/

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.util.ArrayList;
 import java.io.BufferedWriter;
 import java.io.InputStreamReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.FileNotFoundException;
 import java.io.File;

 public class appendix{

    static String archivo = "Student.txt";// Create a String variable to store the name of the file to be read/written
    static File f = new File( archivo );// Create an instance of File using the fileName
    static ArrayList<Student> list = new ArrayList<Student>();// The ArrayList will store String[] ( String arrays )
    static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));// Declare BufferedWriter to get input from user
    static boolean hey = false;//Static boolean

      //============================================//
     //              MAIN METHOD                   // 
    //============================================//
    public static void main(String[] args) {

        getting();// placing all text content to the ArrayList to be handled
        
        displayMenu();// to the  menu.

    }//END OF THE MAIN METHOD
    
      //============================================//
     // GETTING  METHOD // Method to read the file //
    //============================================//
    public static void getting(){

        FileReader leer = null;// Create an instance of the FileReader using the File ( global )
        
        String[] data;// Declare an array to store the data from each line of the file
        
        try {

            leer = new FileReader( f );
        } catch (FileNotFoundException e) {
            System.out.println("\nError creating FileReader\n");
        }
        
        BufferedReader in = new BufferedReader( leer );// Create an instance of BufferedReader to read the file
        
        String str = "";// Create variable to store each line of the file
        
        try{

            str = in.readLine();// Read the first line
            
            while( str != null ){// If the first line is not null keep reading the file

                data = str.split(";");// split the line based on ";" and store the result into the data array
                
                Student s = new Student();// Create an instance of the Student object
                
                // Assign values for the attribute of the object
                s.setStudentNumber( Integer.parseInt( data[0] )); 
                s.setLastName( data[1] );
                s.setFirstName( data[2] );
                s.setEmail( data[3] );
                s.setPhoneNumber( Integer.parseInt( data[4] ));
                
                list.add( s );// Stores the Student object into the list
                
                str = in.readLine();// Read the next line
                
            }
        } catch( IOException ioe ){

            System.out.println("Error reading file");

            
        }catch(NumberFormatException nuE){//To catch the format errors

            System.out.println("Error in format data file");
        }
        
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Error closing BufferedWriter");
        }
    }//END OF GETTING METHOD

      //==============================================================//
     // DISPLAY MENU  METHOD // Method to display the principal menu //
    //==============================================================//
    public static void displayMenu(){

        int option = 0;// Create variable to store the input from user

        welcomen();

        do{//Loop to interate until 0 is pressed

            //Menu options
            System.out.println("\n----------------------------------------------\n");
            System.out.println("    \n     Menu\n");
            System.out.println(" 1   Add new Student");
            System.out.println(" 2   Search for a Student");
            System.out.println(" 3   Display details of a Student");
            System.out.println(" 4   Modify details of a Student");
            System.out.println(" 5   Delete a Student");
            System.out.println(" 0   Exit ");
            System.out.println("\n----------------------------------------------\n");
            
            System.out.print(" Enter an option: ");


            try{//create a try and catch block to get user inputs and catch any error

                option = Integer.parseInt( br.readLine() );//Parsing the input from users
            } catch( IOException ioe ){
                System.out.println("There was something wrong with the input entered");
            } catch( NumberFormatException e ){

                option = 9; // This option set to 9 will allow getting erros from input

            }
            
            switch( option ){// Switch to choose a method depending on input from users 

                case 1:

                addNewStudent();// Calling Adding New Student Method 
                break;

                case 2:

                searchStudent();// Calling Search Student Method 
                break;

                case 3:

                displayDetails();// Calling Display Details Method 
                break;

                case 4:

                modifyDetails();// Calling Modify Details Method 
                break;

                case 5:

                deleteStudent();// Calling Delete Student Method 
                break;

                case 0:

                closePr();// Closing the program method and saving all elements to the Text file.
                System.out.println("Details Saved");
                break;

                default:

                System.out.println("\nYou did not enter a valid option. Please, try it again\n");

                break;
            }      
        } while ( option != 0 );
    }//END OF DISPLAY MENU METHOD

    
      //===================================================================================================//
     // SEARCH STUDENT  METHOD // Method to search students by studendt number, last name and first  name // 
    //===================================================================================================//
    
    public static void searchStudent(){

        int a = 0;//store the input form users

        do {//Creating a loop for using the menu until users press 0

                //Menu to be displayed
            System.out.println("\n----------------------------------------------\n");
            System.out.println ("\n              SEARCH STUDENT BY \n");
            System.out.println ("1  Student Number ");
            System.out.println ("2  Last Name ");
            System.out.println ("3  First Name ");
            System.out.print ("0  Back To Main Menu \n\n");
            System.out.println("\n----------------------------------------------\n");
            System.out.print("\n  Enter an option: ");

            try {

                a = Integer.parseInt(br.readLine());//Getting inputs from users

            }

            catch (IOException e){

                System.out.println("Looks like something went wrong try again");//Message to be shown when an error occur
            }

            catch(NumberFormatException nfe){

                a = 7;
            }
            //switching between options
            switch (a){
                //------------------------------- Searching  Student by Number -----------------------------------------//
                case 1:
                System.out.println("\n----------------------------------------------\n");
                System.out.print("Enter the Student Number: "  );

                try{
                                //store student number
                    int stndtNumb = Integer.parseInt(br.readLine());

                                //checking up the list//
                    for (int x=0; x<list.size();x++){

                        if (list.get(x).getStudentNumber() == stndtNumb){
                            hey = true;//boolean set to true in case condition is valid

                            //Details to be printed
                            System.out.println("\n                Student   Details");
                            System.out.println();
                            System.out.println("Student number: "+list.get(x).getStudentNumber());
                            System.out.println("Last Name:      "+list.get(x).getLastName());
                            System.out.println("First Name:     "+list.get(x).getFirstName());
                            System.out.println("Email:          "+list.get(x).getEmail());
                            System.out.println("Phone number:   "+list.get(x).getPhoneNumber()+"\n");
                            
                        }//End if condition
                        else { 
                            hey =false;//boolean false in case condition is broken
                        }//End of else
                    }//End for loop

                    if( hey ==false)//message to be displayed in case a student has not been found
                    System.out.println("\n\t\t\tStudent Not found\n");
                }catch( IOException ioe ){

                    System.out.println("Input Error");        
                }catch(NumberFormatException nfe){

                    System.out.println("\n===============================================\n");
                    System.out.println("\tInvalid Input, try again");
                    System.out.println("\n===============================================\n");
                    a = 7;
                }

                break;

                case 2://------------------------------- Searching  Student by Last Name -----------------------------------------//
                
                hey= false;
                System.out.println("\n----------------------------------------------\n");

                System.out.print("Enter the Student Last Name: "  );

                try{
                                //store student name
                    String stndtLName = br.readLine();
                    System.out.println("\n----------------------------------------------\n");

                                //checking up the list//
                    for (int x=0; x<list.size();x++){

                        if (list.get(x).getLastName().contains(stndtLName)){ 
                            hey = true;

                            //Student details to be displayed
                            System.out.println("\n                Student   Details");
                            System.out.println();
                            System.out.println("Student number: "+list.get(x).getStudentNumber());
                            System.out.println("Last Name:      "+list.get(x).getLastName());
                            System.out.println("First Name:     "+list.get(x).getFirstName());
                            System.out.println("Email:          "+list.get(x).getEmail());
                            System.out.println("Phone number:   "+list.get(x).getPhoneNumber()+"\n");
                            
                            }//End of if condition

                        }//end of For Loop
                        if( hey==false){
                           System.out.println("\n===============================================\n");
                           System.out.println("\tStudent not found, try again");
                           System.out.println("\n===============================================\n");
                       }

                   }catch( IOException ioe ){

                    System.out.println("Input Error");        
                }catch(NumberFormatException nfe){

                    System.out.println("\n===============================================\n");
                    System.out.println("\tInvalid Input, try again");
                    System.out.println("\n===============================================\n");
                    //a = 7;
                }

                break;

                case 3://------------------------------- Searching  Student by First Name -----------------------------------------//
                hey = false;
                System.out.println("\n----------------------------------------------\n");
                System.out.print("Enter the Student First Name: "  );

                try{

                    String stndtName = br.readLine();//store student name
                    System.out.println("\n----------------------------------------------\n");
                                //checking up the list//
                    for (int x=0; x<list.size();x++){//for loop to check the whole list

                        if (list.get(x).getFirstName().contains(stndtName)){ 
                            hey = true;//Boolean set to true in case condition is valid

                            //Student details to be displayed
                            System.out.println("\n                Student   Details");
                            System.out.println();
                            System.out.println("Student number: "+list.get(x).getStudentNumber());
                            System.out.println("Last Name:      "+list.get(x).getLastName());
                            System.out.println("First Name:     "+list.get(x).getFirstName());
                            System.out.println("Email:          "+list.get(x).getEmail());
                            System.out.println("Phone number:   "+list.get(x).getPhoneNumber()+"\n");
                            
                        }//End of if condition

                    }//end of for loop
                    if( hey==false){
                       System.out.println("\n===============================================\n");
                       System.out.println("\tStudent not found, try again");
                       System.out.println("\n===============================================\n");
                   }

               }catch( IOException ioe ){

                System.out.println("Input Error");        
            }catch(NumberFormatException nfe){

                System.out.println("\n===============================================\n");
                System.out.println("\tInvalid Input, try again");
                System.out.println("\n===============================================\n");
                    //a = 7;
            }

            break;

            case 0:

                //back To Menu
            break;

            default:

            System.out.println ("\n Not a valid option.\n");
        }

    }while(a !=0);

    }//END OF SEARCH FOR A STUDENT METHOD//END OF SEARCH FOR A STUDENT METHOD

      //=========================================================================//
     // ADD NEW STUDENT  METHOD // Method to add a new student to the arrayList //
    //=========================================================================//
    public static void addNewStudent(){

            String[] details = new String[5];// Storing input from the user

            Student s = new Student();// Create an Student object and set the value of the attributes

            
            do{//Loop until boolean is false

                try{ 

                    /* Ask users for details to set them */

            //:::::::::::::::::::::::: Student number
                    System.out.println("\n----------------------------------------------\n");
            System.out.println("\tEnter Student:");//Asking for Student Number
            System.out.println("\n----------------------------------------------\n");
            System.out.print("Number:       ");//Asking for Student Number
            
            details[0] = br.readLine();// Get student number
            s.setStudentNumber( Integer.parseInt(details[0]) );//Setting values and parsing
            

            //:::::::::::::::::::::::: Student Last Name
            System.out.print("Last Name:    ");// Get student last name
            
            details[1] = br.readLine();// Get student last name
            s.setLastName( details[1] );//Setting values

            //:::::::::::::::::::::::: Student First Name
            System.out.print("Name:         ");// Get student first name
            
            details[2] = br.readLine();//Get the student first name
            s.setFirstName( details[2] );//Setting values


            //:::::::::::::::::::::::: Student email
            System.out.print("e-mail:       "); // Get student email
            
            details[3] = br.readLine();
            s.setEmail(details[3]);

            //:::::::::::::::::::::::: Student phone number
            System.out.print("Phone Number: ");// Get student phone number

            details[4] = br.readLine();//get the student phone number 
            s.setPhoneNumber( Integer.parseInt(details[4]) );// setting values
            hey=true;
            System.out.println("\n----------------------------------------------\n");

            } catch( IOException ioe ){//catching format errors and displaying messages 
                System.out.println("\n===============================================\n");

                System.out.println("\tError getting details from user ");
                System.out.println("\n===============================================\n");
            }
            catch (NumberFormatException nfe){

                System.out.println("\n===============================================\n");
                System.out.println("\tInvalid Input, try again");
                System.out.println("\n===============================================\n");
            }
        }while(hey==false);

        char confirme=' ';


        try{     
                        System.out.print("\nPress enter 'Y' to confirm or 'N' to cancel ");//Ask users to confirm deleting
                        confirme = br.readLine().toLowerCase().charAt(0);//Get user inputs 

                    }catch( IOException ioe ){
                        System.out.println("Input Error, try over again");
                    }
                    
                    switch(confirme){//choose wheater deleting student or canceling

                        case 'y'://confirm to delete
                        list.add( s );// Add student details to the list
                        System.out.println("\n----------------------------------------------\n");
                        System.out.println("\nStudent have been added Succefully ");// inform user that the new student was added to the list
                        System.out.println("\n----------------------------------------------\n");
                        break;
                        
                        case 'n'://canceling
                        System.out.println("\n----------------------------------------------\n");
                        System.out.println("\nStudent have not been added ");
                        System.out.println("\n-----------------------------------------------\n\n");
                        break;
                        
                        default:
                        
                        System.out.println("\n===============================================\n");
                        System.out.println("\tInvalid Input, try again");
                        System.out.println("\n===============================================\n");

                        break;

                    }//End of the switch

                    closePr();
                }

      //==============================================================================================//
     // CLOSE  METHOD // Method to close the application and store all the elements to the text file //
    //==============================================================================================//
                public static void closePr(){

        FileWriter fw = null;// Create FileWriter
        

        try {
            fw = new FileWriter( f );//Creating a File
        } catch (IOException e) {
            System.out.println("Error creating FileWriter");
        }

        BufferedWriter out = new BufferedWriter( fw );// Create BufferedWriter
        
        try{

            for ( int x = 0; x < list.size() ; x++ ){

                //Storing all student details to the text file
                out.write( list.get(x).getStudentNumber() + ";"); // write student number to the file
                out.write( list.get(x).getLastName()      + ";"); // write student first name
                out.write( list.get(x).getFirstName()     + ";"); // write student last name
                out.write( list.get(x).getEmail()         + ";"); // write student email
                out.write( list.get(x).getPhoneNumber()   + ";"); // write student phone number
                
                out.write(System.getProperty("line.separator")); // break line
                
            }
            
        } catch( IOException ioe ){
            System.out.println("Error writing to the buffer");
        }
        
        // close BufferedWriter
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error closing BufferedWriter");
        }
        
    }//END OF THE CLOSE METHOD


      //========================================================================//
     // DISPLAY STUDENT DETAILS METHOD // Method to display students detail by // 
    //========================================================================//
    public static void displayDetails(){
        hey = false;
        //Message to be shown
        System.out.println("\n----------------------------------------------\n");

        System.out.print("Enter the Student Number: "  );

        try{

            int studentN = Integer.parseInt(br.readLine());//store student number
            System.out.println("\n----------------------------------------------\n");

            for (int x=0; x<list.size();x++){//checking up the list//

                if (list.get(x).getStudentNumber() == studentN) {
                    hey=true;

                    //Printing Student details to the screen
                    System.out.println("\n----------------------------------------------\n");

                    System.out.println("\n                Student   Details");
                    System.out.println();
                    System.out.println("Student number: "+list.get(x).getStudentNumber());
                    System.out.println("Last Name:      "+list.get(x).getLastName());
                    System.out.println("First Name:     "+list.get(x).getFirstName());
                    System.out.println("Email:          "+list.get(x).getEmail());
                    System.out.println("Phone number:   "+list.get(x).getPhoneNumber()+"\n");
                    System.out.println("\n----------------------------------------------\n");

                }//end of if condition
            }//end of for loop
            if( hey==false){
             System.out.println("\n===============================================\n");
             System.out.println("\tStudent not found, try again");
             System.out.println("\n===============================================\n");

         }

     }catch (NumberFormatException nfe){
        System.out.println("\n===============================================\n");
        System.out.println("\tInvalid Input, try again");
        System.out.println("\n===============================================\n");
    }catch( IOException ioe ){

        System.out.println("\n===============================================\n");
        System.out.println("\tInvalid Input, try again");
        System.out.println("\n===============================================\n");        
    }

    }// END OF DISPLAY DETAILS METHOD

      //===========================================================//
     // MODIFY STUDENT METHOD // Method to modify student details //
    //===========================================================//
    public static void modifyDetails(){

        int k = 0;//counter to store our variable in the loop to be used later on
        int studntNumb = -1;//Store variable and set at -1 to start from 0
        int counter=0;//store the variable from the loop
        
        System.out.println("\n----------------------------------------------\n");

        System.out.print("Please, enter the Student Number: "  );

        try{
            studntNumb = Integer.parseInt( br.readLine() );// parsing and getting user input
            hey=false;
            for ( int x = 0; x < list.size() ; x++ ){//Checking all over the list


                if (list.get(x).getStudentNumber() == studntNumb){//check if the student number is in the list
                     hey=true;//if the condition happens set boolean to true
                     k=x;//Storing our variable x in the k to be use outside of the loop


                }//End of the if condition
            }//End of the for loop

            if (hey==true){ 

                System.out.println("\n----------------------------------------------\n");
                    System.out.println("Remember, the current details will be overwritten ");//Warning before rewriting
                    System.out.println("\n----------------------------------------------\n");

                    //Printing Student details to the screen
                    System.out.println("----------------------------------------------");
                    System.out.println("\n      Student   Details to be modified");
                    System.out.println();
                    System.out.println("Student number: "+list.get(k).getStudentNumber());
                    System.out.println("Last Name:      "+list.get(k).getLastName());
                    System.out.println("First Name:     "+list.get(k).getFirstName());
                    System.out.println("Email:          "+list.get(k).getEmail());
                    System.out.println("Phone number:   "+list.get(k).getPhoneNumber()+"\n");
                    System.out.println("\n----------------------------------------------\n");

                    System.out.println("\n----------------------------------------------\n");
                    System.out.println("\n\tModifying Student Details\n");

                    //Asking for details to be modified
                    System.out.print("Enter Last Name:      ");
                    list.get(k).setLastName(br.readLine());//Get a New student Last Name

                    System.out.print("Enter First Name:     ");
                    list.get(k).setFirstName(br.readLine());//Get a New student First Name
                    
                    System.out.print("Enter Email:          ");
                    list.get(k).setEmail(br.readLine());// Get a New student Email 

                    System.out.print("Enter Number Phone:   ");
                    list.get(k).setPhoneNumber(Integer.parseInt (br.readLine()));// Get a New student Number Phone

                    System.out.println("\n----------------------------------------------\n");
                    System.out.print("\nPress enter to confirm ");
                    br.readLine();
                    closePr();
                    System.out.println("\n----------------------------------------------\n");
                    System.out.println("\n\n\tStudent details modified");//Message to be shown once all details are modified
                    //Printing Student details to the screen
                    System.out.println("\n----------------------------------------------\n");
                    System.out.println("\n                Student   Details");
                    System.out.println();
                    System.out.println("Student number: "+list.get(k).getStudentNumber());
                    System.out.println("Last Name:      "+list.get(k).getLastName());
                    System.out.println("First Name:     "+list.get(k).getFirstName());
                    System.out.println("Email:          "+list.get(k).getEmail());
                    System.out.println("Phone number:   "+list.get(k).getPhoneNumber()+"\n");
                    System.out.println("\n----------------------------------------------\n");
                }//end if condition
                else{
                   System.out.print("\n\nIncorrect Student number, please enter student number \n");
               }

           } catch( IOException ioe ){
            System.out.println("input error");

        } catch( NumberFormatException nfe ){

            System.out.println("Invalid input"); 
        }

    }// End of modify details method 


      //=====================================================//
     // DELETE STUDENT METHOD // Method to delete a student //
    //=====================================================//
    public static void deleteStudent(){
        hey = false;
        char confirm=' ';//declare a char to store input users to confirm

        int studntNumero = -1;//Store variable and set at -1 to start from 0

        do{

            System.out.println("\n----------------------------------------------\n");

            System.out.print("Enter the Student Number: "  );

            try{

                studntNumero = Integer.parseInt( br.readLine() );//get user inputs and parse them

                for ( int x = 0; x < list.size() ; x++ ){//Check the list

                    if (list.get(x).getStudentNumber() == studntNumero){//Comparing
                        hey=true;
                         //Printing Student details to the screen
                        System.out.println("\n----------------------------------------------\n");
                        System.out.println("\n                Student   Details");
                        System.out.println();
                        System.out.println("Student number: "+list.get(x).getStudentNumber());
                        System.out.println("Last Name:      "+list.get(x).getLastName());
                        System.out.println("First Name:     "+list.get(x).getFirstName());
                        System.out.println("Email:          "+list.get(x).getEmail());
                        System.out.println("Phone number:   "+list.get(x).getPhoneNumber()+"\n");
                        System.out.println("\n----------------------------------------------\n");

                        try{     
                            System.out.print("\nPress enter 'Y' to confirm or 'N' to cancel ");//Ask users to confirm deleting
                            confirm = br.readLine().toLowerCase().charAt(0);//Get user inputs 

                        }catch( IOException ioe ){
                            System.out.println("Input Error, try over again");
                        }
                        
                        switch(confirm){//choose wheater deleting student or canceling

                            case 'y'://confirm to delete
                            list.remove(list.get(x));
                            System.out.println("\n----------------------------------------------\n");
                            System.out.println("\n\tStudent  deleted sucesfully");
                            // System.out.print("Press enter to go back to main menu ");
                            // br.readLine();

                            break;
                            case 'n'://canceling
                            System.out.println("\n----------------------------------------------\n");
                            System.out.println("\n\tStudent have not been deleted");
                            System.out.println("\n-----------------------------------------------\n\n");
                            // System.out.print("Press enter to go back to main menu ");
                            // br.readLine();
                            break;

                            default:

                            System.out.println("\n----------------------------------------------\n");
                            System.out.println("\n\tOption invalid try once again");
                            System.out.println("\n-----------------------------------------------\n\n");
                            break;

                        }//End of the switch
                        
                    }//End of if condition
                    
                }//End of for loop  
                
            } catch( IOException ioe ){
                System.out.println("Input Error, try over again");

            } catch( NumberFormatException nfe ){

                System.out.print("invalid input ");  
            }
            if(hey==false){//condition in case student number is not found
                System.out.println("----------------------------------------------\n");
                System.out.println("\n\tIncorrect student number");
                System.out.println("\n-----------------------------------------------\n");
                    //break;  
            }//end of if statement

        }while(hey == false);

    }// End of delete student method

    public static void welcomen(){

        System.out.println("\n\n----------.-~*'¨¯¨'*·~-.¸-(_( JinSystems © )_)-,.-~*'¨¯¨'*·~-.----------\n\n");
        
    }


}//End of the class

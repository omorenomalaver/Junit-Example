import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Convertor {
    /**
     * this function does offer to user a menu option.
     */
    
    private static String errorText = "Value or choose enter is wrong"; 
    public void menuOption()
    {
        // Create a string array to save each sentence user can choose
        String[] menuOption = new String[7];
        menuOption[0] = "Welcome to convertor Program.\n";
        menuOption[1] = "Enter 0 to convert Cm to Inch.\n";
        menuOption[2] = "Enter 1 to convert Meters to Feet\n";
        menuOption[3] = "Enter 2 to convert Celsius to Fahrenheit\n";
        menuOption[4] = "Enter 3 to convert Cm to Fee\n";
        menuOption[5] = "Enter 4 to convert Miles to Kilometres\n";
        menuOption[6] = "Enter 5 to exit\n";
        
        String mesageBox = "";
        int userSelection = 0;
        
        // add all array of message in only one variable to show user
        for(String tmpMsg: menuOption)
        {
            mesageBox = mesageBox + tmpMsg;
        }
        // then the program ask to user a number to start conversion program
        Object variableValidate = JOptionPane.showInputDialog(mesageBox,JOptionPane.YES_OPTION );
        if(validateUserSelection(variableValidate))
        {
            userSelection = Integer.parseInt(variableValidate.toString());
            if(userSelection!=5)
                showResult(userSelection);
            else
                exitProgram();
        }
        else
        {
            JOptionPane.showMessageDialog(null, errorText);
            menuOption();
        }
        // if the value user enter is 5 or more, the program will finish, lest than 5 the program goes to showResult
        
    }

    private boolean validateUserSelection(Object variableValidate)
    {
        boolean result = false;
        if(isNumber(variableValidate))
        {
            if(variableValidate==null)
                return false;
            if(Integer.parseInt(variableValidate.toString())<6)
                return true;
        }
        return result;
    }
    
    private boolean isNumber(Object value)
    {
        try {
            if(value==null)
                return false;
            int num = Integer.parseInt(value.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isDouble(Object value)
    {
        try {
            if(value==null)
                return false;
            double num = Double.parseDouble(value.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * this function expected a value between 0 to 4, 
     * where 0 is convert cm to inches, 
     * 1 is convert meters to feet, 
     * 2 convert Celsius to Fahrenheit, 
     * 3 convert cm to feet
     * 4 convert miles to kilometers
     */
    private void showResult(int userSelection)
    {
        double calculation=0;
        double convertValue=0;
        String messageBox ="";
        String[] questionnarie = {"CM","Meter","Celsius","CM","Miles"}; // this array keeps all convertion selection definition
        String[] answer = {"Inches","Feet","Fahrenheit","Feet","Kilometres"}; // this array kkeps all convertion text results
        double[] equations = {0.39,3.2808,32,0.3,1.8000}; // this array keeps all values of convertion
        
        // firstly the program shows a message where ask the nombre a convert, it also create a string text using userSelection variable and arrays questionnarie and answer
        Object userValue = JOptionPane.showInputDialog("Enter "+questionnarie[userSelection]+" to convert in " + answer[userSelection]+ " , please",JOptionPane.OK_OPTION);
        if(isDouble(userValue))
        {
            convertValue = Double.parseDouble(userValue.toString());
            // Rounded user value
            convertValue = roundValues(convertValue);
            // then the program identify what kind of conversion user choose
            calculation = calculate(userSelection,convertValue);
            // finally the program create a message where it shows a result of convertion,  using again arrays to identify value fron and to convert 
            messageBox = convertValue + " in "+ questionnarie[userSelection] +" is " + answer[userSelection]+ ": " + calculation;
            JOptionPane.showMessageDialog(null, messageBox);
            // back to menuoption
            menuOption();
        }
        else
        {
            JOptionPane.showMessageDialog(null, errorText);
            showResult(userSelection);
        }
        
    }
    
    private double roundValues(double valueToRound)
    {
        double result;
        DecimalFormat df = new DecimalFormat("0.00");
        result = Double.valueOf(df.format(valueToRound));
        return result;
    }
    
    public double calculate(int userSelection, double convertValue)
    {
        double result;
        double[] equations = {0.39370,3.2808,32,0.032808,0.62137}; // this array keeps all values of convertion
        switch(userSelection){
            case 0: 
                // Cm to Inches conversion 
                result = roundValues(convertValue*equations[0]);
                break;
            case 1:
                // Meter to Feet conversion 
                result = roundValues(convertValue*equations[1]);
                break;
            case 2: 
                // Celsius to Fahrenheit conversion 
                result = roundValues((convertValue*(1.8000))+equations[2]);
                break;
            case 3: 
                // CM to Feet conversion
                result = roundValues(convertValue*equations[3]);
                break;
            case 4: 
                 // Miles to Kilometres conversion
                result = roundValues((convertValue/equations[4]));
                break;
            default:
                //add somwthing wrong
                JOptionPane.showMessageDialog(null, errorText );
                result = 0;
                break;
    }
        return result;
    }
    
    /**
     * this function show a exit message
     */
    private static void exitProgram()
    {
        // display mesage box to shoy info to user
        JOptionPane.showMessageDialog(null,"See you!");
    }
    
}

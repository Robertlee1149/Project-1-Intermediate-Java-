package javazon;

import javax.swing.JOptionPane;

public class Validator {

    //TODO - CODE THE VALIDATOR
    public static String getValidFirstName(String aFirstName) {
        while (isValidFirstName(aFirstName) == false) {
            aFirstName = JOptionPane.showInputDialog("Please Enter Valid First Name");
        }
        return aFirstName;

    }

    private static boolean isValidFirstName(String aFirstName) {
        boolean result = false;

        try {
            if (aFirstName.length() >= 1) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;

    }

    public static String getValidLastName(String aLastName) {
        while (isValidLastName(aLastName) == false) {
            aLastName = JOptionPane.showInputDialog("Please Enter Valid Last Name");
        }
        return aLastName;
    }

    public static boolean isValidLastName(String aLastName) {
        boolean result = false;

        try {
            if (aLastName.length() >= 1) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }

        return result;
    }

    public static String getValidStreet(String aStreet) {
        while (isValidStreet(aStreet) == false) {
            aStreet = JOptionPane.showInputDialog("Please Enter Valid Street Name");
        }
        return aStreet;
    }

    public static boolean isValidStreet(String aStreet) {
        boolean result = false;

        try {
            if (aStreet.length() >= 1) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValidCity(String aCity) {
        while (isValidCity(aCity) == false) {
            aCity = JOptionPane.showInputDialog("Please Enter Valid City Name");
        }
        return aCity;
    }

    public static boolean isValidCity(String aCity) {
        boolean result = false;

        try {
            if (aCity.length() >= 1) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValidState(String aState) {
        while (isValidState(aState) == false) {
            aState = JOptionPane.showInputDialog("Please Enter Valid State Name. State Name " + aState + "is invalid.");
        }
        return aState;
    }

    public static boolean isValidState(String aState) {
        boolean result = false;

        try {
            if (aState.length() == 2) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValidZip(String aZip) {
        while (isValidZip(aZip) == false) {
            aZip = JOptionPane.showInputDialog("Please Enter Valid 5 digit ZipCode. Zip Code " + aZip + "is invalid.");
            
        }
        return aZip;
    }

    public static boolean isValidZip(String aZip) {
        boolean result = false;

        try {
            Integer.parseInt(aZip);

            if (aZip.length() == 5) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static String getValidPhoneNumber(String aPhoneNumber) {
        while (isValidPhoneNumber(aPhoneNumber) == false) {
            aPhoneNumber = JOptionPane.showInputDialog("Please Enter Valid Phone Number. Phone Number " + aPhoneNumber + "is invalid.");
        }
        return aPhoneNumber;
    }

    public static boolean isValidPhoneNumber(String aPhoneNumber) {

        //had a bit of trouble on this...
        //had some help from tutor
        //Here is original code I had before
        /* boolean result = false;

        try {
            Integer.parseInt(aPhoneNumber);
            
            
            //found this online of regular expression for 10 digit phone number
            if (aPhoneNumber.matches("\\d{10}")) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;*/
        char[] number = aPhoneNumber.toCharArray();

        if (number.length == 10) {
            return true;
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] < 1 || number[i] > 10) {
                return false;
            }
        }
        return true;

    }

    public static String getValidMembership(String aMembership) {
        while (isValidMembership(aMembership) == false) {
            aMembership = JOptionPane.showInputDialog("Please Enter Valid Membership Code, the Membership ID" + aMembership + " is invalid");
        }
        return aMembership;
    }

    public static boolean isValidMembership(String aMembership) {
        boolean result = true;

       //used in class example
       if(aMembership.length() != 6){
           result = false;
       }else if(aMembership.charAt(0) != 'M' || aMembership.charAt(1) != 'B'){
           result = false;
       }else{
           String digiPart = aMembership.substring(2,6);
           try{
               Integer.parseInt(digiPart);
           }catch (Exception ex){
               result = false;
           }
       }
       return result;

    }

    public static int getValidQuantity(String aQty) {
        //loops until a valid quantity is entered
        while (isValidQuantity(aQty) == false) {
            aQty = JOptionPane.showInputDialog("Please enter a valid quantity that lies between 1-10, the value " + aQty + " is invalid");
        }
        //returns quantity
        return Integer.parseInt(aQty);
    }

    private static boolean isValidQuantity(String aQty) {
        boolean result = false;

        try {
            int quantity = Integer.parseInt(aQty);
            if (quantity >= 1 && quantity <= 10) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}

class Solution {
    public int romanToInt(String s) {
        
        if(s.length() < 1 || s.length() > 15) {
            System.out.println("Length IS Invalid");
            return -1;
        }
        
        String[] strArr = s.split("");
        int sum = 0;
        for(int index = 0; index < strArr.length; index++) {
            
            String elem = strArr[index];
            switch(elem) {
                    
                case "I":
                    if(((index+1) < strArr.length) && (strArr[index+1].equalsIgnoreCase("X"))) {
                        sum = sum + 9;
                        index++;
                    } else if(((index+1) < strArr.length) && strArr[index+1].equalsIgnoreCase("V")) {
                         sum = sum + 4;
                        index++;
                    }
                    else {
                        sum = sum + 1;
                    } 
                    break;
                case "V":
                    sum = sum + 5;
                    break;
                case "X":
                     if(((index+1) < strArr.length) && (strArr[index+1].equalsIgnoreCase("L"))) {
                        sum = sum + 40;
                         index++;
                    } else if(((index+1) < strArr.length) && strArr[index+1].equalsIgnoreCase("C")) {
                         sum = sum + 90;
                         index++;
                    }
                    else {
                        sum = sum + 10;
                    } 
                    break;
                case "L":
                    sum = sum + 50;
                    break;
                case "C":
                    if(((index+1) < strArr.length) && (strArr[index+1].equalsIgnoreCase("D"))) {
                        sum = sum + 400;
                        index++;
                    } else if(((index+1) < strArr.length) && strArr[index+1].equalsIgnoreCase("M")) {
                         sum = sum + 900;
                        index++;
                    }
                    else {
                        sum = sum + 100;
                    } 
                    break;
                case "D":
                    sum = sum + 500;
                    break;
                case "M":
                    sum = sum + 1000;
                    break;
                default:
                    System.out.println("Invalid Character");
                    return -1;
            }
           
        }
         return sum;
    }
   
}
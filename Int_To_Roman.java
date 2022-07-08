enum RomanDigit {
    
    M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
    final int value;
    RomanDigit(int value) {
        this.value = value;
    }
}

class Solution {
    public String intToRoman(int num) {
        
        StringBuffer sb = new StringBuffer();
        for(RomanDigit digit : RomanDigit.values()) {
            
            while(num >= digit.value) {
                num = num - digit.value;
                sb.append(digit);
            }
        }
        
        return sb.toString();
    }
}
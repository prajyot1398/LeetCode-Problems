/*
 Write a console program that produces the following output.

Reserved Words:
gt -> greater than (>)
lt -> less than (<)
gte -> greater than or equal (>=)
lte -> less than or equal (<=)
eq -> equals (==)
neq -> not equals (!=)
or -> or (||)
and -> and (&&)

Notes:
> -> User Input

The program should detect if the expression is not balanced 
Example:
>( a gt b 
Should return: "Expression cannot be parsed"

The program should detect if the expression contains undefined variables. If list of variables is { "a" : 1, "b" : 3, "c" : 4, "d" : -1 } then
>( a lt z )
Should return: "Undefined variable z"

You can assume that the expression:
All elements in the input ( '(', ')', reserved words like gt, lt etc.) are separated by exactly one space
The list of variables may include reserved words

DONOT use Javascript eval or equivalent.

_________

Program Execution:

Welcome to expression Solver!

Enter your set of values in JSON format:
> { "a" : 1, "b" : 3, "c" : 4, "d" : -1 }

Enter your expression:
> ( ( a gt b ) or ( b gt d ) )

Result: true

Do you want to evaluate another expression (y/n):
> y

Enter your expression:
> ( ( a gt b ) or ( b lte d ) )

Result: false

Do you want to evaluate another expression (y/n):
> n

Do you want to restart the program (y/n):
> n

Bye!
"""
 */

/*
 # gt -> greater than (>)
# lt -> less than (<)
# gte -> greater than or equal (>=)
# lte -> less than or equal (<=)
# eq -> equals (==)
# neq -> not equals (!=)
# or -> or (||)
# and -> and (&&)

def gt(a,b):
    return a>b

def lt(a,b):
    return a<b

def gte(a,b):
    return a>=b

def lte(a,b):
    return a<=b

def eq(a,b):
    return a==b

def neq(a,b):
    return a!=b


def orr(a,b):
    return True if  a or b else False

def andd(a,b):
    return True if a and b else False
    

def checkParanthesis(l):
    count  = 0
    for x in l:
        if x=='(':
            count +=1
        elif x==')':
            if count <=0:
                return False
            count -=1
    if count>0:
        return False
    return True

def add_valid_keywords(valid_keywords, arr):
    for x in arr:
        valid_keywords.add(x)
    return valid_keywords

def check_invalid_character(valid_keywards, arr):
    for x in arr:
        if x not in valid_keywards:
            return False
    return True

def evaluate(arr):
    while len(arr)>=3:
        a = arr.pop()
        b = arr.pop()
        c = arr.pop()
        if b not in operations:
            return 'invalid operations'
        else:
            arr.append(operations[b](int(a), int(c)))
    return arr


def func(expression, string,valid_keywords, operations):
    value_map = json.loads(string)
    expression_list = list(expression.split(' '))
    
    #base cases 1
    if not checkParanthesis(expression_list):
        return "having invalid paranthesis in expression"
    #base cases 2
    valid_keywords = add_valid_keywords(valid_keywords, list(value_map.keys()))
    print(valid_keywords)
    
    if not check_invalid_character(valid_keywords, expression_list):
        return "Invalid expression."
    
    
    #evaluation
    stack = []
    for keyword in expression_list:
        if keyword =='(':
            stack.append('(')
        elif keyword == ')':
            new_list = []
            while stack and stack[-1]!='(':
                k = stack.pop()
                new_list.append(k)
            stack.pop()
            stack = stack + evaluate(new_list)
        else:
            if keyword in operations:
                stack.append(keyword)
            else:
                keyword_value = value_map[keyword]
                stack.append(keyword_value)
    return stack[0]            

#Driver Code 
import json
operations = {'gt' : gt, 'lt':lt, 'gte' :gte, 'lte' :lte, 'eq' :eq, 'neq' :neq, 'or':orr, 'and':andd}
valid_keywords =  set(list(operations.keys()))
valid_keywords.add('(')
valid_keywords.add(')')


#user input
string = input()
expression = input().strip()
ans = func(expression, string,valid_keywords, operations)
print(ans)
#assumptions:
"""
evaluation precedence -> right to left.
always having operator have 2 operands.
"""
 * */

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

 
 public class Main {
     
     List<String> validKeywords;
     Map<String, Method> operations;
     public Main() throws NoSuchMethodException, SecurityException {
         this.validKeywords = new ArrayList<String>();
         this.validKeywords.add("gt");
         this.validKeywords.add("lt");
         this.validKeywords.add("gte");
         this.validKeywords.add("lte");
         this.validKeywords.add("eq");
         this.validKeywords.add("neq");
         this.validKeywords.add("or");
         this.validKeywords.add("and");
         this.validKeywords.add("(");
         this.validKeywords.add(")");
         
         this.operations = new HashMap<>();
         this.operations.put("gt", Main.class.getMethod("gt", new Class[] {Integer.class, Integer.class}));
         this.operations.put("lt", Main.class.getMethod("lt", new Class[] {Integer.class, Integer.class}));
         this.operations.put("gte", Main.class.getMethod("gte", new Class[] {Integer.class, Integer.class}));
         this.operations.put("lte", Main.class.getMethod("lte", new Class[] {Integer.class, Integer.class}));
         this.operations.put("eq", Main.class.getMethod("eq", new Class[] {Integer.class, Integer.class}));
         this.operations.put("neq", Main.class.getMethod("neq", new Class[] {Integer.class, Integer.class}));
         this.operations.put("or", Main.class.getMethod("or", new Class[] {Integer.class, Integer.class}));
         this.operations.put("and", Main.class.getMethod("and", new Class[] {Integer.class, Integer.class}));
     }
     public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        System.out.println("Welcome to expression Solver!");
        char yorn1;
        char yorn2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        do {
            
            System.out.println("Enter your set of values in JSON format:");
            String inputJSON = br.readLine().strip();
            
            do {
                System.out.println("Enter your expression:");
                String expressionInput = br.readLine().strip();
    
                //Result
                Main mainObj = new Main();
                System.out.println("Result: "+mainObj.checkAndEvaluate(inputJSON, expressionInput));
                
                System.out.println("Do you want to evaluate another expression (y/n):");
                yorn1 = (char)br.read();
                br.readLine();
            }while(yorn1 != 'n' && yorn1 != 'N');
            
            System.out.println("Do you want to restart the program (y/n):");
            yorn2 = (char)br.read();
            br.readLine();
        }while(yorn2 != 'n' && yorn2 != 'N');
        
        System.out.println("Bye!");
     }
     
     public boolean gt(Integer a, Integer b){
         return a>b;
     }
     public boolean lt(Integer a, Integer b){
         return a<b;
     }
     public boolean lte(Integer a, Integer b){
         return a<=b;
     }
     public boolean gte(Integer a, Integer b){
         return a>=b;
     }
     public boolean eq(Integer a, Integer b){
         return a==b;
     }
     public boolean neq(Integer a, Integer b){
         return a!=b;
     }
     public boolean or(Integer a, Integer b) {
         return (a | b) != 0 ? true : false; 
     }
     public boolean and(Integer a, Integer b) {
         return (a & b) != 0 ? true : false; 
     }
 
     private boolean checkParanthesis(String[] expressionArr){
             int count =0 ;
             for(String x : expressionArr){
                 if(x.equals("(")) count++;
                 else if(x.equals(")")){
                     if (count <=0) return false;
                     count--;
                 }
             }
             if(count > 0 )return false;
             return true;
     }
 
     private void addValidKeyword(Set<String> arr){
         for(String s : arr){
             this.validKeywords.add(s);
         }
     }
 
     private Map.Entry<String, Boolean> checkInvalidChar(String[] arr){
         Map.Entry<String, Boolean> entry = Map.entry("",true);
         for(int i=0;i<arr.length;i++){
             if(!this.validKeywords.contains(arr[i])) {
                 entry = Map.entry(arr[i], false);
                 return entry;
             }
         }
         return entry;
     }
 
     private Map.Entry<String, Collection<String>> evaluate(List<String> arr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
         Map.Entry<String, Collection<String>> entry = Map.entry("true", arr);
         while(arr.size() >= 3){
             String a = arr.get(0); arr.remove(0); 
             String b = arr.get(0); arr.remove(0); 
             String c = arr.get(0); arr.remove(0); 
             if(!this.operations.containsKey(b)) {
                 entry = Map.entry("Invalid operations", new ArrayList<String>());
             }else {
                 Object[] parameters = new Object[2];
                 if(a.equals("false")) {
                     a = "0";
                 }
                 if(a.equals("true")) {
                     a = "1";
                 }
                 if(c.equals("false")) {
                     c = "0";
                 }
                 if(c.equals("true")) {
                     c = "1";
                 }
                 parameters[0] = Integer.parseInt(c);
                 parameters[1] = Integer.parseInt(a);
                 arr.add((this.operations.get(b).invoke(this, parameters)).toString()); 
             }
         }
         return entry;
     }
     
     private Map<String, String> getMapFromJSONInp(String inputJSON) {
         
         Map<String, String> valueMap = new HashMap<>();
         String[] splittedArr = inputJSON.split(",");
         for(String s : splittedArr) {
             s = s.strip();
             if(s.contains("}"))
                 s = s.substring(0, s.indexOf("}")-1);
             String variable = s.substring(s.indexOf("\"")+1, s.lastIndexOf("\""));
             String value = s.substring(s.indexOf(":")+2);
             valueMap.put(variable, value);
         }
         return valueMap;
     }
     
     private String checkAndEvaluate(String inputJSON, String expressionInput) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
         Map<String, String> valueMap = getMapFromJSONInp(inputJSON);
         String[] expressionArr = expressionInput.split(" "); 
         
         //Base Case 1
         if(!checkParanthesis(expressionArr)) {
                return "Expression cannot be parsed.";
         }
        
         //Base Case 2
         addValidKeyword(valueMap.keySet());
         System.out.println(this.validKeywords);
         Map.Entry<String, Boolean> entry = checkInvalidChar(expressionArr);
         if(!entry.getValue()) {
             return "Invalid expression. Undefined Variable Or Operation : "+entry.getKey();
         }
         
         //Evaluation
         Stack<String> stack = new Stack<>();
         for(String s : expressionArr) {
             if(s.equals("(")) {
                 stack.push(s);
             } else if(s.equals(")")) {
                 List<String> newList = new ArrayList<>();
                 while(!stack.isEmpty() && !stack.lastElement().equals("(")) {
                    newList.add(stack.pop());
                 }
                 stack.pop();
                 Map.Entry<String, Collection<String>> entry1 = evaluate(newList);
                 if(entry1.getKey().equals("true")) {
                     stack.addAll(entry1.getValue());
                 }
                 else {
                     return entry1.getKey();
                 }
             } else {
                 if(this.operations.containsKey(s)) {
                     stack.push(s);
                 }else {
                     stack.push(valueMap.get(s));
                 }
             }
         }
         if(stack.isEmpty()) {
             return "false";
         }
         else {
             return stack.firstElement();
         }
    }
     
 }
 

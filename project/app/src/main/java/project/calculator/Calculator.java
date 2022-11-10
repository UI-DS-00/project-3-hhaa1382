package project.calculator;

public class Calculator {
    private final MyStack<Character> operators=new MyStack<>();
    private final MyStack<Double> numbers=new MyStack<>();

    public String convertToPostfix(String args) throws IllegalStateException{
        StringBuilder temp=new StringBuilder();

        for(int i=0;i<args.length();i++){
            char c=args.charAt(i);
            if(Character.isDigit(c) || c=='.'){
                if(temp.length()==0 || !checkParenthesis(temp.toString())){
                    temp.append("(");
                }
                temp.append(c);
            }
            else if(c=='('){
                operators.push(c);
            }
            else if(c==')'){
                if(checkParenthesis(temp.toString())) temp.append(")");

                while(!operators.isEmpty() && operators.top()!='('){
                    temp.append(operators.pop());
                }

                if(operators.isEmpty()){
                    throw new IllegalStateException("error");
                }

                operators.pop();
            }
            else{
                if(checkParenthesis(temp.toString())) temp.append(")");
                if(!checkMinus(args,i)){
                    temp.append("(-1)");
                    operators.push('*');
                    continue;
                }
                while (!operators.isEmpty() && operators.top()!='(' && priority(c)<=priority(operators.top())){
                    temp.append(operators.pop());
                }
                operators.push(c);
            }
        }
        if(checkParenthesis(temp.toString())){
            temp.append(")");
        }

        while (!operators.isEmpty()){
            temp.append(operators.pop());
        }
        return temp.toString();
    }

    private boolean checkMinus(String args,int index){
        if(index==0){
            return false;
        }
        else if(Character.isDigit(args.charAt(index-1)) || args.charAt(index-1)==')'){
            return true;
        }
        return false;
    }

    private boolean checkParenthesis(String args){
        return args.length() > 0 && (Character.isDigit(args.charAt(args.length() - 1)) || args.charAt(args.length() - 1)=='.');
    }

    private int priority(char c){
        if(c=='^'){
            return 3;
        }
        else if(c=='*' || c=='/'){
            return 2;
        }
        else if(c=='-' || c=='+'){
            return 1;
        }
        return 0;
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c=='^' ;
    }

    public double getAnswer(String args){
        String postfix=convertToPostfix(args);
        StringBuilder temp=new StringBuilder();

        for(int i=0;i<postfix.length();i++){
            char c=postfix.charAt(i);
            if(isOperator(c) && postfix.charAt(i-1)!='('){
                Double number1=numbers.pop();
                Double number2=numbers.pop();
                double hold;

                if(number1==null || number2==null){
                    throw new IllegalStateException("error");
                }

                switch (c) {
                    case '+' :
                        hold=number2 + number1;
                        numbers.push(hold);
                        break;

                    case '-' :
                        hold=number2 - number1;
                        numbers.push(hold);
                        break;

                    case '*' :
                        hold=number2 * number1;
                        numbers.push(hold);
                        break;

                    case '/' :
                        hold=number2 / number1;
                        numbers.push(hold);
                        break;

                    case '^' :
                        hold=power(number2,number1);
                        numbers.push(hold);
                        break;
                }
            }
            else{
                if(c!='(' && c!=')'){
                    temp.append(c);
                }
                else if(c==')'){
                    double number=Double.parseDouble(temp.toString());
                    numbers.push(number);
                    temp.delete(0,temp.length());
                }
            }
        }
        return numbers.pop();
    }

    private double power(double number,double powNumber){
        if(powNumber==1){
            return number;
        }
        return power(number,powNumber-1)*number;
    }
}

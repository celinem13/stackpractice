public class InfixToPostfixConverter implements ExpressionConverterInterface{
    private StackInterface<Character> stack;
    private String outputString;

    public InfixToPostfixConverter(){
        stack = new LinkedStack<>();
    }
    public InfixToPostfixConverter(StackInterface<Character> myStack){
        stack = myStack;
    }
    /**
     * The convert method converts one type of expression format to another
     *
     * @param expression The expression to be converted
     * @return The expression in the new format
     * @throws InvalidExpressionException If the expression to be converted has syntax errors
     */

    @Override
    public String convert(String expression) throws InvalidExpressionException {
        outputString = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isLetter(ch)) {
                outputString += ch;
            } else if (ch == '^')
                stack.push(ch);
            else if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')) {
                if ((ch == '/') || (ch == '*')) {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '^') {
                            outputString += stack.peek();
                            stack.pop();
                        } else if ((stack.peek() == '/') || (stack.peek() == '*')) {
                            outputString += stack.peek();
                            stack.pop();
                        } else if ((stack.peek() == '+') || stack.peek() == '-') {
                            break;
                        } else if ((stack.peek() == '(') || (stack.peek() == ')'))
                            break;
                    }
                    stack.push(ch);
                }
                if ((ch == '+') || (ch == '-')) {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '^') {
                            outputString += stack.peek();
                            stack.pop();
                        } else if ((stack.peek() == '+') || stack.peek() == '-') {
                            outputString += stack.pop();
                        } else if ((stack.peek() == '(') || (stack.peek() == ')'))
                            break;
                        else if ((stack.peek() == '/') || (stack.peek() == '*')) {
                            outputString += stack.peek();
                            stack.pop();
                        }
                    }
                    stack.push(ch);
                }
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    outputString += stack.pop();
                }
            } else if (ch == ' ') {
                continue;
            } else {
                System.out.println("Invalid character");
                throw new InvalidExpressionException();
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            char ch = expression.charAt(index);
            if (Character.isLetter(ch)) {
                index++;
                continue;
            } else {
                stack.pop();
            }
            if (ch == '(')
                throw new InvalidExpressionException();
            else {
                outputString += ch;
            }
            index++;
        }
        return outputString;
    }
}

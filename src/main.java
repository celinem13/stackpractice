public class main {
    public static void main(String[] args){
        ArrayStack<Character> myStack = new ArrayStack<>();
        LinkedStack<Integer> stack2 = new LinkedStack<>(100);
        InfixToPostfixConverter converter = new InfixToPostfixConverter(myStack);

        for(int i = 0; i < 10; i ++){
            stack2.push(i);
        }
        System.out.println(stack2.isEmpty());
        stack2.peek();

        for (int i = 0; i < 5; i++){
            System.out.println(stack2.peek());
            stack2.pop();
        }
        stack2.peek();
        System.out.println(stack2.isEmpty());
        stack2.clear();
        System.out.println(stack2.isEmpty());

        System.out.println(converter.convert("A+B-D*(C/E^F)+G"));
        System.out.println(converter.convert("A+B-C/D^E*G"));
        System.out.println(converter.convert("A+C^D*((A*D)+B)"));
        System.out.println(converter.convert("(((A+B-C)))"));
        System.out.println(converter.convert("A+B-C*D/E^F"));
        System.out.println(converter.convert("A-B"));
        System.out.println(converter.convert("A*B"));
        System.out.println(converter.convert("A/B"));
        System.out.println(converter.convert("A^B"));
        System.out.println(converter.convert("((A+B)-C"));
        //System.out.println(converter.convert("A!B"));
    }
}

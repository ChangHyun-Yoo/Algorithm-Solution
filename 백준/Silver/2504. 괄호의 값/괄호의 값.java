import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if(!solution(input)) {
            System.out.println(0);
            return;
        }
        int small = 0;
        int large = 0;
        char[] chs = input.toCharArray();
        Stack<Object> stack = new Stack<>();
        for(char ch: chs) {
            if(ch == '[') {
                large++;
                stack.push(ch);
            }
            else if(ch == ']') {
                large--;
                try {
                    if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                        int p = (int) stack.pop();
                        stack.pop();
                        try {
                            if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                                stack.push(p * 3 + (int) stack.pop());
                            } else {
                                stack.push(p * 3);
                            }
                        } catch(Exception e) {
                            stack.push(p * 3);
                        }
                    } else if((char) stack.peek() == '[') {
                        stack.pop();
                        try {
                            if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                                stack.push(3 + (int) stack.pop());
                            } else
                                stack.push(3);
                        } catch(Exception e) {
                            stack.push(3);
                        }
                    }
                } catch(Exception e) {
                    System.out.println(0);
                    return;
                }
                if(small < 0 || large < 0) {
                    System.out.println(0);
                }
            }
            else if(ch == '(') {
                small++;
                stack.push(ch);
            }
            else {
                small--;
                try {
                    if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                        int p = (int) stack.pop();
                        stack.pop();
                        try {
                            if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                                stack.push(p * 2 + (int) stack.pop());
                            } else {
                                stack.push(p * 2);
                            }
                        } catch(Exception e) {
                            stack.push(p * 2);
                        }
                    } else if((char) stack.peek() == '(') {
                        stack.pop();
                        try {
                            if(stack.peek().getClass().getSimpleName().equals("Integer")) {
                                stack.push(2 + (int) stack.pop());
                            } else
                                stack.push(2);
                        } catch(Exception e) {
                            stack.push(2);
                        }

                    }
                } catch (Exception e) {
                    System.out.println(0);
                    return;
                }

            }
        }
        if(small != 0 || large != 0) {
            System.out.println(0);
            return;
        }

        System.out.println((int) stack.peek());
    }

    private static boolean solution(String s) {
        if(s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                //닫힌것은 비교하여 뺀다
                case ')':
                    try {
                        if(stack.peek() == '(') stack.pop();
                    } catch(Exception e) {
                        return false;
                    }
                    break;
                case '}':
                    try {
                        if(stack.peek() == '{') stack.pop();
                    } catch(Exception e) {
                        return false;
                    }
                    break;
                case ']':
                    try {
                        if(stack.peek() == '[') stack.pop();
                    } catch(Exception e) {
                        return false;
                    }
                    break;
                //열린것은 담고
                default :
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }
}
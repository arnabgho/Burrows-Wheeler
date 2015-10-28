/**
 * Auto Generated Java Class.
 */
import java.util.*;
public class MoveToFront {
    
    public static void encode(){
        String data=BinaryStdIn.readString();
//        System.out.println("data\n");
//        System.out.println(data);
        data=data.substring(0,data.length()-1);  
        Stack<Character> Radix=new Stack<Character>();
        Stack<Character> Temp=new Stack<Character>();
        
//        System.out.println("Hi1");
        for(int i=255;i>=0;i--){
//            System.out.println("Hi push");
            Radix.push((char)i);
        }
//        System.out.println("Hi2");
       
        int len=data.length();
        int k=0;
        char res[] =new char[len+1];
        while(k<len){
            char c=data.charAt(k);
            char count=0;
            while(Radix.peek()!=c){
                count++;
                char ch=Radix.peek();
                Temp.push(ch);
                Radix.pop();
            }
            res[k]=count;
            Radix.pop();
            while(!Temp.isEmpty()){
                char ch=Temp.peek();
                Radix.push(ch);
                Temp.pop();
            }
            Radix.push(c);
            k++;
        }
        for(k=0;k<len;k++){
             BinaryStdOut.write(res[k]);
        }
        BinaryStdOut.close();    
    }
    public static void decode(){
        String data=BinaryStdIn.readString();
//        System.out.println("data\n");
//        System.out.println(data);
        
        Stack<Character> Radix=new Stack<Character>();
        Stack<Character> Temp=new Stack<Character>();
        for(int i=255;i>=0;i--){
            Radix.push((char)i);
        }
        int len=data.length();
        int k=0;
        int res[] =new int[len+1];
        while(k<len){
            char c=data.charAt(k);
            char count=0;
            while(count<c){
                count++;
                char ch=Radix.peek();
                Temp.push(ch);
                Radix.pop();
            }
            c=Radix.peek();
            res[k]=c;
            Radix.pop();
            while(!Temp.isEmpty()){
                char ch=Temp.peek();
                Radix.push(ch);
                Temp.pop();
            }
            Radix.push(c);
            k++;
        }
        for(k=0;k<len;k++){
             BinaryStdOut.write(res[k]);
        }
        BinaryStdOut.close();
    }
    public static void main(String[] args){
        if(args[0].equals("-")){
            
//            System.out.println("Hi encode");
            encode();
        }  
        if(args[0].equals("+")){
            decode();
        } 
    }
}

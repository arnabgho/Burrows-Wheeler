/**
 * Auto Generated Java Class.
 */
public class BurrowsWheeler {
   
    public static void encode(){
        String data= BinaryStdIn.readString();
        data=data.substring(0,data.length()-1);                         
//        System.out.println("Data \n " +data);
        int i,first=0,len;
        len=data.length();
//        System.out.println("Length "+len);
        CircularSuffixArray helper=new CircularSuffixArray(data);
        String t="";
        for(i=0;i<len;i++){
            if(helper.index(i)==0){
                first=i;
                t+=data.charAt(len-1);
            }
            else{
                t+=data.charAt(helper.index(i)-1);
            }
        }
       
//        System.out.println("First "+ first);
//        System.out.println("t \n" +t);
        BinaryStdOut.flush();
        BinaryStdOut.write(first);
        for(i=0;i<len;i++){
            BinaryStdOut.write(t.charAt(i));
        }
        BinaryStdOut.close();
    }
    public static void decode(){
        int first,R,n,i;
        String t;
        first=BinaryStdIn.readInt();
        t=BinaryStdIn.readString();
        R=256;
        n=t.length();
        int[] count=new int[R+1];
        int[] next=new int[n+1];
        for(i=0;i<n;i++)
            count[t.charAt(i)+1]++;
        
        for(i=0;i<R;i++)
            count[i+1]+=count[i];
        
        for(i=0;i<n;i++){
            next[i]=count[t.charAt(i)]++;
        }
        int curr=first;
        String decoded="";
        for(i=0;i<n;i++){
            decoded+=t.charAt(curr);
            curr=next[curr];
        }
        
        BinaryStdOut.flush();

        for(i=0;i<n;i++){
            BinaryStdOut.write(decoded.charAt(n-i-1));
        }
        BinaryStdOut.close();
    }
    
    public static void main(String[] args){

        if(args[0].equals("-")){
            encode();
        }  
        if(args[0].equals("+")){
            decode();
        } 
    }
}

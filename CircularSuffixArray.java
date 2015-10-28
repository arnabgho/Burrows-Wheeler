/**
 * Auto Generated Java Class.
 */
public class CircularSuffixArray {
    
    SuffixArrayX helper;
    int len;
    int[] indexes;
    public CircularSuffixArray(String s){
        SuffixArrayX helper=new SuffixArrayX(s);
        len=helper.length();
        indexes=new int[len];
        int i;
        for(i=0;i<len;i++)
            indexes[i]=helper.index(i);
    }
    public int length(){
        return len;   
    }
    public int index(int i){
        if(i<0 || i>=len)
            throw new IndexOutOfBoundsException("Nothing to carve \n");
        return indexes[i];
    }
    public static void main(String[] args){
        CircularSuffixArray abra=new CircularSuffixArray("ABRACADABRA!");
        for(int i=0;i<12;i++){
            System.out.println("Index "+abra.index(i) );
        
        }
    }
}

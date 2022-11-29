import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaArray {
  
  static public void main(String[] args) {
  	
    String[] ss = new String[]{"hello"};
    
    Object[] os = ss; // OK because String[] is a subtype of Object[]
    
    os[0] = new Object(); // fails with ArrayStoreException at run time
    
    ss[0].charAt(0); // would try to call charAt on an Object if it were allowed to execute
    
  }
}

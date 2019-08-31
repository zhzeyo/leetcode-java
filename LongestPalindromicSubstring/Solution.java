import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        //if(s.length()==1) return s;
        
        StringBuffer filledStr = getFilledStr(s);
		//System.out.println("filledStr: " + filledStr);
        char[] cs = filledStr.toString().toCharArray();
       getLongestPldm(cs);
       return maxStr;
    }
    
    private StringBuffer getFilledStr(String s){
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            sb.append('#');
            sb.append(cs[i]);
        }
        sb.append('#');
        return sb;
    }  
    
    private int maxNum = 0;
    private String maxStr = "";
    
    private void getLongestPldm(char[] cs){
        // abcba  ----  #a#b#c#b#a #
        // 01234  ----  012345678910
        int max = 0;
       // String maxStr = "";
        for(int i=0; i<cs.length; i++){
        	checkMaxStr(cs, i);
        }
    }
    
    private void checkMaxStr(char[] cs, int index) {
    	int len=0, j=0;
    	while(j<=index&&j<cs.length-index) {
            if(cs[index-j]==cs[index+j]) {
				len++;
			} else break;
            j++;
        }
    	if(--j<0) j = 0;
        if(len>maxNum) {
            maxNum = len;
            maxStr = getRealStr(cs, index, j);
//			System.out.println("the new max is " + max);
//			System.out.println("the new realMaxStr is " + maxStr);
        }
    }
    
    private String getRealStr(char[] cs, int i, int j){	
        StringBuffer sb = new StringBuffer();
		int l = i-j;
		int r = i+j;
		
//		System.out.print("new maxStr is ");
//		for(int x=l; x<=r; x++){
//			System.out.print(cs[x]);
//		}
//		System.out.println();
		
        for(int k=l+1; k<=r; k+=2){
            sb.append(cs[k]);
        }
        return sb.toString();
    } 
}
package com.atguigu;

// "static void main" must be defined in a public class.
public class Main {
    public static String longestPalindrome(String s) {
        int len = s.length();
        char[] charArr = s.toCharArray();
        String resStr = "";
        for(int i=0;i<len;i++){
            for(int j=len-1;j>=0;j--){
                if(s.charAt(i)==s.charAt(j) && isReverse(s.substring(i,j+1))){
                    resStr = resStr.length() < (s.substring(i,j+1)).length() ? s.substring(i,j+1) : resStr;
                    break;
                }
            }
        }
        return resStr;
    }
    public static boolean isReverse(String str){
        int len = str.length();
        if(len==1){
            return true;
        }
        char[] charArr = str.toCharArray();
        for(int i=0;i<len/2;i++){
            char c=charArr[i];
            charArr[i] = charArr[len-i-1];
            charArr[len-i-1]=c;
        }
        String newStr = new String(charArr);
        System.out.println("newStr  out----->"+newStr);
        if(str.equals(newStr)){
            System.out.println("str----->"+str);
            System.out.println("newStr----->"+newStr);
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {

        String res = longestPalindrome("vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv");
        System.out.println("res------>"+res);
        System.out.println("ori------>"+"vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv");
        // initialize
//        String s1 = "Hello World";
//        System.out.println("s1 is \"" + s1 + "\"");
//        String s2 = s1;
//        System.out.println("s2 is another reference to s1.");
//        String s3 = new String(s1);
//        System.out.println("s3 is a copy of s1.");
//        // compare using '=='
//        System.out.println("Compared by '==':");
//        // true since string is immutable and s1 is binded to "Hello World"
//        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
//        // true since s1 and s2 is the reference of the same object
//        System.out.println("s1 and s2: " + (s1 == s2));
//        // false since s3 is refered to another new object
//        System.out.println("s1 and s3: " + (s1 == s3));
//        // compare using 'equals'
//        System.out.println("Compared by 'equals':");
//        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
//        System.out.println("s1 and s2: " + s1.equals(s2));
//        System.out.println("s1 and s3: " + s1.equals(s3));
//        // compare using 'compareTo'
//        System.out.println("Compared by 'compareTo':");
//        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
//        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
//        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));

//        String s = "";
//        int n = 10000;
//        for (int i = 0; i < n; i++) {
//            s += "hello";
//        }
//        System.out.println(s);



    }
}
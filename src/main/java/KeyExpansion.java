public class KeyExpansion {
    public static boolean flag;
    public int Nk;
    public int Nb;
    public int Nr;

    public static final String [] RCON = {"01",  "02",  "04",  "08",  "10",  "20",  "40",  "80",  "1b",  "36"};

    public KeyExpansion(int key_size) {
        flag = false;
        //RCON = new String[]{"01",  "02",  "04",  "08",  "10",  "20",  "40",  "80",  "1b",  "36"};
        if (key_size == 128){
                Nk = 4;
                Nb = 4;
                Nr = 10;
        }
        else if(key_size == 192){
                Nk = 6;
                Nb = 4;
                Nr = 12;
        }
        else if(key_size == 256) {
            Nk = 8;
            Nb = 4;
            Nr = 14;

        }
        else if(key_size == 512) {
            Nk = 16;
            Nb = 4;
            Nr = 22;
        }
         else{
             System.out.println("The entered size is not valid. So by default 128 is being used");
            Nk = 4;
            Nb = 4;
            Nr = 10;

        }
    }
    public static Hexa[] roundShift(Hexa [] word){
        Hexa [] word_copy = new Hexa[word.length];
        for(int i = 0; i < word.length; i++){
            word_copy[i] = word[i];
        }
        int counter = word_copy.length-1;
        Hexa temp = word[0];
        for(int i = 1; i <= counter; i++){
            word_copy[i-1] = word_copy[i];
        }
        word_copy[counter] = temp;
        return word_copy;
    }
    public static void displayHexWord(Hexa[] hex_matrix){
        for (int i=0; i < hex_matrix.length; i++) {

            System.out.print(hex_matrix[i].firstChar +" "+ hex_matrix[i].secondChar + " ");
        }
        System.out.println();
    }
    public static Hexa[][] StringToHexaArr(String str, int rows, int columns){
        Hexa hex_mat[][] = new Hexa[4][4];
        //String str = "76a41ef78971a2be3987f20913465998";
        //int row  = 4;
        //int column =4;

        int offset = 0;
        for (int i=0; i < rows; i++) {
            for (int j=0; j < columns; j++) {
                hex_mat[j][i] = new Hexa();
                hex_mat[j][i].firstChar = str.charAt(offset++);
                hex_mat[j][i].secondChar = str.charAt(offset++);
                //System.out.print(hex_mat[i][j].firstChar +" "+ hex_mat[i][j].secondChar + " ");
            }
            //System.out.println ();
        }
        return hex_mat;
    }

    public static Hexa[] StringToHexa(String str){
        Hexa [] hex_mat = new Hexa[str.length()/2];
        int offset = 0;
        for (int i=0; i < str.length()/2; i++) {
                hex_mat[i] = new Hexa();
                hex_mat[i].firstChar = str.charAt(offset++);
                hex_mat[i].secondChar = str.charAt(offset++);
        }
        return hex_mat;
    }

    public static Hexa [] SubBytes(Hexa [] word){

        Hexa [] word_copy = new Hexa[word.length];
        for(int i = 0; i < word.length; i++){
            word_copy [i]=new Hexa();
            word_copy[i].firstChar = word[i].firstChar;
            word_copy[i].secondChar = word[i].secondChar;
        }
        for(int i = 0; i < word_copy.length ; i++){
            word_copy[i] = SubBytes.SubBytesWord(word_copy[i]);

            //System.out.println(word_copy[i].firstChar+" "+word_copy[i].secondChar);
        }
        //System.out.println(word_copy[i].firstChar+" "+word_copy[i].secondChar);
        return word_copy;
    }
    public static Hexa oneStringToHexa(String str){
        Hexa hex_ret = new Hexa();
        if(str.length()>1) {
            int offset = 0;
            hex_ret.firstChar = str.charAt(offset++);
            hex_ret.secondChar = str.charAt(offset++);
        }
        else{
            hex_ret.firstChar = '0';
            hex_ret.secondChar = str.charAt(0);
        }
        return hex_ret;
    }
    public static String HextoString(Hexa hex_mat){

        String ret_str = "";

        ret_str += hex_mat.firstChar;
        ret_str += hex_mat.secondChar;;

        return ret_str;
    }
    public static String hexToBinary(String hex) {
        //System.out.println("Hex = " + hex);
        int i = Integer.parseInt(hex.toLowerCase(), 16);
        String bin = Integer.toBinaryString(i);
        while (bin.length()<8){
            bin="0"+bin;
        }
        return bin;

    }
    public static String XOR_Func(String binary_str1, String binary_str2)
    {
        String result = "";
        for(int i=0; i<binary_str1.length(); i++)
        {
            if(binary_str1.charAt(i)!=binary_str2.charAt(i))
            {
                result = result + "1";
            }
            else
            {
                result = result + "0";
            }
        }
        return result;
    }
    public static String binaryToHexString(String binary) {
        int decimal = Integer.parseInt(binary,2);
        String hexStr = Integer.toString(decimal,16);
        //System.out.println("Binary To Hexa= " + hexStr.toUpperCase());
        return hexStr.toUpperCase();
    }

    public static Hexa [] XOR(Hexa[] word1, Hexa[] word2){
        /*if(flag == true){
            //System.out.println("Hellow");
        }*/
        Hexa [] newWord = new Hexa[word1.length];
        for(int i = 0; i < word1.length; i++){
            newWord[i] = new Hexa();
            newWord[i] = oneStringToHexa(binaryToHexString(XOR_Func(hexToBinary(HextoString(word1[i])),hexToBinary(HextoString(word2[i])))));

        }
        return newWord;
    }
    public static Hexa [] XorRCon(Hexa [] word, Hexa rCon){

        Hexa [] resultant = new Hexa[word.length];
        Hexa [] word_copy = new Hexa[word.length];
        for(int i = 0; i < word.length; i++){
            word_copy [i]=new Hexa();
            word_copy[i].firstChar = word[i].firstChar;
            word_copy[i].secondChar = word[i].secondChar;
        }
        for(int i = 0; i < word_copy.length ; i++){
            resultant[i] = new Hexa();
            if (i == 0){
                //System.out.println("XORING = "+HextoString(word_copy[i])+ " and "+ HextoString(rCon));
                resultant[i] = oneStringToHexa(binaryToHexString(XOR_Func(hexToBinary(HextoString(word_copy[i])),hexToBinary(HextoString(rCon)))));
            }
            else{
                resultant[i].firstChar = word_copy[i].firstChar;
                resultant[i].secondChar = word_copy[i].secondChar;
            }
        }

        return resultant;
    }
    public static void displayHexMatrix(Hexa[][] hex_matrix, int rows, int cols){
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {

                System.out.print(hex_matrix[i][j].firstChar +" "+ hex_matrix[i][j].secondChar + " ");
            }
            System.out.println ();
        }
    }

    public Hexa[][][] KeyExpansionAlgo(Hexa[][] orignalKey){

        System.out.println("KEY EXPANSION:");
        Hexa [][][] expandedKey = new Hexa[(Nr+1)][Nb][Nb];
        int i = 0;
        expandedKey[i]= orignalKey;
        //i++;
        while (i < (Nr)) {
            System.out.println("Key after Round " + String.valueOf(i));
            displayHexMatrix(expandedKey[i],4,4);
            Hexa[] curr_col = new Hexa[Nb];
            for (int j = 0; j < Nb ; j++){
                    curr_col[j] = expandedKey[i][j][Nb-1];
                }
            //Round Shift
            Hexa[]  shiftedCol = roundShift(curr_col);

            //Substitute Bytes
            Hexa[] substituted_col = SubBytes(shiftedCol);


            //Xor with RCon
            Hexa [] rcj = XorRCon(substituted_col,oneStringToHexa(RCON[i]));
            Hexa [] w_ = rcj;

            //XOR w_prime with all columns
            for(int l = 0; l < Nb; l++){
                Hexa [] w_1 = new Hexa[Nb];
                for(int m = 0; m < Nb; m++){
                    w_1[m] = expandedKey[i][m][l];
                }
                //System.out.println(":");


                Hexa w_r[] = XOR(w_,w_1);
                for(int r = 0; r < Nb; r++){
                    expandedKey[i+1][r][l]= w_r[r];
                }

                w_ = w_r;
            }
            i++;


        }
        System.out.println("Key after Round " + String.valueOf(i));
        displayHexMatrix(expandedKey[i],4,4);
        // end while
        return expandedKey;
    }



    public static void main(String []  args){

        //KeyExpansion ke = new KeyExpansion(128);
        //Hexa[][][] expanded_key = ke.KeyExpansionAlgo(StringToHexaArr("2B7E151628AED2A6ABf7158809CF4F3C", 4, 4));
        //displayExpandedKey(expanded_key, 11, 4, 4);
       /* System.out.println("Display before: ");
        Hexa[] hex = StringToHexa("7D5ACB46");
        displayHexWord(hex);
        System.out.println("Display After");
        Hexa [] rs_word = roundShift(hex);
        displayHexWord(rs_word);
        System.out.println("After Sbox Sub:");
        Hexa [] sbox_word = SubBytes(rs_word);
        displayHexWord(sbox_word);
        System.out.println("After Rcj:");
        Hexa [] rcj = XorRCon(sbox_word,oneStringToHexa(RCON[0]));
        displayHexWord(rcj);

        System.out.println("After XOR:");
        Hexa [] xor = XOR(rcj,StringToHexa("38497268"));
        displayHexWord(xor);*/
        //2B7E151628AED2A6ABf7158809CF4F3C
    }

    private static void displayExpandedKey(Hexa[][][] expanded_key, int blocks, int rows, int cols) {
        for(int a  = 0; a < blocks ; a++){
            for (int i=0; i < rows; i++) {
                for (int j=0; j < cols; j++) {

                    System.out.print(expanded_key[a][i][j].firstChar +" "+ expanded_key[a][i][j].secondChar + " ");
                }
                System.out.println();

            }
            System.out.println ();
        }

    }
}

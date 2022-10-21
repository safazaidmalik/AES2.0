public class AddRoundKey {
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
        return hexStr.toUpperCase();
    }


    public static Hexa[][] addRoundkey(Hexa[][] state, Hexa [][][] key, int round, int Nb){
        Hexa[][] resultant = state;
        for(int i = 0; i < Nb ; i++){
            for(int j = 0; j < Nb; j++){
                resultant[i][j] = oneStringToHexa(binaryToHexString(XOR_Func(hexToBinary(HextoString(state[i][j])),hexToBinary(HextoString(key[round][i][j])))));
            }
        }
        return resultant;
    }
}

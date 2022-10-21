import java.io.UnsupportedEncodingException;
import javax.xml.bind.DatatypeConverter;

public class AES {

    public static Hexa[][] StringToHexa(String str, int rows, int columns){
        Hexa hex_mat[][] = new Hexa[4][4];
        //String str = "76a41ef78971a2be3987f20913465998";
        //int row  = 4;
        //int column =4;

        int offset = 0;
        for (int j=0; j < columns; j++) {
            for (int i=0; i < rows; i++) {
                hex_mat[i][j] = new Hexa();
                hex_mat[i][j].firstChar = str.charAt(offset++);
                hex_mat[i][j].secondChar = str.charAt(offset++);
                //System.out.print(hex_mat[i][j].firstChar +" "+ hex_mat[i][j].secondChar + " ");
            }
            //System.out.println ();
        }
        return hex_mat;
    }

    public static Hexa[][] AESAlgoEnc(int Nb, int Nk,int Nr, String blk, String key){

        String block = blk;
        Hexa state[][] = StringToHexa(block, Nb, Nb);



        KeyExpansion ke = new KeyExpansion(128);
        Hexa[][][] expanded_key = ke.KeyExpansionAlgo(ke.StringToHexaArr(key, Nb, Nb));

        System.out.println("Original Block:");
        displayHexMatrix(state, Nb,Nb);


        state = AddRoundKey.addRoundkey(state,expanded_key,0,Nb);
        System.out.println("Add Round Key:");
        displayHexMatrix(state, Nb,Nb);


        for (int round = 1; round <= Nr - 1; round++) {
            //Sub Bytes
            System.out.println("ROUND : "+ String.valueOf(round)+"\n");

            state = SubBytes.SubBytesEnc(state);
            System.out.println("Sub Bytes: ");
            displayHexMatrix(state,Nb,Nb);

            //Shift Rows
            state = ShiftRows.shiftRows(state,Nb,Nb);
            System.out.println("Shift Rows: ");
            displayHexMatrix(state,Nb,Nb);

            //Mix Columns
            Hexa mix_mat [][] = MixColumns.StringToHexa(MixColumns.enc_matrix, 4,4);
            state = MixColumns.multiplyMatrices(mix_mat, state,Nb,Nb,Nb);
            System.out.println("Mix Columns: ");
            displayHexMatrix(state,Nb,Nb);


            //Add round Key
            state = AddRoundKey.addRoundkey(state,expanded_key,round,Nb);
            System.out.println("Add Round Key: ");
            displayHexMatrix(state,Nb,Nb);



        }
        //Sub Bytes
        state = SubBytes.SubBytesEnc(state);
        System.out.println("Sub Bytes: ");
        displayHexMatrix(state,Nb,Nb);
        //Shift Rows
        state = ShiftRows.shiftRows(state,Nb,Nb);
        System.out.println("Shift Rows: ");
        displayHexMatrix(state,Nb,Nb);
        //Round Key
        state = AddRoundKey.addRoundkey(state,expanded_key,Nr,Nb);
        System.out.println("Add Round Key: ");
        displayHexMatrix(state,Nb,Nb);

        return state;
    }
    public static Hexa[][] AESAlgoDec(int Nb, int Nk,int Nr, String blk, String key){

        String block = blk;
        Hexa state[][] = StringToHexa(block, Nb, Nb);

        KeyExpansion ke = new KeyExpansion(128);
        Hexa[][][] expanded_key = ke.KeyExpansionAlgo(ke.StringToHexaArr(key, Nb, Nb));

        state = AddRoundKey.addRoundkey(state,expanded_key,0,Nb);


        for (int round = 1; round <= Nr - 1; round++) {
            //Sub Bytes
            System.out.println("ROUND :"+String.valueOf(round)+"\n");
            state = SubBytes.SubBytesEnc(state);
            System.out.println("Sub Bytes: ");
            displayHexMatrix(state,Nb,Nb);

            //Shift Rows
            state = ShiftRows.shiftRows(state,Nb,Nb);
            System.out.println("Shift Rows: ");
            displayHexMatrix(state,Nb,Nb);

            //Mix Columns
            Hexa mix_mat [][] = MixColumns.StringToHexa(MixColumns.dec_matrix, 4,4);
            state = MixColumns.multiplyMatrices(mix_mat, state,Nb,Nb,Nb);
            System.out.println("Mix Columns: ");
            displayHexMatrix(state,Nb,Nb);
            //Add round Key
            state = AddRoundKey.addRoundkey(state,expanded_key,round,Nb);
            System.out.println("Add Round Key: ");
            displayHexMatrix(state,Nb,Nb);

        }
        System.out.println("Final Round:");

        //Sub Bytes
        state = SubBytes.SubBytesEnc(state);
        System.out.println("Sub Bytes: ");
        displayHexMatrix(state,Nb,Nb);

        //Shift Rows
        state = ShiftRows.shiftRows(state,Nb,Nb);
        System.out.println("Shift Rows: ");
        displayHexMatrix(state,Nb,Nb);

        //Round Key
        state = AddRoundKey.addRoundkey(state,expanded_key,Nr,Nb);
        System.out.println("Add Round Key: ");
        displayHexMatrix(state,Nb,Nb);

        return state;
    }
    public static void displayHexMatrix(Hexa[][] hex_matrix, int rows, int cols){
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {

                System.out.print(hex_matrix[i][j].firstChar +" "+ hex_matrix[i][j].secondChar + " ");
            }
            System.out.println ();
        }
    }

    public static String HextoString(Hexa[][] hex_mat, int rows, int cols){

        String ret_str = "";
        for(int j = 0; j < cols ;j++ ){
            for(int i = 0; i < rows ; i++ ){
                ret_str += hex_mat[i][j].firstChar;
                ret_str += hex_mat[i][j].secondChar;;
            }
        }
        System.out.println("return String = "+ ret_str);

        return ret_str;
    }
    public static String toHexadecimal(String text) throws UnsupportedEncodingException
    {
        byte[] myBytes = text.getBytes("UTF-8");

        return DatatypeConverter.printHexBinary(myBytes);
    }
    static String truncate(String text, int length) {
        if (text.length() <= length) {

            while(text.length()<length)
            {
                text+="x";
            }
            return text;
        }

        else {
            return text.substring(0, length);
        }
    }



    public static void main(String [] args) throws UnsupportedEncodingException {

        Hexa [][] encrypted_data = AESAlgoEnc(4, 4, 10, "00000000000000000000000000000000", "00000000000000000000000000000000");
        System.out.println("Final Encryption:");
        displayHexMatrix(encrypted_data, 4, 4);
        Hexa [][] decrypted_data = AESAlgoDec(4, 4, 10, HextoString(encrypted_data,4,4), "2B7E151628AED2A6ABf7158809CF4F3C");
        System.out.println("Final Decryption:");
        displayHexMatrix(decrypted_data, 4, 4);

    }
}

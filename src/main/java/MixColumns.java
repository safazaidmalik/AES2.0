import static java.lang.String.valueOf;

public class MixColumns {
    public static final String enc_matrix= "02010103030201010103020101010302";
    public static final String dec_matrix= "0E0B0D09090E0B0D0D090E0B0B0D090E";

    public static Hexa[][] StringToHexa(String str, int rows, int columns){
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
    public static void displayHexMatrix(Hexa[][] hex_matrix, int rows, int cols){
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {

                System.out.print(hex_matrix[i][j].firstChar +" "+ hex_matrix[i][j].secondChar + " ");
            }
            System.out.println ();
        }
    }
    public static String hexToBinary(String hex) {
        int i = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(i);
        while (bin.length()<8){
            bin="0"+bin;
        }
        return bin;

    }

    public static String binaryToHexString(String binary) {
        int decimal = Integer.parseInt(binary,2);
        String hexStr = Integer.toString(decimal,16);
        return hexStr;
    }


    public static Hexa[][] multiplyMatrices(Hexa[][] mix_matrix, Hexa[][] state_matrix, int r1, int c1, int c2) {
        Hexa[][] product = new Hexa[r1][c2];
        GaloisFields gf = new GaloisFields();
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                String binary_results = "";
                for (int k = 0; k < c1; k++) {
                    if (k == 0){
                        //System.out.println("Hex To Binary = "+ hexToBinary(HextoString(mix_matrix[i][k]))+ " and "+ hexToBinary(HextoString(state_matrix[k][j])));
                        binary_results = gf.GaloisMultiplication(hexToBinary(HextoString(mix_matrix[i][k])),hexToBinary(HextoString(state_matrix[k][j])));
                    }
                    else {
                        //System.out.println("Hex To Binary = "+ hexToBinary(HextoString(mix_matrix[i][k]))+ " and "+ hexToBinary(HextoString(state_matrix[k][j])));
                        binary_results = gf.XOR_Func(binary_results, GaloisFields.GaloisMultiplication(hexToBinary(HextoString(mix_matrix[i][k])), hexToBinary(HextoString(state_matrix[k][j]))));
                    }
                }
                product[i][j] = oneStringToHexa(binaryToHexString(binary_results));

            }
        }

        return product;
    }

    public static void main(String [] args){
        String str = "76A41EF78971A2BE3987F20913465998";
        int row  = 4;
        int column =4;
        System.out.println("Before Sub: ");
        Hexa hex_mat [][]= StringToHexa(str, row, column);
        displayHexMatrix(hex_mat,row,column);

        Hexa hex_aftr_sub [][] = SubBytes.SubBytesEnc(hex_mat);

        System.out.println("After Sub: ");
        displayHexMatrix(hex_aftr_sub, 4, 4);

        Hexa hex_aftr_row_shift [][]= ShiftRows.shiftRows(hex_aftr_sub, 4,4);
        System.out.println("After Shift Rows:");
        displayHexMatrix(hex_aftr_row_shift,4,4);

        System.out.println("Mix Matrix:");
        Hexa mix_mat [][] = StringToHexa(enc_matrix, 4,4);
        displayHexMatrix(mix_mat, 4,4);

        System.out.println("Multiplying matrices:");
        Hexa mix_cols_output [][] = multiplyMatrices(mix_mat, hex_aftr_row_shift,4,4,4);
        displayHexMatrix(mix_cols_output,4,4);

    }


}

public class ShiftRows {
    public static Hexa[][] shiftRows(Hexa[][] hex_mat, int rows, int cols){
        int shift = 0;

        //copying data to a new array
        Hexa hex_mat_copy[][] = new Hexa[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hex_mat_copy[i][j] = new Hexa();
                hex_mat_copy[i][j].firstChar = hex_mat[i][j].firstChar;
                hex_mat_copy[i][j].secondChar = hex_mat[i][j].secondChar;
            }
        }

        for(int i=1; i<rows; i++){
            shift++;
            for(int count=0; count<shift; count++){

                Hexa temp1 = hex_mat_copy[i][2];
                hex_mat_copy[i][2] = hex_mat_copy[i][3];
                Hexa temp2 = hex_mat_copy[i][1];
                hex_mat_copy[i][1] = temp1;
                temp1 = hex_mat_copy[i][0];
                hex_mat_copy[i][0] = temp2;
                hex_mat_copy[i][3] = temp1;
            }
        }
        return hex_mat_copy;
    }
    public static void displayHexMatrix(Hexa[][] hex_matrix, int rows, int cols){
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {

                System.out.print(hex_matrix[i][j].firstChar +" "+ hex_matrix[i][j].secondChar + " ");
            }
            System.out.println ();
        }
    }
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

        Hexa hex_aftr_row_shift [][]= shiftRows(hex_aftr_sub, 4,4);
        System.out.println("After Shift Rows:");
        displayHexMatrix(hex_aftr_row_shift,4,4);
    }
}

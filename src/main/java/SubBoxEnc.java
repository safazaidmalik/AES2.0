public class SubBoxEnc {
    Hexa sBox[][] = new Hexa[16][16]; // [row][col]

    SubBoxEnc(){
        for(int i=0; i<16; i++){
            for(int j=0; j<16; j++){
                sBox[i][j] = new Hexa();
            }
        }
    }

    void setsBox() {
        //first row
        sBox[0][0].firstChar = '6';
        sBox[0][0].secondChar = '3';

        sBox[0][1].firstChar = '7';
        sBox[0][1].secondChar = 'C';

        sBox[0][2].firstChar = '7';
        sBox[0][2].secondChar = '7';

        sBox[0][3].firstChar = '7';
        sBox[0][3].secondChar = 'B';

        sBox[0][4].firstChar = 'F';
        sBox[0][4].secondChar = '2';

        sBox[0][5].firstChar = '6';
        sBox[0][5].secondChar = 'B';

        sBox[0][6].firstChar = '6';
        sBox[0][6].secondChar = 'F';

        sBox[0][7].firstChar = 'C';
        sBox[0][7].secondChar = '5';

        sBox[0][8].firstChar = '3';
        sBox[0][8].secondChar = '0';

        sBox[0][9].firstChar = '0';
        sBox[0][9].secondChar = '1';

        sBox[0][10].firstChar = '6';
        sBox[0][10].secondChar = '7';

        sBox[0][11].firstChar = '2';
        sBox[0][11].secondChar = 'B';

        sBox[0][12].firstChar = 'F';
        sBox[0][12].secondChar = 'E';

        sBox[0][13].firstChar = 'D';
        sBox[0][13].secondChar = '7';

        sBox[0][14].firstChar = 'A';
        sBox[0][14].secondChar = 'B';

        sBox[0][15].firstChar = '7';
        sBox[0][15].secondChar = '6';

        //second row
        sBox[1][0].firstChar = 'C';
        sBox[1][0].secondChar = 'A';

        sBox[1][1].firstChar = '8';
        sBox[1][1].secondChar = '2';

        sBox[1][2].firstChar = 'C';
        sBox[1][2].secondChar = '9';

        sBox[1][3].firstChar = '7';
        sBox[1][3].secondChar = 'D';

        sBox[1][4].firstChar = 'F';
        sBox[1][4].secondChar = 'A';

        sBox[1][5].firstChar = '5';
        sBox[1][5].secondChar = '9';

        sBox[1][6].firstChar = '4';
        sBox[1][6].secondChar = '7';

        sBox[1][7].firstChar = 'F';
        sBox[1][7].secondChar = '0';

        sBox[1][8].firstChar = 'A';
        sBox[1][8].secondChar = 'D';

        sBox[1][9].firstChar = 'D';
        sBox[1][9].secondChar = '4';

        sBox[1][10].firstChar = 'A';
        sBox[1][10].secondChar = '2';

        sBox[1][11].firstChar = 'A';
        sBox[1][11].secondChar = 'F';

        sBox[1][12].firstChar = '9';
        sBox[1][12].secondChar = 'C';

        sBox[1][13].firstChar = 'A';
        sBox[1][13].secondChar = '4';

        sBox[1][14].firstChar = '7';
        sBox[1][14].secondChar = '2';

        sBox[1][15].firstChar = 'C';
        sBox[1][15].secondChar = '0';

        //third row
        sBox[2][0].firstChar = 'B';
        sBox[2][0].secondChar = '7';

        sBox[2][1].firstChar = 'F';
        sBox[2][1].secondChar = 'D';

        sBox[2][2].firstChar = '9';
        sBox[2][2].secondChar = '3';

        sBox[2][3].firstChar = '2';
        sBox[2][3].secondChar = '6';

        sBox[2][4].firstChar = '3';
        sBox[2][4].secondChar = '6';

        sBox[2][5].firstChar = '3';
        sBox[2][5].secondChar = 'F';

        sBox[2][6].firstChar = 'F';
        sBox[2][6].secondChar = '7';

        sBox[2][7].firstChar = 'C';
        sBox[2][7].secondChar = 'C';

        sBox[2][8].firstChar = '3';
        sBox[2][8].secondChar = '4';

        sBox[2][9].firstChar = 'A';
        sBox[2][9].secondChar = '5';

        sBox[2][10].firstChar = 'E';
        sBox[2][10].secondChar = '5';

        sBox[2][11].firstChar = 'F';
        sBox[2][11].secondChar = '1';

        sBox[2][12].firstChar = '7';
        sBox[2][12].secondChar = '1';

        sBox[2][13].firstChar = 'D';
        sBox[2][13].secondChar = '8';

        sBox[2][14].firstChar = '3';
        sBox[2][14].secondChar = '1';

        sBox[2][15].firstChar = '1';
        sBox[2][15].secondChar = '5';

        //fourth row
        sBox[3][0].firstChar = '0';
        sBox[3][0].secondChar = '4';

        sBox[3][1].firstChar = 'C';
        sBox[3][1].secondChar = '7';

        sBox[3][2].firstChar = '2';
        sBox[3][2].secondChar = '3';

        sBox[3][3].firstChar = 'C';
        sBox[3][3].secondChar = '3';

        sBox[3][4].firstChar = '1';
        sBox[3][4].secondChar = '8';

        sBox[3][5].firstChar = '9';
        sBox[3][5].secondChar = '6';

        sBox[3][6].firstChar = '0';
        sBox[3][6].secondChar = '5';

        sBox[3][7].firstChar = '9';
        sBox[3][7].secondChar = 'A';

        sBox[3][8].firstChar = '0';
        sBox[3][8].secondChar = '7';

        sBox[3][9].firstChar = '1';
        sBox[3][9].secondChar = '2';

        sBox[3][10].firstChar = '8';
        sBox[3][10].secondChar = '0';

        sBox[3][11].firstChar = 'E';
        sBox[3][11].secondChar = '2';

        sBox[3][12].firstChar = 'E';
        sBox[3][12].secondChar = 'B';

        sBox[3][13].firstChar = '2';
        sBox[3][13].secondChar = '7';

        sBox[3][14].firstChar = 'B';
        sBox[3][14].secondChar = '2';

        sBox[3][15].firstChar = '7';
        sBox[3][15].secondChar = '5';

        //fifth row
        sBox[4][0].firstChar = '0';
        sBox[4][0].secondChar = '9';

        sBox[4][1].firstChar = '8';
        sBox[4][1].secondChar = '3';

        sBox[4][2].firstChar = '2';
        sBox[4][2].secondChar = 'C';

        sBox[4][3].firstChar = '1';
        sBox[4][3].secondChar = 'A';

        sBox[4][4].firstChar = '1';
        sBox[4][4].secondChar = 'B';

        sBox[4][5].firstChar = '6';
        sBox[4][5].secondChar = 'E';

        sBox[4][6].firstChar = '5';
        sBox[4][6].secondChar = 'A';

        sBox[4][7].firstChar = 'A';
        sBox[4][7].secondChar = '0';

        sBox[4][8].firstChar = '5';
        sBox[4][8].secondChar = '2';

        sBox[4][9].firstChar = '3';
        sBox[4][9].secondChar = 'B';

        sBox[4][10].firstChar = 'D';
        sBox[4][10].secondChar = '6';

        sBox[4][11].firstChar = 'B';
        sBox[4][11].secondChar = '3';

        sBox[4][12].firstChar = '2';
        sBox[4][12].secondChar = '9';

        sBox[4][13].firstChar = 'E';
        sBox[4][13].secondChar = '3';

        sBox[4][14].firstChar = '2';
        sBox[4][14].secondChar = 'F';

        sBox[4][15].firstChar = '8';
        sBox[4][15].secondChar = '4';

        //sixth row
        sBox[5][0].firstChar = '5';
        sBox[5][0].secondChar = '3';

        sBox[5][1].firstChar = 'D';
        sBox[5][1].secondChar = '1';

        sBox[5][2].firstChar = '0';
        sBox[5][2].secondChar = '0';

        sBox[5][3].firstChar = 'E';
        sBox[5][3].secondChar = 'D';

        sBox[5][4].firstChar = '2';
        sBox[5][4].secondChar = '0';

        sBox[5][5].firstChar = 'F';
        sBox[5][5].secondChar = 'C';

        sBox[5][6].firstChar = 'B';
        sBox[5][6].secondChar = '1';

        sBox[5][7].firstChar = '5';
        sBox[5][7].secondChar = 'B';

        sBox[5][8].firstChar = '6';
        sBox[5][8].secondChar = 'A';

        sBox[5][9].firstChar = 'C';
        sBox[5][9].secondChar = 'B';

        sBox[5][10].firstChar = 'B';
        sBox[5][10].secondChar = 'E';

        sBox[5][11].firstChar = '3';
        sBox[5][11].secondChar = '9';

        sBox[5][12].firstChar = '4';
        sBox[5][12].secondChar = 'A';

        sBox[5][13].firstChar = '4';
        sBox[5][13].secondChar = 'C';

        sBox[5][14].firstChar = '5';
        sBox[5][14].secondChar = '8';

        sBox[5][15].firstChar = 'C';
        sBox[5][15].secondChar = 'F';

        //seventh row
        sBox[6][0].firstChar = 'D';
        sBox[6][0].secondChar = '0';

        sBox[6][1].firstChar = 'E';
        sBox[6][1].secondChar = 'F';

        sBox[6][2].firstChar = 'A';
        sBox[6][2].secondChar = 'A';

        sBox[6][3].firstChar = 'F';
        sBox[6][3].secondChar = 'B';

        sBox[6][4].firstChar = '4';
        sBox[6][4].secondChar = '3';

        sBox[6][5].firstChar = '4';
        sBox[6][5].secondChar = 'D';

        sBox[6][6].firstChar = '3';
        sBox[6][6].secondChar = '3';

        sBox[6][7].firstChar = '8';
        sBox[6][7].secondChar = '5';

        sBox[6][8].firstChar = '4';
        sBox[6][8].secondChar = '5';

        sBox[6][9].firstChar = 'F';
        sBox[6][9].secondChar = '9';

        sBox[6][10].firstChar = '0';
        sBox[6][10].secondChar = '2';

        sBox[6][11].firstChar = '7';
        sBox[6][11].secondChar = 'F';

        sBox[6][12].firstChar = '5';
        sBox[6][12].secondChar = '0';

        sBox[6][13].firstChar = '3';
        sBox[6][13].secondChar = 'C';

        sBox[6][14].firstChar = '9';
        sBox[6][14].secondChar = 'F';

        sBox[6][15].firstChar = 'A';
        sBox[6][15].secondChar = '8';

        //eighth row
        sBox[7][0].firstChar = '5';
        sBox[7][0].secondChar = '1';

        sBox[7][1].firstChar = 'A';
        sBox[7][1].secondChar = '3';

        sBox[7][2].firstChar = '4';
        sBox[7][2].secondChar = '0';

        sBox[7][3].firstChar = '8';
        sBox[7][3].secondChar = 'F';

        sBox[7][4].firstChar = '9';
        sBox[7][4].secondChar = '2';

        sBox[7][5].firstChar = '9';
        sBox[7][5].secondChar = 'D';

        sBox[7][6].firstChar = '3';
        sBox[7][6].secondChar = '8';

        sBox[7][7].firstChar = 'F';
        sBox[7][7].secondChar = '5';

        sBox[7][8].firstChar = 'B';
        sBox[7][8].secondChar = 'C';

        sBox[7][9].firstChar = 'B';
        sBox[7][9].secondChar = '6';

        sBox[7][10].firstChar = 'D';
        sBox[7][10].secondChar = 'A';

        sBox[7][11].firstChar = '2';
        sBox[7][11].secondChar = '1';

        sBox[7][12].firstChar = '1';
        sBox[7][12].secondChar = '0';

        sBox[7][13].firstChar = 'F';
        sBox[7][13].secondChar = 'F';

        sBox[7][14].firstChar = 'F';
        sBox[7][14].secondChar = '3';

        sBox[7][15].firstChar = 'D';
        sBox[7][15].secondChar = '2';

        //nineth row
        sBox[8][0].firstChar = 'C';
        sBox[8][0].secondChar = 'D';

        sBox[8][1].firstChar = '0';
        sBox[8][1].secondChar = 'C';

        sBox[8][2].firstChar = '1';
        sBox[8][2].secondChar = '3';

        sBox[8][3].firstChar = 'E';
        sBox[8][3].secondChar = 'C';

        sBox[8][4].firstChar = '5';
        sBox[8][4].secondChar = 'F';

        sBox[8][5].firstChar = '9';
        sBox[8][5].secondChar = '7';

        sBox[8][6].firstChar = '4';
        sBox[8][6].secondChar = '4';

        sBox[8][7].firstChar = '1';
        sBox[8][7].secondChar = '7';

        sBox[8][8].firstChar = 'C';
        sBox[8][8].secondChar = '4';

        sBox[8][9].firstChar = 'A';
        sBox[8][9].secondChar = '7';

        sBox[8][10].firstChar = '7';
        sBox[8][10].secondChar = 'E';

        sBox[8][11].firstChar = '3';
        sBox[8][11].secondChar = 'D';

        sBox[8][12].firstChar = '6';
        sBox[8][12].secondChar = '4';

        sBox[8][13].firstChar = '5';
        sBox[8][13].secondChar = 'D';

        sBox[8][14].firstChar = '1';
        sBox[8][14].secondChar = '9';

        sBox[8][15].firstChar = '7';
        sBox[8][15].secondChar = '3';

        //tenth row
        sBox[9][0].firstChar = '6';
        sBox[9][0].secondChar = '0';

        sBox[9][1].firstChar = '8';
        sBox[9][1].secondChar = '1';

        sBox[9][2].firstChar = '4';
        sBox[9][2].secondChar = 'F';

        sBox[9][3].firstChar = 'D';
        sBox[9][3].secondChar = 'C';

        sBox[9][4].firstChar = '2';
        sBox[9][4].secondChar = '2';

        sBox[9][5].firstChar = '2';
        sBox[9][5].secondChar = 'A';

        sBox[9][6].firstChar = '9';
        sBox[9][6].secondChar = '0';

        sBox[9][7].firstChar = '8';
        sBox[9][7].secondChar = '8';

        sBox[9][8].firstChar = '4';
        sBox[9][8].secondChar = '6';

        sBox[9][9].firstChar = 'E';
        sBox[9][9].secondChar = 'E';

        sBox[9][10].firstChar = 'D';
        sBox[9][10].secondChar = '8';

        sBox[9][11].firstChar = '1';
        sBox[9][11].secondChar = '4';

        sBox[9][12].firstChar = 'D';
        sBox[9][12].secondChar = 'E';

        sBox[9][13].firstChar = '5';
        sBox[9][13].secondChar = 'E';

        sBox[9][14].firstChar = '0';
        sBox[9][14].secondChar = 'B';

        sBox[9][15].firstChar = 'D';
        sBox[9][15].secondChar = 'B';

        //eleventh row
        sBox[10][0].firstChar = 'E';
        sBox[10][0].secondChar = '0';

        sBox[10][1].firstChar = '3';
        sBox[10][1].secondChar = '2';

        sBox[10][2].firstChar = '3';
        sBox[10][2].secondChar = 'A';

        sBox[10][3].firstChar = '0';
        sBox[10][3].secondChar = 'A';

        sBox[10][4].firstChar = '4';
        sBox[10][4].secondChar = '9';

        sBox[10][5].firstChar = '0';
        sBox[10][5].secondChar = '6';

        sBox[10][6].firstChar = '2';
        sBox[10][6].secondChar = '4';

        sBox[10][7].firstChar = '5';
        sBox[10][7].secondChar = 'C';

        sBox[10][8].firstChar = 'C';
        sBox[10][8].secondChar = '2';

        sBox[10][9].firstChar = 'D';
        sBox[10][9].secondChar = '3';

        sBox[10][10].firstChar = 'A';
        sBox[10][10].secondChar = 'C';

        sBox[10][11].firstChar = '6';
        sBox[10][11].secondChar = '2';

        sBox[10][12].firstChar = '9';
        sBox[10][12].secondChar = '1';

        sBox[10][13].firstChar = '9';
        sBox[10][13].secondChar = '5';

        sBox[10][14].firstChar = 'E';
        sBox[10][14].secondChar = '4';

        sBox[10][15].firstChar = '7';
        sBox[10][15].secondChar = '9';

        //Twelveth row
        sBox[11][0].firstChar = 'E';
        sBox[11][0].secondChar = '7';

        sBox[11][1].firstChar = 'C';
        sBox[11][1].secondChar = '8';

        sBox[11][2].firstChar = '3';
        sBox[11][2].secondChar = '7';

        sBox[11][3].firstChar = '9';
        sBox[11][3].secondChar = 'D';

        sBox[11][4].firstChar = '8';
        sBox[11][4].secondChar = 'D';

        sBox[11][5].firstChar = 'D';
        sBox[11][5].secondChar = '5';

        sBox[11][6].firstChar = '4';
        sBox[11][6].secondChar = 'E';

        sBox[11][7].firstChar = 'A';
        sBox[11][7].secondChar = '9';

        sBox[11][8].firstChar = '6';
        sBox[11][8].secondChar = 'C';

        sBox[11][9].firstChar = '5';
        sBox[11][9].secondChar = '6';

        sBox[11][10].firstChar = 'F';
        sBox[11][10].secondChar = '4';

        sBox[11][11].firstChar = 'E';
        sBox[11][11].secondChar = 'A';

        sBox[11][12].firstChar = '6';
        sBox[11][12].secondChar = '5';

        sBox[11][13].firstChar = '7';
        sBox[11][13].secondChar = 'A';

        sBox[11][14].firstChar = 'A';
        sBox[11][14].secondChar = 'E';

        sBox[11][15].firstChar = '0';
        sBox[11][15].secondChar = '8';

        //Thirteenth row
        sBox[12][0].firstChar = 'B';
        sBox[12][0].secondChar = 'A';

        sBox[12][1].firstChar = '7';
        sBox[12][1].secondChar = '8';

        sBox[12][2].firstChar = '2';
        sBox[12][2].secondChar = '5';

        sBox[12][3].firstChar = '2';
        sBox[12][3].secondChar = '3';

        sBox[12][4].firstChar = '1';
        sBox[12][4].secondChar = 'C';

        sBox[12][5].firstChar = 'A';
        sBox[12][5].secondChar = '6';

        sBox[12][6].firstChar = 'B';
        sBox[12][6].secondChar = '4';

        sBox[12][7].firstChar = 'C';
        sBox[12][7].secondChar = '6';

        sBox[12][8].firstChar = 'E';
        sBox[12][8].secondChar = '8';

        sBox[12][9].firstChar = 'D';
        sBox[12][9].secondChar = 'D';

        sBox[12][10].firstChar = '7';
        sBox[12][10].secondChar = '4';

        sBox[12][11].firstChar = '1';
        sBox[12][11].secondChar = 'F';

        sBox[12][12].firstChar = '4';
        sBox[12][12].secondChar = 'B';

        sBox[12][13].firstChar = 'B';
        sBox[12][13].secondChar = 'D';

        sBox[12][14].firstChar = '8';
        sBox[12][14].secondChar = 'B';

        sBox[12][15].firstChar = '8';
        sBox[12][15].secondChar = 'A';

        //Fourtheenth row
        sBox[13][0].firstChar = '7';
        sBox[13][0].secondChar = '0';

        sBox[13][1].firstChar = '3';
        sBox[13][1].secondChar = 'E';

        sBox[13][2].firstChar = 'B';
        sBox[13][2].secondChar = '5';

        sBox[13][3].firstChar = '6';
        sBox[13][3].secondChar = '6';

        sBox[13][4].firstChar = '4';
        sBox[13][4].secondChar = '8';

        sBox[13][5].firstChar = '0';
        sBox[13][5].secondChar = '3';

        sBox[13][6].firstChar = 'F';
        sBox[13][6].secondChar = '6';

        sBox[13][7].firstChar = '0';
        sBox[13][7].secondChar = 'E';

        sBox[13][8].firstChar = '6';
        sBox[13][8].secondChar = '1';

        sBox[13][9].firstChar = '3';
        sBox[13][9].secondChar = '5';

        sBox[13][10].firstChar = '5';
        sBox[13][10].secondChar = '7';

        sBox[13][11].firstChar = 'B';
        sBox[13][11].secondChar = '9';

        sBox[13][12].firstChar = '8';
        sBox[13][12].secondChar = '6';

        sBox[13][13].firstChar = 'C';
        sBox[13][13].secondChar = '1';

        sBox[13][14].firstChar = '1';
        sBox[13][14].secondChar = 'D';

        sBox[13][15].firstChar = '9';
        sBox[13][15].secondChar = 'E';

        //Fifteenth row
        sBox[14][0].firstChar = 'E';
        sBox[14][0].secondChar = '1';

        sBox[14][1].firstChar = 'F';
        sBox[14][1].secondChar = '8';

        sBox[14][2].firstChar = '9';
        sBox[14][2].secondChar = '8';

        sBox[14][3].firstChar = '1';
        sBox[14][3].secondChar = '1';

        sBox[14][4].firstChar = '6';
        sBox[14][4].secondChar = '9';

        sBox[14][5].firstChar = 'D';
        sBox[14][5].secondChar = '9';

        sBox[14][6].firstChar = '8';
        sBox[14][6].secondChar = 'E';

        sBox[14][7].firstChar = '9';
        sBox[14][7].secondChar = '4';

        sBox[14][8].firstChar = '9';
        sBox[14][8].secondChar = 'B';

        sBox[14][9].firstChar = '1';
        sBox[14][9].secondChar = 'E';

        sBox[14][10].firstChar = '8';
        sBox[14][10].secondChar = '7';

        sBox[14][11].firstChar = 'E';
        sBox[14][11].secondChar = '9';

        sBox[14][12].firstChar = 'C';
        sBox[14][12].secondChar = 'E';

        sBox[14][13].firstChar = '5';
        sBox[14][13].secondChar = '5';

        sBox[14][14].firstChar = '2';
        sBox[14][14].secondChar = '8';

        sBox[14][15].firstChar = 'D';
        sBox[14][15].secondChar = 'F';

        //Sixteenth row
        sBox[15][0].firstChar = '8';
        sBox[15][0].secondChar = 'C';

        sBox[15][1].firstChar = 'A';
        sBox[15][1].secondChar = '1';

        sBox[15][2].firstChar = '8';
        sBox[15][2].secondChar = '9';

        sBox[15][3].firstChar = '0';
        sBox[15][3].secondChar = 'D';

        sBox[15][4].firstChar = 'B';
        sBox[15][4].secondChar = 'F';

        sBox[15][5].firstChar = 'E';
        sBox[15][5].secondChar = '6';

        sBox[15][6].firstChar = '4';
        sBox[15][6].secondChar = '2';

        sBox[15][7].firstChar = '6';
        sBox[15][7].secondChar = '8';

        sBox[15][8].firstChar = '4';
        sBox[15][8].secondChar = '1';

        sBox[15][9].firstChar = '9';
        sBox[15][9].secondChar = '9';

        sBox[15][10].firstChar = '2';
        sBox[15][10].secondChar = 'D';

        sBox[15][11].firstChar = '0';
        sBox[15][11].secondChar = 'F';

        sBox[15][12].firstChar = 'B';
        sBox[15][12].secondChar = '0';

        sBox[15][13].firstChar = '5';
        sBox[15][13].secondChar = '4';

        sBox[15][14].firstChar = 'B';
        sBox[15][14].secondChar = 'B';

        sBox[15][15].firstChar = '1';
        sBox[15][15].secondChar = '6';

    }

    char[] getVal(char row, char col) {
        SubBoxEnc sb = new SubBoxEnc();
        char subValues[] = new char[2];

        int rowNum = 0, colNum = 0;

        if (row <= 57) {
            rowNum = row;
            rowNum -= 48;
        }

        if(col <= 57) {
            colNum = col;
            colNum -= 48;
        }

        if(row=='A'){
            rowNum=10;
        }
        else if(row=='B'){
            rowNum=11;
        }
        else if(row=='C'){
            rowNum=12;
        }
        else if(row=='D'){
            rowNum=13;
        }
        else if(row=='E'){
            rowNum=14;
        }
        else if(row=='F'){
            rowNum=15;
        }

        if(col=='A'){
            colNum=10;
        }
        else if(col=='B'){
            colNum=11;
        }
        else if(col=='C'){
            colNum=12;
        }
        else if(col=='D'){
            colNum=13;
        }
        else if(col=='E'){
            colNum=14;
        }
        else if(col=='F'){
            colNum=15;
        }
        sb.setsBox();
        Hexa temp = sb.sBox[rowNum][colNum];

        subValues[0] = temp.firstChar;
        subValues[1] = temp.secondChar;

        return subValues;
    }
    public void displaySubBox(){
        SubBoxEnc sb = new SubBoxEnc();
        sb.setsBox();
        for(int i =0; i < 16 ; i++){
            for(int j = 0; j < 16; j++){
                System.out.print(sb.sBox[i][j].firstChar+""+ sb.sBox[i][j].secondChar+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        SubBoxEnc sb = new SubBoxEnc();
        sb.displaySubBox();
    }
}

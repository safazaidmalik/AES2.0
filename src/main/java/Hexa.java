public class Hexa {
    char firstChar;
    char secondChar;

    Hexa(){
        firstChar = '0';
        secondChar = '0';
    }
    void decToHex(int n){
        char hexaDeciNum[] = new char[2];

        // counter for hexadecimal number array
        int i = 0;
        while (n != 0) {
            // temporary variable to store remainder
            int temp = 0;

            // storing remainder in temp variable.
            temp = n % 16;

            // check if temp < 10
            if (temp < 10) {
                hexaDeciNum[i] = (char) (temp + 48);
                i++;
            }
            else {
                hexaDeciNum[i] = (char) (temp + 55);
                i++;
            }

            n = n / 16;
        }

        this.firstChar = hexaDeciNum[1];
        this.secondChar = hexaDeciNum[0];

    }

    void displayHex(){
        System.out.print(this.firstChar);
        System.out.print(this.secondChar);
    }

    int hexToDec(){
        int decVal = 0;

        if (firstChar >= '0' && firstChar <= '9') {
            decVal += (((int)(firstChar)) - 48) * 16;
        }
        else if (firstChar == 'A') {
            decVal += 10*16;
        }
        else if (firstChar == 'B') {
            decVal += 11*16;
        }
        else if (firstChar == 'C') {
            decVal += 12*16;
        }
        else if (firstChar == 'D') {
            decVal += 13*16;
        }
        else if (firstChar == 'E') {
            decVal += 14*16;
        }
        else if (firstChar == 'F') {
            decVal += 15*16;
        }

        if (secondChar >= '0' && secondChar <= '9') {
            decVal += ((int)(secondChar)) - 48;
        }
        else if (secondChar == 'A') {
            decVal += 10;
        }
        else if (secondChar == 'B') {
            decVal += 11;
        }
        else if (secondChar == 'C') {
            decVal += 12;
        }
        else if (secondChar == 'D') {
            decVal += 13;
        }
        else if (secondChar == 'E') {
            decVal += 14;
        }
        else if (secondChar == 'F') {
            decVal += 15;
        }

        return decVal;
    }

    Binary decToBin(int val){
        Binary bin = new Binary();
        int valTmp = val;

        int tmp = 128; // 2 power 7

        for(int i = 0; i < 7; i++){
            int remainder = val % tmp;
            if(remainder < valTmp){
                valTmp -= tmp;
                bin.setBit(i);
            }
            tmp = (int)(Math.pow(i,2));
        }
        return bin;
    }

    Binary hexToBin(){
        return decToBin(hexToDec());
    }



    // safa's work
    public Hexa copyHex(Hexa hexaToCopy)
    {
        this.firstChar = hexaToCopy.firstChar;
        this.secondChar = hexaToCopy.secondChar;
        return this;
    }

    public String xoring(String a, String b, int n){
        String ans = "";
        for (int i = 0; i < n; i++)
        {
            // If the Character matches
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }

    String hexToBinary(int hex_DecValue) {
        String binary = Integer.toBinaryString(hex_DecValue);
        int added_zeros = 4-binary.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<added_zeros; i++)
        {
            sb.append('0');
        }
        for(int i=0; i<binary.length(); i++)
            sb.append(binary.charAt(i));
        String binaryFinal = sb.toString();
        System.out.println("Binary Value is : " + binaryFinal);
        return binaryFinal;
    }
    /*
        Hexa xorHex(Hexa h2) {
            Hexa thisChar1 = new Hexa();
            thisChar1.firstChar = '0';
            thisChar1.secondChar = this.firstChar;
            int int1_1 = thisChar1.hexToDec();
            String bin1_1 = hexToBinary(int1_1);

            Hexa h2Char1 = new Hexa();
            h2Char1.firstChar = '0';
            h2Char1.secondChar = h2.firstChar;
            int int2_1 = h2Char1.hexToDec();
            String bin2_1 = hexToBinary(int2_1);

            String xor1 = xoring(bin1_1,bin2_1,4);
            System.out.println("\nBitwise XOR bit 1: "+xor1);

            Hexa thisChar2 = new Hexa();
            thisChar2.firstChar = '0';
            thisChar2.secondChar = this.secondChar;
            int int1_2 = thisChar2.hexToDec();
            String bin1_2 = hexToBinary(int1_2);

            Hexa h2Char2 = new Hexa();
            h2Char2.firstChar = '0';
            h2Char2.secondChar = h2.secondChar;
            int int2_2 = h2Char2.hexToDec();
            String bin2_2 = hexToBinary(int2_2);

            //Xoring

            String xor2 = xoring(bin1_2,bin2_2,4);
            System.out.println("\nBitwise XOR bit 2: "+xor2);

            return this;
        }
    */
    Hexa xorHex(Hexa h2)
    {
        Hexa thisChar1 = new Hexa();
        thisChar1.firstChar = '0';
        thisChar1.secondChar = this.firstChar;
        int int1_1 = thisChar1.hexToDec();
        String bin1_1 = hexToBinary(int1_1);

        Hexa h2Char1 = new Hexa();
        h2Char1.firstChar = '0';
        h2Char1.secondChar = h2.firstChar;
        int int2_1 = h2Char1.hexToDec();
        String bin2_1 = hexToBinary(int2_1);

        String xor1 = xoring(bin1_1,bin2_1,4).toUpperCase();

        Hexa thisChar2 = new Hexa();
        thisChar2.firstChar = '0';
        thisChar2.secondChar = this.secondChar;
        int int1_2 = thisChar2.hexToDec();
        String bin1_2 = hexToBinary(int1_2);

        Hexa h2Char2 = new Hexa();
        h2Char2.firstChar = '0';
        h2Char2.secondChar = h2.secondChar;
        int int2_2 = h2Char2.hexToDec();
        String bin2_2 = hexToBinary(int2_2);

        //Xoring

        String xor2 = xoring(bin1_2,bin2_2,4).toUpperCase();
        this.firstChar = Character.toUpperCase(binToHexa(xor1, xor2).firstChar);
        this.secondChar = Character.toUpperCase(binToHexa(xor1, xor2).secondChar);

        return this;
    }
    Hexa binToHexa(String bit1, String bit2)
    {
        int num1 = Integer.parseInt(bit1, 2);
        int num2 = Integer.parseInt(bit2, 2);
        String hex1 = Integer.toHexString(num1);
        String hex2 = Integer.toHexString(num2);
        Hexa xorResult = new Hexa();
        xorResult.firstChar = hex1.charAt(0);
        xorResult.secondChar = hex2.charAt(0);
        return xorResult;
    }

}

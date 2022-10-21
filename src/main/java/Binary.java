public class Binary {
    boolean num[] = new boolean[8];

    Binary(){
        for (int i = 0; i < 8; i++) {
            num[i] = false;
        }
    }

    void setBit(int index){
        num[index] = true;
    }

    boolean getBit(int index){
        return num[index];
    }

    Binary XOR(Binary n){
        Binary result = new Binary();
        boolean overflowBit = false;

        for (int i = 0; i < 8; i++) {
            if((n.getBit(i) == true && num[i] == false) || (n.getBit(i) == false && num[i] == true)){
                result.setBit(i);
                if(i==7) {
                    overflowBit = true; // take double XOR
                }
            }
        }

        if(overflowBit == true){
            result = result.XOR(result);
        }

        return result;
    }

    int binToDec(){
        int dec = 0;

        for(int i=0; i<8; i++){
            if(getBit(i) == true){
                dec += Math.pow(i,2);
            }
        }

        return dec;
    }
}

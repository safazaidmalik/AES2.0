public class GaloisFields {

    static String irreducible_aes_128;
    public GaloisFields(){
        irreducible_aes_128 = "100011011";
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

    
    public static String shiftLeftByOneBit(String binary_str1)
    {
        String result = "";
        result = binary_str1.substring(1, binary_str1.length())+'0';
        return result;
    }


    public static String GaloisMultiplication(String g_x, String f_x)
    {
        String resultant = "";
        //The maximum placement of the digit 1 in g(x)
        int order = f_x.length()-f_x.indexOf('1');
        //Removing overflow bit
        String new_irreducible = irreducible_aes_128.substring(1, irreducible_aes_128.length());

        //copy of g(x)
        String g_x_copy = g_x;

        //2d array containing all the xf(x)
        String x_arr[] = new String[order+1];

        x_arr[0] = g_x;


        for(int i = 1 ; i <= order ; i++){
            if(g_x_copy.charAt(0) == '0') //if overflow bit is '0', only left shift is required
            {
                g_x_copy = shiftLeftByOneBit(g_x_copy);
                x_arr[i]=g_x_copy;
            }
            else //
            {
                g_x_copy = shiftLeftByOneBit(g_x_copy);//if overflow bit is '1', left shift and xor are required
                g_x_copy = XOR_Func(g_x_copy, new_irreducible);
                x_arr[i] = g_x_copy;
            }
        }

        //making all bits of resultant 0s
        for(int i=0;i<f_x.length();i++)
        {
            resultant = resultant + "0";
        }

        //XOR values where bit x = 1
        for(int i=0;i<f_x.length();i++)
        {
            if(f_x.charAt(i)=='1')
            {
                resultant = XOR_Func(x_arr[(f_x.length()-i)-1],resultant);
            }
        }

        return resultant;
    }
    public static void main(String [] args){

        GaloisFields gf = new GaloisFields();
        System.out.println(gf.GaloisMultiplication("01010111","10000011"));
    }
}
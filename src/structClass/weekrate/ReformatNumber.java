package structClass.weekrate;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/20 10:33
 */
public class ReformatNumber {

    public static String test(String number){
        if(null == number || "".equals(number) || number.length()<= 3)return number;
        StringBuilder builder = new StringBuilder();
        number = number.replace(" ","").replace("-","");
        String first = "";
        String secode = "";
        if(number.length()%3!=0) {
            first = number.substring(0, number.length() - 4);
            secode =  number.substring(number.length() - 4);
        }else {
            first = number;
        }
        for (int i = 0;i< first.length();i++){
            char c = first.charAt(i);
            builder.append(c);
            if((i+1)%3 == 0 && i < number.length()-1) builder.append('-');
        }
         boolean flag = secode.length()%2 ==0;
        for (int j = 0;j<secode.length();j++){
            if(flag && j <1){
                builder.append(secode.charAt(j));
                continue;
            }
            if(flag && (j+1)%2 == 0 && j< secode.length()-1){
              builder.append(secode.charAt(j)).append('-');
              continue;
            }
            builder.append(secode.charAt(j));

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(test("--17-5 229 35-39475 "));
    }
}

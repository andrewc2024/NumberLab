
public class Number {
    private int denary;

    public Number(int denary) {
        this.denary = denary;
    }

    public int getDenary() {
        return denary;
    }

    public void setDenary(int denary) {
        this.denary = denary;
    }

    public String getSignedBinary(){
        String answer = "";
        int x = 0;
        int numb = getDenary();
        while((1<<x) <= Math.abs(numb)){
            x++;
        }
        int power = 1 << (x-1), goal = 0;
        if (numb < 0) {
            goal = (1<<x) + numb;
            answer += '1';
        } else {
            goal = numb;
            answer += '0';
        }
        for (int i = 1; i <= x; i++) {
            if (goal >= power) {
                goal -= power;
                answer += '1';
            } else {
                answer += '0';
            }
            power /= 2;
        }
        return answer;

    }

    public String getHexadecimal(){
        String s = getSignedBinary(), answer = "";
        int remainder = s.length()%4;
        for(int i = 0; i < s.length()/4 + (remainder != 0?1:0); i++){
            int num = 0;
            for(int j = 3;j >= 0;j--){
                if(i == 0 && remainder != 0 && j>= remainder)continue;
                if(s.charAt((i-1)*4+(3-j) + (remainder == 0?4: remainder)) =='1'){
                    num+=(1<<j);
                }
            }
            if(num == 0)continue;
            if(num <= 9){
                answer = answer + (char)(num+'0');
            }
            else{
                num-=10;
                answer = answer + (char)(num+'A');
            }
        }
        return answer;
    }
    public void negate()
    {
        int number = getDenary();
        number = number* -1;
        setDenary(number);
    }

    @Override
    public String toString() {
        String x = getHexadecimal();
        String y = String.valueOf(getDenary());
        String z = getSignedBinary();
        return "Number{denary=" + y+ " binary=" + z+" hexadecimal=" +x +"}";
    }
}

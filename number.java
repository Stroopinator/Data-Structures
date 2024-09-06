public class number {
    public int numerator;
    public int denominator;
    public boolean fraction;

    public number(int _numerator){
        numerator = _numerator;
        denominator = 1;
        fraction = false;
    }

    public number(int _numerator, int _denominator){
        numerator = _numerator;
        denominator = _denominator;
        fraction = true;
    
    }
    public boolean isFraction(){
        return fraction;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

}

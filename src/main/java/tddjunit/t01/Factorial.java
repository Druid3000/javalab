package tddjunit.t01;

class Factorial {
    int fact(int number) throws Exception{

        if(number < 0) throw new Exception();

        int i = 1;
        int result = 1;
        while (i <= number) {
            result = result * i;
            i++;
        }
        return result;
    }
}

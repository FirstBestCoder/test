package com.liuzm.test;

public class Singlenton {

    private volatile static Singlenton singlenton;
    private Singlenton(){}
    public static  Singlenton getSinglenton(){
        if (singlenton == null){
            synchronized(Singlenton.class) {
                singlenton = new Singlenton();
            }
        }
        return singlenton;
    }

}
class Singlenton2{
    private static Singlenton2 SINGLENTON_2 = new Singlenton2();
    private Singlenton2(){}
    public static Singlenton2 getSinglenton2(){
        return SINGLENTON_2;
    }
}
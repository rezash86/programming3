package com.jac.mvc.springmvcproject.testexperiment;

public class Dummy {

    public Integer customAdd(int a, int b) throws Exception {
        if(a < 0 || b< 0){
            throw new Exception("The number needs to be positive");
        }
        if(a > 0 && b> 0){
            return a+b;
        }
        return -1;
    }

    public boolean isOdd(int number){
        return number % 2 != 0;
    }
}

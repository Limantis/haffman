package com.limantis;

/**
 * Created by Katerina on 25.02.2018.
 */
 class Leave {
    Character symb;
    String cod;
    Integer priorety;
    Leave leftChaild;
    Leave rightChild;
    Leave (Character symb, Integer priorety){
        this.symb = symb;
        this.priorety = priorety;
        this.cod="";
    }
    Leave (Leave left, Leave right, Integer priorety){
        this.priorety = priorety;
        leftChaild = left;
        rightChild = right;
        this.cod="";
    }
}
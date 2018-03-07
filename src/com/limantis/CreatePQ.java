package com.limantis;

import java.util.ArrayList;
import java.util.Scanner;



public class CreatePQ {
    ArrayList arrayOfString;
    CreatePQ(){
        ReadInput myreadInput = new ReadInput();
        myreadInput.Start(this.arrayOfString);
    }
    public void Start(){
        System.out.println(this.arrayOfString);
    }
}

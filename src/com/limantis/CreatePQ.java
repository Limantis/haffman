package com.limantis;

import java.util.*;


public class CreatePQ {
    ArrayList arrayOfString;
    CreatePQ(){
        this.arrayOfString = new ArrayList<String>();
        ReadInput myreadInput = new ReadInput();
        myreadInput.Start(this.arrayOfString);
    }

    private static Comparator<Integer> idComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return (Integer) (i2 - i1);
        }
    };

    public void Start(){
        Queue<Integer> userPriorityQueeue = new PriorityQueue<Integer>(7, idComparator);

        for (int i = 0; i < this.arrayOfString.size(); i++) {
            userPriorityQueeue.add(i);
        }

        System.out.println(userPriorityQueeue.peek());
    }
}

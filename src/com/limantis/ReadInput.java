package com.limantis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Katerina on 25.02.2018.
 */
class ReadInput {
    public void Start(ArrayList arrayOfString){
        Scanner sc = new Scanner(System.in);
        Integer numberOfString = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numberOfString; i++) {
            arrayOfString.add(sc.nextLine());
        }
    }
}

package com.limantis;

import java.util.*;

/**
 * Created by Katerina on 17.02.2018.
 */
public class haffman {
    private static Comparator<Leave> idComparator = new Comparator<Leave>() {
        @Override
        public int compare(Leave c1, Leave c2) {
            return (Integer) (c1.priorety - c2.priorety);
        }
    };

    public static HashMap<Character, String> QueueToMap(Leave startLeave) {

        HashMap<Character, String> mapCod = new HashMap<>();

        if (!(startLeave.leftChaild == null)) {
            startLeave.leftChaild.cod = startLeave.cod + "0";
            Iterator it = QueueToMap(startLeave.leftChaild).entrySet().iterator();
            while (it.hasNext()){
                Map.Entry me = (Map.Entry)it.next();
                mapCod.put((Character) me.getKey(), (String) me.getValue());
            }
        }
        if (!(startLeave.rightChild == null)) {
            startLeave.rightChild.cod = startLeave.cod + "1";
            Iterator it = QueueToMap(startLeave.rightChild).entrySet().iterator();
            while (it.hasNext()){
                Map.Entry me = (Map.Entry)it.next();
                mapCod.put((Character) me.getKey(), (String) me.getValue());
            }
        }
        if (!(startLeave.symb == null)) {
            if (startLeave.cod=="") startLeave.cod="0";
            mapCod.put(startLeave.symb, startLeave.cod);
        }
        return mapCod;
    }
    public void Start(){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        Queue<Leave> userPriorityQueeue = new PriorityQueue<>(7, idComparator);

        TreeMap<Character, Integer> userList = new TreeMap<>();
        int tempCount = 0;

        for (int i = 0; i < n.length(); i++) {
            if (userList.containsKey(n.charAt(i))) {
                tempCount = userList.get(n.charAt(i)) + 1;
                userList.put(n.charAt(i), tempCount);
            } else {
                userList.put(n.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : userList.entrySet()) {
            userPriorityQueeue.add(new Leave(pair.getKey(), pair.getValue()));
        }
        while (userPriorityQueeue.size() != 1) {
            Leave fisrstLeave = userPriorityQueeue.poll();
            Leave secondLeave = userPriorityQueeue.poll();
            userPriorityQueeue.add(new Leave(fisrstLeave, secondLeave, fisrstLeave.priorety + secondLeave.priorety));
        }

        Map<Character, String> mapCod = new HashMap<>(QueueToMap(userPriorityQueeue.poll()));

        String resultString="";
        for (int j = 0; j < n.length(); j++) {
            resultString=resultString+(mapCod.get(n.charAt(j)));
        }

        System.out.println(mapCod.size() +" " + resultString.length());
        Iterator it = mapCod.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        System.out.println(resultString);
    }
    }

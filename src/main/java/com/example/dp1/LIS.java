package com.example.dp1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LIS {
int[] LEDS;
int[] lis1;
int size;
int[] subArray;
boolean[] ON;
int max, maxindex;
int subsequence[];
public LIS (int[]LEDS, int size) {
    this.LEDS = LEDS;
    this.size = size;
    findlis(LEDS,size);
    }

    public static StringBuilder arraystat=new StringBuilder();

public void findlis(int[] LEDS, int size) {
    ON = new boolean[size];
     subArray = new int[size];
    lis1 = new int[size];
    for (int i = 0; i < size; i++) {
        lis1[i] = 1; // initial value
        subArray[i] = -1;
    }
    StringBuilder tempindex = new StringBuilder();
    tempindex.append("[");

    for (int i = 0 ; i < lis1.length ; i++) {
        tempindex.append(i+",");

    }
    tempindex.append("]");

    for (int i = 1; i < lis1.length; i++) {
        for (int j = 0; j < i; j++) {
            if (LEDS[i] >= LEDS[j] && lis1[i] <= lis1[j] + 1) {
                lis1[i] = lis1[j] + 1;
                subArray[i] = j;
                arraystat.append("Values Array\n");
                arraystat.append(Arrays.toString(lis1)+"\n");
                arraystat.append(tempindex.toString()+"\n");
                arraystat.append("Path Array\n");
                arraystat.append(Arrays.toString(subArray)+"\n");
                arraystat.append(tempindex.toString()+"\n");
                arraystat.append("####################################\n");

            }
        }
    }
    maxindex = max_index(lis1);
    ON[maxindex] = true;

    int maxindex2 = subArray[maxindex];
    while (true) {
        if (maxindex2 == -1)
            break;
        ON[maxindex2] = true;
        maxindex2 = subArray[maxindex2];

    }




}



    public  int max_index(int []LiS) {
         max = LiS[0];
        int index = 0;
        for (int i = 1; i < LiS.length; i++)
            if (max<LiS[i]) {
                max = LiS[i];
                index = i;
            }
        return index;
    }

    public String subsequnceString() {
    String text = "";
    subsequence = new int[max];
    int[] s = new int[subArray.length];
        for (int i = 0; i < subArray.length; i++) {
            s[i] = subArray[i];
        }
    int c = 0;
        for (int i = 0; i < ON.length; i++) {
            if(ON[i]==true)
            {
                s[c] = LEDS[i];
                text+=LEDS[i]+" ";
                c++;
            }
        }
        return text;
    }

}
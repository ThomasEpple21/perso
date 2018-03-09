package com.afpa.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Saisie {


    private static Scanner sc=new Scanner(System.in); //static= initialiasation directe




    public static String saisirChaine()
    {

        return sc.nextLine(); // permet la saisie d'une chaine
    }


    public static int saisirEntier()
    {
        return Integer.parseInt(sc.nextLine());   //permet la saisie d'un entier avec une conversion
    }

    public static BigDecimal saisieBigDecimal() //permet la saisie d"un big Decimal avec une conversion
    {
        return new BigDecimal(sc.nextLine());
    }



}

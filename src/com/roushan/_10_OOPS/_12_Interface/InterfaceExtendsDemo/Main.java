package com.roushan._10_OOPS._12_Interface.InterfaceExtendsDemo;

import com.roushan._10_OOPS._11_Abstraction.Parent;

public class Main {
    public static void main(String[] args) {
        Party party = new Party();
        party.fun();
        party.greet();

        //it is coming from constructor because we created it as default
        party.dance();

    }
}

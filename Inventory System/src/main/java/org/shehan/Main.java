package org.shehan;

import org.shehan.dao.DBconnection;

public class Main {
    public static void main(String[] args) {

        Mainmenu menu=new Mainmenu();

        DBconnection db= new DBconnection();

        menu.show();
    }
}
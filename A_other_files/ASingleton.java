package bitedu.bipa.quiz.singlton;

import java.util.Calendar;

public class ASingleton {
    private static final ASingleton INSTANCE = new ASingleton();

    private ASingleton() {
    }

    public static ASingleton getInstance() {
        return INSTANCE;
    }
}

class BSingleton {
    private static BSingleton INSTANCE;

    private BSingleton() {
    }

    public static BSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BSingleton();
        }
        return INSTANCE;
    }
}

class CSingleton {
    private CSingleton() {
    }
    //innerClass
    private static class CSingletonHolder {
        private static CSingleton INSTANCE = new CSingleton();
    }
    public static CSingleton getInstance() {
        return CSingletonHolder.INSTANCE;
    }
}

class Main {
    public static void main(String[] args) {
        ASingleton aSingleton = ASingleton.getInstance();
        ASingleton aSingleton1 = ASingleton.getInstance();

        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();

        if (calendar1 == calendar) {
            System.out.println("같냐?");

        } else System.out.println("다르다");
    }
}

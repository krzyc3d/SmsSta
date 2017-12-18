package ObserverSmsStation;

import ObserverSmsStation.observable.SmsStation;

public class Main {
    public static void main(String[] args) {

        SmsStation smsStation = new SmsStation();

        smsStation.addPhone("14");
        smsStation.addPhone("123");
        smsStation.addPhone("125");
        smsStation.addPhone("124");
        smsStation.addPhone("1246");
        smsStation.addPhone("1333");
        smsStation.addPhone("12");

        smsStation.sendSms("123","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        smsStation.sendSms("123","działa");
        smsStation.sendSms("12","witaaaaaaaaaaaaaaaaaaaaaam");
        smsStation.sendSms("1","witam ");
        smsStation.sendSms("1","witam amamamamamamammamama");
        smsStation.sendSms("1","witam amamamamamamammamama");
        smsStation.sendSms("125","Wysyłąm długaaaaaaaa wiadomośćććććććććććććććććććć");


    }
}

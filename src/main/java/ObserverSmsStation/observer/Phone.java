package ObserverSmsStation.observer;

import ObserverSmsStation.observable.SmsRequest;

import java.util.Observable;
import java.util.Observer;

public class Phone implements Observer {
    private String phoneNumber;


    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof SmsRequest) {
            SmsRequest smsRequest = (SmsRequest) arg;
            if (smsRequest.getPhoneNumber().equalsIgnoreCase(getPhoneNumber())) {
                System.out.println("The message to: " + smsRequest.getPhoneNumber() + " content: " + smsRequest.getContent());
            }
        }
    }

}

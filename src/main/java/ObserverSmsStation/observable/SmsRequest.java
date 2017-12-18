package ObserverSmsStation.observable;

import java.util.Observable;

public class SmsRequest extends Observable implements Runnable {
    private String phoneNumber;
    private String content;

    public SmsRequest(String phoneNumber, String content) {
        this.phoneNumber = phoneNumber;
        this.content = content;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public void run() {
        try {
            System.out.println("Beginn");
            Thread.sleep(100*content.length());
            System.out.println("Sms sended");
            setChanged();
            notifyObservers(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package ObserverSmsStation.observable;

/*
Stworzymy aplikację SMS station. Aplikacja ma symulować pracę stacji smsowej.
Stwórz klasę SmsStation. zakładamy że stacja smsowa otrzymuje jakieś zlecenie o wysłaniu smsa,
które musi się wydarzyć poprzez broadcast. Ta klasa powinna mieć metodę:
void sendSms(String numer, String tresc)
która tworzy obiekt typu SmsRequest(Runnable), a następnie przekazuje go do puli wątków (/anten) do wykonania.
Klasa SmsRequest posiada dwa pola (tresc i numer). W metodzie run() SmsRequest najpierw czeka określoną ilość czasu
(100ms * ilość_liter_w_smsie), po czym wypisuje komunikat o wysłaniu smsa.
Użytkownik z poziomu Main'a wpisuje komendę:
1235346457 jakas tresc smsa
Po otrzymaniu komendy podziel ją przez split na numer (1 słowo komendy) oraz pozostałą część komendy - to będzie treść smsa.
 */

import ObserverSmsStation.observer.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SmsStation {
    private List<Phone> phoneList = new ArrayList();

    private Executor antena = Executors.newFixedThreadPool(5);

    public void addPhone(String number) {
        phoneList.add(new Phone(number));
    }

    public void sendSms(String numer, String content) {

        SmsRequest request = new SmsRequest(numer, content);
        for (Phone phone:phoneList) {
           request.addObserver(phone);
        }
        antena.execute(request);
    }
}

package app.lib.notifications;

import app.entities.Example;
import app.lib.sms.Sender;

//import org.twilio.airtng.lib.sms.Sender;
//import org.twilio.airtng.models.Reservation;

public class SmsNotifier {
    private Sender smsSender;

    public SmsNotifier() {
        this(new Sender());
    }

    public SmsNotifier(Sender smsSender) {
        this.smsSender = smsSender;
    }

    public void notifyTest(Example example) {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(String.format("Ping: %s\n", example.getPing()));
        
        String vitorPhone = "5545998228699";

        smsSender.send(vitorPhone, messageBuilder.toString());
    }

}
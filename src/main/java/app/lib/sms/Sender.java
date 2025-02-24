package app.lib.sms;


import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import app.lib.Config;

public class Sender {

    private final TwilioRestClient client;

    public Sender() {
    	System.out.println(Config.getAuthToken());
        client = new TwilioRestClient.Builder(Config.getAccountSid(), Config.getAuthToken()).build();
    }

    public Sender(TwilioRestClient client) {
        this.client = client;
    }

    public void send(String to, String message) {
        new MessageCreator(
                new PhoneNumber(to),
                new PhoneNumber(Config.getPhoneNumber()),
                message
        ).create(client);
    }

}
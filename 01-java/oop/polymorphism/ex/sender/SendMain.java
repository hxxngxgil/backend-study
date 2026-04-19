package poly.ex.sender;

public class SendMain {

    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBoockSender() };
        for (Sender sender : senders) {
            sender.sendMessage("환영합니다!");
        }
    }
}

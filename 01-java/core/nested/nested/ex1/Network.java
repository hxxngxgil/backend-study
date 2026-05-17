package nested.nested.ex1;

public class Network {

    public void sendMessage(String text) {
        NetorkMessage netorkMessage = new NetorkMessage(text);
        netorkMessage.print();
    }
}

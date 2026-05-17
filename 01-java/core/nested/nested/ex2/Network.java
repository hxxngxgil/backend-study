package nested.nested.ex2;

public class Network {

    public void sendMessage(String text) {
        NetorkMessage netorkMessage = new NetorkMessage(text);
        netorkMessage.print();
    }


    public static class NetorkMessage {
        private String content;

        public NetorkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }
}

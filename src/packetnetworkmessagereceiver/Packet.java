
package packetnetworkmessagereceiver;

class Packet {
    int sequenceNumber;
    String data;

    public Packet(int sequenceNumber, String data) {
        this.sequenceNumber = sequenceNumber;
        this.data = data;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getData() {
        return data;
    }
}

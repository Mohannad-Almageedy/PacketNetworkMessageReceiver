
package packetnetworkmessagereceiver;
import java.util.LinkedList;

class PacketReceiver {
    private LinkedList<Packet> buffer;
    private int expectedSeq;

    public PacketReceiver() {
        this.buffer = new LinkedList<>();
        this.expectedSeq = 0;
    }

    public void receivePacket(Packet packet) {
       
        if (packet.getSequenceNumber() < expectedSeq) {
            return;
        }

   
        int index = 0;
        while (index < buffer.size() && buffer.get(index).getSequenceNumber() < packet.getSequenceNumber()) {
            index++;
        }
        buffer.add(index, packet);
        
      
        processPackets();
    }

    private void processPackets() {
        while (!buffer.isEmpty() && buffer.getFirst().getSequenceNumber() == expectedSeq) {
            Packet packet = buffer.removeFirst();
            System.out.print(packet.getData() + " ");
            expectedSeq++;
        }
    }
}

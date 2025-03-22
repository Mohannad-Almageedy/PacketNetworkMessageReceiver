
package packetnetworkmessagereceiver;

public class PacketNetworkMessageReceiver {
  public static void main(String[] args) {
        System.out.println("Test 1: Normal Out-of-Order Arrival");
        testScenario(new int[]{2, 0, 1}, new String[]{"!", "Hello", "World"}); 
     

        System.out.println("\nTest 2: Missing Packet");
        testScenario(new int[]{0, 2}, new String[]{"Hello", "!"});
     

        System.out.println("\nTest 3: Duplicate Packets");
        testScenario(new int[]{0, 1, 1, 2}, new String[]{"Hello", "World", "World", "!"});
   

        System.out.println("\nTest 4: Large Number of Packets");
        testScenario(new int[]{3, 1, 0, 2, 5, 4}, new String[]{"D", "B", "A", "C", "F", "E"});
   
    }

    private static void testScenario(int[] sequenceNumbers, String[] data) {
        PacketReceiver receiver = new PacketReceiver();
        for (int i = 0; i < sequenceNumbers.length; i++) {
            receiver.receivePacket(new Packet(sequenceNumbers[i], data[i]));
        }
        System.out.println(); 
    }

}


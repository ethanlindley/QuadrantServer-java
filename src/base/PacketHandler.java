package base;

import utils.PacketTypes;

class PacketHandler extends PacketTypes {

     String handleReceivedPacket(String packet) {

         String __packet = packet;
         char x = packet.charAt(0);

        if (x == '<') {
            System.out.println("received XML packet with data: " + packet);
            __packet = handleXMLPacket(packet);
        }
        else if (packet.charAt(0) == '%') {
            System.out.println("received RAW packet with data: " + packet);
            __packet = handleRAWPacket(packet);
        }

        return __packet;

    }

    private String handleXMLPacket(String packet) {

         String __packet = packet;

         if (packet.contains(policy_file_req)) {
             __packet = policy_file_res;
         }
         else if (packet.contains(api_ver_chk_req)) {
             __packet = checkVersion(packet);
         }

         return __packet;

    }

    private String handleRAWPacket(String packet) {

         String __packet = packet;
         // TODO: handle RAW packets
         return __packet;

    }

    private String checkVersion(String version) {


         if (version.contains("153")) {
             // send the OK API response here
             return api_OK;
         }
         else {
             // send the KO API response here
             return api_KO;
         }

    }

}

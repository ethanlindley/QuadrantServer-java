package utils;

public class PacketTypes {

    protected final String policy_file_req = "<policy-file-request/>\u0000";
    protected final String policy_file_res = "<cross-domain-policy><allow-access-from domain='*' to-ports='*' " +
            "/></cross-domain-policy>\u0000";

    protected final String api_ver_chk_req = "<body action='verChk' r='0'>\u0000";
    protected final String api_OK = "<msg t='sys'><body action='apiOK' r='0'></body></msg>\u0000";
    protected final String api_KO = "<msg t='sys'><body action='apiKO' r='0'></body></msg>\u0000";

}

import java.util.Arrays;

public class IPAddr {

    private short[] value;

    private IPAddr(short[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IPAddr{" +
                "value=" + Arrays.toString(value) +
                '}';
    }

    public static IPAddr from(String ip){
        String[] parts = ip.split("\\.");
        if(parts.length != 4)
            throw new IllegalArgumentException("Invalid IP Address ["+ip+"]");
        short[] val = new short[]{
            Short.parseShort(parts[0]),
            Short.parseShort(parts[1]),
            Short.parseShort(parts[2]),
            Short.parseShort(parts[3]),
        };
        return new IPAddr(val);
    }

    public short[] getValue() {
        return value;
    }

    public boolean isGreaterThan(IPAddr ip) {
        for(int i=0; i<4; i++) {
            if (this.value[i] > ip.getValue()[i])
                return true;
            if (this.value[i] < ip.getValue()[i])
                return false;
        }
        return false;
    }

    public boolean isLesserThan(IPAddr ip) {
        for(int i=0; i<4; i++) {
            if (this.value[i] < ip.getValue()[i])
                return true;
            if (this.value[i] > ip.getValue()[i])
                return false;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPAddr ipAddr = (IPAddr) o;
        return Arrays.equals(value, ipAddr.value);
    }
}

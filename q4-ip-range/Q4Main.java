import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4Main {

    private static List<IPAddr> ipAddrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int lines = Integer.parseInt(sn.nextLine());

        IPAddr rangeStart = IPAddr.from(sn.nextLine());
        IPAddr rangeEnd = IPAddr.from(sn.nextLine());
        for(int i=1; i<=lines-2; i++)
            ipAddrList.add(IPAddr.from(sn.nextLine()));

        System.out.println("\nOutput:");
        for (IPAddr ip : ipAddrList)
            System.out.println((ip.equals(rangeStart) || ip.isGreaterThan(rangeStart)) &&
                    (ip.equals(rangeEnd) || ip.isLesserThan(rangeEnd)));
    }

}
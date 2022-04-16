package com.withing.niuke._18;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author huangweixin7
 * @date 2022/4/15 21:21:21
 * description: Main
 */
public class Main {

    static HashSet<Integer> subnetLegal = new HashSet<>();

    static {
        subnetLegal.add(0);
        subnetLegal.add(128);
        subnetLegal.add(192);
        subnetLegal.add(224);
        subnetLegal.add(240);
        subnetLegal.add(248);
        subnetLegal.add(252);
        subnetLegal.add(254);
        subnetLegal.add(255);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO [127,128] {[10,11],[172,172],[192,192]}[1,127),[128,192),[192,224],[224,240],[240,256]
        // 注意 hasNext 和 hasNextLine 的区别
        //先看是否合法，ip合法问题，1.是否有四个点，2.四个点拆开后是否都是数字，3.这四个数字是否都子啊0～255之间
        //子网掩码合法问题，1.是否有四个点，2.四个点拆开后是否都是数字，3.这四个数字是否都子啊0～255之间，
        //4.个数字大小顺序是否从大大小，5.是否在这几个数字里0,128，192，224，240，248，252，254，255
        int[] validate = new int[7];
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] str = s.split("~");
            String ip = str[0];
            String subnet = str[1];

            boolean validateIp = validateFormat(ip);
            boolean validateSubnet = validateSubnet(subnet);
            String[] ips = ip.split("\\.");
            int prefix = Integer.parseInt(ips[0]);
            int second = Integer.parseInt(ips[1]);
            if (!validateIp || !validateSubnet) {
                if (prefix == 0 || prefix == 127) {
                    continue;
                }
                validate[5]++;
                continue;
            }
            if (prefix == 10) {
                validate[6]++;
            } else if (prefix == 172) {
                if (second >= 16 && second < 32) {
                    validate[6]++;
                }
            } else if (prefix == 192 && second == 168) {
                validate[6]++;
            }

            if (prefix >= 1 && prefix < 127) {
                validate[0]++;
            } else if (prefix >= 128 && prefix < 192) {
                validate[1]++;
            } else if (prefix >= 192 && prefix < 224) {
                validate[2]++;
            } else if (prefix >= 224 && prefix < 240) {
                validate[3]++;
            } else if (prefix >= 240 && prefix < 256) {
                validate[4]++;
            }
        }
        for (int j : validate) {
            System.out.print(j + " ");
        }
    }


    public static boolean validateSubnet(String subnet) {
        if (!validateFormat(subnet)) {
            return false;
        }
        String[] subnets = subnet.split("\\.");
        for (int i = 0; i < subnets.length; i++) {
            int subnetIp = Integer.parseInt(subnets[i]);
            if (!subnetLegal.contains(subnetIp)) {
                return false;
            }
            if (i != subnets.length - 1 && subnetIp < Integer.parseInt(subnets[i + 1])) {
                return false;
            }
        }
        if (subnets[0].equals(subnets[1]) && subnets[0].equals(subnets[2]) && subnets[0].equals(subnets[3])) {
            if (subnets[0].equals("0") || subnets[0].equals("255")) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateFormat(String ip) {
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for (String s : ips) {
            try {
                if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}

package com.kt.conv.robotvtf.qat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkAddressUtil {



	/**
	 * <pre>
	 * Network get Macaddress ff-ff-ff-ff-ff-ff
	 * </pre>
	 * 
	 * @param ifname
	 * @return
	 * @throws SocketException
	 */
	public static String getMacAddress(String ifname) throws SocketException {

		String macaddress = "";
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		while(nets.hasMoreElements()) {
			NetworkInterface element = nets.nextElement();
			if(element.getName().equals(ifname)) {
				byte[] mac = element.getHardwareAddress();

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
				}
				macaddress = sb.toString();

			}
		}

		return macaddress;
	}

	
	

	public static String getMacAddressRuntime() throws IOException, InterruptedException {

		Runtime r = Runtime.getRuntime();
		Process p = r.exec("ifconfig -u |grep ether");
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";

		while ((line = b.readLine()) != null) {
			System.out.println(line);
		}

		b.close();
		return line;

	}






	public static String getMacAddress() throws UnknownHostException,
	SocketException
	{
		InetAddress ipAddress = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface
				.getByInetAddress(ipAddress);
		byte[] macAddressBytes = networkInterface.getHardwareAddress();
		StringBuilder macAddressBuilder = new StringBuilder();

		for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++)
		{
			String macAddressHexByte = String.format("%02X", macAddressBytes[macAddressByteIndex]);
			macAddressBuilder.append(macAddressHexByte);

			if (macAddressByteIndex != macAddressBytes.length - 1)
			{
				macAddressBuilder.append(":");
			}
		}

		return macAddressBuilder.toString();
	}






	public static String GetAddress(String addressType) {
		String address = "";
		InetAddress lanIp = null;
		try {

			String ipAddress = null;
			Enumeration<NetworkInterface> net = null;
			net = NetworkInterface.getNetworkInterfaces();

			while (net.hasMoreElements()) {
				NetworkInterface element = net.nextElement();
				Enumeration<InetAddress> addresses = element.getInetAddresses();

				if(addresses==null) break;
				while (addresses.hasMoreElements() && element.getHardwareAddress().length > 0 && !isVMMac(element.getHardwareAddress())) {
					InetAddress ip = addresses.nextElement();
					if (ip instanceof Inet4Address) {

						if (ip.isSiteLocalAddress()) {
							ipAddress = ip.getHostAddress();
							lanIp = InetAddress.getByName(ipAddress);
						}

					}

				}
			}

			if (lanIp == null)
				return null;

			if (addressType.equals("ip")) {

				address = lanIp.toString().replaceAll("^/+", "");

			} else if (addressType.equals("mac")) {

				address = getMacAddress(lanIp);

			} else {

				throw new Exception("Specify \"ip\" or \"mac\"");

			}

		} catch (UnknownHostException ex) {

			ex.printStackTrace();

		} catch (SocketException ex) {

			ex.printStackTrace();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return address;

	}

	private static String getMacAddress(InetAddress ip) {
		String address = null;
		try {

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			address = sb.toString();

		} catch (SocketException ex) {

			ex.printStackTrace();

		}

		return address;
	}

	private static boolean isVMMac(byte[] mac) {
		if(null == mac) return false;
		byte invalidMacs[][] = {
				{0x00, 0x05, 0x69},             //VMWare
				{0x00, 0x1C, 0x14},             //VMWare
				{0x00, 0x0C, 0x29},             //VMWare
				{0x00, 0x50, 0x56},             //VMWare
				{0x08, 0x00, 0x27},             //Virtualbox
				{0x0A, 0x00, 0x27},             //Virtualbox
				{0x00, 0x03, (byte)0xFF},       //Virtual-PC
				{0x00, 0x15, 0x5D}              //Hyper-V
		};

		for (byte[] invalid: invalidMacs){
			if (invalid[0] == mac[0] && invalid[1] == mac[1] && invalid[2] == mac[2]) return true;
		}

		return false;
	}

}
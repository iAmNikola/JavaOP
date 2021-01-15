import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modules.PlumbingRepair;
import services.WriterYAML;

public class GenerateRepairs {
	public static void main(String[] args) throws IOException {
		String separator = System.getProperty("file.separator");
        String mainDir = System.getProperty("user.dir");
        String repairsPath = mainDir + separator + "resources" + separator + "repairs.yaml";
        WriterYAML.write(getRepairsList(), repairsPath);
	}
	
	private static List<PlumbingRepair> getRepairsList(){
		List<PlumbingRepair> repairs = new ArrayList<PlumbingRepair>();
        boolean more = false;

        while (repairs.size() < 15 || !more) {
            PlumbingRepair repair = getRepair();
            System.out.println("Repair added to list.\n");
            repairs.add(repair);
            if (repairs.size() > 15) {
                Scanner sc = new Scanner(System.in);
                String in = "";
                System.out.println("Add another repair?(Y/N)>>");
                in = sc.nextLine();
                if (in.equals("n") || in.equals("N")) {
                    more = true;
                }
            }
        }
        return repairs;
	}
	
	private static PlumbingRepair getRepair() {
		int repairNo = getRepairNo();
        String plumberID = getPlumberID();
        int cost = getCost();
        int price = getPrice();
        String datetime = getDatetime();

        return new PlumbingRepair(repairNo, plumberID, cost, price, datetime);
	}
	
	private static int getRepairNo() {
		System.out.println("Repair Number (e.g. 12345):");
		Scanner sc = new Scanner(System.in);
		int repairNo = sc.nextInt();
		return repairNo;
	}
	private static String getPlumberID() {
		System.out.println("Plumber's ID (e.g. plumberIlija):");
		Scanner sc = new Scanner(System.in);
		String plumberID = sc.nextLine();
		return plumberID;
	}
	private static int getCost() {
		System.out.println("Repair cost:");
		Scanner sc = new Scanner(System.in);
		int cost = sc.nextInt();
		return cost;
	}
	private static int getPrice() {
		System.out.println("Repair price:");
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		return price;
	}
	private static String getDatetime() {
		System.out.println("Repair date(YYYY-MM-DD):");
		Scanner sc = new Scanner(System.in);
		String date = sc.nextLine();
		System.out.println("Repair time(HH:MM):");
		String time = sc.nextLine();
		
		String datetime = date+"T"+time+":00";
		return datetime;
	}




	
	
	
}

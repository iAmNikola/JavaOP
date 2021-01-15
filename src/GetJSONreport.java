import java.io.FileNotFoundException;
import java.time.Month;
import java.util.List;
import java.util.Map;

import modules.PlumbingRepair;
import modules.PlumbingReport;
import services.MonthlyReport;
import services.ReaderYAML;
import services.WriterJSON;


public class GetJSONreport {

	public static void main(String[] args) throws FileNotFoundException {
        String s = System.getProperty("file.separator");
        String mainDir = System.getProperty("user.dir");
        String fileName = "repairs";
        String yaml = mainDir + s + "resources" + s + fileName + ".yaml";
        String json = mainDir + s + "resources" + s + fileName + "json_report.json";
        
        List<PlumbingRepair> repairs = ReaderYAML.read(yaml);
        System.out.println("Creating report.");
        Map<Month, List<PlumbingReport>> monthlyReports = MonthlyReport.create(repairs);
        WriterJSON.write(monthlyReports, json);
        System.out.println("Report created!");
        System.out.println("You can find it here: " + json);
    }
}

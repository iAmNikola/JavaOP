package services;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modules.PlumbingRepair;
import modules.PlumbingReport;
import modules.SortComparator;

public class MonthlyReport {

	public static Map<Month, List<PlumbingReport>> create(List<PlumbingRepair> repairs) {
        Map<Month, List<PlumbingReport>> monthlyReports = new HashMap<Month, List<PlumbingReport>>();
        for (int i = 1; i < 13; i++) {
            List<PlumbingReport> reports = new ArrayList<PlumbingReport>();
            monthlyReports.put(Month.of(i), reports);
        }
        for (PlumbingRepair r : repairs) {
            boolean flag = false;
            Month m = LocalDateTime.parse(r.getDatetime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME).getMonth();
            List<PlumbingReport> reportsForM = monthlyReports.get(m);
            for (PlumbingReport rfm : reportsForM) {
                if (rfm.plumberID.equals(r.getPlumberID())) {
                	rfm.addEarnings(r.getPrice());
                    rfm.cost(r.getCost());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                PlumbingReport report = new PlumbingReport(r.getPlumberID(), m, r.getPrice(), r.getCost());
                monthlyReports.get(m).add(report);
            }
        }
        List<Month> months = new ArrayList<Month>(monthlyReports.keySet());

        for (Month m : months) {
            List<PlumbingReport> sorted = sortByPlumberID(monthlyReports.get(m));
            monthlyReports.replace(m, sorted);
        }
        return monthlyReports;
    }
	
	private static List<PlumbingReport> sortByPlumberID(List<PlumbingReport> reports) {
        SortComparator c = new SortComparator();
        reports.sort(c);
        return reports;
    }
}


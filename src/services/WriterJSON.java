package services;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import modules.PlumbingReport;

public class WriterJSON {

	public static void write(Map<Month, List<PlumbingReport>> monthlyReports, String file) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File jsonFile = new File(file);

        try {
            mapper.writeValue(jsonFile, monthlyReports);
            System.out.println("Writing to JSON successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}

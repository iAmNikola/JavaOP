package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import modules.PlumbingRepair;

public class ReaderYAML {
	public static List<PlumbingRepair> read(String inputFile) throws FileNotFoundException {
        List<PlumbingRepair> repairs = new ArrayList<PlumbingRepair>();
        try (InputStream yamlFile = new FileInputStream(new File(inputFile))) {

            Yaml yaml = new Yaml();

            // The .loadAll(input) method returns an instance of Iterable<Object>,
            // where each object is of type List<PlumbingRepair>
            for (Object data : yaml.loadAll(yamlFile)) {
                repairs = (List<PlumbingRepair>) data;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return repairs;
    }
}

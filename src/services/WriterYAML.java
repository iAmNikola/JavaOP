package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import modules.PlumbingRepair;

public class WriterYAML {
	
	public static void write(List<PlumbingRepair> repairs, String file) throws IOException {
		Yaml yaml = new Yaml();
        File yamlFile = new File(file);
        boolean fileExists = yamlFile.exists();
        if (!fileExists) {
            try {
                fileExists = yamlFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileExists) {
            try (FileWriter fw = new FileWriter(yamlFile)) {
                    yaml.dump(repairs, fw);
                    System.out.println("File created.");
                }
            }

    }
}

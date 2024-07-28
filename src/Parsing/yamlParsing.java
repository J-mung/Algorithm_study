package Parsing;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class yamlParsing {
    public static void main(String[] args) {
        System.out.println("hello yaml");
        doParsing();
        doParsing2();
    }

    public static void doParsing() {
        Yaml yaml = new Yaml();
        try (InputStream in = new FileInputStream("resources/yamlFiles/testYaml.yaml")) {
            Map<String, Object> obj = yaml.load(in);
            Map<String, Object> database = (Map<String, Object>) obj.get("database");

            YamlData config = new YamlData();
            config.setUrl((String) database.get("url"));
            config.setUsername((String) database.get("username"));
            config.setPassword((String) database.get("password"));

            System.out.println(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doParsing2() {
        try (InputStream in = new FileInputStream("resources/yamlFiles/testYaml2.yaml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> obj = yaml.load(in);
            List<Map<String, Object>> clientsList = (List<Map<String, Object>>) obj.get("clients");

            System.out.println(clientsList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream in = new FileInputStream("resources/yamlFiles/testYaml2.yaml")) {
            LoaderOptions loaderOptions = new LoaderOptions();
            Yaml yaml = new Yaml(new Constructor(Clients.class, loaderOptions));
            Clients clients = yaml.load(in);

            System.out.println(clients.getClients().get(0).getSource().getHost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package continut;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path))) {
            Catalog catalog = (Catalog) oin.readObject();
            return catalog;
        }
    }

    public static void view(Document doc) throws URISyntaxException,IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(doc.getLocation()));
    }
}
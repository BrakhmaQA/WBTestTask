package data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:testData.properties"})
public interface TestData extends Config {
    String bookEndpoint();

    String bookTitle();

    String basketHeader();

    String bookBrand();
}

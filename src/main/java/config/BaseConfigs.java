package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface BaseConfigs extends Config {
    String wbUrl();
}

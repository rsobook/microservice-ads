package si.fri.rsobook.config;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("properties")
public class AdsApiConfigProperties {

    @ConfigValue(watch = true)
    private Boolean adsEnabled;

    public Boolean getAdsEnabled() {
        return adsEnabled;
    }

    public void setAdsEnabled(Boolean adsEnabled) {
        this.adsEnabled = adsEnabled;
    }
}

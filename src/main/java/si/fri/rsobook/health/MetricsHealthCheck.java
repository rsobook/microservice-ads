package si.fri.rsobook.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class MetricsHealthCheck  implements HealthCheck {

    @Inject
    @Metric(name = "si.fri.rsobook.rest.AdsResource.about_returned", absolute = true)
    private Counter adsReturnedCounter;

    @Override
    public HealthCheckResponse call() {

        if(adsReturnedCounter.getCount() > 3) {
            return HealthCheckResponse.named(MetricsHealthCheck.class.getSimpleName()).down().build();
        }

        return HealthCheckResponse.named(MetricsHealthCheck.class.getSimpleName()).up().build();
    }

}

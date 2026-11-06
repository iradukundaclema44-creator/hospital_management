package smart_hospital;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HospitalConfig {

    @Value("${hospital.name:General City Hospital}")
    private String hospitalName;

    @Value("${HOSPITAL_API_SECRET}")
    private String apiSecret;

    public String getHospitalName() {
        return hospitalName;
    }

    public String getApiSecret() {
        return apiSecret;
    }
}

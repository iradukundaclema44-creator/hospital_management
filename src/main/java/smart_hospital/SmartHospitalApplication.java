
package smart_hospital;
import smart_hospital.processor.PatientAlertProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PatientAlertProcessor processor,
						  HospitalConfig config) {

		return args -> {

			System.out.println("HOSPITAL: " + config.getHospitalName());

			System.out.println("--- NORMAL ALERT ---");

			processor.processNormalAlert(
					"P001",
					"Your appointment is tomorrow."
			);

			System.out.println("--- EMERGENCY ALERT ---");

			processor.processEmergencyAlert(
					"P002",
					"Critical ICU alert!"
			);
		};
	}
}

package com.tours;

import com.tours.domain.Difficulty;
import com.tours.domain.Region;
import com.tours.service.TourPackageService;
import com.tours.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * The application class for Touristic Tours microservice.
 * Demo data is loaded after spring boot started using run() method from CommandLineRunner.
 * */
@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class TouristToursApplication implements CommandLineRunner {

	@Autowired
	private TourService tourService;

	@Autowired
	private TourPackageService tourPackageService;

	public static void main(String[] args) {
		SpringApplication.run(TouristToursApplication.class, args);
	}

	/**
	 * Import demo data for tour and tour packages. Runs after app is started, but before receives web requests.
	 * */
	@Override
	public void run(String... args) throws Exception {
		createTourPackages();
		importTours();

	}

	private void createTourPackages() {

		tourPackageService.createTourPackage("A", "Nordic Lights");
		tourPackageService.createTourPackage("B", "Bratislava, Budapest and Bucharest");
		tourPackageService.createTourPackage("C", "Adriatic");
		tourPackageService.createTourPackage("D", "Cycling cities break");
		tourPackageService.createTourPackage("E", "DACH Christmas");
	}

	private void importTours() throws IOException {
		TourFromFile.read("tours.json").forEach(importedTour ->
				tourService.createTour(
						importedTour.getTitle(),
						importedTour.getDescription(),
						importedTour.getPrice(),
						importedTour.getLength(),
						importedTour.getOffer(),
						importedTour.getPackageType(),
						importedTour.getDifficulty(),
						importedTour.getRegion()));
	}

	/**
	 * Helper class to import tours from a json file
	 */
	private static class TourFromFile {

		private String packageType, title, description, price, length,
				offer, difficulty, region;
		static List<TourFromFile> read(String fileToImport) throws IOException {

			File file = new File("tour-service/src/main/resources/" + fileToImport);

			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
					readValue(new FileInputStream(file.getAbsolutePath()), new TypeReference<List<TourFromFile>>() {});
		}
		protected TourFromFile(){}

		String getPackageType() { return packageType; }

		String getTitle() { return title; }

		String getDescription() { return description; }

		Integer getPrice() { return Integer.parseInt(price); }

		String getLength() { return length; }

		String getOffer() { return offer; }

		Difficulty getDifficulty() {
			return Difficulty.valueOf(difficulty);
		}

		Region getRegion() {
			return Region.findByLabel(region);
		}
	}
}

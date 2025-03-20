package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker;

public class RandomDataUtility {

	static Faker faker;

	public static String getCategoryName() {
		faker = new Faker();
		return faker.commerce().department();
	}
	
	public static int getRandomNumberBetWeen(int startNumber,int endNumber) {
		faker = new Faker();
		return faker.number().numberBetween(startNumber, endNumber);
	}

	public static String getFirstName() {
		faker = new Faker(new Locale("en-IND"));
		return faker.name().firstName();
	}

	public static String getFullAddress() {
		faker = new Faker(new Locale("en-IND"));
		return faker.address().fullAddress();
	}

	public static String getBuldingNumberWithStreetAddress() {
		faker = new Faker(new Locale("en-IND"));
		String buildingNumber = faker.address().buildingNumber();
		String streetAddress = faker.address().streetAddress();
		return buildingNumber + streetAddress;
	}

	public static String getPhoneNumber() {

		faker = new Faker(new Locale("en-IND"));
		String extension = faker.phoneNumber().extension();
		String phoneNumber = faker.phoneNumber().cellPhone().concat(extension);
		return phoneNumber;

	}

	public static String getEmail() {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomStringEmail = sb.toString() + "@gmail.com";
		return randomStringEmail;

	}
	
	
	public static String getDateOfBirth_Day() {
		
		//for getting only date in 'dd' format
		SimpleDateFormat simpledate = new SimpleDateFormat("dd");
		faker = new Faker();
		String date = simpledate.format(faker.date().birthday());
		return date;
		
	}
	
     public static Date getAge() {
		faker = new Faker();
		//return age between 18 to 60
		return faker.date().birthday(18,60);
		
	}
     
     
     public static String getDateOfBirth() {
 		
 		//for getting date in 'dd-mm-yyyy' format
 		SimpleDateFormat simpledate = new SimpleDateFormat("dd-mm-yyyy");
 		faker = new Faker();
 		Date date = faker.date().birthday(18,60);
 		return simpledate.format(date);
 		 		
 	}
	

}

package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	public String randomPhoneNumberGenerator() {
		Faker faker= new Faker();
		return faker.phoneNumber().cellPhone();
		
	}
	
	public String randomNameGenerator() {
		Faker faker= new Faker();
		return faker.name().firstName();
		
	}
	
	public String randomFullNameGenerator() {
		Faker faker= new Faker();
		return faker.name().fullName();
		
	}
	
	public String randomPasswordGenerator() {
		Faker faker= new Faker();
		return faker.code().asin();
		
	}

}

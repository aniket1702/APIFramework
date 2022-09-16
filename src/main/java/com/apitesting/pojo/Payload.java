package com.apitesting.pojo;

import com.apitesting.pojo.students.Address;
import com.apitesting.pojo.students.Company;
import com.apitesting.pojo.students.Geo;
import com.apitesting.pojo.students.Student;
import com.github.javafaker.Faker;

public final class Payload {

    private static Student student;
    private static Address address;
    private static Geo geo;
    private static Company company;
    private static Faker faker;

    private Payload(){

    }

    public static Student setValues(){

        faker=new Faker();
        student=new Student();
        student.setName(faker.name().fullName());
        student.setUsername(faker.name().username());
        student.setEmail(faker.internet().emailAddress());

        address=new Address();
        address.setStreet(faker.address().streetName());
        address.setSuite(faker.address().cityName());
        address.setCity(faker.address().cityName());
        address.setZipcode(faker.address().zipCode());

        geo=new Geo();
        geo.setLng(faker.address().longitude());
        geo.setLat(faker.address().latitude());
        address.setGeo(geo);
        student.setAddress(address);
        student.setPhone(faker.phoneNumber().phoneNumber());
        student.setWebsite(faker.internet().domainName());

        company=new Company();
        company.setName(faker.company().name());
        company.setCatchPhrase(faker.company().catchPhrase());
        company.setBs(faker.company().bs());
        student.setCompany(company);

        return student;

    }
}

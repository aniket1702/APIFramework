package com.apitesting.pojo;

import com.apitesting.pojo.students.Address;
import com.apitesting.pojo.students.Company;
import com.apitesting.pojo.students.Geo;
import com.apitesting.pojo.students.Student;
import com.github.javafaker.Faker;

public final class Payload {

    private Payload(){

    }

    public static Student setValues(){

        Faker faker=new Faker();
        Student student=new Student();
        student.setName(faker.name().fullName());
        student.setUsername(faker.name().username());
        student.setEmail(faker.internet().emailAddress());

        Address address=new Address();
        address.setStreet(faker.address().streetName());
        address.setSuite(faker.address().cityName());
        address.setCity(faker.address().cityName());
        address.setZipcode(faker.address().zipCode());

        Geo geo=new Geo();
        geo.setLng(faker.address().longitude());
        geo.setLat(faker.address().latitude());
        address.setGeo(geo);
        student.setAddress(address);
        student.setPhone(faker.phoneNumber().phoneNumber());
        student.setWebsite(faker.internet().domainName());

        Company company=new Company();
        company.setName(faker.company().name());
        company.setCatchPhrase(faker.company().catchPhrase());
        company.setBs(faker.company().bs());
        student.setCompany(company);

        return student;

    }
}

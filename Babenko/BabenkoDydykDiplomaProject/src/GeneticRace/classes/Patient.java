// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko, Anastasiia Dydyk
// Contacts: vbabenko2191@gmail.com

package GeneticRace.classes;

public class Patient {
    private int id;
    private String surname;
    private String firstname;
    private String middlename;
    private String sex;
    private String dateOfBirth;

    public Patient(int id, String surname, String firstname, String middlename, String sex, String dateOfBirth) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSex() {
        return sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectTests extends TestBase {
    @Test
    void fillFormTest() {
        String userName = "dsvsz";
        String userLastName = "dfvsdas";
        String userEmail = "name@example.com";
        String userGender = "Female";
        String userNumber = "1934577890";
        String userBirth_day = "11";
        String userBirth_month = "September";
        String userBirth_year = "1996";
        String userSubjects = "Art";
        String userHobbies = "Gaming";
        String userPictureLocation = "pictures/img1.jpeg";
        String userAddress = "Address 33, 99";
        String userState = "Uttar Pradesh";
        String userCity = "Moscow";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userNumber)
                .setBirthDate(userBirth_day, userBirth_month, userBirth_year)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .setPicture(userPictureLocation)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBirth_day + " " + userBirth_month + "," + userBirth_year)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);

    }
}
package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import utils.StudentData;

import static tests.TestData.userEmail;
import static tests.TestData.userName;

public class RegistrationWithFakerTests extends TestBase {
    RegistrationWithFakerTests registrationPage = new RegistrationWithFakerTests();
     StudentData studentData = DataGenerator.getRandomStudent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
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


        registrationResultsModal.verifyModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBirth_day + " " + userBirth_month + "," + userBirth_year)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity)
                .verifyResult("Picture", "img1.jpg");

    }
}

package parametrizedTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;
import tests.TestBase;
import utils.DataGenerator;
import utils.StudentData;

public class ParametrizedTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = DataGenerator.getRandomStudent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @ValueSource(strings = {
            "Москва, ул.Ангелов д 5", "75 PARK PLACE 8TH FLOOR NEW YORK NY 10007"
    })
    @Tag("Regress")
    @DisplayName("Корректное отображение адреса введенного при регистрации в модальном окне подтверждения")
    @ParameterizedTest
    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(studentData.getFirstName())
                .setLastName(studentData.getLastName())
                .setEmail(studentData.getUserEmail())
                .setGender(studentData.getGender())
                .setPhone(studentData.getUserPhone())
                .setBirthDate(studentData.getDay(), studentData.getMonth(), studentData.getYear())
                .setSubjects(studentData.getSubject())
                .setHobby(studentData.getHobby())
                .setPicture(studentData.getFilePath())
                .setAddress(studentData.getAddress())
                .setState(studentData.getState())
                .setCity(studentData.getCity())
                .clickSubmit();


        registrationResultsModal.verifyModalAppears()
                .verifyResult("Student Name", studentData.getFirstName() + " " + studentData.getLastName())
                .verifyResult("Student Email", studentData.getUserEmail())
                .verifyResult("Gender", studentData.getGender())
                .verifyResult("Mobile", studentData.getUserPhone())
                .verifyResult("Date of Birth", studentData.getDay() + " " + studentData.getMonth() + "," + studentData.getYear())
                .verifyResult("Subjects", studentData.getSubject())
                .verifyResult("Hobbies", studentData.getHobby())
                .verifyResult("Address", studentData.getAddress())
                .verifyResult("State and City", studentData.getState() + " " + studentData.getCity())
                .verifyResult("Picture", studentData.getFilePath()
                        .substring(studentData.getFilePath().lastIndexOf("/")+ 1));

    }
}


package artim.nemuos.bankingUserProfileApplication.model;

import artim.nemuos.banking.lib.common.dataMasking.Masker;
import artim.nemuos.banking.lib.common.dataValidation.ProfileValidatorUtilities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@Entity
@Table
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private String userId;
    private String password;
    private int age;
    private String phoneNumber;
    private String email;
    private String address;
    private String pincode;
    private String[] accountIds;

    public UserProfile(String userId, String password, int age, String phoneNumber, String email, String address, String pincode, String[] accountIds) {
        this.userId = userId;
        this.password = password;
        this.age = age;
        if(!ProfileValidatorUtilities.isValidPhoneNumber(phoneNumber)) throw new RuntimeException("Invalid Phone Number exception");
        this.phoneNumber = phoneNumber;
        if(!ProfileValidatorUtilities.isValidEmail(email)) throw new RuntimeException("Invalid email exception");
        this.email = email;
        this.address = address;
        this.pincode = pincode;
        this.accountIds = accountIds;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", age=" + age +
                ", phoneNumber='" + Masker.maskPhoneNumber(phoneNumber) + '\'' +
                ", email='" + Masker.maskEmail(email) + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                ", accountIds=" + Arrays.toString(accountIds) +
                '}';
    }
}

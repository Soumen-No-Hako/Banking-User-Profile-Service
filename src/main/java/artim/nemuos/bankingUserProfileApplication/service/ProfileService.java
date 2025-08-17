package artim.nemuos.bankingUserProfileApplication.service;

import artim.nemuos.bankingUserProfileApplication.model.UserProfile;
import artim.nemuos.bankingUserProfileApplication.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    UserProfileRepository profileRepository;

    public List<UserProfile> fetchAllUsers()
    {
        return (List<UserProfile>) profileRepository.findAll();
    }

    public UserProfile fetchByUserId(String userId)
    {
        Optional<UserProfile> user = profileRepository.findById(userId);
        System.out.println(profileRepository.auditAction(user.get()));
        return user.get();
    }
    public List<UserProfile> searchByFirstName(String firstname)
    {
        return profileRepository.searchMatchedByFirstName(firstname);
    }
    public List<UserProfile> searchByLastName(String lastname)
    {
        return profileRepository.searchMatchedByLastName(lastname);
    }

    //TODO Write auditAction logic properly in the library
    //TODO keep userid as foreign key in the Accounts service/table
}

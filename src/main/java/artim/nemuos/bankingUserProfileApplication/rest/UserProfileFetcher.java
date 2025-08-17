package artim.nemuos.bankingUserProfileApplication.rest;

import artim.nemuos.bankingUserProfileApplication.model.UserProfile;
import artim.nemuos.bankingUserProfileApplication.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileFetcher {

    @Autowired
    ProfileService profileService;

    @GetMapping("/fetch")
    public ResponseEntity<List<UserProfile>> fetchAllUsers()
    {
        return ResponseEntity.ok(profileService.fetchAllUsers());
    }
    @GetMapping("/fetch")
    public ResponseEntity<UserProfile> fetchParticularUserById(@Param("userId") String userId)
    {
        return ResponseEntity.ok(profileService.fetchByUserId(userId));
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<UserProfile>> fetchParticularUserByFirstname(@Param("firstname") String firstname)
    {
        return ResponseEntity.ok(profileService.searchByFirstName(firstname));
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<UserProfile>> fetchParticularUserByLastname(@Param("lastname") String lastname)
    {
        return ResponseEntity.ok(profileService.searchByLastName(lastname));
    }
}

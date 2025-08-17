package artim.nemuos.bankingUserProfileApplication.repository;

import artim.nemuos.banking.lib.common.bankingRepostitories.BasicBankingRepository;
import artim.nemuos.bankingUserProfileApplication.model.UserProfile;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends BasicBankingRepository<UserProfile, String> {

    @Query("Select * from USERPROFILE where firstname like %:?1%")
    List<UserProfile> searchMatchedByFirstName(String firstname);
    @Query("Select * from USERPROFILE where lastname like %:?1%")
    List<UserProfile> searchMatchedByLastName(String lastname);

    //TODO Add logic profile Profile updates

}

package artim.nemuos.bankingUserProfileApplication.repository;

import artim.nemuos.banking.lib.common.bankingRepostitories.BasicBankingRepository;
import artim.nemuos.bankingUserProfileApplication.model.UserProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends BasicBankingRepository<UserProfile, String> {

}

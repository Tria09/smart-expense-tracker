package in.codingstreams.etuserauthservice.service.user;

import in.codingstreams.etuserauthservice.constant.ErrorMessages;
import in.codingstreams.etuserauthservice.constant.LoggingConstants;
import in.codingstreams.etuserauthservice.data.model.AppUser;
import in.codingstreams.etuserauthservice.data.repo.AppUserRepo;
import in.codingstreams.etuserauthservice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final AppUserRepo appUserRepo;
    @Override
    public AppUser getUserInfo(String userId)
    {

        var methodName ="UserServiceImpl:getUserInfo";
        log.info(LoggingConstants.START_METHOD_LOG,methodName,userId);

        //  Find user by userId
        var appUser=appUserRepo.findById(userId)
                .orElseThrow(()->{
                    log.error(LoggingConstants.ERROR_METHOD_LOG,methodName,userId
                            +"not found");

                    return new UserNotFoundException(
                            ErrorMessages.USER_NOT_FOUND.getErrorMessage(),
                            ErrorMessages.USER_NOT_FOUND.getErrorCode()
                    );
                });

        log.info(LoggingConstants.END_METHOD_LOG,methodName);
        return appUser;
    }
}

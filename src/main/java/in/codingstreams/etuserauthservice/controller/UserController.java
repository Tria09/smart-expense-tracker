package in.codingstreams.etuserauthservice.controller;

import in.codingstreams.etuserauthservice.constant.LoggingConstants;
import in.codingstreams.etuserauthservice.controller.dto.UserInfo;
import in.codingstreams.etuserauthservice.controller.mapper.UserInfoMapper;
import in.codingstreams.etuserauthservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    //Get user info
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String userId) {

        var methodName = "UserController:getUserInfo";
        log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

        String loggedInEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        var appUser = userService.getUserInfo(userId);

        if (!appUser.getEmail().equals(loggedInEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        log.info(LoggingConstants.END_METHOD_LOG, methodName);
        return ResponseEntity.ok(UserInfoMapper.INSTANCE.mapToUserInfo(appUser));
    }

    //Change password

    //Update user details

}

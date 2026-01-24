package in.codingstreams.etuserauthservice.service.user;

import in.codingstreams.etuserauthservice.data.model.AppUser;

public interface UserService {
    AppUser getUserInfo(String userId);
}

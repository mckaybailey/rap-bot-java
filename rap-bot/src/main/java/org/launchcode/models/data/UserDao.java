package org.launchcode.models.data;

//import org.launchcode.models.;
import org.launchcode.models.forms.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
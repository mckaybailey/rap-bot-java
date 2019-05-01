package org.launchcode.models.data;

//import org.launchcode.models.;
import org.launchcode.models.forms.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface BlogDao extends CrudRepository<Blog, Integer> {
}
package company.ryzhkov.enterprise.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * The type Abstract repository bean.
 * @author Stanislav Ryzhkov
 * Created 27/03/2020
 */
public abstract class AbstractRepositoryBean {

    @PersistenceContext
    protected EntityManager em;
}

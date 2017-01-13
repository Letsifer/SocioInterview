package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.dao.CandidateDao;
import edu.altstu.sociointerview.entities.Candidate;
import java.util.List;

/**
 *
 * @author Евгений
 */
public class CandidateServiceImpl implements CandidateService{

    private CandidateDao candidateDao = new CandidateDao();
    
    @Override
    public List<Candidate> getAllCandidates() {
        return candidateDao.getListOfEntities(null);
    }

    @Override
    public Candidate getCandidate(Integer id) {
        return candidateDao.getEntity(id);
    }
    
}

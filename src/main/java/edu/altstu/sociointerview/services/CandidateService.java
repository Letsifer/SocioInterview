package edu.altstu.sociointerview.services;

import edu.altstu.sociointerview.entities.Candidate;
import java.util.List;

/**
 *
 * @author gea
 */
public interface CandidateService {
    List<Candidate> getAllCandidates();
    
    Candidate getCandidate(Integer id);
}

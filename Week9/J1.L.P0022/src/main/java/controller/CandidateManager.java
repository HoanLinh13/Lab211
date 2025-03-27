package controller;

import model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateManager {
    private List<Candidate> candidateList = new ArrayList<>();

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
    }

    public void displayAllCandidates() {
        for (Candidate c : candidateList) {
            c.showInfo();
        }
    }

    public List<Candidate> searchByName(String name) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            if (c.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Candidate> getCandidatesByType(int type) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type) {
                result.add(c);
            }
        }
        return result;
    }
}

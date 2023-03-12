package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Loan;
import rest.repository.LoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoan(){
        List<Loan> allLoan = loanRepository.findAll();
        return allLoan;
    }

    public Loan getOneLoan(Integer loanId) {
        Optional<Loan> loanOpt = loanRepository.findById(loanId);
        Loan foundLoan = loanOpt.get();
        return foundLoan;
    }

    public Loan createLoan(Loan loan) {
        Loan createdLoan = loanRepository.save(loan);
        return createdLoan;
    }

    public void deleteOneLoan(Integer loanId) {
        loanRepository.deleteById(loanId);
    }


}

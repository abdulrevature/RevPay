package com.revature.loan.controller;

import com.revature.loan.model.Loan;
import com.revature.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok().body(loanService.getAllLoans());
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Object> getLoanById(@PathVariable("loanId") int loanId) {
        try {
            return ResponseEntity.ok().body(loanService.getLoanById(loanId));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{loanId}/approval")
    public ResponseEntity<Object> updateLoanIsApprovedById(@PathVariable("loanId") int loanId, @RequestBody boolean isApproved) {
        try {
            return ResponseEntity.accepted().body(loanService.updateLoanIsApprovedById(loanId, isApproved));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

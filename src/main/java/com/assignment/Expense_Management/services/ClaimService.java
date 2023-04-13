package com.assignment.Expense_Management.services;

import java.util.List;
import com.assignment.Expense_Management.entities.Claim;

public interface ClaimService {

    List<Claim> getAllClaims();
    Claim getClaimById(Long claimId);
    Claim createClaim(Claim claim);
    Claim updateClaim(Long claimId, Claim claimDetails);
    void deleteClaim(Long claimId);
}
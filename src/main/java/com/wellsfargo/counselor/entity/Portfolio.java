package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import java.time.LocalDateTime;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;
    
    @ManyToOne
    @JoinColumn(name = "clientId", foreignKey = @ForeignKey(name = "fk_portfolio_client"))
    private Client clientId; 

    @Column(nullable = false)
    private LocalDateTime creationDate;

    protected Portfolio() {

    }

    public Portfolio(Client clientId, LocalDateTime creationDate) {
        this.clientId = clientId;
        this.creationDate = creationDate;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }
    
    public Client getClientId() {
      return clientId;
    }
    
    public void setClientId(Client clientId) {
      this.clientId = clientId;
    }
    
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
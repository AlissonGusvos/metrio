package com.metrio.Metrio.repository;

import com.metrio.Metrio.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}

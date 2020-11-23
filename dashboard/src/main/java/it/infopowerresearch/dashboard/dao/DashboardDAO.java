package it.infopowerresearch.dashboard.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.infopowerresearch.dashboard.beans.Dashboard;

@Repository
public interface DashboardDAO extends CrudRepository<Dashboard, Long> {

	Set<Dashboard> findByUserId(long userId);

}

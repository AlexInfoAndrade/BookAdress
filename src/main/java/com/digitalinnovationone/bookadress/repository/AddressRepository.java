package com.digitalinnovationone.bookadress.repository;

import com.digitalinnovationone.bookadress.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Adress, Long> {
}

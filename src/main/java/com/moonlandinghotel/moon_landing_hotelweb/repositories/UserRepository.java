package com.moonlandinghotel.moon_landing_hotelweb.repositories;

import com.moonlandinghotel.moon_landing_hotelweb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
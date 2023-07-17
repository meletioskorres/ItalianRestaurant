package com.melkor.italianrestaurant.Repository;

import com.melkor.italianrestaurant.Entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder,Long> {
}

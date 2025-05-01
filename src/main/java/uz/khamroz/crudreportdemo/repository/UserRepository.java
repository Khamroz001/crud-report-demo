package uz.khamroz.crudreportdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.khamroz.crudreportdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

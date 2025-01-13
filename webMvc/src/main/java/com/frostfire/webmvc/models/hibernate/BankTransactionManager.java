package com.frostfire.webmvc.models.hibernate;

import com.frostfire.webmvc.models.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class BankTransactionManager implements BankTransactionDao {
    //private final SessionFactory sessionFactory;

    private Environment env;

    public BankTransactionManager(){
        Configuration configuration = new Configuration().configure()
                .setProperty(env.getProperty("hibernate.connection.driver_class"), "fd");
    }
    @Override
    public Transaction store(Transaction transaction) {
        return null;
    }

    @Override
    public void delete(Long courseId) {

    }

    @Override
    public Transaction findById(Long id) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return List.of();
    }
}

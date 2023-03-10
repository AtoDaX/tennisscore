package edu.pet.tennis.dao;

import edu.pet.tennis.Util.HibernateSessionFactoryUtil;
import edu.pet.tennis.models.Player;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PlayerDao implements DaoInterface<Player> {

    @Override
    public Optional<Player> findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Optional<Player> toReturn = Optional.of(session.get(Player.class, id));
        session.close();
        return toReturn;
    }

    public Optional<Player> findByName(String name){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "FROM Player WHERE name = :name";
        List<Player> playerList = session.createQuery(hql).setParameter("name", name).getResultList();
        int countPlayers = playerList.size();
        if (countPlayers == 1) {
            return Optional.of(playerList.get(0));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void save(Player entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Player entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Player entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(entity);
        tx1.commit();
        session.close();

    }

    @Override
    public List<Player> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Player.class);
        Root rootEntry = cq.from(Player.class);
        CriteriaQuery all = cq.select(rootEntry);
        TypedQuery allQuery = session.createQuery(all);

        List<Player> players = (List<Player>) allQuery.getResultList();
        session.close();
        return players;
    }

}

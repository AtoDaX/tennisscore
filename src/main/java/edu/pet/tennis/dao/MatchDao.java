package edu.pet.tennis.dao;

import edu.pet.tennis.Util.HibernateSessionFactoryUtil;
import edu.pet.tennis.models.Match;
import edu.pet.tennis.models.Player;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MatchDao implements DaoInterface<Match> {

    @Override
    public Optional<Match> findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return Optional.of(session.get(Match.class, id));
    }

    @Override
    public void save(Match entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Match entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Match entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(entity);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Match> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Match.class);
        Root rootEntry = cq.from(Match.class);
        CriteriaQuery all = cq.select(rootEntry);
        TypedQuery allQuery = session.createQuery(all);
        List<Match> matches = (List<Match>) allQuery.getResultList();
        session.close();
        return matches;
    }

    public List<Match> findMatchesByPlayer(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "FROM Match WHERE player1.name = :name or player2.name = :name";
        /*String hql = "FROM Match " +
                "left join Player as p1 ON p1.id = Match.player1.id " +
                "left join Player as p2 ON p2.id = Match.player2.id " +
                "WHERE p1.name = :name OR p2.name = :name";*/
        List<Match> matches = session.createQuery(hql).setParameter("name", name).getResultList();

        return matches;
    }
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.Profile;
import pojo.Task;
import pojo.User;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;

public class Hibernate_operation {

    public boolean user_exists(String email,String password) throws Exception {

        Session session = get_session();
        Query query = session.createQuery("from Profile where email ="+"'"+email+"'"+" and password ="+password);
        Profile profiles = (Profile) query.uniqueResult();
        return profiles!=null;
    }


    public void register_profile(String email,String password){

        try {

            if(!user_exists(email,password)){

                Profile profile = new Profile(Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),email,password);
                User user = new User(profile,profile.getEmail(),0);

                Session session = get_session();
                Transaction transaction = session.beginTransaction();

                session.save(profile);
                session.save(user);

                transaction.commit();

                session.close();

                System.out.println("profile registered");

            }else{
                System.out.println("profile already exists");
            }

        } catch (Exception e) {

            Profile profile = new Profile(Timestamp.from(Instant.now()),Timestamp.from(Instant.now()),email,password);
            User user = new User(profile,profile.getEmail(),0);

            Session session = get_session();
            Transaction transaction = session.beginTransaction();

            session.save(profile);
            session.save(user);

            transaction.commit();

            session.close();

            System.out.println("profile registered");
        }
    }


    public void update_profile(Profile profile){

        Session session = get_session();
        Transaction transaction = session.beginTransaction();

        Profile existing_profile = session.get(Profile.class,profile.getId());

        existing_profile.setEmail(profile.getEmail());
        existing_profile.setPassword(profile.getPassword());

        session.saveOrUpdate(existing_profile);

        transaction.commit();

        System.out.println("profile update for userid "+existing_profile.getId());

    }



    public void create_task(int user_id,String item){

        Task task = new Task(item, Timestamp.from(Instant.now()) , (long) user_id,0);

        Session session = get_session();
        Transaction transaction = session.beginTransaction();

        session.save(task);

        transaction.commit();

        session.close();

        System.out.println("task created for userid "+user_id);

    }


    public void get_user_task(int user_id){

        Session session = get_session();
        Query query = session.createQuery("from Task where user_id ="+user_id);

        List tasks = query.getResultList();

        for (Iterator iterator = tasks.iterator(); iterator.hasNext();){
            Object object = iterator.next();
            System.out.println(object.toString());
        }


    }


    public void update_task(Task task){

        Session session = get_session();
        Transaction transaction = session.beginTransaction();

        Task existing_task = session.get(Task.class,task.getId());

        existing_task.setEnd_date(task.getEnd_date());
        existing_task.setId(task.getId());
        existing_task.setItem(task.getItem());
        existing_task.setStatus(task.getStatus());
        existing_task.setUser_id(task.getUser_id());

        session.saveOrUpdate(existing_task);

        transaction.commit();

        System.out.println("task update for userid "+task.getUser_id());

    }


    static Session get_session(){
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory.openSession();
    }

}

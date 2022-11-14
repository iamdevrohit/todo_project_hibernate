package mappingDemo.repository;


import mappingDemo.manytomany.Delegate;
import mappingDemo.manytomany.Event;
import mappingDemo.onetomany.Cart;
import mappingDemo.onetomany.College;
import mappingDemo.onetomany.Items;
import mappingDemo.onetomany.Student;
import mappingDemo.onetoone.Person;
import mappingDemo.onetoone.PersonDetail;
import mappingDemo.onetoone.bidirectional.BiPerson;
import mappingDemo.onetoone.bidirectional.BiPersonDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class MappingRepo {


    public void saveCart(){

        Cart cart = new Cart();
        cart.setCustomerName("Rohit's Cart");

        Items item = new Items(1, 123, 100, 1, cart);
        Items item2 = new Items(2, 124, 34, 2, cart);

        HashSet<Items> hs = new HashSet<Items>();
        hs.add(item2);
        hs.add(item);

        AtomicInteger total = new AtomicInteger();

//      for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
//            Items items = (Items) iterator.next();
//            total = total+items.getQuantity()*items.getItemTotal();
//      }

        hs.stream().iterator().forEachRemaining(v->{
            total.addAndGet((int) v.getItemTotal());
        });
//

        cart.setTotal(total.doubleValue());
        cart.setItems(hs);

        Session session = get_session();

        Transaction t = session.beginTransaction();

        session.save(cart);
        session.save(item);
        session.save(item2);

        t.commit();
        session.close();

        System.out.println("Transaction saves success.. ");

    }

    public void saveOnetoOne(){

        Session session = get_session();

        Transaction t = session.beginTransaction();

        PersonDetail personDetail = new PersonDetail();
        personDetail.setIncome(100000.00);
        personDetail.setJob("java developer");
        personDetail.setZipCode("360001");

        Person person = new Person();
        person.setPersonName("mahesh vishvakarma");
        person.setPersonDetail(personDetail);

        session.save(person);


        //BI DIRECTIONAL

        BiPersonDetail biPersonDetail = new BiPersonDetail();
        biPersonDetail.setIncome(100000.00);
        biPersonDetail.setJob("Bi java developer");
        biPersonDetail.setZipCode("360001");

        BiPerson biPerson = new BiPerson();
        biPerson.setPersonName("bi mahesh vishvakarma");
        biPerson.setPersonDetail(biPersonDetail);

        session.save(biPerson);

        t.commit();
        session.close();

    }



    public void saveOnetoMany(){

        Session session = get_session();

        Transaction t = session.beginTransaction();

        College college = new College();
        college.setCollegeName("vvp college");

        College college1 = new College();
        college1.setCollegeName("MARWADI college");

        Student student = new Student();
        student.setStudentName("rohit vishvakarma");
        student.setStudentAddress("maruti nagar");


        Student student1 = new Student();
        student1.setStudentName("mahesh vishvakarma");
        student1.setStudentAddress("maruti nagar str 3");


        student.setCollege(college);
        student1.setCollege(college1);


        session.save(college1);
        session.save(college);

        session.save(student);
        session.save(student1);


        t.commit();
        session.close();

    }


    public void saveManytoMany(){

        Session session = get_session();

        Transaction t = session.beginTransaction();

        Delegate delegate = new Delegate();
        delegate.setDelegateName("rohit vishvakarma");

        Delegate delegate1 = new Delegate();
        delegate1.setDelegateName("li felli");

        Delegate delegate2 = new Delegate();
        delegate2.setDelegateName("fran felli");

        Event fullstack = new Event();
        fullstack.setEventName("fullstack event");

        Event android = new Event();
        android.setEventName("android event");

        Event flutter = new Event();
        flutter.setEventName("flutter event");

        fullstack.getDelegates().add(delegate);
        android.getDelegates().add(delegate);
        flutter.getDelegates().add(delegate);

        android.getDelegates().add(delegate1);
        flutter.getDelegates().add(delegate1);

        flutter.getDelegates().add(delegate2);

        session.save(delegate);
        session.save(delegate1);
        session.save(delegate2);

        session.save(fullstack);
        session.save(android);
        session.save(flutter);


        t.commit();
        session.close();

    }



    static Session get_session(){
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionFactory.openSession();
    }

}

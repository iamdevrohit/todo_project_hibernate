import java.sql.*;
import java.time.Instant;

public class Operations {


    //CREATE TABLE

    public void create_PROFILE_table(){

        try {

            Connection c = get_connection();

            String create_table ="CREATE TABLE PROFILE (" +
                    "ID INT NOT NULL AUTO_INCREMENT, " +
                    "LAST_LOGIN TIMESTAMP, " +
                    "LAST_PASSWORD_CHANGE TIMESTAMP, " +
                    "EMAIL VARCHAR(250) NOT NULL, "+
                    "PASSWORD VARCHAR(250) NOT NULL, " +
                    "UNIQUE (EMAIL), " +
                    "PRIMARY KEY(ID, EMAIL))";

            Statement s=c.createStatement();
            s.executeUpdate(create_table);
            s.close();
            c.close();

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public void create_USER_table(){

        try {

            Connection c = get_connection();

            String create_table ="CREATE TABLE USER (" +
                    "    COUNT_TASK int NOT NULL, " +

                    "    PROFILE_EMAIL VARCHAR(250) NOT NULL, " +
                    "    FOREIGN KEY (PROFILE_EMAIL)  " +
                    "    REFERENCES PROFILE (EMAIL), " +

                    "    PROFILE_ID INT NOT NULL, " +
                    "    FOREIGN KEY (PROFILE_ID)  " +
                    "    REFERENCES PROFILE (ID)" +
                    ")";

            PreparedStatement preparedStatement = c.prepareStatement(create_table);
            preparedStatement.execute();
            preparedStatement.close();
            c.close();

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public void create_TASK_table(){

        try {

            Connection c = get_connection();

            String create_table ="CREATE TABLE TASK (" +
                    "ID INT NOT NULL AUTO_INCREMENT, " +
                    "ITEM VARCHAR(250) NOT NULL, " +
                    "END_DATE DATE NOT NULL, " +
                    "USER_ID INT NOT NULL, " +
                    "STATUS BOOLEAN, " +
                    "FOREIGN KEY (USER_ID) REFERENCES PROFILE (ID), " +
                    "PRIMARY KEY (ID))";

            Statement s=c.createStatement();
            s.executeUpdate(create_table);
            s.close();
            c.close();

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
            throw new RuntimeException(e);
        }

    }




    //USER

    public void register_user(String email,String password){

        try {
            Connection c = get_connection();
            String valid_email = "'"+email+"'";

            String check="SELECT EXISTS(SELECT 1 FROM PROFILE WHERE EMAIL=" +
                    valid_email+" )";

            Statement check_stmt = c.createStatement();
            ResultSet rs = check_stmt.executeQuery(check);


            if(!rs.next()){
                System.out.println("alert : email address already exists");
                return;
            }


            PreparedStatement register_profile = c.prepareStatement("insert into PROFILE values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            register_profile.setInt(1,0);
            register_profile.setTimestamp(2,Timestamp.from(Instant.now()));
            register_profile.setTimestamp(3,Timestamp.from(Instant.now()));
            register_profile.setString(4,email);
            register_profile.setString(5,password);

            register_profile.executeUpdate();

            ResultSet res = register_profile.getGeneratedKeys();
            int profile_id=-1;
            while (res.next()) {
                profile_id=res.getInt(1);
            }

            PreparedStatement register_user = c.
                    prepareStatement("insert into USER values(?,?,?)");
            register_user.setInt(1,0);
            register_user.setString(2,email);
            register_user.setInt(3,profile_id);

            register_user.executeUpdate();

            register_profile.close();
            register_user.close();
            check_stmt.close();
            c.close();

            System.out.println("alert : new user registered");

        } catch (ClassNotFoundException e) {
            System.out.println("alert  class not found: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("alert  sql exception : "+e.getMessage());
            System.out.println("alert : email address already exists");
            throw new RuntimeException(e);
        }

    }


    public boolean login_profile(String email,String password){
        try {
            Connection c = get_connection();

            String query="select * from  PROFILE where email= ? and password= ?";

            PreparedStatement login_profile = c.prepareStatement(query);
            login_profile.setString(1,email);
            login_profile.setString(2,password);
            login_profile.execute();

            ResultSet resultSet = login_profile.getResultSet();

//            if(!resultSet.next()){
//                System.out.println("alert : user not exists ");
//            }

            while(resultSet.next()){
                System.out.println("login data  : user_id : "+resultSet.getInt(1)+
                        "\nlast login : "+resultSet.getTimestamp(2)+
                        "\nlast password chnage : "+resultSet.getTimestamp(3)+
                        "\nemail : "+resultSet.getString(4)+
                        "\npassword : "+resultSet.getString(5));
            }

            resultSet.close();
            login_profile.close();
            c.close();


            return true;

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
            return false;
        }
    }


    public void update_password(int user_id,String old_password,String new_password){
        try {


            Connection c = get_connection();

            String query="select * from PROFILE where ID= ? and PASSWORD= ?";

            PreparedStatement login_profile = c.prepareStatement(query);
            login_profile.setInt(1,user_id);
            login_profile.setString(2,old_password);
            login_profile.execute();

            ResultSet resultSet = login_profile.getResultSet();

            int get_user_id=-1;
            Timestamp last_login,last_password_change;
            String email="",password="";

            while(resultSet.next()){

                get_user_id=resultSet.getInt(1);
                last_login= resultSet.getTimestamp(2);
                last_password_change= resultSet.getTimestamp(3);
                email=resultSet.getString(4);
                password=resultSet.getString(5);

                System.out.println("login data  : user_id : "+resultSet.getInt(1)+
                        "\nlast login : "+resultSet.getTimestamp(2)+
                        "\nlast password chnage : "+resultSet.getTimestamp(3)+
                        "\nemail : "+resultSet.getString(4)+
                        "\npassword : "+resultSet.getString(5));
            }

            if(get_user_id==-1){

                System.out.println("alert : user not exists ");

            }else{

                if(password.equals(old_password)){

                    //update task count
                    String update_password="update PROFILE set PASSWORD= ? WHERE ID = ?";
                    PreparedStatement ps_update_password = c.prepareStatement(update_password);
                    ps_update_password.setString(1,new_password);
                    ps_update_password.setInt(2,user_id);

                    ps_update_password.executeUpdate();

                    System.out.println("alert : password changed");

                    ps_update_password.close();


                }else{
                    System.out.println("alert : password does not match");
                }
            }


            resultSet.close();
            login_profile.close();
            c.close();

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }
    }


    public void update_profile(int user_id,String email,String password){

        try {
            Connection c = get_connection();

            //update task count
            String update_profile="update PROFILE set EMAIL= ? , PASSWORD= ?  WHERE ID = ?";
            PreparedStatement ps_update_profile = c.prepareStatement(update_profile);
            ps_update_profile.setString(1,email);
            ps_update_profile.setString(2,password);
            ps_update_profile.setInt(3,user_id);

            ps_update_profile.executeUpdate();

            System.out.println("alert : profile updated");

            ps_update_profile.close();

            c.close();


        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }

    }





    //CREATE TASK

    public boolean get_user_task(int id){
        try {
            Connection c = get_connection();

            String query="select * from  TASK where USER_ID= ?";

            PreparedStatement login_profile = c.prepareStatement(query);
            login_profile.setInt(1,id);
            login_profile.execute();

            ResultSet resultSet = login_profile.getResultSet();


            while(resultSet.next()){
                System.out.println("task  : task_id : "+resultSet.getInt(1)+
                        "\ntask name : "+resultSet.getString(2)+
                        "\ntask end date : "+resultSet.getDate(3)+
                        "\nuser_id : "+resultSet.getInt(4)+
                        "\nstatus : "+resultSet.getBoolean(5));
            }

            resultSet.close();
            login_profile.close();
            c.close();


            return true;

        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
            return false;
        }
    }


    public void new_task(int user_id, String name, Date enddate){

        try {

            Connection  c = get_connection();


            // get task count
            String get_task_count="select * from  USER where PROFILE_ID= ?";
            PreparedStatement ps_get_taskcount = c.prepareStatement(get_task_count);
            ps_get_taskcount.setInt(1,user_id);

            ps_get_taskcount.execute();

            ResultSet res = ps_get_taskcount.getResultSet();
            int count=0;
            while (res.next()) {
                count=res.getInt(1);
            }

            PreparedStatement create_task = c.prepareStatement("insert into TASK values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            create_task.setInt(1,0);
            create_task.setString(2,name);
            create_task.setDate(3,enddate);
            create_task.setInt(4,user_id);
            create_task.setBoolean(5,false);

            create_task.executeUpdate();


            //update task count
            String update_task_count="update USER set COUNT_TASK= ? WHERE PROFILE_ID= ?";
            PreparedStatement ps_update_taskcount = c.prepareStatement(update_task_count);
            ps_update_taskcount.setInt(1,(count+1));
            ps_update_taskcount.setInt(2,user_id);

            ps_update_taskcount.executeUpdate();


            ps_get_taskcount.close();
            create_task.close();
            ps_update_taskcount.close();


        }catch (ClassNotFoundException e) {

            System.out.println("alert  class not found: "+e.getMessage());
            throw new RuntimeException(e);

        } catch (SQLException e) {

            System.out.println("alert  sql exception : "+e.getMessage());
            throw new RuntimeException(e);

        }

    }


    public void update_task(int user_id,int task_id,String name,Date enddate){

        try {

            Connection c = get_connection();

            //update task count
            String update_task="update TASK set ITEM= ? , END_DATE= ? WHERE ID= ? AND USER_ID= ?";
            PreparedStatement ps_update_task = c.prepareStatement(update_task);
            ps_update_task.setString(1,name);
            ps_update_task.setDate(2,enddate);
            ps_update_task.setInt(3,task_id);
            ps_update_task.setInt(4,user_id);

            ps_update_task.executeUpdate();

            System.out.println("alert : task updated");

            ps_update_task.close();
            c.close();


        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }

    }


    public void update_task_status(int user_id,int task_id,boolean status){

        try {

            Connection c = get_connection();

            //update task count
            String update_task="update TASK set STATUS= ? WHERE ID= ? AND USER_ID= ?";
            PreparedStatement ps_update_task = c.prepareStatement(update_task);
            ps_update_task.setBoolean(1,status);
            ps_update_task.setInt(2,task_id);
            ps_update_task.setInt(3,user_id);

            ps_update_task.executeUpdate();

            System.out.println("alert : task updated to "+(status?"DONE":"NOT DONE"));

            ps_update_task.close();
            c.close();


        } catch (ClassNotFoundException e) {
            System.out.println("error class"+e.getMessage());
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }

    }


    Connection get_connection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/tododb", "root","1234");
        System.out.println("connection added");
        return  c;
    }

}

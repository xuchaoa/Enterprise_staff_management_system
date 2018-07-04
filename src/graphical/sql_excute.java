package graphical;


import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;


public class sql_excute {
    static Connection con;//声明Connection对象
    static Statement statement;//2.创建statement类对象，用来执行SQL语句

    public static boolean sql_connect(String username,String passwd){

        String current_password = null;


        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/esm";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "xuchao";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeessfully connecting to the Database!");
            statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select password from esm.alluser where name=\""+username+"\"";
            //3.ResultSet类，用来存放获取的结果集
            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("this is the result:");
//            System.out.println("-----------------");
//            System.out.println("name" + "\t" + "phone");
//            System.out.println("-----------------");

//            String name = null;
//            String phone = null;

            while(rs.next()){
                //获取stuname这列数据
                current_password = rs.getString("password");
                //获取stuid这列数据
                //phone = rs.getString("phone");

                //输出结果

            }

//            System.out.println("查询出的密码"+current_password+"   输入的密码"+passwd);
//            System.out.println(username);
//            rs.close();   //关闭数据库连接
//            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {

            e.printStackTrace();
        }

        if(current_password.equals(passwd)){
            return true;
        }
        else
            return false;
    }
    public static void close_connect(){
        try {
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public static void register(int au_id,int department_id,String name,String sex,int age,String password){
        String sql = "insert into esm.alluser(au_id,department_id,name,sex,age,password) values ("+au_id+","+department_id+",'"+name+"','"+sex+"',"+age+",'"+password+"')";
        System.out.println(sql);
        try {
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        }
    public static void modify(){   //修改

    }
    public static void delete(){
        
    }
    public static void search(){

    }
}

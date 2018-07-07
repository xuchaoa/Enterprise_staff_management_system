package graphical;


import javax.management.Query;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;


public class sql_excute {
    static Connection con;//声明Connection对象
    static Statement statement ;//2.创建statement类对象，用来执行SQL语句

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
            String sql = "select password from esm.alluser where name='"+username+"'";
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
        //System.out.println(current_password);
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
    public static void register(String au_id,String department_id,String name,String sex,String age,String password){
        String sql = "insert into esm.alluser(au_id,department_id,name,sex,age,password) values ("+au_id+","+department_id+",'"+name+"','"+sex+"',"+age+",'"+password+"')";
        System.out.println("当前执行的sql语句："+sql);
        try {
            statement.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        }
    public static void modify(){   //修改

    }
    public static void delete_by_id(String userid){
        //DELETE * FROM table_name
        sql_connect("admin","admin");
        String sql = "delete from esm.alluser where user_id = "+userid;
        System.out.println("当前执行的sql语句："+sql);
        try{
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String[][] search_by_userid(String userid){
        String result[][] = new String[30][5];
        sql_connect("admin","admin");
        String sql = "select * from esm.alluser where user_id = "+userid;
        System.out.println("当前执行的sql语句："+sql);
        try{
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while(rs.next()){
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static String[][] search_by_username(String name){
        String result[][] = new String[30][5];
        sql_connect("admin","admin");
        String sql = "select * from esm.alluser where name = '"+name+"'";
        System.out.println("当前执行的sql语句："+sql);
        try{
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while(rs.next()){
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static String[][] search_by_department(String id){
        sql_connect("admin","admin");
        String sql = "select * from esm.alluser where department_id ="+id;
        System.out.println("当前执行的sql语句："+sql);
        int a = 0;
        String result[][] = new String[30][5];
        try {

//          System.out.println("con:"+con);
//          System.out.println("statement:"+statement);
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
            System.out.println("查询出的结果：\n");
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    System.out.print(result[i][j]);
                }
            System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return result;
    }
}

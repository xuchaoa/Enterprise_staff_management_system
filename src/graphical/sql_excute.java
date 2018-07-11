package graphical;


import jdk.jfr.events.ExceptionThrownEvent;

import javax.management.Query;
import javax.management.relation.RelationSupport;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class sql_excute {
    static Connection con;//声明Connection对象
    static Statement statement;//2.创建statement类对象，用来执行SQL语句

    public static boolean sql_connect(String username, String passwd) {

        String current_password = null;
        boolean result = false;

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
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeessfully connecting to the Database!");
            statement = con.createStatement();
            //要执行的SQL语句


            String sql = "select * from esm.alluser where name='" + username + "'";
            ResultSet rs = statement.executeQuery(sql);


            while (rs.next()) {
                current_password = rs.getString("password");
            }

        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("输入的密码" + passwd);
        System.out.println("查询到的密码" + current_password);

        if (current_password != null && current_password.length() > 0 && passwd != null && passwd.length() > 0) {
            if (current_password.equals(passwd)) {
                result = true;
            }
        }
        else {
            result = false;
        }
        return result;
    }

    public static void close_connect() {
        try {
            statement.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void register(String au_id, String department_id, String name, String sex, String age, String password) {
        String sql = "insert into esm.alluser(au_id,department_id,name,sex,age,password) values (" + au_id + "," + department_id + ",'" + name + "','" + sex + "'," + age + ",'" + password + "')";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void inertinto_authority(String au_id) {
        String sql = "insert into esm.authority(authority) values (" + au_id + ")";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
    public static void inertinto_department( String department_id) {
        String sql = "insert into esm.department(department_name, department_number) values (" + department_id + ","+department_id+")";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void modify() {   //修改

    }

    public static void delete_by_id(String userid) {
        //DELETE * FROM table_name
        sql_connect("admin", "admin");
        String sql = "delete from esm.alluser where user_id = " + userid;
        System.out.println("当前执行的sql语句：" + sql);
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[][] search_by_userid(String userid, int au_id, int department_id) {
        String result[][] = new String[30][5];
        String sql = null;
        sql_connect("admin", "admin");
        if (au_id == 0) {
            sql = "select * from esm.alluser where user_id = " + userid;
        } else {
            sql = "select * from esm.alluser where user_id = " + userid + " and au_id != 0 and department_id = " + department_id;
        }

        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                System.out.println();
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] search_by_username(String name, int au_id, int department_id) {
        String result[][] = new String[30][5];
        String sql = null;
        sql_connect("admin", "admin");
        if (au_id == 0) {
            sql = "select * from esm.alluser where name = '" + name + "'";
        } else {
            sql = "select * from esm.alluser where name = '" + name + "' and department_id = " + department_id + " and au_id != 0";
        }

        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] search_by_username_all(String username) {
        String result[][] = new String[30][6];
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where name = '" + username + "'";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("name");
                result[a][1] = rs.getString("sex");
                result[a][2] = rs.getString("age");
                result[a][3] = rs.getString("department_id");
                result[a][4] = rs.getString("user_id");
                result[a][5] = rs.getString("password");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }   //查询用户全部数据：6个字段

    public static String[][] search_by_userid_all(String userid) {
        String result[][] = new String[30][6];
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where user_id = '" + userid + "'";
        System.out.println("执行的sql语句：" + sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
                System.out.println();
                result[a][0] = rs.getString("name");
                System.out.println();
                result[a][1] = rs.getString("sex");
                result[a][2] = rs.getString("age");
                result[a][3] = rs.getString("department_id");
                result[a][4] = rs.getString("user_id");
                result[a][5] = rs.getString("password");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }   //查询用户全部数据：6个字段

    public static String[][] search_by_department_notadmin(int department_id) {
        String result[][] = new String[30][6];

        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where department_id = " + department_id + " and au_id != 0";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;

            while (rs.next()) {
                result[a][0] = rs.getString("name");
                result[a][1] = rs.getString("sex");
                result[a][2] = rs.getString("age");
                System.out.println();
                result[a][3] = rs.getString("department_id");
                System.out.println();
                result[a][4] = rs.getString("user_id");
                result[a][5] = rs.getString("password");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] search_by_department_admin(int department_id) {
        String result[][] = new String[30][6];
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where department_id = " + department_id;
        System.out.println("当前执行的sql语句：" + sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;

            while (rs.next()) {
                result[a][0] = rs.getString("name");
                System.out.println();
                result[a][1] = rs.getString("sex");
                result[a][2] = rs.getString("age");
                System.out.println();

                result[a][3] = rs.getString("department_id");
                System.out.println();
                result[a][4] = rs.getString("user_id");
                result[a][5] = rs.getString("password");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[][] search_by_department(String id) {
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where department_id =" + id;
        System.out.println("当前执行的sql语句：" + sql);
        int a = 0;
        String result[][] = new String[30][5];
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                System.out.println();
                result[a][4] = rs.getString("department_id");
                a++;
            }
            System.out.println("查询出的结果：\n");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return result;
    }

    public static String[][] search_by_department_notadmin_deleteinterface(String department_id) {
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where department_id =" + department_id;
        System.out.println("当前执行的sql语句：" + sql);
        int a = 0;
        String result[][] = new String[30][5];
        try {

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                result[a][0] = rs.getString("user_id");
                result[a][1] = rs.getString("name");
                System.out.println();
                result[a][2] = rs.getString("sex");
                result[a][3] = rs.getString("age");
                result[a][4] = rs.getString("department_id");
                a++;
            }
            System.out.println("查询出的结果：\n");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return result;
    }

    public static void updata_modify_data(String modify_data[]) {        //admin信息修改界面调用
        sql_connect("admin", "admin");
        String sql = "update esm.alluser set name='" + modify_data[0] + "',sex='" + modify_data[1] + "',age=" + modify_data[2] + ",department_id=" + modify_data[3] + ",user_id=" + modify_data[4] + ",password='" + modify_data[5] + "'where user_id=" + modify_data[4];

        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata_user_data(String modify_data[][]) {        //user信息修改界面调用
        sql_connect("admin", "admin");
        String sql = "update esm.alluser set name='" + modify_data[0][0] + "',sex='" + modify_data[0][1] + "',age=" + modify_data[0][2] + ",department_id=" + modify_data[0][3] + ",user_id=" + modify_data[0][4] + ",password='" + modify_data[0][5] + "' where name='" + modify_data[0][0] + "'";

        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[][] search_by_userid_modify(String userid) {
        String result[][] = new String[30][6];
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where user_id = " + userid;
        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            int a = 0;
            while (rs.next()) {
//                工号","姓名","性别","年龄","所属部门
                result[a][0] = rs.getString("name");
                result[a][1] = rs.getString("sex");
                result[a][2] = rs.getString("age");
                System.out.println();
                result[a][3] = rs.getString("department_id");
                result[a][4] = rs.getString("user_id");
                result[a][5] = rs.getString("password");
                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String database_backup() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");//设置日期格式
        String current_time = df.format(new Date());
        System.out.println(current_time);// new Date()为获取当前系统时间
        sql_connect("admin", "admin");
        String backup_path = "c://" + current_time + "_backup.sql";
        String command = "mysqldump esm -R -uroot -pxuchao --default-character-set=utf8 --result-file " + backup_path;

        try {
            Runtime rt = Runtime.getRuntime();
            Process ch = rt.exec(command);  //执行cmd命令
            System.out.println("执行的cmd命令为:" + command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return backup_path;
    }

    public static int get_authority(String name) {    //by name 得到au_id
        int result = 0;
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where name = '" + name + "'";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String result_str = rs.getString("au_id");
                result = Integer.parseInt(result_str);
            }

            System.out.println("查询到当前用户的权限代码为：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int get_departmentid_by_userid(int user_id) {
        int department_id = 0;
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where user_id = '" + user_id + "'";
        System.out.println("当前执行的sql语句：" + sql);
        try {

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                department_id = Integer.parseInt(rs.getString("department_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department_id;
    }

    public static boolean get_all_username(String username) {

        String sql = "select * from esm.alluser";
        int a = 0;
        String result[] = new String[30];
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                result[a] = rs.getString("name");

                a++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        int tips = 0;
        System.out.println("查询出数据库中所有用户名：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println(result[0].equals(username));
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null && result[i].length() > 0){
                if (result[i].equals(username)) {
                    tips = 1;
                }
            }
        }
        if (tips != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int by_name_get_userid(String name) {
        int user_id = 0;
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser where name = '" + name + "'";
        System.out.println("当前执行的sql语句：" + sql);
        try {
            //statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                String data = rs.getString("user_id");
                user_id = Integer.parseInt(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user_id;
    }

    public static StringBuilder get_all_data_to_excel(){
        StringBuilder result = new StringBuilder();
        sql_connect("admin", "admin");
        String sql = "select * from esm.alluser";
        System.out.println("执行的sql语句：" + sql);
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                result.append(rs.getString("name")+",");
                result.append(rs.getString("sex")+",");
                result.append(rs.getString("age")+",");
                result.append(rs.getString("department_id")+",");
                result.append(rs.getString("user_id")+",");
                result.append(rs.getString("password")+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("全部信息字符串为："+result);
        return result;
    }


}

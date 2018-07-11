package graphical;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;


class export_to_excel {
    public static void fileChooser(String result) {
        JFileChooser chooser = new JFileChooser();                //（）内设置初始路径
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","jpg","gif");
        //设置文件类型
        chooser.setFileFilter(filter);
        //打开选择器面板
        int returnVal = chooser.showSaveDialog(new JPanel());
        //保存文件从这里入手，输出的是文件名
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            //System.out.println("你打开的文件夹是: " + chooser.getSelectedFile().getPath());
            String path = chooser.getSelectedFile().getPath();
            try {
                File f = new File(path + ".csv");                            //默认文件类型
                //System.out.println(f.getAbsolutePath());        //getAbsolutePath()：返回抽象路径名的绝对路径名字符串
                f.createNewFile();
                FileOutputStream out = new FileOutputStream(f);
                OutputStreamWriter oStreamWriter = new OutputStreamWriter(out,"gbk");  //转换成字符流写入
                oStreamWriter.write(result);  //内容
                oStreamWriter.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}